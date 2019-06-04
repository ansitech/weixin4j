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
 * @author yangqisheng
 * @since 0.1.5
 */
@XmlRootElement(name = "xml")
public class PayNotifySLResult {

    //通知参数
    private String return_code;     //返回状态码
    private String return_msg;      //返回信息
    //以下字段在return_code为SUCCESS的时候有返回
    private String appid;           //公众账号ID
    private String mch_id;          //商户号
    private String sub_appid;       //子商户公众账号ID
    private String sub_mch_id;      //子商户号
    private String device_info;     //设备号
    private String is_subscribe;    //是否关注公众账号，用户是否关注公众账号，Y-关注，N-未关注（机构商户不返回）
    private String nonce_str;       //随机字符串
    private String sub_is_subscribe;//是否关注子公众账号
    private String sign;            //签名
    private String result_code;     //业务结果
    private String err_code;        //错误代码
    private String err_code_des;    //错误代码描述
    private String openid;          //用户标识
    private String sub_openid;      //用户子标识
    private String trade_type;      //交易类型
    private String bank_type;       //付款银行
    private String total_fee;       //总金额
    private String fee_type;        //货币种类
    private String cash_fee;        //现金支付金额
    private String cash_fee_type;   //现金支付货币类型
    private String settlement_total_fee;    //应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
    private String coupon_fee;      //代金券金额
    private String coupon_count;    //代金券使用数量
    private String transaction_id;  //微信支付订单号
    private String out_trade_no;    //商户订单号
    private String attach;          //商家数据包
    private String time_end;        //支付完成时间

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("return_code", return_code);
        map.put("return_msg", return_msg);
        map.put("appid", appid);
        map.put("mch_id", mch_id);
        map.put("sub_mch_id", sub_mch_id);
        map.put("device_info", device_info);
        map.put("nonce_str", nonce_str);
        map.put("sub_is_subscribe", sub_is_subscribe);
        map.put("sign", sign);
        map.put("result_code", result_code);
        map.put("err_code", err_code);
        map.put("err_code_des", err_code_des);
        map.put("openid", openid);
        map.put("sub_openid", sub_openid);
        map.put("is_subscribe", is_subscribe);
        map.put("trade_type", trade_type);
        map.put("bank_type", bank_type);
        map.put("total_fee", total_fee);
        map.put("fee_type", fee_type);
        map.put("cash_fee", cash_fee);
        map.put("cash_fee_type", cash_fee_type);
        map.put("settlement_total_fee", settlement_total_fee);
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

    public String getSub_appid() {
        return sub_appid;
    }

    @XmlElement(name = "sub_appid")
    public void setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
    }

    public String getSub_is_subscribe() {
        return sub_is_subscribe;
    }

    @XmlElement(name = "sub_is_subscribe")
    public void setSub_is_subscribe(String sub_is_subscribe) {
        this.sub_is_subscribe = sub_is_subscribe;
    }

    public String getSub_openid() {
        return sub_openid;
    }

    @XmlElement(name = "sub_openid")
    public void setSub_openid(String sub_openid) {
        this.sub_openid = sub_openid;
    }

    public String getSettlement_total_fee() {
        return settlement_total_fee;
    }

    @XmlElement(name = "settlement_total_fee")
    public void setSettlement_total_fee(String settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }
}
