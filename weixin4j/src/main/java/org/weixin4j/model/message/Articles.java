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
 * 实体类对象，用来接受<tt>NewsOutputMessage</tt>中的条目
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class Articles {

    /**
     * 图文消息标题
     */
    private String Title;
    /**
     * 图文消息描述
     */
    private String Description;
    /**
     * 发送被动响应时设置的图片url
     * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     */
    private String PicUrl;
    /**
     * 发送客服消息时设置的图片URL
     */
    private String picurl;
    /**
     * 点击图文消息跳转链接
     */
    private String Url;

    /**
     * 获取 图文消息的标题
     *
     * @return 图文消息的标题
     */
    public String getTitle() {
        return Title;
    }

    /**
     * 设置 图文消息的标题
     *
     * @param Title 图文消息的标题
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * 获取 图文消息的描述
     *
     * @return 图文消息的描述
     */
    public String getDescription() {
        return Description;
    }

    /**
     * 设置 图文消息的描述
     *
     * @param Description 图文消息的描述
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * 获取 图片链接
     *
     * @return 图片链接
     */
    public String getPicUrl() {
        return PicUrl;
    }

    /**
     * 设置 图片链接
     *
     * @param PicUrl 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     */
    public void setPicUrl(String PicUrl) {
        this.PicUrl = PicUrl;
    }

    /**
     * 获取 点击图文消息跳转链接
     *
     * @return 点击图文消息跳转链接
     */
    public String getUrl() {
        return Url;
    }

    /**
     * 设置 点击图文消息跳转链接
     *
     * @param Url 点击图文消息跳转链接
     */
    public void setUrl(String Url) {
        this.Url = Url;
    }

    /**
     * @return the picurl
     */
    public String getPicurl() {
        return picurl;
    }

    /**
     * @param picurl the picurl to set
     */
    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }
}
