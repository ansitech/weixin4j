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

import java.security.MessageDigest;
import org.weixin4j.misc.BASE64Encoder;

/**
 * MD5加密算法
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class MD5 {

    /**
     * 将字符串加密
     *
     * @param str 要加密的字符串
     * @return 加密后的字符串
     */
    public static String encryptByMd5(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            byte[] b = str.getBytes();
            byte[] digest = md5.digest(b);
            String newstr = base64en.encode(digest);
            return newstr;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
