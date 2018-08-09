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

import org.weixin4j.util.TokenUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.weixin4j.spi.IMessageHandler;
import org.weixin4j.spi.HandlerFactory;

/**
 * 微信公众平台接受消息默认拦截器
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class WeixinUrlFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        if (Configuration.isDebug()) {
            System.out.println("WeixinUrlFilter启动成功!");
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        //微信服务器将发送GET请求到填写的URL上,这里需要判定是否为GET请求
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        if (Configuration.isDebug()) {
            System.out.println("获得微信请求:" + request.getMethod() + " 方式");
            System.out.println("微信请求URL:" + request.getServletPath());
        }
        //消息来源可靠性验证
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce");       // 随机数
        //Token为weixin4j.properties中配置的Token
        String token = TokenUtil.get();
        if (isGet) {
            //1.验证消息真实性
            //http://mp.weixin.qq.com/wiki/index.php?title=验证消息真实性
            //URL为http://www.weixin4j.org/api/公众号
            //成为开发者验证
            String echostr = request.getParameter("echostr");   //
            //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
            if (TokenUtil.checkSignature(token, signature, timestamp, nonce)) {
                response.getWriter().write(echostr);
            }
        } else {
            //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
            if (!TokenUtil.checkSignature(token, signature, timestamp, nonce)) {
                //消息不可靠，直接返回
                response.getWriter().write("");
                return;
            }
            //用户每次向公众号发送消息、或者产生自定义菜单点击事件时，响应URL将得到推送
            doPost(request, response);
        }
    }

    //当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上
    //用户在关注与取消关注公众号时，微信会把这个事件推送到开发者填写的URL
    //用户每次发送语音给公众号时，微信会在推送的语音消息XML数据包中，增加一个Recongnition字段
    private void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/xml");
            //获取POST流
            ServletInputStream in = request.getInputStream();
            if (Configuration.isDebug()) {
                System.out.println("接收到微信输入流,准备处理...");
            }
            IMessageHandler messageHandler = HandlerFactory.getMessageHandler();
            //处理输入消息，返回结果
            String xml = messageHandler.invoke(in);
            //返回结果
            response.getWriter().write(xml);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.getWriter().write("");
        }
    }

    @Override
    public void destroy() {
    }
}
