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
package org.weixin4j.model.js;

/**
 * 临时票据类型
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public enum TicketType {

    /**
     * 用于调用微信JSSDK的临时票据
     */
    JSAPI("jsapi"),
    /**
     * 用于调用微信卡券相关接口的临时票据
     */
    WX_CARD("wx_card");

    private String value = "";

    TicketType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
