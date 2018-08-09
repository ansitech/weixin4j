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

/**
 * 回复图片消息中的图片对象
 *
 * <p>
 * 提供了获取图片Id<code>getMediaId()</code>等主要方法.</p>
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class Image implements java.io.Serializable {

    private String MediaId; //通过上传多媒体文件，得到的id

    /**
     * 获取 通过上传多媒体文件，得到的id
     *
     * @return 通过上传多媒体文件，得到的id
     */
    public String getMediaId() {
        return MediaId;
    }

    /**
     * 设置 通过上传多媒体文件，得到的id
     *
     * @param mediaId 通过上传多媒体文件，得到的id
     */
    public void setMediaId(String mediaId) {
        this.MediaId = mediaId;
    }
}
