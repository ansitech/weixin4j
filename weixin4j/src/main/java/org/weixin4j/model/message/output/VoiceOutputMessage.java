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
package org.weixin4j.model.message.output;

import org.weixin4j.model.message.Voice;
import org.weixin4j.model.message.OutputMessage;

/**
 * 这个类实现了<tt>OutputMessage</tt>，用来回复语音消息
 *
 * <p>提供了获取语音Id<code>getVoice()</code>等主要方法.</p>
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class VoiceOutputMessage extends OutputMessage {

    /**
     * 消息类型:语音消息
     */
    private final String MsgType = "voice";
    /**
     * 通过上传多媒体文件，得到的id封装的Voice对象
     */
    private Voice Voice;

    /**
     * 创建一个新的 Output Message.并且MsgType的值为voice.
     */
    public VoiceOutputMessage() {
    }

    /**
     * 创建一个自定义语音Id mediaId的Output Message.
     *
     * @param voice 语音资源Id
     */
    public VoiceOutputMessage(Voice voice) {
        Voice = voice;
    }

    /**
     * 获取 消息类型
     *
     * @return 消息类型
     */
    @Override
    public String getMsgType() {
        return MsgType;
    }

    /**
     * 获取 通过上传多媒体文件，得到的id封装的Voice对象
     *
     * @return 通过上传多媒体文件，得到的id封装的Voice对象
     */
    public Voice getVoice() {
        return Voice;
    }

    /**
     * 设置 通过上传多媒体文件，得到的id封装的Voice对象
     *
     * @param voice 通过上传多媒体文件，得到的id封装的Voice对象
     */
    public void setVoice(Voice voice) {
        Voice = voice;
    }

    @Override
    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[").append(this.getToUserName()).append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[").append(this.getFromUserName()).append("]]></FromUserName>");
        sb.append("<CreateTime>").append(this.getCreateTime()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[" + this.MsgType + "]]></MsgType>");
        sb.append("<Voice>");
        sb.append("<MediaId><![CDATA[").append(this.getVoice().getMediaId()).append("]]></MediaId>");
        sb.append("</Voice>");
        sb.append("</xml>");
        return sb.toString();
    }
}