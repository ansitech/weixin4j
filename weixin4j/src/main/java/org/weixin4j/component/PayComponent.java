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
package org.weixin4j.component;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.weixin4j.Configuration;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.http.HttpsClient;
import org.weixin4j.http.Response;
import org.weixin4j.model.pay.OrderQuery;
import org.weixin4j.model.pay.OrderQueryResult;
import org.weixin4j.model.pay.UnifiedOrder;
import org.weixin4j.model.pay.UnifiedOrderResult;

/**
 * 支付组件
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.0
 */
public class PayComponent extends AbstractComponent {

    public PayComponent(Weixin weixin) {
        super(weixin);
    }

    /**
     * 统一下单
     *
     * @param unifiedorder 统一下单对象
     * @return 下单返回结果对象
     * @throws org.weixin4j.WeixinException
     */
    public UnifiedOrderResult payUnifiedOrder(UnifiedOrder unifiedorder) throws WeixinException {
        //将统一下单对象转成XML
        String xmlPost = unifiedorder.toXML();
        if (Configuration.isDebug()) {
            System.out.println("调试模式_统一下单接口 提交XML数据：" + xmlPost);
        }
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //提交xml格式数据
        Response res = http.postXml("https://api.mch.weixin.qq.com/pay/unifiedorder", xmlPost);
        //获取微信平台下单接口返回数据
        String xmlResult = res.asString();
        try {
            JAXBContext context = JAXBContext.newInstance(UnifiedOrderResult.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            UnifiedOrderResult result = (UnifiedOrderResult) unmarshaller.unmarshal(new StringReader(xmlResult));
            return result;
        } catch (JAXBException ex) {
            return null;
        }
    }

    /**
     * 查询订单
     *
     * @param orderQuery 订单查询对象
     * @return 订单查询结果
     * @throws org.weixin4j.WeixinException
     */
    public OrderQueryResult payOrderQuery(OrderQuery orderQuery) throws WeixinException {
        //将统一下单对象转成XML
        String xmlPost = orderQuery.toXML();
        if (Configuration.isDebug()) {
            System.out.println("调试模式_查询订单接口 提交XML数据：" + xmlPost);
        }
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //提交xml格式数据
        Response res = http.postXml("https://api.mch.weixin.qq.com/pay/orderquery", xmlPost);
        //获取微信平台查询订单接口返回数据
        String xmlResult = res.asString();
        try {
            if (Configuration.isDebug()) {
                System.out.println("调试模式_查询订单接口 接收XML数据：" + xmlResult);
            }
            JAXBContext context = JAXBContext.newInstance(OrderQueryResult.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            OrderQueryResult result = (OrderQueryResult) unmarshaller.unmarshal(new StringReader(xmlResult));
            return result;
        } catch (JAXBException ex) {
            return null;
        }
    }
}
