/*
 * 微信公众平台(JAVA) SDK
 *
 * Copyright (c) 2014, Ansitech Network Technology Co.,Ltd All rights reserved.
 * 
 * http://www.weixin4j.org/spring/
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
package org.weixin4j.spring;

import org.springframework.beans.factory.DisposableBean;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.component.BaseComponent;
import org.weixin4j.component.FileComponent;
import org.weixin4j.component.GroupsComponent;
import org.weixin4j.component.JsSdkComponent;
import org.weixin4j.component.MaterialComponent;
import org.weixin4j.component.MediaComponent;
import org.weixin4j.component.MenuComponent;
import org.weixin4j.component.MessageComponent;
import org.weixin4j.component.PayComponent;
import org.weixin4j.component.QrcodeComponent;
import org.weixin4j.component.RedpackComponent;
import org.weixin4j.component.SnsComponent;
import org.weixin4j.component.TagsComponent;
import org.weixin4j.component.UserComponent;
import org.weixin4j.WeixinConfig;
import org.weixin4j.factory.WeixinFactory;
import org.weixin4j.WeixinPayConfig;
import org.weixin4j.model.base.Token;
import org.weixin4j.model.js.Ticket;

/**
 * 微信代理模板类
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 1.0.0
 */
public class WeixinTemplate extends Weixin implements DisposableBean {

    private final WeixinFactory weixinFactory;

    private final Weixin weixinProxy;

    public WeixinFactory getWeixinFactory() {
        return weixinFactory;
    }

    @Override
    public void destroy() throws Exception {
    }

    public WeixinTemplate(WeixinFactory weixinFactory) {
        this.weixinFactory = weixinFactory;
        this.weixinProxy = weixinFactory.getWeixin();
    }

    @Override
    public String getAppId() {
        return this.weixinProxy.getAppId();
    }

    @Override
    public String getSecret() {
        return this.weixinProxy.getSecret();
    }

    /**
     * 获取Token对象
     *
     * @return Token对象
     * @throws WeixinException
     * @since 0.1.0
     */
    @Override
    public Token getToken() throws WeixinException {
        return this.weixinProxy.getToken();
    }

    /**
     * 获取jsapi开发ticket
     *
     * @return jsapi_ticket
     * @throws WeixinException
     */
    @Override
    public Ticket getJsApiTicket() throws WeixinException {
        return this.weixinProxy.getJsApiTicket();
    }

    @Override
    public BaseComponent base() {
        return this.weixinProxy.base();
    }

    @Override
    public JsSdkComponent js() {
        return this.weixinProxy.js();
    }

    @Override
    public UserComponent user() {
        return this.weixinProxy.user();
    }

    @Override
    public SnsComponent sns() {
        return this.weixinProxy.sns();
    }

    @Override
    public SnsComponent sns(String authorize_url) {
        return this.weixinProxy.sns(authorize_url);
    }

    @Override
    public TagsComponent tags() {
        return this.weixinProxy.tags();
    }

    @Override
    public GroupsComponent groups() {
        return this.weixinProxy.groups();
    }

    @Override
    public PayComponent pay() {
        return this.weixinProxy.pay();
    }

    @Override
    public RedpackComponent redpack() {
        return this.weixinProxy.redpack();
    }

    @Override
    public MessageComponent message() {
        return this.weixinProxy.message();
    }

    @Override
    public MenuComponent menu() {
        return this.weixinProxy.menu();
    }

    @Override
    public MediaComponent media() {
        return this.weixinProxy.media();
    }

    @Override
    @Deprecated
    public FileComponent file() {
        return this.weixinProxy.file();
    }

    @Override
    public MaterialComponent material() {
        return this.weixinProxy.material();
    }

    @Override
    public QrcodeComponent qrcode() {
        return this.weixinProxy.qrcode();
    }

    @Override
    public WeixinConfig getWeixinConfig() {
        return this.weixinProxy.getWeixinConfig();
    }

    @Override
    public WeixinPayConfig getWeixinPayConfig() {
        return this.weixinProxy.getWeixinPayConfig();
    }
}
