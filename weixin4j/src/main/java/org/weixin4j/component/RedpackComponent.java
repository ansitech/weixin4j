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
import org.weixin4j.model.redpack.SendRedPack;
import org.weixin4j.model.redpack.SendRedPackResult;

/**
 * 红包组件
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.0
 */
public class RedpackComponent extends AbstractComponent {

    public RedpackComponent(Weixin weixin) {
        super(weixin);
    }

    /**
     * 发送现金红包
     *
     * <p>
     * 使用weixin4j.properties的配置</p>
     *
     * @param sendRedPack 现金红包对象
     * @return 发送现金红包返回结果对象
     * @throws org.weixin4j.WeixinException
     */
    public SendRedPackResult sendRedPack(SendRedPack sendRedPack) throws WeixinException {
        String partnerId = this.weixin.getWeixinPayConfig().getPartnerId();
        String certPath = this.weixin.getWeixinPayConfig().getCertPath();
        String certSecret = this.weixin.getWeixinPayConfig().getCertSecret();
        return sendRedPack(sendRedPack, partnerId, certPath, certSecret);
    }

    /**
     * 发送现金红包
     *
     * @param sendRedPack 现金红包对象
     * @param partnerId 商户ID
     * @param certPath 证书路径
     * @param certSecret 证书密钥
     * @return 发送现金红包返回结果对象
     * @throws org.weixin4j.WeixinException
     */
    public SendRedPackResult sendRedPack(SendRedPack sendRedPack, String partnerId, String certPath, String certSecret) throws WeixinException {
        //将统一下单对象转成XML
        String xmlPost = sendRedPack.toXML();
        if (Configuration.isDebug()) {
            System.out.println("调试模式_发送现金红包接口 提交XML数据：" + xmlPost);
        }
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //提交xml格式数据
        Response res = http.postXml("https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack", xmlPost, partnerId, certPath, certSecret);
        //获取微信平台下单接口返回数据
        String xmlResult = res.asString();
        try {
            JAXBContext context = JAXBContext.newInstance(SendRedPackResult.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SendRedPackResult result = (SendRedPackResult) unmarshaller.unmarshal(new StringReader(xmlResult));
            return result;
        } catch (JAXBException ex) {
            return null;
        }
    }
}
