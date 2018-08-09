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
package org.weixin4j.model.message.normal;

import javax.xml.bind.annotation.XmlElement;

/**
 * 普通消息
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public abstract class NormalMessage {

    /**
     * 开发者微信号
     */
    private String ToUserName;
    /**
     * 发送方帐号（一个OpenID）
     */
    private String FromUserName;
    /**
     * 消息创建时间 （整型）
     */
    private Long CreateTime;
    /**
     * 消息id，64位整型
     */
    private Long MsgId;

    /**
     * 获取 消息类型
     *
     * @return 消息类型
     */
    public abstract String getMsgType();

    public String getToUserName() {
        return ToUserName;
    }

    @XmlElement(name = "ToUserName")
    public void setToUserName(String ToUserName) {
        this.ToUserName = ToUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    @XmlElement(name = "FromUserName")
    public void setFromUserName(String FromUserName) {
        this.FromUserName = FromUserName;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    @XmlElement(name = "CreateTime")
    public void setCreateTime(Long CreateTime) {
        this.CreateTime = CreateTime;
    }

    public Long getMsgId() {
        return MsgId;
    }

    @XmlElement(name = "MsgId")
    public void setMsgId(Long MsgId) {
        this.MsgId = MsgId;
    }
}
