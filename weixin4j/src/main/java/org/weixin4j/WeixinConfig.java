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
package org.weixin4j;

/**
 * 微信配置
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.3
 */
public class WeixinConfig {

    /**
     * 开发者第三方用户唯一凭证
     */
    private String appid;
    /**
     * 开发者第三方用户唯一凭证密钥
     */
    private String secret;
    /**
     * 公众号原始ID
     */
    private String originalid;
    /**
     * 消息加密方式 0:明文模式(默认), 1:兼容模式, 2:安全模式(推荐)
     */
    private int encodingtype = 0;
    /**
     * 消息加密密钥(43位字符组成A-Za-z0-9)
     */
    private String encodingaeskey;
    /**
     * 网页安全授权URL
     */
    private String oauthUrl;
    /**
     * 公众平台接口域名
     */
    private String apiDomain = "api.weixin.qq.com";

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getOriginalid() {
        return originalid;
    }

    public void setOriginalid(String originalid) {
        this.originalid = originalid;
    }

    public int getEncodingtype() {
        return encodingtype;
    }

    public void setEncodingtype(int encodingtype) {
        this.encodingtype = encodingtype;
    }

    public String getEncodingaeskey() {
        return encodingaeskey;
    }

    public void setEncodingaeskey(String encodingaeskey) {
        this.encodingaeskey = encodingaeskey;
    }

    public String getOauthUrl() {
        return oauthUrl;
    }

    public void setOauthUrl(String oauthUrl) {
        this.oauthUrl = oauthUrl;
    }

    public String getApiDomain() {
        return apiDomain;
    }

    public void setApiDomain(String apiDomain) {
        this.apiDomain = apiDomain;
    }
}
