<%@page import="com.fomind.web.GlobalConfig"%>
<%@page import="com.fomind.web.po.UserAccount"%>
<%@page import="com.fomind.util.WebApp"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="org.weixin4j.pay.PayUtil"%>
<%@page import="com.fomind.web.po.OrderPayDetial"%>
<%@page import="com.fomind.web.mapper.OrderPayMapper"%>
<%@page import="org.weixin4j.pay.WCPay"%>
<%@page import="com.fomind.web.weixin.WeixinHelp"%>
<%@page import="org.weixin4j.pay.UnifiedOrderResult"%>
<%@page import="org.weixin4j.pay.SignUtil"%>
<%@page import="com.fomind.util.WebTool"%>
<%@page import="org.weixin4j.Configuration"%>
<%@page import="org.weixin4j.pay.UnifiedOrder"%>
<%@page import="com.fomind.web.mapper.UserAccountMapper"%>
<%@page import="com.fomind.web.po.UserAccoutDetial"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    //H5支付对象
    WCPay wcPay = null;
    String orderId = "未获取到";
    String showMoney = "0.00";
    //1.进行判断当前是通过浏览器访问还是微信访问
    String agent = request.getHeader("user-agent");
    if (!agent.contains("MicroMessenger")) {
        response.sendRedirect(request.getContextPath() + "/weixin.jsp");
        return;
    } else {
        //获取支付Id
        String payId = request.getParameter("id");
        //如果未获取到用户openId
        if (payId == null || StringUtils.isEmpty(payId)) {
            //跳转到404界面
            response.sendRedirect(request.getContextPath() + "/404.do");
            return;
        }
        UserAccount currentUser = WebApp.getCurrentUser(request);
        //盘点用户是否登录
        if (currentUser == null) {
            String url = java.net.URLEncoder.encode("/pay/wxpay/pay.jsp?id=" + payId, "UTF-8");
            response.sendRedirect(request.getContextPath() + "/login.do?url=" + url);
            return;
        }
        //设置到Session中
        Object openId = request.getSession().getAttribute("victool_openId");
        //如果未获取到用户openId
        if (openId == null || StringUtils.isEmpty(openId.toString())) {
            //跳转到openId页，授权获取OpenId
            response.sendRedirect(request.getContextPath() + "/pay/wxpay/openId.jsp?state=" + payId);
            return;
        }
        UnifiedOrder unifiedorder = null;
        String total_fee = "";
        try {
            //获取Servlet上下文对象
            ServletContext sc = request.getServletContext();
            //获取Spring容器上下文对象
            WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(sc);
            //获取订单支付Mapper
            OrderPayMapper ad = wc.getBean(OrderPayMapper.class);
            //根据支付Id，查询订单支付详情
            OrderPayDetial detial = ad.getOrderPayDetialById(Integer.valueOf(payId));
            //如果不是同一个账号，则异常
            if (currentUser.getId() != detial.getUserId()) {
                //跳转到错误页
                response.sendRedirect(request.getContextPath() + "/error.do");
                return;
            }
            //统一下单对象
            unifiedorder = new UnifiedOrder();
            unifiedorder.setAppid(Configuration.getOAuthAppId());
            unifiedorder.setBody("投票订单支付描述内容");
            unifiedorder.setMch_id(Configuration.getProperty("weixin4j.pay.partner.id"));
            unifiedorder.setNonce_str(java.util.UUID.randomUUID().toString().substring(0, 15));
            unifiedorder.setNotify_url(GlobalConfig.getDomain_Mobile_Url() + "/pay/wxpay/pay_notify.jsp");
            unifiedorder.setOpenid(openId.toString());
            unifiedorder.setOut_trade_no(detial.getSwiftNumber());
            String ip = WebTool.getIPAddr(request);
            unifiedorder.setSpbill_create_ip(ip);

            orderId = detial.getSwiftNumber();
            showMoney = detial.getMoney() + "";
            //总费用
            total_fee = (detial.getMoney() * 100) + "";
            unifiedorder.setTotal_fee(total_fee.substring(0, total_fee.indexOf(".")));
            unifiedorder.setTrade_type("JSAPI");
            //获取商户密钥
            String partnerKey = Configuration.getProperty("weixin4j.pay.partner.key");
            //对下单对象进行签名
            String sign = SignUtil.getSign(unifiedorder.toMap(), partnerKey);
            //设置签名
            unifiedorder.setSign(sign);
            //统一预下单
            UnifiedOrderResult unifiedOrderResult = WeixinHelp.getInstance().payUnifiedOrder(unifiedorder);
            //下单成功
            if (unifiedOrderResult.isSuccess()) {
                String prepay_id = unifiedOrderResult.getPrepay_id();
                //初始化
                wcPay = PayUtil.getBrandWCPayRequest(Configuration.getOAuthAppId(), prepay_id, partnerKey);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>微信3.0支付</title>
        <script type="text/javascript">
            //调用微信JS api 支付
            function jsApiCall()
            {
                WeixinJSBridge.invoke('getBrandWCPayRequest',
                {
                    appId: "<%=wcPay.getAppId()%>",
                    timeStamp: "<%=wcPay.getTimeStamp()%>",
                    nonceStr: "<%=wcPay.getNonceStr()%>",
                    package: "<%=wcPay.getPackage()%>",
                    signType: "<%=wcPay.getSignType()%>",
                    paySign: "<%=wcPay.getPaySign()%>"
                },
                function(res) {
                    if (res.err_msg == "get_brand_wcpay_request:ok") {
                        alert("恭喜您，投票成功!");
                    }
                });
            }
            function callpay()
            {
                if (typeof WeixinJSBridge == "undefined") {
                    if (document.addEventListener) {
                        document.addEventListener('WeixinJSBridgeReady', jsApiCall, false);
                    } else if (document.attachEvent) {
                        document.attachEvent('WeixinJSBridgeReady', jsApiCall);
                        document.attachEvent('onWeixinJSBridgeReady', jsApiCall);
                    }
                } else {
                    jsApiCall();
                }
            }
        </script>
    </head>
    <body>
        <div id="container">
            <p class="text-center" style="margin-top: 20px;">
                <a id="chooseWXPay" href="javascript:callpay();" class=" btn btn-success btn-lg" style="font-size:30px;">
                    立即支付
                </a>
            </p>
        </div>
    </body>
</html>
