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
package org.weixin4j.model.menu;

/**
 * 永久素材(只能是图文消息)
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class ViewLimitedButton extends SingleButton {

    /**
     * 类型必须.网页链接，用户点击菜单可打开链接，不超过256字节
     */
    private String mediaId;

    public ViewLimitedButton(String name, String mediaId) {
        super(name);
        this.mediaId = mediaId;
    }

    public String getType() {
        return ButtonType.View_Limited.toString();
    }

    /**
     * 获取 调用新增永久素材接口返回的合法media_id
     *
     * @return 调用新增永久素材接口返回的合法media_id
     */
    public String getMedia_Id() {
        return mediaId;
    }

    /**
     * 设置 调用新增永久素材接口返回的合法media_id
     *
     * @param mediaId 调用新增永久素材接口返回的合法media_id
     */
    public void setMedia_Id(String mediaId) {
        this.mediaId = mediaId;
    }
}
