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
package org.weixin4j.util;

import java.io.StringReader;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.weixin4j.model.pay.PayNotifyResult;
import org.weixin4j.model.pay.WCPay;
import org.weixin4j.model.pay.WXPackage;
import org.weixin4j.model.pay.WXPay;

/**
 * 微信支付工具
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.4
 */
public class PayUtil {

    /**
     * 对预下单Id进行H5支付
     *
     * @param appId 开发者Id
     * @param prepay_id 预下单Id
     * @param paternerKey 商户密钥
     * @return 支付对象
     */
    public static WCPay getBrandWCPayRequest(String appId, String prepay_id, String paternerKey) {
        //初始化支付对象
        return new WCPay(appId, prepay_id, paternerKey);
    }

    /**
     * chooseWXPay 旧版
     *
     * @param appId 公众号Id
     * @param jsapi_ticket jsapi验证票据
     * @param packages 签名参数
     * @param url 发起请求的url地址
     * @param paternerKey 商户密钥
     * @param appKey 商户支付密钥
     * @return 支付对象
     */
    @Deprecated
    public static WXPay getChooseWXPay(String appId, String jsapi_ticket, WXPackage packages, String url, String paternerKey, String appKey) {
        return new WXPay(appId, jsapi_ticket, packages, url, paternerKey, appKey);
    }

    /**
     * chooseWXPay 新版
     *
     * @param appId 公众号Id
     * @param jsapi_ticket jsapi验证票据
     * @param prepay_id 预下单Id
     * @param paternerKey 商户密钥
     * @param url 发起请求的url地址
     * @return 支付对象
     */
    public static WXPay getChooseWXPay(String appId, String jsapi_ticket, String prepay_id, String url, String paternerKey) {
        return new WXPay(appId, jsapi_ticket, prepay_id, url, paternerKey);
    }

    /**
     * 验证签名
     *
     * @param xmlMsg xml参数字符串
     * @param paternerKey 商户密钥
     * @return 签名验证，成功返回true,否则返回false
     */
    public static boolean verifySign(String xmlMsg, String paternerKey) {
        try {
            JAXBContext context = JAXBContext.newInstance(PayNotifyResult.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            PayNotifyResult result = (PayNotifyResult) unmarshaller.unmarshal(new StringReader(xmlMsg));
            //转换为Map
            Map<String, String> M = result.toMap();
            if (M.containsKey("sign")) {
                M.remove("sign");
            }
            //签名
            String sign = SignUtil.getSign(M, paternerKey);
            if (sign == null || sign.equals("")) {
                return false;
            }
            //判断是否一致
            return sign.equals(result.getSign());
        } catch (JAXBException ex) {
            return false;
        }
    }
}
