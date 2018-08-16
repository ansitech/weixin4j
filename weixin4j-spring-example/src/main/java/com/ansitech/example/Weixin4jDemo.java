package com.ansitech.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.weixin4j.spring.WeixinTemplate;

/**
 * Weixin4jDemo
 *
 * @author yangqisheng
 */
public class Weixin4jDemo {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        WeixinTemplate weixinTemplate = (WeixinTemplate) ac.getBean("weixinTemplate");
        System.out.println("appId=" + weixinTemplate.getAppId());
    }
}
