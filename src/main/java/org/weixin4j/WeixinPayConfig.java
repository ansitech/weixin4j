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
 * 微信支付配置
 *
 * @author yangqisheng
 * @since 0.1.3
 */
public class WeixinPayConfig {

    /**
     * 微信支付_商户ID
     */
    @Deprecated
    private String partnerId;
    /**
     * 微信支付_商户密钥
     */
    @Deprecated
    private String partnerKey;
    /**
     * 微信支付_通知URL
     */
    @Deprecated
    private String notifyUrl;
    /**
     * 开发者第三方用户唯一凭证
     */
    private String appId;
    /**
     * 商户号
     *
     * @since 0.1.6
     */
    private String mchId;
    /**
     * Api密钥
     */
    private String mchKey;
    /**
     * 证书路径
     */
    private String certPath;
    /**
     * 证书密钥，证书密码默认为您的商户号
     */
    private String certSecret;

    /**
     * 商户号，官方已改名，请调用getMchId()方法
     *
     * @return 商户号
     * @since 0.1.3
     * @deprecated
     */
    @Deprecated
    public String getPartnerId() {
        return partnerId;
    }

    @Deprecated
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    /**
     * 支付密钥，官方已改名，请调用getMchKey()方法
     *
     * <p>
     * 账户设置--API安全--密钥设置</p>
     *
     * @return 支付密钥
     * @since 0.1.3
     * @deprecated
     */
    @Deprecated
    public String getPartnerKey() {
        return partnerKey;
    }

    @Deprecated
    public void setPartnerKey(String partnerKey) {
        this.partnerKey = partnerKey;
    }

    @Deprecated
    public String getNotifyUrl() {
        return notifyUrl;
    }

    @Deprecated
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMchKey() {
        return mchKey;
    }

    public void setMchKey(String mchKey) {
        this.mchKey = mchKey;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public String getCertSecret() {
        return certSecret;
    }

    public void setCertSecret(String certSecret) {
        this.certSecret = certSecret;
    }
}
