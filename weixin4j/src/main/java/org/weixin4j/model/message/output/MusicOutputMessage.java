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

import org.weixin4j.model.message.Music;
import org.weixin4j.model.message.OutputMessage;

/**
 * 这个类实现了<tt>OutputMessage</tt>，用来回复音乐消息
 *
 * <p>
 * 提供了获取音乐链接<code>getMusicURL()</code>等主要方法.</p>
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class MusicOutputMessage extends OutputMessage {

    /**
     * 消息类型:音乐消息
     */
    private final String MsgType = "music";
    /**
     * 音乐消息对象
     */
    private Music Music;

    @Override
    public String getMsgType() {
        return MsgType;
    }

    public MusicOutputMessage(Music music) {
        super();
        Music = music;
    }

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music Music) {
        this.Music = Music;
    }

    @Override
    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[").append(this.getToUserName()).append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[").append(this.getFromUserName()).append("]]></FromUserName>");
        sb.append("<CreateTime>").append(this.getCreateTime()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[" + this.MsgType + "]]></MsgType>");
        sb.append("<Music>");
        sb.append("<Title><![CDATA[").append(this.getMusic().getTitle()).append("]]></Title>");
        sb.append("<Description><![CDATA[").append(this.getMusic().getDescription()).append("]]></Description>");
        sb.append("<MusicUrl><![CDATA[").append(this.getMusic().getMusicUrl()).append("]]></MusicUrl>");
        sb.append("<HQMusicUrl><![CDATA[").append(this.getMusic().getHQMusicUrl()).append("]]></HQMusicUrl>");
        sb.append("<ThumbMediaId><![CDATA[").append(this.getMusic().getThumbMediaId()).append("]]></ThumbMediaId>");
        sb.append("</Music>");
        sb.append("</xml>");
        return sb.toString();
    }
}
