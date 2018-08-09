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
package org.weixin4j.model.message.template;

/**
 * 实体类对象，用来设置<tt>TemplateMessage</tt>中的模板数据
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.0
 */
public class TemplateData implements java.io.Serializable {

    /**
     * 字段Key
     */
    private String key;

    /**
     * 值
     */
    private String value;

    /**
     * 颜色
     */
    private String color;

    public TemplateData() {
    }
    
    public TemplateData(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public TemplateData(String key, String value, String color) {
        this.key = key;
        this.value = value;
        this.color = color;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
