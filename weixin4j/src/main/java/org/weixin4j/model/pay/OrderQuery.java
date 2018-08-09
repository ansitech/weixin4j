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
 * 查询订单
 *
 * 接口文档：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_2
 *
 * <b>应用场景</b>
 *
 * 该接口提供所有微信支付订单的查询，商户可以通过查询订单接口主动查询订单状态，完成下一步的业务逻辑。
 *
 * 需要调用查询接口的情况：
 *
 * ◆ 当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知；
 *
 * ◆ 调用支付接口后，返回系统错误或未知交易状态情况；
 *
 * ◆ 调用刷卡支付API，返回USERPAYING的状态；
 *
 * ◆ 调用关单或撤销接口API之前，需确认支付状态；
 *
 * <b>是否需要证书</b>
 *
 * 不需要
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.1
 */
public class OrderQuery {

    private String appid;               //公众账号ID 
    private String mch_id;             //商户号 
    private String transaction_id;     //微信订单号(二选一，优先)
    private String out_trade_no;       //商户订单号(二选一)
    private String nonce_str;          //随机字符串 
    private String sign;               //签名
    private String sign_type;           //签名类型

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("appid", appid);
        map.put("mch_id", mch_id);
        if (transaction_id != null && !transaction_id.equals("")) {
            map.put("transaction_id", transaction_id);
        } else {
            map.put("out_trade_no", out_trade_no);
        }
        map.put("nonce_str", nonce_str);
        return map;
    }

    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<appid><![CDATA[").append(appid).append("]]></appid>");
        sb.append("<mch_id><![CDATA[").append(mch_id).append("]]></mch_id>");
        sb.append("<nonce_str><![CDATA[").append(nonce_str).append("]]></nonce_str>");
        if (transaction_id != null && !transaction_id.equals("")) {
            sb.append("<transaction_id><![CDATA[").append(transaction_id).append("]]></transaction_id>");
        } else {
            sb.append("<out_trade_no><![CDATA[").append(out_trade_no).append("]]></out_trade_no>");
        }
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

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
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

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

}
