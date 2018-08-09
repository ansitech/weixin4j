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
package org.weixin4j;

import org.weixin4j.model.base.Token;
import java.util.HashMap;
import java.util.Map;
import org.weixin4j.component.AbstractComponent;
import org.weixin4j.component.BaseComponent;
import org.weixin4j.component.FileComponent;
import org.weixin4j.component.GroupsComponent;
import org.weixin4j.component.JsSdkComponent;
import org.weixin4j.component.MaterialComponent;
import org.weixin4j.component.MediaComponent;
import org.weixin4j.component.MenuComponent;
import org.weixin4j.component.MessageComponent;
import org.weixin4j.component.PayComponent;
import org.weixin4j.component.QrcodeComponent;
import org.weixin4j.component.RedpackComponent;
import org.weixin4j.component.SnsComponent;
import org.weixin4j.component.TagsComponent;
import org.weixin4j.component.UserComponent;
import org.weixin4j.loader.DefaultTokenLoader;
import org.weixin4j.loader.DefaultTicketLoader;
import org.weixin4j.loader.ITokenLoader;
import org.weixin4j.loader.ITicketLoader;
import org.weixin4j.model.js.Ticket;
import org.weixin4j.model.js.TicketType;

/**
 * 微信平台基础支持对象
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class Weixin extends WeixinSupport implements java.io.Serializable {

    /**
     * 解决多线程并发重复获取token问题
     */
    private volatile Token _token;
    /**
     * 同步锁
     */
    private final byte[] lock = new byte[0];
    /**
     * 公众号开发者ID
     */
    private final String appId;
    /**
     * 公众号开发者密钥
     */
    private final String secret;
    /**
     * AccessToken加载器
     */
    protected ITokenLoader tokenLoader = new DefaultTokenLoader();
    /**
     * Ticket加载器
     */
    protected ITicketLoader ticketLoader = new DefaultTicketLoader();
    /**
     * 新增组件
     */
    private final Map<String, AbstractComponent> components = new HashMap<String, AbstractComponent>();

    public Weixin() {
        this(Configuration.getOAuthAppId(), Configuration.getOAuthSecret());
    }

    public Weixin(String appId, String secret) {
        this.appId = appId;
        this.secret = secret;
    }

    public String getAppId() {
        return appId;
    }

    public String getSecret() {
        return secret;
    }

    /**
     * 获取Token对象
     *
     * @return Token对象
     * @throws WeixinException
     * @since 0.1.0
     */
    public Token getToken() throws WeixinException {
        _token = tokenLoader.get();
        Token token = this._token;
        if (token == null) {
            synchronized (lock) {
                token = this._token;
                if (token == null) {
                    this._token = token = base().token();
                    tokenLoader.refresh(token);
                }
            }
        }
        return token;
    }

    /**
     * 获取jsapi开发ticket
     *
     * @return jsapi_ticket
     * @throws WeixinException
     */
    public Ticket getJsApiTicket() throws WeixinException {
        Ticket ticket = ticketLoader.get(TicketType.JSAPI);
        if (ticket == null) {
            ticket = js().getJsApiTicket();
            ticketLoader.refresh(ticket);
        }
        return ticket;
    }

    public BaseComponent base() {
        String key = BaseComponent.class.getName();
        if (components.containsKey(key)) {
            return (BaseComponent) components.get(key);
        }
        BaseComponent component = new BaseComponent(this);
        components.put(key, component);
        return component;
    }

    public JsSdkComponent js() {
        String key = JsSdkComponent.class.getName();
        if (components.containsKey(key)) {
            return (JsSdkComponent) components.get(key);
        }
        JsSdkComponent component = new JsSdkComponent(this);
        components.put(key, component);
        return component;
    }

    public UserComponent user() {
        String key = UserComponent.class.getName();
        if (components.containsKey(key)) {
            return (UserComponent) components.get(key);
        }
        UserComponent component = new UserComponent(this);
        components.put(key, component);
        return component;
    }

    public SnsComponent sns() {
        String key = SnsComponent.class.getName();
        if (components.containsKey(key)) {
            return (SnsComponent) components.get(key);
        }
        SnsComponent component = new SnsComponent(this);
        components.put(key, component);
        return component;
    }

    public SnsComponent sns(String authorize_url) {
        String key = SnsComponent.class.getName();
        if (components.containsKey(key)) {
            return (SnsComponent) components.get(key);
        }
        SnsComponent component = new SnsComponent(this, authorize_url);
        components.put(key, component);
        return component;
    }

    public TagsComponent tags() {
        String key = TagsComponent.class.getName();
        if (components.containsKey(key)) {
            return (TagsComponent) components.get(key);
        }
        TagsComponent component = new TagsComponent(this);
        components.put(key, component);
        return component;
    }

    public GroupsComponent groups() {
        String key = GroupsComponent.class.getName();
        if (components.containsKey(key)) {
            return (GroupsComponent) components.get(key);
        }
        GroupsComponent component = new GroupsComponent(this);
        components.put(key, component);
        return component;
    }

    public PayComponent pay() {
        String key = PayComponent.class.getName();
        if (components.containsKey(key)) {
            return (PayComponent) components.get(key);
        }
        PayComponent component = new PayComponent(this);
        components.put(key, component);
        return component;
    }

    public RedpackComponent redpack() {
        String key = RedpackComponent.class.getName();
        if (components.containsKey(key)) {
            return (RedpackComponent) components.get(key);
        }
        RedpackComponent component = new RedpackComponent(this);
        components.put(key, component);
        return component;
    }

    public MessageComponent message() {
        String key = MessageComponent.class.getName();
        if (components.containsKey(key)) {
            return (MessageComponent) components.get(key);
        }
        MessageComponent component = new MessageComponent(this);
        components.put(key, component);
        return component;
    }

    public MenuComponent menu() {
        String key = MenuComponent.class.getName();
        if (components.containsKey(key)) {
            return (MenuComponent) components.get(key);
        }
        MenuComponent component = new MenuComponent(this);
        components.put(key, component);
        return component;
    }

    public MediaComponent media() {
        String key = MediaComponent.class.getName();
        if (components.containsKey(key)) {
            return (MediaComponent) components.get(key);
        }
        MediaComponent component = new MediaComponent(this);
        components.put(key, component);
        return component;
    }

    @Deprecated
    public FileComponent file() {
        String key = FileComponent.class.getName();
        if (components.containsKey(key)) {
            return (FileComponent) components.get(key);
        }
        FileComponent component = new FileComponent(this);
        components.put(key, component);
        return component;
    }

    public MaterialComponent material() {
        String key = MaterialComponent.class.getName();
        if (components.containsKey(key)) {
            return (MaterialComponent) components.get(key);
        }
        MaterialComponent component = new MaterialComponent(this);
        components.put(key, component);
        return component;
    }

    public QrcodeComponent qrcode() {
        String key = QrcodeComponent.class.getName();
        if (components.containsKey(key)) {
            return (QrcodeComponent) components.get(key);
        }
        QrcodeComponent component = new QrcodeComponent(this);
        components.put(key, component);
        return component;
    }
}
