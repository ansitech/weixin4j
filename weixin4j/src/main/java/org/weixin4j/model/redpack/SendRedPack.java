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

import java.util.HashMap;
import java.util.Map;

/**
 * 现金红包对象
 *
 * 接口文档：https://pay.weixin.qq.com/wiki/doc/api/cash_coupon.php?chapter=13_5
 *
 * <p>
 * 用于企业向微信用户个人发现金红包</p>
 *
 * <p>
 * 目前支持向指定微信用户的openid发放指定金额红包。</p>
 *
 * <b>是否需要证书</b>
 *
 * 是（证书及使用说明详见https://pay.weixin.qq.com/wiki/doc/api/cash_coupon.php?chapter=4_3）
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.4
 */
public class SendRedPack {

    /**
     * 随机字符串
     *
     * 随机字符串，不长于32位
     */
    private String nonce_str;
    /**
     * 签名
     *
     * 签名算法：https://pay.weixin.qq.com/wiki/doc/api/cash_coupon.php?chapter=4_3
     */
    private String sign;
    /**
     * 商户订单号
     *
     * 商户订单号（每个订单号必须唯一）
     *
     * 组成：mch_id+yyyymmdd+10位一天内不能重复的数字。
     */
    private String mch_billno;
    /**
     * 商户号
     */
    private String mch_id;
    /**
     * 公众账号appid
     */
    private String wxappid;
    /**
     * 提供方名称
     */
    private String nick_name;
    /**
     * 商户名称
     *
     * 红包发送者名称
     */
    private String send_name;
    /**
     * 用户openid
     *
     * 接受红包的用户
     *
     * 用户在wxappid下的openid
     */
    private String re_openid;
    /**
     * 付款金额
     *
     * 付款金额，单位分
     */
    private int total_amount;
    /**
     * 最小红包金额
     *
     * 最小红包金额，单位分
     */
    private int min_value;
    /**
     * 最大红包金额
     *
     * 最大红包金额，单位分
     *
     * （最小金额等于最大金额：min_value=max_value=total_amount）
     */
    private int max_value;
    /**
     * 红包发放总人数
     *
     * total_num=1
     */
    private int total_num = 1;
    /**
     * 红包祝福语
     */
    private String wishing;
    /**
     * Ip地址
     */
    private String client_ip;
    /**
     * 活动名称
     */
    private String act_name;
    /**
     * 备注
     */
    private String remark;
    /**
     * 商户logo的url
     */
    private String logo_imgurl;

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("nonce_str", nonce_str);
        map.put("mch_billno", mch_billno);
        map.put("mch_id", mch_id);
        map.put("wxappid", wxappid);
        map.put("nick_name", nick_name);
        map.put("send_name", send_name);
        map.put("re_openid", re_openid);
        map.put("total_amount", total_amount + "");
        map.put("min_value", min_value + "");
        map.put("max_value", max_value + "");
        map.put("total_num", total_num + "");
        map.put("wishing", wishing);
        map.put("client_ip", client_ip);
        map.put("act_name", act_name);
        map.put("remark", remark);
        return map;
    }

    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<sign><![CDATA[").append(sign).append("]]></sign>");
        sb.append("<mch_billno><![CDATA[").append(mch_billno).append("]]></mch_billno>");
        sb.append("<mch_id><![CDATA[").append(mch_id).append("]]></mch_id>");
        sb.append("<wxappid><![CDATA[").append(wxappid).append("]]></wxappid>");
        sb.append("<nick_name><![CDATA[").append(nick_name).append("]]></nick_name>");
        sb.append("<send_name><![CDATA[").append(send_name).append("]]></send_name>");
        sb.append("<re_openid><![CDATA[").append(re_openid).append("]]></re_openid>");
        sb.append("<total_amount><![CDATA[").append(total_amount).append("]]></total_amount>");
        sb.append("<min_value><![CDATA[").append(min_value).append("]]></min_value>");
        sb.append("<max_value><![CDATA[").append(max_value).append("]]></max_value>");
        sb.append("<total_num><![CDATA[").append(total_num).append("]]></total_num>");
        sb.append("<wishing><![CDATA[").append(wishing).append("]]></wishing>");
        sb.append("<client_ip><![CDATA[").append(client_ip).append("]]></client_ip>");
        sb.append("<act_name><![CDATA[").append(act_name).append("]]></act_name>");
//        sb.append("<act_id><![CDATA[").append(act_id).append("]]></act_id>");
        sb.append("<remark><![CDATA[").append(remark).append("]]></remark>");
//        sb.append("<logo_imgurl><![CDATA[").append(logo_imgurl).append("]]></logo_imgurl>");
//        sb.append("<share_content><![CDATA[").append(share_content).append("]]></share_content>");
//        sb.append("<share_url><![CDATA[").append(share_url).append("]]></share_url>");
//        sb.append("<share_imgurl><![CDATA[").append(share_imgurl).append("]]></share_imgurl>");
        sb.append("<nonce_str><![CDATA[").append(nonce_str).append("]]></nonce_str>");
        sb.append("</xml>");
        return sb.toString();
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

    public String getMch_billno() {
        return mch_billno;
    }

    public void setMch_billno(String mch_billno) {
        this.mch_billno = mch_billno;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getWxappid() {
        return wxappid;
    }

    public void setWxappid(String wxappid) {
        this.wxappid = wxappid;
    }

    public String getNick_name() {
        return nick_name;
    }

    @Deprecated
    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getSend_name() {
        return send_name;
    }

    public void setSend_name(String send_name) {
        this.send_name = send_name;
    }

    public String getRe_openid() {
        return re_openid;
    }

    public void setRe_openid(String re_openid) {
        this.re_openid = re_openid;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
        this.min_value = total_amount;
        this.max_value = total_amount;
    }
//
//    public int getMin_value() {
//        return min_value;
//    }
//
//    public void setMin_value(int min_value) {
//        this.min_value = min_value;
//    }
//
//    public int getMax_value() {
//        return max_value;
//    }
//
//    public void setMax_value(int max_value) {
//        this.max_value = max_value;
//    }
//
//    public int getTotal_num() {
//        return total_num;
//    }
//
//    public void setTotal_num(int total_num) {
//        this.total_num = total_num;
//    }

    public String getWishing() {
        return wishing;
    }

    public void setWishing(String wishing) {
        this.wishing = wishing;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
//
//    public String getLogo_imgurl() {
//        return logo_imgurl;
//    }
//
//    public void setLogo_imgurl(String logo_imgurl) {
//        this.logo_imgurl = logo_imgurl;
//    }
}
