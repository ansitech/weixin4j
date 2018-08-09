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
package org.weixin4j.model.message.event;

import org.weixin4j.model.message.EventType;

/**
 * 上报地理位置事件
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class LocationEventMessage extends EventMessage {

    //地理位置纬度
    private String Latitude;
    //地理位置经度
    private String Longitude;
    //地理位置精度
    private String Precision;

    @Override
    public String getEvent() {
        return EventType.Location.toString();
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String Precision) {
        this.Precision = Precision;
    }

}
