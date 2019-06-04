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
 * 服务商统一下单
 *
 * 接口文档：https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_1
 *
 * <b>应用场景</b>
 *
 * 除付款码支付场景以外，商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易会话标识后再按Native、JSAPI、APP等不同场景生成交易串调起支付。
 *
 * <b>是否需要证书</b>
 *
 * 不需要
 *
 * @author yangqisheng
 * @since 0.1.5
 */
public class UnifiedOrderSL {

    private String appid;               //公众账号ID
    private String mch_id;              //商户号
    private String nonce_str;           //随机字符串
    private String sign;                //签名
    private String body;                //商品描述
    private String out_trade_no;        //商户订单号
    private String total_fee;           //总金额
    private String spbill_create_ip;    //终端IP
    private String notify_url;          //通知地址
    private String trade_type;          //交易类型 取值如下：JSAPI，NATIVE，APP
    private String product_id;          //商品ID，trade_type=NATIVE时，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
    private String openid;              //用户标识
    //服务商扩展字段
    private String sub_appid;           //子商户公众账号ID 
    private String sub_mch_id;          //子商户号
    private String sub_openid;          //用户子标识

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("appid", appid);
        map.put("body", body);
        map.put("mch_id", mch_id);
        map.put("nonce_str", nonce_str);
        map.put("notify_url", notify_url);
        if ("JSAPI".equals(trade_type)) {
            map.put("openid", openid);
        }
        map.put("out_trade_no", out_trade_no);
        if ("NATIVE".equals(trade_type)) {
            map.put("product_id", product_id);
        }
        map.put("spbill_create_ip", spbill_create_ip);
        if (sub_appid != null) {
            map.put("sub_appid", sub_appid);
        }
        map.put("sub_mch_id", sub_mch_id);
        if (sub_openid != null) {
            map.put("sub_openid", sub_openid);
        }
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
        if ("JSAPI".equals(trade_type)) {
            sb.append("<openid><![CDATA[").append(openid).append("]]></openid>");
        }
        sb.append("<out_trade_no><![CDATA[").append(out_trade_no).append("]]></out_trade_no>");
        if ("NATIVE".equals(trade_type)) {
            sb.append("<product_id><![CDATA[").append(product_id).append("]]></product_id>");
        }
        sb.append("<spbill_create_ip><![CDATA[").append(spbill_create_ip).append("]]></spbill_create_ip>");
        if (sub_appid != null) {
            sb.append("<sub_appid><![CDATA[").append(sub_appid).append("]]></sub_appid>");
        }
        sb.append("<sub_mch_id><![CDATA[").append(sub_mch_id).append("]]></sub_mch_id>");
        if (sub_openid != null) {
            sb.append("<sub_openid><![CDATA[").append(sub_openid).append("]]></sub_openid>");
        }
        sb.append("<total_fee><![CDATA[").append(total_fee).append("]]></total_fee>");
        sb.append("<trade_type><![CDATA[").append(trade_type).append("]]></trade_type>");
        sb.append("<sign><![CDATA[").append(sign).append("]]></sign>");
        sb.append("</xml>");
        return sb.toString();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public void setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSub_openid() {
        return sub_openid;
    }

    public void setSub_openid(String sub_openid) {
        this.sub_openid = sub_openid;
    }

}
