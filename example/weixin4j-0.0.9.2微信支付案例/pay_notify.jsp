<%@page import="org.weixin4j.pay.PayNotifyResult"%>
<%@page import="javax.xml.bind.JAXBContext"%>
<%@page import="javax.xml.bind.Unmarshaller"%>
<%@page import="org.weixin4j.Configuration"%>
<%@page import="org.weixin4j.pay.PayUtil"%>
<%@page import="org.weixin4j.util.XStreamFactory"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try {
        //---------------------------------------------------------
        //微信支付支付通知（后台通知）示例，商户按照此文档进行开发即可
        //---------------------------------------------------------
        //创建支付应答对象
        System.out.println("收到微信支付回调 start");
        //获取Post的流
        ServletInputStream in = request.getInputStream();
        //将流转换为字符串
        String xmlMsg = XStreamFactory.inputStream2String(in);
        //商户密钥
        String paternerKey = Configuration.getProperty("weixin4j.pay.partner.key");
        
        JAXBContext context = JAXBContext.newInstance(PayNotifyResult.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //结果
        PayNotifyResult payNotifyResult = (PayNotifyResult) unmarshaller.unmarshal(new StringReader(xmlMsg));
        
        //商户订单号
        String out_trade_no = payNotifyResult.getOut_trade_no();
        //支付结果
        String return_code = payNotifyResult.getReturn_code();
        
        System.out.println("收到微信支付回调 return_code = " + return_code);
        System.out.println("收到微信支付回调 out_trade_no = " + out_trade_no);
        //判断签名及结果
        if ("SUCCESS".equals(return_code)) {
            //验证签名
            boolean verify = PayUtil.verifySign(xmlMsg, paternerKey);
            if (verify) {
                //------------------------------
                //即时到账处理业务开始
                //------------------------------
                //根据id查询支付订单信息
                //商户内部处理订单交易状态业务逻辑 start
                //商户内部代码
                //商户内部处理订单交易状态业务逻辑 end
                //注意交易单不要重复处理
                //注意判断返回金额
                //------------------------------
                //即时到账处理业务完毕
                //------------------------------
                //给财付通系统发送成功信息，财付通系统收到此结果后不再进行后续通知
                response.getWriter().write("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
                System.out.println("收到微信支付回调 成功");
            } else {
                System.out.println("收到微信支付回调 签名失败");
                response.getWriter().write("<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[签名失败]]></return_msg></xml>");
            }
        } else {
            System.out.println("收到微信支付回调 支付失败");
            response.getWriter().write("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
        }
    } catch (Exception ex) {
        System.out.println("收到微信支付回调 异常");
        response.getWriter().write("<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[参数格式校验错误]]></return_msg></xml>");
    }
%>