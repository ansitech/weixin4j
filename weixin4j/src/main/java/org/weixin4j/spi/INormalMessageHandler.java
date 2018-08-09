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
package org.weixin4j.spi;

import org.weixin4j.model.message.normal.TextInputMessage;
import org.weixin4j.model.message.normal.ImageInputMessage;
import org.weixin4j.model.message.normal.LinkInputMessage;
import org.weixin4j.model.message.normal.LocationInputMessage;
import org.weixin4j.model.message.normal.ShortVideoInputMessage;
import org.weixin4j.model.message.normal.VideoInputMessage;
import org.weixin4j.model.message.normal.VoiceInputMessage;
import org.weixin4j.model.message.OutputMessage;

/**
 * <p>
 * Title: 微信公众平台接受消息处理器</p>
 *
 * <p>
 * Description: 接受消息分8类，普通消息（1.文本消息、2.图片消息、3.语音消息<br />
 * 、4.视频消息、5.地理位置消息、6.链接消息）<br />
 * 事件推送（1.关注/取消关注事件、2.扫描带二维码参数事件、3.上报地理位置事件、4.自定义<br />
 * 菜单事件、5.点击菜单拉取消息时事件推送、6.点击菜单跳转链接时的事件推送</p>
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.6
 */
public interface INormalMessageHandler {

    /**
     * 文字内容的消息处理
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage textTypeMsg(TextInputMessage msg);

    /**
     * 图片类型的消息处理
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage imageTypeMsg(ImageInputMessage msg);

    /**
     * 语音类型的消息处理
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage voiceTypeMsg(VoiceInputMessage msg);

    /**
     * 视频类型的消息处理
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage videoTypeMsg(VideoInputMessage msg);

    /**
     * 小视频类型的消息处理
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage shortvideoTypeMsg(ShortVideoInputMessage msg);

    /**
     * 地理位置类型的消息处理
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage locationTypeMsg(LocationInputMessage msg);

    /**
     * 链接类型的消息处理
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage linkTypeMsg(LinkInputMessage msg);
}
