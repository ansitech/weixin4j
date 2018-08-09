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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 查询订单结果
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.1
 */
@XmlRootElement(name = "xml")
public class OrderQueryResult {

    private String return_code;
    private String return_msg;
    //以下字段在return_code为SUCCESS的时候有返回 
    private String appid;               //公众账号ID 
    private String mch_id;             //商户号 
    private String nonce_str;          //随机字符串 
    private String sign;               //签名
    private String result_code;           //签名类型
    private String err_code;            //错误代码 
    private String err_code_des;        //错误代码描述
    //以下字段在return_code 、result_code、trade_state都为SUCCESS时有返回 ，如trade_state不为 SUCCESS，则只返回out_trade_no（必传）和attach（选传）。
    private String device_info;
    private String openid;
    private String is_subscribe;
    private String trade_type;
    private String trade_state;
    private String bank_type;
    private int total_fee;
    private int settlement_total_fee;
    private String fee_type;
    private int cash_fee;
    private String cash_fee_type;
    private int coupon_fee;
    private int coupon_count;
    private String transaction_id;      //微信支付订单号 
    private String attach;              //附加数据 
    private String out_trade_no;        //商户订单号 
    private String time_end;            //支付完成时间 
    private String trade_state_desc;    //交易状态描述

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

    public String getDevice_info() {
        return device_info;
    }

    @XmlElement(name = "device_info")
    public void setDevice_info(String device_info) {
        this.device_info = device_info;
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

    public String getTrade_state() {
        return trade_state;
    }

    @XmlElement(name = "trade_state")
    public void setTrade_state(String trade_state) {
        this.trade_state = trade_state;
    }

    public String getBank_type() {
        return bank_type;
    }

    @XmlElement(name = "bank_type")
    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    @XmlElement(name = "total_fee")
    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public int getSettlement_total_fee() {
        return settlement_total_fee;
    }

    @XmlElement(name = "settlement_total_fee")
    public void setSettlement_total_fee(int settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
    }

    public String getFee_type() {
        return fee_type;
    }

    @XmlElement(name = "fee_type")
    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public int getCash_fee() {
        return cash_fee;
    }

    @XmlElement(name = "cash_fee")
    public void setCash_fee(int cash_fee) {
        this.cash_fee = cash_fee;
    }

    public String getCash_fee_type() {
        return cash_fee_type;
    }

    @XmlElement(name = "cash_fee_type")
    public void setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
    }

    public int getCoupon_fee() {
        return coupon_fee;
    }

    @XmlElement(name = "coupon_fee")
    public void setCoupon_fee(int coupon_fee) {
        this.coupon_fee = coupon_fee;
    }

    public int getCoupon_count() {
        return coupon_count;
    }

    @XmlElement(name = "coupon_count")
    public void setCoupon_count(int coupon_count) {
        this.coupon_count = coupon_count;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    @XmlElement(name = "transaction_id")
    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getAttach() {
        return attach;
    }

    @XmlElement(name = "attach")
    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    @XmlElement(name = "out_trade_no")
    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTime_end() {
        return time_end;
    }

    @XmlElement(name = "time_end")
    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public String getTrade_state_desc() {
        return trade_state_desc;
    }

    @XmlElement(name = "trade_state_desc")
    public void setTrade_state_desc(String trade_state_desc) {
        this.trade_state_desc = trade_state_desc;
    }
}
