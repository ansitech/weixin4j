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

import org.weixin4j.model.message.Video;
import org.weixin4j.model.message.OutputMessage;

/**
 * 这个类实现了<tt>OutputMessage</tt>，用来回复视频消息
 *
 * <p>
 * 提供了获取视频Id<code>getMediaId()</code>等主要方法.</p>
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class VideoOutputMessage extends OutputMessage {

    /**
     * 消息类型:视频消息
     */
    private final String MsgType = "video";
    /**
     * 通过上传多媒体文件，得到的id
     */
    private Video Video;

    /**
     * 创建一个视频 Output Message.
     *
     * 并且MsgType的值为video.
     */
    public VideoOutputMessage() {
    }

    /**
     * 创建一个视频 Output Message.
     *
     * 并且MsgType的值为video.
     *
     * @param video 视频
     */
    public VideoOutputMessage(Video video) {
        Video = video;
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
     * 获取 通过上传多媒体文件，得到的id
     *
     * @return 通过上传多媒体文件，得到的id
     */
    public Video getVideo() {
        return Video;
    }

    /**
     * 设置 通过上传多媒体文件，得到的id
     *
     * @param video 通过上传多媒体文件，得到的id
     */
    public void setVideo(Video video) {
        Video = video;
    }

    @Override
    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[").append(this.getToUserName()).append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[").append(this.getFromUserName()).append("]]></FromUserName>");
        sb.append("<CreateTime>").append(this.getCreateTime()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[" + this.MsgType + "]]></MsgType>");
        sb.append("<Video>");
        sb.append("<MediaId><![CDATA[").append(this.getVideo().getMediaId()).append("]]></MediaId>");
        sb.append("<Title><![CDATA[").append(this.getVideo().getTitle()).append("]]></Title>");
        sb.append("<Description><![CDATA[").append(this.getVideo().getDescription()).append("]]></Description>");
        sb.append("</Video>");
        sb.append("</xml>");
        return sb.toString();
    }
}
