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
package org.weixin4j.model.message.event;

import org.weixin4j.model.message.EventType;

/**
 * 扫描带参数二维码事件
 *
 * 用户未关注
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class QrsceneSubscribeEventMessage extends EventMessage {

    //事件KEY值，qrscene_为前缀，后面为二维码的参数值
    private String EventKey;
    //二维码的ticket，可用来换取二维码图片
    private String Ticket;

    @Override
    public String getEvent() {
        return EventType.Subscribe.toString();
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String EventKey) {
        this.EventKey = EventKey;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String Ticket) {
        this.Ticket = Ticket;
    }

}
