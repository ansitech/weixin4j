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
package org.weixin4j.model.qrcode;

/**
 * 二维码类型
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.0
 */
public enum QrcodeType {

    /**
     * 临时的整型参数值
     */
    QR_SCENE("QR_SCENE"),
    /**
     * 临时的字符串参数值
     */
    QR_STR_SCENE("QR_QR_STR_SCENE"),
    /**
     * 永久的整型参数值
     */
    QR_LIMIT_SCENE("QR_LIMIT_SCENE"),
    /**
     * 永久的字符串参数值
     */
    QR_LIMIT_STR_SCENE("QR_LIMIT_STR_SCENE");

    private String value = "";

    QrcodeType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static QrcodeType parse(String value) {
        if (value == null) {
            return null;
        }
        if (value.toUpperCase().equals(QR_SCENE.toString())) {
            return QR_SCENE;
        }
        if (value.toUpperCase().equals(QR_STR_SCENE.toString())) {
            return QR_STR_SCENE;
        }
        if (value.toUpperCase().equals(QR_LIMIT_SCENE.toString())) {
            return QR_LIMIT_SCENE;
        }
        if (value.toUpperCase().equals(QR_LIMIT_STR_SCENE.toString())) {
            return QR_LIMIT_STR_SCENE;
        }
        return null;
    }
}
