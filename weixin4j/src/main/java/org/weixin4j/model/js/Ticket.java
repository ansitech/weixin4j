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
package org.weixin4j.model.js;

import java.io.Serializable;
import java.util.Date;

/**
 * 凭证
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.0
 */
public final class Ticket implements Serializable {

    /**
     * 凭证字符串
     */
    private String ticket;

    /**
     * 凭证类型
     */
    private TicketType ticketType;

    /**
     * 有效时间(s)
     */
    private int expires_in;

    /**
     * 过期时间
     */
    private long exprexpired_time;

    /**
     * 创建时间
     */
    private long create_time;

    public Ticket(TicketType ticketType, String ticket, int expires_in) {
        this(ticketType, ticket, expires_in, new Date().getTime());
    }

    public Ticket(TicketType ticketType, String ticket, int expires_in, long create_time) {
        this.ticketType = ticketType;
        this.ticket = ticket;
        this.expires_in = expires_in;
        //获取当前时间毫秒数
        this.create_time = create_time - 60000;
        //设置下次过期时间 = 当前时间 + (凭证有效时间(秒) * 1000)
        this.exprexpired_time = this.create_time + (expires_in * 1000);
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    /**
     * 判断凭证是否过期
     *
     * @return 过期返回 true,否则返回false
     */
    public boolean isExprexpired() {
        Date now = new Date();
        long nowLong = now.getTime();
        return nowLong >= exprexpired_time;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public long getCreate_time() {
        return create_time + 60000;
    }

    /**
     * 将数据转换为JSON数据包
     *
     * @return JSON数据包
     */
    @Override
    public String toString() {
        //对外的时间 需要加上扣掉的 60秒
        return "{\"ticket\":\"" + this.getTicket() + "\",\"expires_in\":" + this.getExpires_in() + ",\"create_time\" : " + this.getCreate_time() + "}";
    }
}
