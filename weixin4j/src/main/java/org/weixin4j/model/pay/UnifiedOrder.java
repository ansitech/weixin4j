/*
 * 微信公众平台(JAVA) SDK
 *
 * Copyright (c) 2014, Ansitech Network Technology Co.,Ltd All rights reserved.
 * 
 * http://www.weixin4j.org/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.weixin4j.model.pay;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一下单
 *
 * 接口文档：http://pay.weixin.qq.com/wiki/doc/api/index.php?chapter=9_1
 *
 * <b>应用场景</b>
 *
 * 除被扫支付场景以外，商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易回话标识后再按扫码、JSAPI、APP等不同场景生成交易串调起支付。
 *
 * <b>是否需要证书</b>
 *
 * 不需要
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.4
 */
public class UnifiedOrder {

    private String appid;               //公众账号ID 是
    private String mch_id;              //商户号 是
    private String device_info;         //设备号
    private String nonce_str;           //随机字符串 是
    private String sign;                //签名 是
    private String body;                //商品描述 是
    private String detail;              //商品详情
    private String attach;              //附加数据
    private String out_trade_no;        //商户订单号 是
    private String fee_type;            //货币类型
    private String total_fee;           //总金额 是
    private String spbill_create_ip;    //终端IP 是
    private String time_start;          //交易起始时间
    private String time_expire;         //交易结束时间
    private String goods_tag;           //商品标记
    private String notify_url;          //通知地址 是
    private String trade_type;          //交易类型 是 取值如下：JSAPI，NATIVE，APP
    private String product_id;          //商品ID
    private String openid;              //用户标识

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("appid", appid);
        map.put("body", body);
        map.put("mch_id", mch_id);
        map.put("nonce_str", nonce_str);
        map.put("notify_url", notify_url);
        map.put("openid", openid);
        map.put("out_trade_no", out_trade_no);
        map.put("spbill_create_ip", spbill_create_ip);
        map.put("total_fee", total_fee);
        map.put("trade_type", trade_type);
        return map;
    }

    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<appid><![CDATA[").append(appid).append("]]></appid>");
        sb.append("<body><![CDATA[").append(body).append("]]></body>");
        sb.append("<mch_id><![CDATA[").append(mch_id).append("]]></mch_id>");
        sb.append("<nonce_str><![CDATA[").append(nonce_str).append("]]></nonce_str>");
        sb.append("<notify_url><![CDATA[").append(notify_url).append("]]></notify_url>");
        sb.append("<openid><![CDATA[").append(openid).append("]]></openid>");
        sb.append("<out_trade_no><![CDATA[").append(out_trade_no).append("]]></out_trade_no>");
        sb.append("<spbill_create_ip><![CDATA[").append(spbill_create_ip).append("]]></spbill_create_ip>");
        sb.append("<total_fee><![CDATA[").append(total_fee).append("]]></total_fee>");
        sb.append("<trade_type><![CDATA[").append(trade_type).append("]]></trade_type>");
        sb.append("<sign><![CDATA[").append(sign).append("]]></sign>");
        sb.append("</xml>");
        return sb.toString();
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
