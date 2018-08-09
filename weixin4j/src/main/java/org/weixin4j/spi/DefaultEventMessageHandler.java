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

import org.weixin4j.model.message.OutputMessage;
import org.weixin4j.model.message.event.ClickEventMessage;
import org.weixin4j.model.message.event.EventMessage;
import org.weixin4j.model.message.event.LocationEventMessage;
import org.weixin4j.model.message.event.LocationSelectEventMessage;
import org.weixin4j.model.message.event.PicPhotoOrAlbumEventMessage;
import org.weixin4j.model.message.event.PicSysPhotoEventMessage;
import org.weixin4j.model.message.event.PicWeixinEventMessage;
import org.weixin4j.model.message.event.QrsceneScanEventMessage;
import org.weixin4j.model.message.event.QrsceneSubscribeEventMessage;
import org.weixin4j.model.message.event.ScanCodePushEventMessage;
import org.weixin4j.model.message.event.ScanCodeWaitMsgEventMessage;
import org.weixin4j.model.message.event.SubscribeEventMessage;
import org.weixin4j.model.message.event.UnSubscribeEventMessage;
import org.weixin4j.model.message.event.ViewEventMessage;
import org.weixin4j.model.message.output.TextOutputMessage;

/**
 * 默认事件消息处理器
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.6
 */
public class DefaultEventMessageHandler implements IEventMessageHandler {

    private OutputMessage allType(EventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的消息已经收到！");
        return out;
    }

    @Override
    public OutputMessage subscribe(SubscribeEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage unSubscribe(UnSubscribeEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage qrsceneSubscribe(QrsceneSubscribeEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage qrsceneScan(QrsceneScanEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage location(LocationEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage click(ClickEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage view(ViewEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage scanCodePush(ScanCodePushEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage scanCodeWaitMsg(ScanCodeWaitMsgEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage picSysPhoto(PicSysPhotoEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage picPhotoOrAlbum(PicPhotoOrAlbumEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage picWeixin(PicWeixinEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage locationSelect(LocationSelectEventMessage msg) {
        return allType(msg);
    }

}
