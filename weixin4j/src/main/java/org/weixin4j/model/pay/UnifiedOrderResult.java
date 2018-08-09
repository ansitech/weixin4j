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
 * 统一下单结果
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.4
 */
@XmlRootElement(name = "xml")
public class UnifiedOrderResult {

    /**
     * 字段名：返回状态码
     *
     * 必填：是
     *
     * 类型：String(16)
     *
     * 描述：SUCCESS/FAIL
     *
     * 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
     */
    private String return_code;
    /**
     * 字段名：返回信息
     *
     * 必填：否
     *
     * 类型：String(128)
     *
     * 描述：返回信息，如非空，为错误原因
     *
     * 签名失败、参数格式校验错误等
     */
    private String return_msg;
    //*** 以下字段在return_code为SUCCESS的时候有返回 ***//
    private String appid;           //公众账号ID
    private String mch_id;          //商户号
    private String device_info;     //设备号
    private String nonce_str;       //随机字符串
    private String sign;            //签名
    private String result_code;     //业务结果  SUCCESS/FAIL
    private String err_code;        //错误代码
    private String err_code_des;    //错误代码描述
    //*** 以下字段在return_code 和result_code都为SUCCESS的时候有返回 ***//
    private String trade_type;      //交易类型
    private String prepay_id;       //预支付交易会话标识
    private String code_url;        //二维码链接

    /**
     * 通信是否成功
     *
     * @return 成功返回True，否则返回false
     */
    public boolean isSuccess() {
        if (return_code == null || return_code.equals("")) {
            return false;
        }
        return return_code.toUpperCase().equals("SUCCESS");
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

    public String getTrade_type() {
        return trade_type;
    }

    @XmlElement(name = "trade_type")
    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getPrepay_id() {
        return prepay_id;
    }

    @XmlElement(name = "prepay_id")
    public void setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
    }

    public String getCode_url() {
        return code_url;
    }

    @XmlElement(name = "code_url")
    public void setCode_url(String code_url) {
        this.code_url = code_url;
    }
}
