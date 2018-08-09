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
 * 自定义菜单按钮
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class BaseButton {

    /**
     * 菜单标题，不超过16个字节，子菜单不超过40个字节
     */
    private final String name;

    /**
     * 基础按钮
     *
     * @param name 菜单标题
     */
    public BaseButton(String name) {
        this.name = name;
    }

    /**
     * 获取 菜单标题
     *
     * @return 菜单标题
     */
    public String getName() {
        return name;
    }
}
