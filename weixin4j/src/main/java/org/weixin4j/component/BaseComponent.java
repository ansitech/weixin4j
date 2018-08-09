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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.weixin4j.Configuration;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.http.HttpsClient;
import org.weixin4j.http.Response;
import org.weixin4j.model.base.Token;

/**
 * 基础组件
 * 
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.0
 */
public class BaseComponent extends AbstractComponent {

    public BaseComponent(Weixin weixin) {
        super(weixin);
    }

    /**
     * 获取access_token（每次都获取新的，请缓存下来，2小时过期）
     *
     * @return 获取的AccessToken对象
     * @throws org.weixin4j.WeixinException
     */
    public Token token() throws WeixinException {
        if (StringUtils.isEmpty(weixin.getAppId())) {
            throw new IllegalArgumentException("appid can't be null or empty");
        }
        if (StringUtils.isEmpty(weixin.getSecret())) {
            throw new IllegalArgumentException("secret can't be null or empty");
        }
        //拼接参数
        String param = "?grant_type=client_credential&appid=" + weixin.getAppId() + "&secret=" + weixin.getSecret();
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.get("https://api.weixin.qq.com/cgi-bin/token" + param);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj == null) {
            throw new WeixinException(getCause(-1));
        }
        if (Configuration.isDebug()) {
            System.out.println("getAccessToken返回json：" + jsonObj.toString());
        }
        Object errcode = jsonObj.get("errcode");
        if (errcode != null) {
            //返回异常信息
            throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
        }
        //设置凭证，设置accessToken和过期时间
        return (Token) JSONObject.toJavaObject(jsonObj, Token.class);
    }

    /**
     * 将一条长链接转成短链接
     *
     * @param long_url 长链接
     * @return 短链接
     * @throws org.weixin4j.WeixinException
     */
    public String shortUrl(String long_url) throws WeixinException {
        if (StringUtils.isEmpty(long_url)) {
            throw new IllegalStateException("long_url can not be null or empty");
        }
        JSONObject postJson = new JSONObject();
        postJson.put("action", "long2short");
        postJson.put("long_url", long_url);

        HttpsClient http = new HttpsClient();
        //调用创建Tick的access_token接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/shorturl?access_token=" + weixin.getToken().getAccess_token(), postJson);
        //根据请求结果判定，返回结果
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj == null) {
            throw new WeixinException(getCause(-1));
        }
        Object errcode = jsonObj.get("errcode");
        if (errcode != null && !errcode.toString().equals("0")) {
            //返回异常信息
            throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
        } else {
            return jsonObj.getString("short_url");
        }
    }

    /**
     * 获取微信服务器IP地址
     *
     * @return 微信服务器IP地址列表
     * @throws org.weixin4j.WeixinException
     */
    public List<String> getCallbackIp() throws WeixinException {
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取微信服务器IP接口
        Response res = http.get("https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=" + weixin.getToken().getAccess_token());
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        //成功返回如下JSON:
        //{"ip_list":["127.0.0.1","127.0.0.1"]}
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("获取getCallbackIp返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            } else {
                JSONArray ipList = jsonObj.getJSONArray("ip_list");
                if (ipList != null) {
                    //转换为List
                    List ips = ipList.subList(0, ipList.size());
                    return (List<String>) ips;
                }
            }
        }
        return null;
    }
}
