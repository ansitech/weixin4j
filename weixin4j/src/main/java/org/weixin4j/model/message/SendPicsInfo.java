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

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 发送的图片信息
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
@XmlRootElement(name = "SendPicsInfo")
public class SendPicsInfo {

    //发送的图片数量
    private int Count;
    //图片列表
    private List<PicList> PicList;

    public int getCount() {
        return Count;
    }

    @XmlElement(name = "Count")
    public void setCount(int Count) {
        this.Count = Count;
    }

    public List<PicList> getPicList() {
        return PicList;
    }

    @XmlElementWrapper(name = "PicList")
    @XmlElement(name = "item")
    public void setPicList(List<PicList> PicList) {
        this.PicList = PicList;
    }
}
