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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 支付结果通用通知
 *
 * http://pay.weixin.qq.com/wiki/doc/api/index.php?chapter=9_7
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.4
 */
@XmlRootElement(name = "xml")
public class PayNotifyResult {

    /**
     * SUCCESS/FAIL
     *
     * 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
     */
    private String return_code;     //返回状态码
    /**
     * 返回信息，如非空，为错误原因
     *
     * 签名失败
     *
     * 参数格式校验错误
     */
    private String return_msg;      //返回信息

    private String appid;
    private String mch_id;
    private String device_info;
    private String nonce_str;
    private String sign;
    private String result_code;
    private String err_code;
    private String err_code_des;
    private String openid;
    private String is_subscribe;
    private String trade_type;
    private String bank_type;
    private String total_fee;
    private String fee_type;
    private String cash_fee;
    private String cash_fee_type;
    private String coupon_fee;
    private String coupon_count;
    private String transaction_id;
    private String out_trade_no;
    private String attach;
    private String time_end;

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("return_code", return_code);
        map.put("return_msg", return_msg);
        map.put("appid", appid);
        map.put("mch_id", mch_id);
        map.put("device_info", device_info);
        map.put("nonce_str", nonce_str);
        map.put("sign", sign);
        map.put("result_code", result_code);
        map.put("err_code", err_code);
        map.put("err_code_des", err_code_des);
        map.put("openid", openid);
        map.put("is_subscribe", is_subscribe);
        map.put("trade_type", trade_type);
        map.put("bank_type", bank_type);
        map.put("total_fee", total_fee);
        map.put("fee_type", fee_type);
        map.put("cash_fee", cash_fee);
        map.put("cash_fee_type", cash_fee_type);
        map.put("coupon_fee", coupon_fee);
        map.put("coupon_count", coupon_count);
        map.put("transaction_id", transaction_id);
        map.put("out_trade_no", out_trade_no);
        map.put("attach", attach);
        map.put("time_end", time_end);
        return map;
    }

    public String getReturn_code() {
        return return_code;
    }

    @XmlElement(name = "return_code")
    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    @XmlElement(name = "return_msg")
    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getAppid() {
        return appid;
    }

    @XmlElement(name = "appid")
    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    @XmlElement(name = "mch_id")
    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    @XmlElement(name = "device_info")
    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    @XmlElement(name = "nonce_str")
    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    @XmlElement(name = "sign")
    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResult_code() {
        return result_code;
    }

    @XmlElement(name = "result_code")
    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code() {
        return err_code;
    }

    @XmlElement(name = "err_code")
    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    @XmlElement(name = "err_code_des")
    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    public String getOpenid() {
        return openid;
    }

    @XmlElement(name = "openid")
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    @XmlElement(name = "is_subscribe")
    public void setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
    }

    public String getTrade_type() {
        return trade_type;
    }

    @XmlElement(name = "trade_type")
    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getBank_type() {
        return bank_type;
    }

    @XmlElement(name = "bank_type")
    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    @XmlElement(name = "total_fee")
    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getFee_type() {
        return fee_type;
    }

    @XmlElement(name = "fee_type")
    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getCash_fee() {
        return cash_fee;
    }

    @XmlElement(name = "cash_fee")
    public void setCash_fee(String cash_fee) {
        this.cash_fee = cash_fee;
    }

    public String getCash_fee_type() {
        return cash_fee_type;
    }

    @XmlElement(name = "cash_fee_type")
    public void setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
    }

    public String getCoupon_fee() {
        return coupon_fee;
    }

    @XmlElement(name = "coupon_fee")
    public void setCoupon_fee(String coupon_fee) {
        this.coupon_fee = coupon_fee;
    }

    public String getCoupon_count() {
        return coupon_count;
    }

    @XmlElement(name = "coupon_count")
    public void setCoupon_count(String coupon_count) {
        this.coupon_count = coupon_count;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    @XmlElement(name = "transaction_id")
    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    @XmlElement(name = "out_trade_no")
    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getAttach() {
        return attach;
    }

    @XmlElement(name = "attach")
    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getTime_end() {
        return time_end;
    }

    @XmlElement(name = "time_end")
    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }
}
