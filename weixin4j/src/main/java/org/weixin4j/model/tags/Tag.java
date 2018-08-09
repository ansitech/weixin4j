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
package org.weixin4j.model.tags;

/**
 * 用户标签管理
 *
 * <p>
 * 通过<tt>Weixin</tt>产生一个请求对象，通过<code>getUserTags()</code>生成一个<tt>Tags</tt>，集合</p>
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.7
 */
public class Tag {

    private int id;             //标签id，由微信分配
    private String name;        //标签名，UTF8编码（30个字符以内）
    private int count;          //此标签下粉丝数

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
