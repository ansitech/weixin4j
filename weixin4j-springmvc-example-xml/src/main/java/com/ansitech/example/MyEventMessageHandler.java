package com.ansitech.example;

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
import org.weixin4j.model.message.event.SubscribeEventMessage;
import org.weixin4j.model.message.event.UnSubscribeEventMessage;
import org.weixin4j.model.message.event.ViewEventMessage;
import org.weixin4j.spi.IEventMessageHandler;

/**
 * MyEventMessageHandler
 *
 * @author yangqisheng
 */
public class MyEventMessageHandler implements IEventMessageHandler {

    @Override
    public OutputMessage subscribe(SubscribeEventMessage msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OutputMessage unSubscribe(UnSubscribeEventMessage msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OutputMessage qrsceneSubscribe(QrsceneSubscribeEventMessage msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OutputMessage qrsceneScan(QrsceneScanEventMessage msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OutputMessage location(LocationEventMessage msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OutputMessage click(ClickEventMessage msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OutputMessage view(ViewEventMessage msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OutputMessage scanCodePush(ScanCodePushEventMessage msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OutputMessage scanCodeWaitMsg(ScanCodeWaitMsgEventMessage msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OutputMessage picSysPhoto(PicSysPhotoEventMessage msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OutputMessage picPhotoOrAlbum(PicPhotoOrAlbumEventMessage msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OutputMessage picWeixin(PicWeixinEventMessage msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OutputMessage locationSelect(LocationSelectEventMessage msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
