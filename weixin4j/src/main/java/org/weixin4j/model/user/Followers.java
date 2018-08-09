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
package org.weixin4j.model.user;

/**
 * 微信平台关注者对象
 *
 * <p>通过<tt>Weixin</tt>产生一个请求对象，通过<code>getWeixinUser()</code>生成一个<tt>WeixinUser</tt>，
 * 然后调用<tt>getUserList()</tt>，得到本对象.</p>
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class Followers {

    private int total;  //关注该公众账号的总用户数
    private int count;  //拉取的OPENID个数，最大值为10000
    private Data data;  //列表数据，OPENID的列表
    private String next_openid; //拉取列表的后一个用户的OPENID

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the next_openid
     */
    public String getNext_openid() {
        return next_openid;
    }

    /**
     * @param next_openid the next_openid to set
     */
    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }

    /**
     * @return the data
     */
    public Data getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Data data) {
        this.data = data;
    }
}
