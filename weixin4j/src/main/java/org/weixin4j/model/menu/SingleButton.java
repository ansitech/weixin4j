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

import java.util.ArrayList;
import java.util.List;

/**
 * 带子菜单的按钮,此按钮中必须设置子菜单
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class SingleButton extends BaseButton {

    /**
     * 子菜单(此菜单需要手动添加，所以get和set方法能喝微信返回的json一致)
     */
    private List<SingleButton> subButton;

    public SingleButton(String name) {
        super(name);
    }

    /**
     * 设置 子菜单
     *
     * @param sub_button 子菜单
     */
    public void setSubButton(List<SingleButton> sub_button) {
        this.subButton = sub_button;
    }

    /**
     * 获取 子菜单
     *
     * @return 子菜单
     */
    public List<SingleButton> getSubButton() {
        if (subButton == null) {
            subButton = new ArrayList<SingleButton>(0);
        }
        return this.subButton;
    }
}
