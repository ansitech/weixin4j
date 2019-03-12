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
 * 跳转URL
 *
 * @author yangqisheng
 * @since 0.0.1
 */
public class ViewButton extends SingleButton {

    /**
     * view类型必须.网页链接，用户点击菜单可打开链接，不超过256字节
     */
    private String url;

    public ViewButton(String name) {
        super(name);
    }

    public ViewButton(String name, String url) {
        super(name);
        this.url = url;
    }

    public String getType() {
        return ButtonType.View.toString();
    }

    /**
     * 获取 网页链接
     *
     * <p>
     * view类型必须.网页链接，用户点击菜单可打开链接，不超过256字节
     * </p>
     *
     * @return 网页链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置 网页链接
     *
     * <p>
     * view类型必须.网页链接，用户点击菜单可打开链接，不超过256字节
     * </p>
     *
     * @param url 网页链接
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
