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
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.3
 */
public class WeixinPayConfig {

    /**
     * 微信支付_商户ID
     */
    private String partnerId;
    /**
     * 微信支付_商户密钥
     */
    private String partnerKey;
    /**
     * 微信支付_通知URL
     */
    private String notifyUrl;
    /**
     * 证书路径
     */
    private String certPath;
    /**
     * 证书密钥
     */
    private String certSecret;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerKey() {
        return partnerKey;
    }

    public void setPartnerKey(String partnerKey) {
        this.partnerKey = partnerKey;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
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
