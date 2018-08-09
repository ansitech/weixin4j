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
 * 订单详情（package）扩展字符串定义
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.4
 */
public class WXPackage {

    private final String bank_type = "WX";  //银行通道类型,固定为"WX"(是)
    private String body;                    //商品描述，128字节以下(是)
    private String attach;                  //附加数据,128字节以下,附加数据，原样返回(否)
    private String partner;                 //商户号,商户号partnerId(是)
    private String out_trade_no;            //商户订单号 商户系统内部的订单号，32 个字符内、可包含字母；确保在商户系统唯一(是)
    private String total_fee;               //订单总金额,单位为分(是)
    private final String fee_type = "1";    //支付币种(是)
    private String notify_url;              //通知URL(是)
    private String spbill_create_ip;        //订单生成的机器IP(是)
    private String time_start;              //交易起始时间(否)
    private String time_expire;             //交易结束时间(否)
    private String transport_fee;           //物流费用(否)
    private String product_fee;             //商品费用(否)
    private String goods_tag;               //商品标记(否)
    private String input_charset = "GBK";   //传入参数字符编码(是)

    public String getBank_type() {
        return bank_type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
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

    public String getFee_type() {
        return fee_type;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_expire() {
        return time_expire;
    }

    public void setTime_expire(String time_expire) {
        this.time_expire = time_expire;
    }

    public String getTransport_fee() {
        return transport_fee;
    }

    public void setTransport_fee(String transport_fee) {
        this.transport_fee = transport_fee;
    }

    public String getProduct_fee() {
        return product_fee;
    }

    public void setProduct_fee(String product_fee) {
        this.product_fee = product_fee;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public String getInput_charset() {
        return input_charset;
    }

    public void setInput_charset(String input_charset) {
        this.input_charset = input_charset;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("bank_type", this.bank_type);
        map.put("body", this.body);
        map.put("partner", this.partner);
        map.put("out_trade_no", this.out_trade_no);
        map.put("total_fee", this.total_fee);
        map.put("fee_type", this.fee_type);
        map.put("notify_url", this.notify_url);
        map.put("spbill_create_ip", this.spbill_create_ip);
        map.put("input_charset", this.input_charset);

        if (attach != null && !attach.equals("")) {
            map.put("attach", this.attach);
        }
        if (time_start != null && !time_start.equals("")) {
            map.put("time_start", this.time_start);
        }
        if (time_expire != null && !time_expire.equals("")) {
            map.put("time_expire", this.time_expire);
        }
        if (transport_fee != null && !transport_fee.equals("")) {
            map.put("transport_fee", this.transport_fee);
        }
        if (product_fee != null && !product_fee.equals("")) {
            map.put("product_fee", this.product_fee);
        }
        if (goods_tag != null && !goods_tag.equals("")) {
            map.put("goods_tag", this.goods_tag);
        }
        return map;
    }
}
