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
package org.weixin4j.loader;

import org.weixin4j.model.js.Ticket;
import org.weixin4j.model.js.TicketType;

/**
 * JsApiTicket加载接口
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.0
 */
public interface ITicketLoader {

    /**
     * 获取Ticket
     *
     * @param ticketType 临时凭证类型
     * @see me.hao0.wechat.model.js.TicketType
     * @return 有效的ticket，若返回""或null，则触发重新从微信请求Ticket的方法refresh
     */
    Ticket get(TicketType ticketType);

    /**
     * 刷新Ticket
     *
     * @param ticket 包含ticket数据的对象
     */
    void refresh(Ticket ticket);
}
