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
     * 配置access_token加载器
     *
     * @param tokenLoader token加载器
     * @return return this
     */
    public WeixinBuilder setTokenLoader(ITokenLoader tokenLoader) {
        if (tokenLoader == null) {
            throw new IllegalStateException("tokenLoader can't be null");
        }
        weixin.tokenLoader = tokenLoader;
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
        weixin.ticketLoader = ticketLoader;
        return this;
    }

    /**
     * 返回最终配置好的Weixin对象
     *
     * @return 微信对象
     */
    public Weixin build() {
        return weixin;
    }
}
