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
package org.weixin4j.model.message.output;

import org.weixin4j.model.message.Articles;
import org.weixin4j.model.message.OutputMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个类实现了<tt>OutputMessage</tt>，用来回复图文消息
 *
 * <p>
 * 提供了获取多条图文消息信息<code>getArticles()</code>等主要方法.</p>
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class NewsOutputMessage extends OutputMessage {

    /**
     * 消息类型:图文消息
     */
    private final String MsgType = "news";
    /**
     * 图文消息个数，限制为10条以内
     */
    private Integer ArticleCount;
    /**
     * 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
     */
    private List<Articles> Articles;

    /**
     * 获取 消息类型
     *
     * @return 消息类型
     */
    @Override
    public String getMsgType() {
        return MsgType;
    }

    /**
     * 获取 图文消息个数
     *
     * @return 图文消息个数
     */
    public Integer getArticleCount() {
        return ArticleCount;
    }

    /**
     * 获取 多条图文消息信息
     *
     * @return 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则只读取前10个
     */
    public List<Articles> getArticles() {
        return Articles;
    }

    /**
     * 设置 多条图文消息信息
     *
     * @param articles 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则只读取前10个
     */
    public void setArticles(List<Articles> articles) {
        if (articles != null) {
            if (articles.size() > 10) {
                articles = new ArrayList<Articles>(articles.subList(0, 10));
            }
            ArticleCount = articles.size();
        }
        Articles = articles;
    }

    @Override
    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[").append(this.getToUserName()).append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[").append(this.getFromUserName()).append("]]></FromUserName>");
        sb.append("<CreateTime>").append(this.getCreateTime()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[" + this.MsgType + "]]></MsgType>");
        sb.append("<ArticleCount>").append(this.ArticleCount).append("</ArticleCount>");
        sb.append("<Articles>");
        for (Articles article : Articles) {
            sb.append("<item>");
            sb.append("<Title><![CDATA[").append(article.getTitle()).append("]]></Title>");
            sb.append("<Description><![CDATA[").append(article.getDescription()).append("]]></Description>");
            sb.append("<PicUrl><![CDATA[").append(article.getPicUrl()).append("]]></PicUrl>");
            sb.append("<Url><![CDATA[").append(article.getUrl()).append("]]></Url>");
            sb.append("</item>");
        }
        sb.append("</Articles>");
        sb.append("</xml>");
        return sb.toString();
    }
}
