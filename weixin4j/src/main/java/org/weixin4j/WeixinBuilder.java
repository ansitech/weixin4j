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

import org.weixin4j.factory.WeixinFactory;
import org.weixin4j.factory.defaults.DefaultWeixinFactory;
import org.weixin4j.loader.ITicketLoader;
import org.weixin4j.loader.ITokenLoader;

/**
 * 微信对象构建器
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.0
 */
public final class WeixinBuilder {

    private Weixin weixin;
    private ITokenLoader tokenLoader;
    private ITicketLoader ticketLoader;

    /**
     * 获取一个新的微信构建器
     *
     * @return 微信构造器
     */
    public static WeixinBuilder newInstance() {
        WeixinBuilder builder = new WeixinBuilder();
        builder.weixin = new Weixin();
        return builder;
    }

    /**
     * 获取一个新的微信构建器
     *
     * @param appId 微信开发者appId
     * @param secret 微信开发者secret
     * @return 微信构造器
     */
    public static WeixinBuilder newInstance(String appId, String secret) {
        WeixinBuilder builder = new WeixinBuilder();
        builder.weixin = new Weixin(appId, secret);
        return builder;
    }

    /**
     * 外部自定义微信公众号配置
     *
     * @param weixinConfig 微信公众号配置对象
     * @return 自身引用对象
     * @since 0.1.3
     */
    public static WeixinBuilder newInstance(WeixinConfig weixinConfig) {
        WeixinBuilder builder = new WeixinBuilder();
        builder.weixin = new Weixin(weixinConfig);
        return builder;
    }

    /**
     * 外部自定义微信支付配置
     *
     * @param weixinPayConfig 微信支付配置对象
     * @return 自身引用对象
     * @since 0.1.3
     */
    public static WeixinBuilder newInstance(WeixinPayConfig weixinPayConfig) {
        WeixinBuilder builder = new WeixinBuilder();
        builder.weixin = new Weixin(weixinPayConfig);
        return builder;
    }

    /**
     * 外部自定义微信支付配置
     *
     * @param weixinConfig 微信公众号配置对象
     * @param weixinPayConfig 微信支付配置对象
     * @return 自身引用对象
     * @since 0.1.3
     */
    public static WeixinBuilder newInstance(WeixinConfig weixinConfig, WeixinPayConfig weixinPayConfig) {
        WeixinBuilder builder = new WeixinBuilder();
        builder.weixin = new Weixin(weixinConfig, weixinPayConfig);
        return builder;
    }

    /**
     * 配置access_token加载器
     *
     * @param tokenLoader token加载器
     * @return return this
     */
    public WeixinBuilder setTokenLoader(ITokenLoader tokenLoader) {
        if (tokenLoader == null) {
            throw new IllegalStateException("tokenLoader can't be null");
        }
        this.tokenLoader = tokenLoader;
        return this;
    }

    /**
     * 配置ticket加载器
     *
     * @param ticketLoader ticket加载器
     * @return return this
     */
    public WeixinBuilder setTicketLoader(ITicketLoader ticketLoader) {
        if (ticketLoader == null) {
            throw new IllegalStateException("ticketLoader can't be null");
        }
        this.ticketLoader = ticketLoader;
        return this;
    }

    /**
     * 返回最终配置好的Weixin对象
     *
     * @return 微信对象
     */
    public Weixin build() {
        if (tokenLoader != null) {
            weixin.tokenLoader = this.tokenLoader;
        }
        if (this.ticketLoader != null) {
            weixin.ticketLoader = this.ticketLoader;
        }
        return weixin;
    }

    /**
     * 返回微信工厂对象
     *
     * @return 微信工厂对象
     * @since 0.1.3
     */
    public WeixinFactory buildWeixinFactory() {
        DefaultWeixinFactory weixinFactory = new DefaultWeixinFactory();
        weixinFactory.setWeixin(build());
        return weixinFactory;
    }
}
