package com.ansitech.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.weixin4j.factory.WeixinFactory;
import org.weixin4j.loader.ITicketLoader;
import org.weixin4j.loader.ITokenLoader;
import org.weixin4j.spi.IEventMessageHandler;
import org.weixin4j.spi.INormalMessageHandler;
import org.weixin4j.spring.MessageFactoryBean;
import org.weixin4j.spring.WeixinFactoryBean;
import org.weixin4j.spring.WeixinTemplate;

/**
 * WebConfig
 *
 * @author yangqisheng
 */
@Configuration
public class WebConfig {

    @Bean
    public WeixinFactoryBean weixinFactoryBean(ITokenLoader tokenLoader, ITicketLoader ticketLoader) {
        System.out.println("...WebConfig.WeixinFactoryBean...");
        WeixinFactoryBean weixinFactoryBean = new WeixinFactoryBean();
        weixinFactoryBean.setTokenLoader(tokenLoader);
        weixinFactoryBean.setTicketLoader(ticketLoader);
        return weixinFactoryBean;
    }

    @Bean
    public WeixinTemplate weixinTemplate(WeixinFactory weixinFactory) {
        System.out.println("...WebConfig.WeixinTemplate...");
        return new WeixinTemplate(weixinFactory);
    }

    @Bean
    public MessageFactoryBean messageFactoryBean(INormalMessageHandler normalMessageHandler, IEventMessageHandler eventMessageHandler) {
        System.out.println("...WebConfig.MessageFactoryBean...");
        MessageFactoryBean messageFactoryBean = new MessageFactoryBean();
        messageFactoryBean.setNormalMessageHandler(normalMessageHandler);
        messageFactoryBean.setEventMessageHandler(eventMessageHandler);
        return messageFactoryBean;
    }

}
