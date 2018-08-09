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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessControlException;
import java.util.Properties;

/**
 * 微信平台调用基础配置
 *
 * <p>
 * 如果存在weixin4j.properties,则加载属性文件中配置的参数</p>
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class Configuration {

    private static Properties defaultProperty;

    static {
        init();
    }

    static void init() {
        //初始化默认配置
        defaultProperty = new Properties();
        defaultProperty.setProperty("weixin4j.debug", "true");
        defaultProperty.setProperty("weixin4j.token", "weixin4j");
        defaultProperty.setProperty("weixin4j.http.connectionTimeout", "20000");
        defaultProperty.setProperty("weixin4j.http.readTimeout", "120000");
        defaultProperty.setProperty("weixin4j.http.retryCount", "3");
        //读取自定义配置
        String t4jProps = "weixin4j.properties";
        boolean loaded = loadProperties(defaultProperty, "." + File.separatorChar + t4jProps)
                || loadProperties(defaultProperty, Configuration.class.getResourceAsStream("/WEB-INF/" + t4jProps))
                || loadProperties(defaultProperty, Configuration.class.getClassLoader().getResourceAsStream(t4jProps));
        if (!loaded) {
            System.out.println("weixin4j:没有加载到weixin4j.properties属性文件!");
        }
    }

    /**
     * 加载属性文件
     *
     * @param props 属性文件实例
     * @param path 属性文件路径
     * @return 是否加载成功
     */
    private static boolean loadProperties(Properties props, String path) {
        try {
            File file = new File(path);
            if (file.exists() && file.isFile()) {
                props.load(new FileInputStream(file));
                return true;
            }
        } catch (IOException ignore) {
            //异常忽略
            ignore.printStackTrace();
        }
        return false;
    }

    /**
     * 加载属性文件
     *
     * @param props 属性文件实例
     * @param is 属性文件流
     * @return 是否加载成功
     */
    private static boolean loadProperties(Properties props, InputStream is) {
        try {
            if (is != null) {
                props.load(is);
                return true;
            }
        } catch (IOException ignore) {
            //异常忽略
            ignore.printStackTrace();
        }
        return false;
    }

    /**
     * 获取开发者第三方用户唯一凭证
     *
     * @return 第三方用户唯一凭证
     */
    public static String getOAuthAppId() {
        return getProperty("weixin4j.oauth.appid");
    }

    /**
     * 获取开发者第三方用户唯一凭证
     *
     * @param appid 默认第三方用户唯一凭证
     * @return 第三方用户唯一凭证
     */
    public static String getOAuthAppId(String appid) {
        return getProperty("weixin4j.oauth.appid", appid);
    }

    /**
     * 获取开发者第三方用户唯一凭证密钥
     *
     * @return 第三方用户唯一凭证密钥
     */
    public static String getOAuthSecret() {
        return getProperty("weixin4j.oauth.secret");
    }

    /**
     * 获取开发者第三方用户唯一凭证密钥
     *
     * @param secret 默认第三方用户唯一凭证密钥
     * @return 第三方用户唯一凭证密钥
     */
    public static String getOAuthSecret(String secret) {
        return getProperty("weixin4j.oauth.secret", secret);
    }

    /**
     * 获取 连接超时时间
     *
     * @return 连接超时时间
     */
    public static int getConnectionTimeout() {
        return getIntProperty("weixin4j.http.connectionTimeout");
    }

    /**
     * 获取 连接超时时间
     *
     * @param connectionTimeout 默认连接超时时间
     * @return 连接超时时间
     */
    public static int getConnectionTimeout(int connectionTimeout) {
        return getIntProperty("weixin4j.http.connectionTimeout", connectionTimeout);
    }

    /**
     * 获取 请求超时时间
     *
     * @return 请求超时时间
     */
    public static int getReadTimeout() {
        return getIntProperty("weixin4j.http.readTimeout");
    }

    /**
     * 获取 请求超时时间
     *
     * @param readTimeout 默认请求超时时间
     * @return 请求超时时间
     */
    public static int getReadTimeout(int readTimeout) {
        return getIntProperty("weixin4j.http.readTimeout", readTimeout);
    }

    /**
     * 获取 是否为调试模式
     *
     * @return 是否为调试模式
     */
    public static boolean isDebug() {
        return getBoolean("weixin4j.debug");
    }

    public static boolean getBoolean(String name) {
        String value = getProperty(name);
        return Boolean.valueOf(value);
    }

    public static int getIntProperty(String name) {
        String value = getProperty(name);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    public static int getIntProperty(String name, int fallbackValue) {
        String value = getProperty(name, String.valueOf(fallbackValue));
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    /**
     * 获取属性值
     *
     * @param name 属性名称
     * @return 属性值
     */
    public static String getProperty(String name) {
        return getProperty(name, null);
    }

    /**
     * 获取属性值
     *
     * @param name 属性名
     * @param fallbackValue 默认返回值
     * @return 属性值
     */
    public static String getProperty(String name, String fallbackValue) {
        String value;
        try {
            //从全局系统获取
            value = System.getProperty(name, null);
            if (null == value) {
                //先从系统配置文件获取
                value = defaultProperty.getProperty(name, fallbackValue);
            }
        } catch (AccessControlException ace) {
            // Unsigned applet cannot access System properties
            value = fallbackValue;
        }
        return value;
    }
}
