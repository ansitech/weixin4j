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
 * 点击推事件
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class ClickButton extends SingleButton {

    /**
     * click类型必须.菜单KEY值，用于消息接口推送，不超过128字节
     */
    private String key;

    public ClickButton(String name, String key) {
        super(name);
        this.key = key;
    }

    public String getType() {
        return ButtonType.Click.toString();
    }

    /**
     * 获取 菜单KEY值
     *
     * <p>
     * click类型必须.菜单KEY值， 用于消息接口推送，不超过128字节
     * </p>
     *
     * @return 菜单KEY值
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置 菜单KEY值
     *
     * <p>
     * click类型必须.菜单KEY值，用于消息接口推送，不超过128字节
     * </p>
     *
     * @param key 菜单KEY值
     */
    public void setKey(String key) {
        this.key = key;
    }
}
