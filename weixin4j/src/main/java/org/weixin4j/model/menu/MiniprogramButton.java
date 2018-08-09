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
 * 打开小程序
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.2
 */
public class MiniprogramButton extends SingleButton {

    /**
     * 小程序的appid（仅认证公众号可配置）
     */
    private String appid;
    /**
     * 小程序的页面路径
     */
    private String pagepath;
    /**
     * 网页 链接，用户点击菜单可打开链接，不超过1024字节。
     *
     * 不支持小程序的老版本客户端将打开本url。
     */
    private String url;

    public MiniprogramButton(String name) {
        super(name);
    }

    public MiniprogramButton(String name, String appid, String pagepath, String url) {
        super(name);
        this.appid = appid;
        this.pagepath = pagepath;
        this.url = url;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
