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
package org.weixin4j.model.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
import org.weixin4j.model.message.normal.ImageInputMessage;
import org.weixin4j.model.message.normal.LinkInputMessage;
import org.weixin4j.model.message.normal.LocationInputMessage;
import org.weixin4j.model.message.normal.NormalMessage;
import org.weixin4j.model.message.normal.ShortVideoInputMessage;
import org.weixin4j.model.message.normal.TextInputMessage;
import org.weixin4j.model.message.normal.VideoInputMessage;
import org.weixin4j.model.message.normal.VoiceInputMessage;

/**
 * POST的XML数据包转换为消息接受对象
 *
 * <p>
 * 由于POST的是XML数据包，所以不确定为哪种接受消息，<br/>
 * 所以直接将所有字段都进行转换，最后根据<tt>MsgType</tt>字段来判断取何种数据</p>
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
@XmlRootElement(name = "xml")
public class InputMessage extends NormalMessage {

    private String MsgType = "text";
    // 文本消息
    private String Content;
    // 图片消息
    private String PicUrl;
    // 位置消息
    private String Location_X;
    private String Location_Y;
    private Long Scale;
    private String Label;
    // 链接消息
    private String Title;
    private String Description;
    private String Url;
    // 语音信息 视频消息
    private String MediaId;
    private String Format;
    private String Recognition;
    //视频消息 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
    private String ThumbMediaId;
    // 事件
    private String Event;
    private String EventKey;
    private String Ticket;
    private String MenuId;
    //上报地理位置事件
    private String Latitude;
    private String Longitude;
    private String Precision;
    //群发消息事件
    private String MsgID;
    private String Status;
    private int TotalCount;
    private int FilterCount;
    private int SentCount;
    private int ErrorCount;
    //扫码推事件
    private ScanCodeInfo ScanCodeInfo;
    //拍照发图
    private SendPicsInfo SendPicsInfo;
    //发送地理位置
    private SendLocationInfo SendLocationInfo;

    @Override
    public String getMsgType() {
        return MsgType;
    }

    @XmlElement(name = "MsgType")
    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    @XmlElement(name = "Content")
    public void setContent(String content) {
        Content = content;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    @XmlElement(name = "PicUrl")
    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getLocation_X() {
        return Location_X;
    }

    @XmlElement(name = "Location_X")
    public void setLocation_X(String locationX) {
        Location_X = locationX;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    @XmlElement(name = "Location_Y")
    public void setLocationY(String location_Y) {
        Location_Y = location_Y;
    }

    public Long getScale() {
        return Scale;
    }

    @XmlElement(name = "Scale")
    public void setScale(Long scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    @XmlElement(name = "Label")
    public void setLabel(String label) {
        Label = label;
    }

    public String getTitle() {
        return Title;
    }

    @XmlElement(name = "Title")
    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    @XmlElement(name = "Description")
    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    @XmlElement(name = "Url")
    public void setUrl(String url) {
        Url = url;
    }

    public String getEvent() {
        //转成小写
        return Event.toLowerCase();
    }

    @XmlElement(name = "Event")
    public void setEvent(String event) {
        Event = event;
    }

    public String getEventKey() {
        return EventKey;
    }

    @XmlElement(name = "EventKey")
    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getMediaId() {
        return MediaId;
    }

    @XmlElement(name = "MediaId")
    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    @XmlElement(name = "ThumbMediaId")
    public void setThumbMediaId(String ThumbMediaId) {
        this.ThumbMediaId = ThumbMediaId;
    }

    public String getFormat() {
        return Format;
    }

    @XmlElement(name = "Format")
    public void setFormat(String format) {
        Format = format;
    }

    public String getRecognition() {
        return Recognition;
    }

    @XmlElement(name = "Recognition")
    public void setRecognition(String recognition) {
        Recognition = recognition;
    }

    public String getTicket() {
        return Ticket;
    }

    @XmlElement(name = "Ticket")
    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public String getLatitude() {
        return Latitude;
    }

    @XmlElement(name = "Latitude")
    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    @XmlElement(name = "Longitude")
    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    @XmlElement(name = "Precision")
    public void setPrecision(String Precision) {
        this.Precision = Precision;
    }

    public String getStatus() {
        return Status;
    }

    @XmlElement(name = "Status")
    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    @XmlElement(name = "TotalCount")
    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
    }

    public int getFilterCount() {
        return FilterCount;
    }

    @XmlElement(name = "FilterCount")
    public void setFilterCount(int FilterCount) {
        this.FilterCount = FilterCount;
    }

    public int getSentCount() {
        return SentCount;
    }

    @XmlElement(name = "SentCount")
    public void setSentCount(int SentCount) {
        this.SentCount = SentCount;
    }

    public int getErrorCount() {
        return ErrorCount;
    }

    @XmlElement(name = "ErrorCount")
    public void setErrorCount(int ErrorCount) {
        this.ErrorCount = ErrorCount;
    }

    public String getMsgID() {
        return MsgID;
    }

    @XmlElement(name = "MsgID")
    public void setMsgID(String MsgID) {
        this.MsgID = MsgID;
    }

    public ScanCodeInfo getScanCodeInfo() {
        return ScanCodeInfo;
    }

    @XmlElement(name = "ScanCodeInfo")
    public void setScanCodeInfo(ScanCodeInfo ScanCodeInfo) {
        this.ScanCodeInfo = ScanCodeInfo;
    }

    public SendLocationInfo getSendLocationInfo() {
        return SendLocationInfo;
    }

    @XmlElement(name = "SendLocationInfo")
    public void setSendLocationInfo(SendLocationInfo SendLocationInfo) {
        this.SendLocationInfo = SendLocationInfo;
    }

    public SendPicsInfo getSendPicsInfo() {
        return SendPicsInfo;
    }

    @XmlElement(name = "SendPicsInfo")
    public void setSendPicsInfo(SendPicsInfo SendPicsInfo) {
        this.SendPicsInfo = SendPicsInfo;
    }

    public TextInputMessage toTextInputMessage() {
        TextInputMessage inputMessage = new TextInputMessage(Content);
        initNormalMessage(inputMessage);
        return inputMessage;
    }

    public ImageInputMessage toImageInputMessage() {
        ImageInputMessage inputMessage = new ImageInputMessage();
        inputMessage.setPicUrl(PicUrl);
        inputMessage.setMediaId(MediaId);
        initNormalMessage(inputMessage);
        return inputMessage;
    }

    public VoiceInputMessage toVoiceInputMessage() {
        VoiceInputMessage inputMessage = new VoiceInputMessage();
        inputMessage.setFormat(Format);
        inputMessage.setMediaId(MediaId);
        inputMessage.setRecognition(Recognition);
        initNormalMessage(inputMessage);
        return inputMessage;
    }

    public VideoInputMessage toVideoInputMessage() {
        VideoInputMessage inputMessage = new VideoInputMessage();
        inputMessage.setMediaId(MediaId);
        inputMessage.setThumbMediaId(ThumbMediaId);
        initNormalMessage(inputMessage);
        return inputMessage;
    }

    public ShortVideoInputMessage toShortVideoInputMessage() {
        ShortVideoInputMessage inputMessage = new ShortVideoInputMessage();
        inputMessage.setMediaId(MediaId);
        inputMessage.setThumbMediaId(ThumbMediaId);
        initNormalMessage(inputMessage);
        return inputMessage;
    }

    public LocationInputMessage toLocationInputMessage() {
        LocationInputMessage inputMessage = new LocationInputMessage();
        inputMessage.setLocation_X(Location_X);
        inputMessage.setLocation_Y(Location_Y);
        inputMessage.setLabel(Label);
        inputMessage.setScale(Scale);
        initNormalMessage(inputMessage);
        return inputMessage;
    }

    public LinkInputMessage toLinkInputMessage() {
        LinkInputMessage inputMessage = new LinkInputMessage();
        inputMessage.setTitle(Title);
        inputMessage.setDescription(Description);
        inputMessage.setUrl(Url);
        initNormalMessage(inputMessage);
        return inputMessage;
    }

    public SubscribeEventMessage toSubscribeEventMessage() {
        SubscribeEventMessage eventMessage = new SubscribeEventMessage();
        initEventMessage(eventMessage);
        return eventMessage;
    }

    public UnSubscribeEventMessage toUnSubscribeEventMessage() {
        UnSubscribeEventMessage eventMessage = new UnSubscribeEventMessage();
        initEventMessage(eventMessage);
        return eventMessage;
    }

    public QrsceneScanEventMessage toQrsceneScanEventMessage() {
        QrsceneScanEventMessage eventMessage = new QrsceneScanEventMessage();
        eventMessage.setEventKey(EventKey);
        eventMessage.setTicket(Ticket);
        initEventMessage(eventMessage);
        return eventMessage;
    }

    public QrsceneSubscribeEventMessage toQrsceneSubscribeEventMessage() {
        QrsceneSubscribeEventMessage eventMessage = new QrsceneSubscribeEventMessage();
        eventMessage.setEventKey(EventKey);
        eventMessage.setTicket(Ticket);
        initEventMessage(eventMessage);
        return eventMessage;
    }

    public LocationEventMessage toLocationEventMessage() {
        LocationEventMessage eventMessage = new LocationEventMessage();
        eventMessage.setLatitude(Latitude);
        eventMessage.setLongitude(Longitude);
        eventMessage.setPrecision(Precision);
        initEventMessage(eventMessage);
        return eventMessage;
    }

    public ClickEventMessage toClickEventMessage() {
        ClickEventMessage eventMessage = new ClickEventMessage();
        eventMessage.setEventKey(EventKey);
        initEventMessage(eventMessage);
        return eventMessage;
    }

    public ViewEventMessage toViewEventMessage() {
        ViewEventMessage eventMessage = new ViewEventMessage();
        eventMessage.setEventKey(EventKey);
        eventMessage.setMenuId(MenuId);
        initEventMessage(eventMessage);
        return eventMessage;
    }

    public ScanCodePushEventMessage toScanCodePushEventMessage() {
        ScanCodePushEventMessage eventMessage = new ScanCodePushEventMessage();
        eventMessage.setEventKey(EventKey);
        eventMessage.setScanCodeInfo(ScanCodeInfo);
        initEventMessage(eventMessage);
        return eventMessage;
    }

    public ScanCodeWaitMsgEventMessage toScanCodeWaitMsgEventMessage() {
        ScanCodeWaitMsgEventMessage eventMessage = new ScanCodeWaitMsgEventMessage();
        eventMessage.setEventKey(EventKey);
        eventMessage.setScanCodeInfo(ScanCodeInfo);
        initEventMessage(eventMessage);
        return eventMessage;
    }

    public PicSysPhotoEventMessage toPicSysPhotoEventMessage() {
        PicSysPhotoEventMessage eventMessage = new PicSysPhotoEventMessage();
        eventMessage.setEventKey(EventKey);
        eventMessage.setSendPicsInfo(SendPicsInfo);
        initEventMessage(eventMessage);
        return eventMessage;
    }

    public PicPhotoOrAlbumEventMessage toPicPhotoOrAlbumEventMessage() {
        PicPhotoOrAlbumEventMessage eventMessage = new PicPhotoOrAlbumEventMessage();
        eventMessage.setEventKey(EventKey);
        eventMessage.setSendPicsInfo(SendPicsInfo);
        initEventMessage(eventMessage);
        return eventMessage;
    }

    public PicWeixinEventMessage toPicWeixinEventMessage() {
        PicWeixinEventMessage eventMessage = new PicWeixinEventMessage();
        eventMessage.setEventKey(EventKey);
        eventMessage.setSendPicsInfo(SendPicsInfo);
        initEventMessage(eventMessage);
        return eventMessage;
    }

    public LocationSelectEventMessage toLocationSelectEventMessage() {
        LocationSelectEventMessage eventMessage = new LocationSelectEventMessage();
        eventMessage.setEventKey(EventKey);
        eventMessage.setSendLocationInfo(SendLocationInfo);
        initEventMessage(eventMessage);
        return eventMessage;
    }

    private void initNormalMessage(NormalMessage inputMessage) {
        inputMessage.setToUserName(this.getToUserName());
        inputMessage.setFromUserName(this.getFromUserName());
        inputMessage.setMsgId(this.getMsgId());
        inputMessage.setCreateTime(this.getCreateTime());
    }

    private void initEventMessage(EventMessage eventMessage) {
        eventMessage.setToUserName(this.getToUserName());
        eventMessage.setFromUserName(this.getFromUserName());
        eventMessage.setCreateTime(this.getCreateTime());
    }

    public String getMenuId() {
        return MenuId;
    }

    @XmlElement(name = "MenuId")
    public void setMenuId(String MenuId) {
        this.MenuId = MenuId;
    }
}
