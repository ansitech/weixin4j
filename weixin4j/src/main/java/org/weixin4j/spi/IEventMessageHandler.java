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

import org.weixin4j.model.message.event.SubscribeEventMessage;
import org.weixin4j.model.message.event.UnSubscribeEventMessage;
import org.weixin4j.model.message.OutputMessage;
import org.weixin4j.model.message.event.ClickEventMessage;
import org.weixin4j.model.message.event.LocationEventMessage;
import org.weixin4j.model.message.event.LocationSelectEventMessage;
import org.weixin4j.model.message.event.PicPhotoOrAlbumEventMessage;
import org.weixin4j.model.message.event.PicSysPhotoEventMessage;
import org.weixin4j.model.message.event.PicWeixinEventMessage;
import org.weixin4j.model.message.event.QrsceneScanEventMessage;
import org.weixin4j.model.message.event.QrsceneSubscribeEventMessage;
import org.weixin4j.model.message.event.ScanCodePushEventMessage;
import org.weixin4j.model.message.event.ScanCodeWaitMsgEventMessage;
import org.weixin4j.model.message.event.ViewEventMessage;

/**
 * 接收事件推送
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.6
 */
public interface IEventMessageHandler {

    /**
     * 关注事件
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage subscribe(SubscribeEventMessage msg);

    /**
     * 取消关注事件
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage unSubscribe(UnSubscribeEventMessage msg);

    /**
     * 用户未关注，扫描带参数二维码事件
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage qrsceneSubscribe(QrsceneSubscribeEventMessage msg);

    /**
     * 用户已关注，扫描带参数二维码事件
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage qrsceneScan(QrsceneScanEventMessage msg);

    /**
     * 上报地理位置事件
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage location(LocationEventMessage msg);

    /**
     * 自定义菜单事件,点击菜单拉取消息时的事件推送
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage click(ClickEventMessage msg);

    /**
     * 自定义菜单事件,点击菜单跳转链接时的事件推送
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage view(ViewEventMessage msg);

    /**
     * 自定义菜单事件,扫码推事件的事件推送
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage scanCodePush(ScanCodePushEventMessage msg);

    /**
     * 自定义菜单事件,扫码推事件的事件推送
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage scanCodeWaitMsg(ScanCodeWaitMsgEventMessage msg);

    /**
     * 自定义菜单事件,弹出系统拍照发图的事件推送
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage picSysPhoto(PicSysPhotoEventMessage msg);

    /**
     * 自定义菜单事件,弹出拍照或者相册发图的事件推送
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage picPhotoOrAlbum(PicPhotoOrAlbumEventMessage msg);

    /**
     * 自定义菜单事件,弹出微信相册发图器的事件推送
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage picWeixin(PicWeixinEventMessage msg);

    /**
     * 自定义菜单事件,弹出地理位置选择器的事件推送
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage locationSelect(LocationSelectEventMessage msg);
}
