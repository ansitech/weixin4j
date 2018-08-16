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

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.weixin4j.WeixinBuilder;
import org.weixin4j.WeixinConfig;
import org.weixin4j.factory.WeixinFactory;
import org.weixin4j.WeixinPayConfig;
import org.weixin4j.loader.ITicketLoader;
import org.weixin4j.loader.ITokenLoader;

/**
 * 微信工厂Bean
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 1.0.0
 */
public class WeixinFactoryBean implements FactoryBean<WeixinFactory>, InitializingBean {

    /**
     * 微信公众号配置
     */
    private WeixinConfig weixinConfig;
    /**
     * 微信支付配置
     */
    private WeixinPayConfig weixinPayConfig;
    /**
     * 微信工厂
     */
    private WeixinFactory weixinFactory;
    /**
     * token加载器
     */
    private ITokenLoader tokenLoader;
    /**
     * ticket加载器
     */
    private ITicketLoader ticketLoader;

    public void setWeixinConfig(WeixinConfig weixinConfig) {
        this.weixinConfig = weixinConfig;
    }

    public void setWeixinPayConfig(WeixinPayConfig weixinPayConfig) {
        this.weixinPayConfig = weixinPayConfig;
    }

    public void setTokenLoader(ITokenLoader tokenLoader) {
        this.tokenLoader = tokenLoader;
    }

    public void setTicketLoader(ITicketLoader ticketLoader) {
        this.ticketLoader = ticketLoader;
    }

    @Override
    public Class<?> getObjectType() {
        return this.weixinFactory == null ? WeixinFactory.class : this.weixinFactory.getClass();
    }

    @Override
    public WeixinFactory getObject() throws Exception {
        System.out.println("WeixinFactoryBean...getObject...");
        if (this.weixinFactory == null) {
            afterPropertiesSet();
        }
        return this.weixinFactory;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("WeixinFactoryBean...afterPropertiesSet...");
        this.weixinFactory = buildWeixinFactory();
    }

    private WeixinFactory buildWeixinFactory() {
        System.out.println("WeixinFactoryBean...buildWeixinFactory...");
        WeixinBuilder weixinBuilder;
        if (this.weixinConfig != null) {
            if (this.weixinPayConfig != null) {
                weixinBuilder = WeixinBuilder.newInstance(weixinConfig, weixinPayConfig);
            } else {
                weixinBuilder = WeixinBuilder.newInstance(weixinConfig);
            }
        } else if (this.weixinPayConfig != null) {
            weixinBuilder = WeixinBuilder.newInstance(weixinPayConfig);
        } else {
            weixinBuilder = WeixinBuilder.newInstance();
        }
        if (this.tokenLoader != null) {
            System.out.println("WeixinFactoryBean.buildWeixinFactory." + this.tokenLoader.getClass().getName());
            weixinBuilder.setTokenLoader(tokenLoader);
        }
        if (this.ticketLoader != null) {
            System.out.println("WeixinFactoryBean.buildWeixinFactory." + this.ticketLoader.getClass().getName());
            weixinBuilder.setTicketLoader(ticketLoader);
        }
        return weixinBuilder.buildWeixinFactory();
    }
}
