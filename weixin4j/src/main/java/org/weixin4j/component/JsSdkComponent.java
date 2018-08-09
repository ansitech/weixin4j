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
package org.weixin4j.component;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.RandomStringUtils;
import org.weixin4j.Configuration;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.http.HttpsClient;
import org.weixin4j.http.Response;
import org.weixin4j.model.js.Ticket;
import org.weixin4j.model.js.TicketType;
import org.weixin4j.model.js.WxConfig;
import org.weixin4j.util.SignUtil;

/**
 * Js接口组件
 * 
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.0
 */
public class JsSdkComponent extends AbstractComponent {

    public JsSdkComponent(Weixin weixin) {
        super(weixin);
    }

    /**
     * 获取jsapi_ticket对象，每次都返回最新
     *
     * @return 成功返回jsapi_ticket对象，失败返回NULL
     * @throws WeixinException
     */
    public Ticket getJsApiTicket() throws WeixinException {
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取jsapi_ticket接口
        Response res = http.get("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + weixin.getToken().getAccess_token() + "&type=jsapi");
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        //成功返回如下JSON:
        //{"errcode":0,"errmsg":"ok","ticket":"bxLdikRXVbTPdHSM05e5u5sUoXNKd8-41ZO3MhKoyN5OfkWITDGgnr2fwJ0m9E8NYzWKVZvdVtaUgWvsdshFKA","expires_in":7200}
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("获取jsapi_ticket返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            } else {
                return new Ticket(TicketType.JSAPI, jsonObj.getString("ticket"), jsonObj.getIntValue("expires_in"));
            }
        }
        return null;
    }

    /**
     * 获取微信Js接口配置
     *
     * @param url 当前网页的URL(包含?及参数，不包含#及其后面部分)
     * @return 微信接口配置对象
     * @throws org.weixin4j.WeixinException
     */
    public WxConfig getWxConfig(String url) throws WeixinException {
        String noncestr = RandomStringUtils.random(16, "abcdefghijklmnopqrstuvwxyz");
        return getWxConfig(weixin.getJsApiTicket().getTicket(), noncestr, System.currentTimeMillis() / 1000, url);
    }

    /**
     * 获取微信Js接口配置
     *
     * @param noncestr 随机字符串
     * @param timestamp 时间戳
     * @param url 当前网页的URL(包含?及参数，不包含#及其后面部分)
     * @return 微信接口配置对象
     * @throws org.weixin4j.WeixinException
     */
    public WxConfig getWxConfig(String noncestr, long timestamp, String url) throws WeixinException {
        return getWxConfig(weixin.getJsApiTicket().getTicket(), noncestr, timestamp, url);
    }

    /**
     * 获取微信Js接口配置
     *
     * @param jsapi_ticket 微信JS接口的临时票据
     * @param url 当前网页的URL(包含?及参数，不包含#及其后面部分)
     * @return 微信接口配置对象
     */
    public WxConfig getWxConfig(String jsapi_ticket, String url) {
        String noncestr = RandomStringUtils.random(16, "abcdefghijklmnopqrstuvwxyz");
        return getWxConfig(jsapi_ticket, noncestr, System.currentTimeMillis() / 1000, url);
    }

    /**
     * 获取微信Js接口配置
     *
     * @param jsapi_ticket 微信JS接口的临时票据
     * @param noncestr 随机字符串
     * @param timestamp 时间戳
     * @param url 当前网页的URL(包含?及参数，不包含#及其后面部分)
     * @return 微信接口配置对象
     */
    public WxConfig getWxConfig(String jsapi_ticket, String noncestr, long timestamp, String url) {
        //获取jsapi签名
        String sign = SignUtil.getSignature(jsapi_ticket, noncestr, timestamp + "", url);
        //返回微信js配置
        WxConfig wxConfig = new WxConfig();
        wxConfig.setAppId(weixin.getAppId());
        wxConfig.setNonceStr(noncestr);
        wxConfig.setTimestamp(timestamp + "");
        wxConfig.setSignature(sign);
        return wxConfig;
    }
}
