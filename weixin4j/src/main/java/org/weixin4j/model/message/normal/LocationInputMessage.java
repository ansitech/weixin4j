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

import org.weixin4j.model.message.MsgType;

/**
 * 地理位置消息
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class LocationInputMessage extends NormalMessage {

    //地理位置维度
    private String Location_X;
    //地理位置经度
    private String Location_Y;
    //地图缩放大小
    private Long Scale;
    //地理位置信息
    private String Label;

    @Override
    public String getMsgType() {
        return MsgType.Location.toString();
    }

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String Location_X) {
        this.Location_X = Location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String Location_Y) {
        this.Location_Y = Location_Y;
    }

    public Long getScale() {
        return Scale;
    }

    public void setScale(Long Scale) {
        this.Scale = Scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String Label) {
        this.Label = Label;
    }

}
