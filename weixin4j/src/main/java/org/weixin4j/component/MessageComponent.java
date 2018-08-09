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
package org.weixin4j.component;

import com.alibaba.fastjson.JSONObject;
import java.util.List;
import org.weixin4j.Configuration;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.http.HttpsClient;
import org.weixin4j.http.Response;
import org.weixin4j.model.message.Articles;
import org.weixin4j.model.message.template.Miniprogram;
import org.weixin4j.model.message.template.TemplateData;
import org.weixin4j.model.message.template.TemplateMessage;

/**
 * 消息管理组件
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.0
 */
public class MessageComponent extends AbstractComponent {

    public MessageComponent(Weixin weixin) {
        super(weixin);
    }

    /**
     * 根据openid列表群发文本消息
     *
     * @param openids 粉丝openid集合
     * @param txtContent 文本消息内容
     * @return 发送成功则返回群发消息Id，否则返回null
     * @throws org.weixin4j.WeixinException
     */
    public String massSendContent(String[] openids, String txtContent) throws WeixinException {
        JSONObject json = new JSONObject();
        JSONObject text = new JSONObject();
        text.put("content", txtContent);
        json.put("touser", openids);
        json.put("text", text);
        json.put("msgtype", "text");
        //创建请求对象
        HttpsClient http = new HttpsClient();
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=" + weixin.getToken().getAccess_token(), json);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("群发文本消息返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            } else {
                //返回群发消息id
                return jsonObj.getString("msg_id");
            }
        }
        return null;
    }

    /**
     * 根据openid列表群发文本消息
     *
     * @param openids 粉丝openid集合
     * @param mediaId 图文消息素材Id
     * @return 发送成功则返回群发消息Id，否则返回null
     * @throws WeixinException
     */
    public String massSendNews(String[] openids, String mediaId) throws WeixinException {
        JSONObject json = new JSONObject();
        JSONObject media_id = new JSONObject();
        media_id.put("media_id", mediaId);
        json.put("touser", openids);
        json.put("mpnews", media_id);
        json.put("msgtype", "mpnews");
        //创建请求对象
        HttpsClient http = new HttpsClient();
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=" + weixin.getToken().getAccess_token(), json);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("/message/mass/send返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            } else {
                //返回群发图文id
                return jsonObj.getString("msg_id");
            }
        }
        return null;
    }

    /**
     * 发送客服文本消息
     *
     * @param openid 粉丝openid
     * @param txtContent 文本消息内容
     * @throws org.weixin4j.WeixinException
     */
    public void customSendContent(String openid, String txtContent) throws WeixinException {
        JSONObject json = new JSONObject();
        JSONObject text = new JSONObject();
        text.put("content", txtContent);
        json.put("touser", openid);
        json.put("text", text);
        json.put("msgtype", "text");
        //创建请求对象
        HttpsClient http = new HttpsClient();
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + weixin.getToken().getAccess_token(), json);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("customSendContent返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            }
        }
    }

    /**
     * 发送客服图文消息
     *
     * @param openid 粉丝openid
     * @param articles 图文消息，一个图文消息支持1到10条图文
     * @throws org.weixin4j.WeixinException
     */
    public void customSendNews(String openid, List<Articles> articles) throws WeixinException {
        JSONObject json = new JSONObject();
        json.put("touser", openid);
        json.put("msgtype", "news");
        JSONObject news = new JSONObject();
        news.put("articles", articles);
        json.put("news", news);
        //创建请求对象
        HttpsClient http = new HttpsClient();
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + weixin.getToken().getAccess_token(), json);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("customSendNews返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            }
        }
    }

    /**
     * 发送模板消息
     *
     * @param openid 接收者
     * @param templateId 模板消息ID
     * @param datas 模板数据
     * @throws WeixinException
     */
    public void sendTemplateMessage(String openid, String templateId, List<TemplateData> datas) throws WeixinException {
        sendTemplateMessage(openid, templateId, datas, null, null);
    }

    /**
     * 发送模板消息(带跳转链接)
     *
     * @param openid 接收者
     * @param templateId 模板消息ID
     * @param datas 模板数据
     * @param miniprogram 跳小程序所需数据，不需跳小程序可不用传该数据
     * @throws WeixinException
     */
    public void sendTemplateMessage(String openid, String templateId, List<TemplateData> datas, Miniprogram miniprogram) throws WeixinException {
        sendTemplateMessage(openid, templateId, datas, miniprogram, null);
    }

    /**
     * 发送模板消息(带跳转链接)
     *
     * @param openid 接收者
     * @param templateId 模板消息ID
     * @param datas 模板数据
     * @param url 模板跳转链接
     * @throws WeixinException
     */
    public void sendTemplateMessage(String openid, String templateId, List<TemplateData> datas, String url) throws WeixinException {
        sendTemplateMessage(openid, templateId, datas, null, url);
    }

    /**
     * 发送模板消息(带跳转小程序或链接)
     *
     * <p>
     * 注：url和miniprogram都是非必填字段，若都不传则模板无跳转；若都传，会优先跳转至小程序。开发者可根据实际需要选择其中一种跳转方式即可。当用户的微信客户端版本不支持跳小程序时，将会跳转至url。</p>
     *
     * @param openid 接收者
     * @param templateId 模板消息ID
     * @param datas 模板数据
     * @param miniprogram 跳小程序所需数据，不需跳小程序可不用传该数据
     * @param url 模板跳转链接
     * @throws WeixinException
     */
    public void sendTemplateMessage(String openid, String templateId, List<TemplateData> datas, Miniprogram miniprogram, String url) throws WeixinException {
        //内部业务验证
        if (openid == null || openid.equals("")) {
            throw new IllegalStateException("openid can not be null or empty");
        }
        if (templateId == null || templateId.equals("")) {
            throw new IllegalStateException("templateId can not be null or empty");
        }
        if (datas == null || datas.isEmpty()) {
            throw new IllegalStateException("datas can not be null or empty");
        }
        JSONObject json = new JSONObject();
        json.put("touser", openid);
        json.put("template_id", templateId);
        //添加模板跳转链接
        if (url != null && !url.equals("")) {
            json.put("url", url);
        }
        //添加小程序
        if (miniprogram != null) {
            JSONObject program = new JSONObject();
            program.put("appid", miniprogram.getAppid());
            program.put("pagepath", miniprogram.getPagepath());
        }
        //添加模板数据
        JSONObject data = new JSONObject();
        for (TemplateData templateData : datas) {
            JSONObject dataContent = new JSONObject();
            dataContent.put("value", templateData.getValue());
            dataContent.put("color", templateData.getColor());
            data.put(templateData.getKey(), dataContent);
        }
        json.put("data", data);
        //创建请求对象
        HttpsClient http = new HttpsClient();
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + weixin.getToken().getAccess_token(), json);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("sendTemplateMessage返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            }
        }
    }

    /**
     * 发送模板消息
     *
     * @param templateMessage 模板消息
     * @throws WeixinException
     */
    public void sendTemplateMessage(TemplateMessage templateMessage) throws WeixinException {
        sendTemplateMessage(templateMessage.getOpenid(), templateMessage.getTemplateId(), templateMessage.getData(), templateMessage.getMiniprogram(), templateMessage.getUrl());
    }
}
