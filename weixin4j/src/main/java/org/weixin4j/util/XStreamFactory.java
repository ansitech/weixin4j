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

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * 将微信POST的流转换为XStream，然后转换为InputMessage对象
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class XStreamFactory {

    /**
     * 将输入流转读取成字符串
     *
     * @param in 输入流
     * @return 字符串
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    public static String inputStream2String(InputStream in)
            throws UnsupportedEncodingException, IOException {
        if (in == null) {
            return "";
        }

        StringBuilder out = new StringBuilder();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1;) {
            out.append(new String(b, 0, n, "UTF-8"));
        }
        return out.toString();
    }
}
