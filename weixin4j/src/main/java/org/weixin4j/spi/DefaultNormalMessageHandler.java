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
import org.weixin4j.model.message.normal.NormalMessage;
import org.weixin4j.model.message.normal.ShortVideoInputMessage;
import org.weixin4j.model.message.normal.VideoInputMessage;
import org.weixin4j.model.message.normal.VoiceInputMessage;
import org.weixin4j.model.message.OutputMessage;
import org.weixin4j.model.message.output.TextOutputMessage;

/**
 * <p>
 * Title: 微信公众平台接受消息处理器</p>
 *
 * <p>
 * Description: 此消息处理器只负责接收消息和返回已收到消息的功能，无特殊功能。</p>
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.6
 */
public class DefaultNormalMessageHandler implements INormalMessageHandler {

    private OutputMessage allType(NormalMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的消息已经收到！");
        return out;
    }

    @Override
    public OutputMessage textTypeMsg(TextInputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage imageTypeMsg(ImageInputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage voiceTypeMsg(VoiceInputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage videoTypeMsg(VideoInputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage shortvideoTypeMsg(ShortVideoInputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage locationTypeMsg(LocationInputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage linkTypeMsg(LinkInputMessage msg) {
        return allType(msg);
    }
}
