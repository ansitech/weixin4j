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
package org.weixin4j.model.groups;

/**
 * 微信平台分组对象
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.4
 */
public class Group implements java.io.Serializable {

    private int id;             //分组id，由微信分配
    private String name;        //分组名字，UTF8编码（30个字符以内）
    private int count;          //分组内用户数量

    /**
     * 获取 分组id
     *
     * @return 分组id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置 分组id
     *
     * @param id 分组id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取 分组名字
     *
     * @return 分组名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 分组名字
     *
     * <p>30个字符以内</p>
     *
     * @param name 分组名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 用户数量
     *
     * @return 用户数量
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置 用户数量
     *
     * @param count 用户数量
     */
    public void setCount(int count) {
        this.count = count;
    }
}
