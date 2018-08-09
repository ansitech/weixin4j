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

import org.weixin4j.Configuration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * Title: 微信公众平台Token算法工具类</p>
 *
 * <p>
 * Description: 为应用提供URL算法<br /> 根据不同的URL返回不同的Token，以适应多微站的需求<br />
 * 例如：Url:http://www.weixin4j.org/api/tiexinqiao<br />
 * 则默认Token:为jEvQdLxi0PvtgK8N+HzUpA==<br /> 根据配置的系统Token不同，而改变</p>
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class TokenUtil {

    //此加密密钥用于加密公众号Token，一经配置，不能修改，一旦修改，所有公众号需要重新填写Token
    private static String systemToken = null;

    /**
     * 获取配置文件配置的Token
     *
     * @return 微站Token
     */
    public static String get() {
        if (systemToken == null) {
            systemToken = Configuration.getProperty("weixin4j.token", "weixin4j");
        }
        return systemToken;
    }

    /**
     * 加密/校验流程如下：
     *
     * <p>
     * 1. 将token、timestamp、nonce三个参数进行字典序排序<br>
     * 2.将三个参数字符串拼接成一个字符串进行sha1加密<br>
     * 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信<br>
     * </p>
     *
     * @param token Token验证密钥
     * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数，nonce参数
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @return 验证成功返回true,否则返回false
     */
    public static boolean checkSignature(String token, String signature, String timestamp, String nonce) {
        List<String> params = new ArrayList<String>();
        params.add(token);
        params.add(timestamp);
        params.add(nonce);
        //1. 将token、timestamp、nonce三个参数进行字典序排序
        Collections.sort(params, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //2. 将三个参数字符串拼接成一个字符串进行sha1加密
        String temp = SHA1.encode(params.get(0) + params.get(1) + params.get(2));
        //3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        return temp.equals(signature);
    }
}
