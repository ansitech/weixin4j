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
package org.weixin4j.model.pay;

import org.weixin4j.util.SignUtil;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.digest.DigestUtils;
import org.weixin4j.Configuration;
import org.weixin4j.util.MapUtil;

/**
 * JS API 微信支付
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class WXPay {

    private final String appId;             //公众号Id
    private final String timestamp;         //支付签名时间戳
    private final String nonceStr;          //支付签名随机串
    private final String packages;          //订单详情扩展字符串
    private final String signType = "MD5";  //签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
    private final String paySign;           //支付签名
    private final String signature;         //jsapi授权签名

    /**
     * chooseWXPay 旧版
     *
     * @param appId 公众号Id
     * @param jsapi_ticket jsapi验证票据
     * @param packages 签名参数
     * @param url 发起请求的url地址
     * @param paternerKey 商户密钥
     * @param appKey 商户支付密钥
     */
    public WXPay(String appId, String jsapi_ticket, WXPackage packages, String url, String paternerKey, String appKey) {
        this.appId = appId;
        this.timestamp = System.currentTimeMillis() / 1000 + "";
        this.nonceStr = java.util.UUID.randomUUID().toString().substring(0, 15);
        //生成订单详情扩展字符串
        this.packages = getPackage(packages.toMap(), paternerKey);
        //生成jsapi授权签名
        this.signature = SignUtil.getSignature(jsapi_ticket, this.nonceStr, this.timestamp, url);

        //对提交的参数进行签名
        Map<String, String> paySignMap = new HashMap<String, String>();
        paySignMap.put("appid", this.appId);
        paySignMap.put("timestamp", timestamp);
        paySignMap.put("noncestr", this.nonceStr);
        paySignMap.put("package", this.packages);
        paySignMap.put("appkey", appKey);

        //生成支付签名
        this.paySign = SignUtil.getOldSign(paySignMap);
    }

    /**
     * chooseWXPay 新版
     *
     * @param appId 公众号Id
     * @param jsapi_ticket jsapi验证票据
     * @param prepay_id 预下单Id
     * @param url 发起请求的url地址
     * @param paternerKey 商户密钥
     */
    public WXPay(String appId, String jsapi_ticket, String prepay_id, String url, String paternerKey) {
        this.appId = appId;
        this.timestamp = System.currentTimeMillis() / 1000 + "";
        this.nonceStr = java.util.UUID.randomUUID().toString().substring(0, 15);
        //生成订单详情扩展字符串
        this.packages = "prepay_id=" + prepay_id;
        //生成jsapi授权签名
        this.signature = SignUtil.getSignature(jsapi_ticket, this.nonceStr, this.timestamp, url);

        //对提交的参数进行签名
        Map<String, String> paySignMap = new HashMap<String, String>();
        paySignMap.put("appId", this.appId);
        paySignMap.put("timeStamp", timestamp);
        paySignMap.put("nonceStr", this.nonceStr);
        paySignMap.put("package", this.packages);
        paySignMap.put("signType", this.signType);

        //生成支付签名
        this.paySign = SignUtil.getSign(paySignMap, paternerKey);
    }

    /**
     * 生成package单详情扩展字符串
     *
     * package 生成方法：
     *
     * 由于package中携带了生成订单的详细信息， 因此在微信将对package里面的内容进行鉴权，
     * 确定package携带的信息是真实、有效、合理的。 因此，这里将定义生成package字符 串的方法。
     *
     * 1.对所有传入参数按照字段名的ASCII码从小到大排序（字典序）后，
     * 使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1， 注意：值为空的参数不参与签名；
     *
     * 2.在string1最后拼接上key=paternerKey得到stringSignTemp字符串，
     * 并对stringSignTemp进行md5运算，再将得到的字符串所有字符转换为大写， 得到sign值signValue。
     *
     * 3.对传入参数中所有键值对的value进行urlencode转码后重新拼接成字符串string2。
     * 对于JS前端程序，一定要使用函数encodeURIComponent进行urlencode编码
     * （注意！进行urlencode时要将空格转化为%20而不是+）。
     *
     * 4.将sign=signValue拼接到string2后面得到最终的package字符串。
     *
     * @param M 参数详情对象
     * @param paternerKey 商户密钥
     * @return 返回订单详情package
     */
    private static String getPackage(Map<String, String> M, String paternerKey) {
        //1.1 将packages参数进行字典序排序
        Map<String, String> sortParams = MapUtil.sortAsc(M);
        //1.2 使用URL键值对的格式
        String string1 = MapUtil.mapJoin(sortParams, false);
        //2.1 接上key=paternerKey
        String stringSignTemp = string1 + "&key=" + paternerKey;
        //2.2 MD5加密
        String sign = DigestUtils.md5Hex(stringSignTemp).toUpperCase();
        if (Configuration.isDebug()) {
            System.out.println("sign = " + sign);
        }
        //3 对传入参数中所有键值对的value进行urlencode转码
        String string2 = MapUtil.mapJoin(sortParams, true);
        if (Configuration.isDebug()) {
            System.out.println("string2 = " + string2);
        }
        //4 将sign=signValue拼接到string2后面得到最终的package字符串。
        return string2 + "&sign=" + sign;
    }

    public String getTimeStamp() {
        return timestamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getPackage() {
        return packages;
    }

    public String getPaySign() {
        return paySign;
    }

    public String getSignature() {
        return signature;
    }

    public String getAppId() {
        return appId;
    }

    public String getSignType() {
        return signType;
    }

}
