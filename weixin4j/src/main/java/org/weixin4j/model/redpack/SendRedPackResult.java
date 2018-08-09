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
package org.weixin4j.model.redpack;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 现金红包发放结果
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.4
 */
@XmlRootElement(name = "xml")
public class SendRedPackResult {

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
    private String sign;            //签名
    private String result_code;     //业务结果  SUCCESS/FAIL
    private String err_code;        //错误代码
    private String err_code_des;    //错误代码描述
    //*** 以下字段在return_code 和result_code都为SUCCESS的时候有返回 ***//
    private String mch_billno;      //商户订单号
    private String mch_id;          //商户号
    private String wxappid;         //商户appid
    private String re_openid;       //用户openid
    private int total_amount;       //付款金额
    private String send_time;       //发放成功时间
    private String send_listid;     //微信单号

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

    public String getMch_billno() {
        return mch_billno;
    }

    @XmlElement(name = "mch_billno")
    public void setMch_billno(String mch_billno) {
        this.mch_billno = mch_billno;
    }

    public String getMch_id() {
        return mch_id;
    }

    @XmlElement(name = "mch_id")
    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getWxappid() {
        return wxappid;
    }

    @XmlElement(name = "wxappid")
    public void setWxappid(String wxappid) {
        this.wxappid = wxappid;
    }

    public String getRe_openid() {
        return re_openid;
    }

    @XmlElement(name = "re_openid")
    public void setRe_openid(String re_openid) {
        this.re_openid = re_openid;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    @XmlElement(name = "total_amount")
    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public String getSend_time() {
        return send_time;
    }

    @XmlElement(name = "send_time")
    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }

    public String getSend_listid() {
        return send_listid;
    }

    @XmlElement(name = "send_listid")
    public void setSend_listid(String send_listid) {
        this.send_listid = send_listid;
    }
}
