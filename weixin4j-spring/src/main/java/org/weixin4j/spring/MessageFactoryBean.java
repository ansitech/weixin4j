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
import org.weixin4j.spi.DefaultMessageHandler;
import org.weixin4j.spi.HandlerFactory;
import org.weixin4j.spi.IEventMessageHandler;
import org.weixin4j.spi.IMessageHandler;
import org.weixin4j.spi.INormalMessageHandler;

/**
 * 微信公众号消息工厂Bean
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 1.0.0
 */
public class MessageFactoryBean implements FactoryBean<IMessageHandler>, InitializingBean {

    private IMessageHandler messageHandler;

    private INormalMessageHandler normalMessageHandler;

    private IEventMessageHandler eventMessageHandler;

    public void setNormalMessageHandler(INormalMessageHandler normalMessageHandler) {
        this.normalMessageHandler = normalMessageHandler;
    }

    public void setEventMessageHandler(IEventMessageHandler eventMessageHandler) {
        this.eventMessageHandler = eventMessageHandler;
    }

    @Override
    public IMessageHandler getObject() throws Exception {
        if (this.messageHandler == null) {
            afterPropertiesSet();
        }
        return this.messageHandler;
    }

    @Override
    public Class<?> getObjectType() {
        return this.messageHandler == null ? IMessageHandler.class : this.messageHandler.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (normalMessageHandler == null) {
            normalMessageHandler = HandlerFactory.getNormalMessageHandler();
        }
        if (eventMessageHandler == null) {
            eventMessageHandler = HandlerFactory.getEventMessageHandler();
        }
        System.out.println("MessageFactoryBean.afterPropertiesSet." + this.normalMessageHandler.getClass().getName());
        System.out.println("MessageFactoryBean.afterPropertiesSet." + this.eventMessageHandler.getClass().getName());
        messageHandler = new DefaultMessageHandler(normalMessageHandler, eventMessageHandler);
    }

}
