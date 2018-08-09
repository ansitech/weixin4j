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
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.weixin4j.Configuration;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.http.HttpClient;
import org.weixin4j.model.media.Attachment;
import org.weixin4j.http.HttpsClient;
import org.weixin4j.http.Response;
import org.weixin4j.model.media.Article;
import org.weixin4j.model.message.MediaType;

/**
 * 多媒体组件
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.0
 */
public class MediaComponent extends AbstractComponent {

    public MediaComponent(Weixin weixin) {
        super(weixin);
    }

    /**
     * 上传图文消息内的图片获取URL
     *
     * <p>
     * 请注意，本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。 <br>
     * 图片仅支持jpg/png格式，大小必须在1MB以下。
     * </p>
     *
     * @param file form-data中媒体文件标识，有filename、filelength、content-type等信息
     * @return 上传成功返回图文素材Id，否则返回null
     * @throws WeixinException
     */
    public String uploadimg(File file) throws WeixinException {
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //上传素材，返回JSON数据包
        String jsonStr = http.uploadHttps("https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=" + weixin.getToken().getAccess_token(), file);
        JSONObject jsonObj = JSONObject.parseObject(jsonStr);
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("上传图文消息内的图片返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            } else {
                //返回图片Url
                return jsonObj.getString("url");
            }
        }
        return null;
    }

    /**
     * 上传图文消息素材
     *
     * @param articles 图文消息，一个图文消息支持1到8条图文
     * @return 上传成功返回图文素材Id，否则返回null
     * @throws WeixinException
     */
    public String uploadnews(List<Article> articles) throws WeixinException {
        JSONObject json = new JSONObject();
        json.put("articles", articles);
        //创建请求对象
        HttpsClient http = new HttpsClient();
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=" + weixin.getToken().getAccess_token(), json);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("uploadnews返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            } else {
                //返回图文消息id
                return jsonObj.getString("media_id");
            }
        }
        return null;
    }

    /**
     * 新增临时素材
     *
     * @param mediaType 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @param file form-data中媒体文件标识，有filename、filelength、content-type等信息
     * @return 上传成功返回素材Id，否则返回null
     * @throws WeixinException
     */
    public String upload(MediaType mediaType, File file) throws WeixinException {
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //上传素材，返回JSON数据包
        String jsonStr = http.uploadHttps("https://api.weixin.qq.com/cgi-bin/media/upload?access_token=" + weixin.getToken().getAccess_token() + "&type=" + mediaType.toString(), file);
        JSONObject jsonObj = JSONObject.parseObject(jsonStr);
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("上传多媒体文件返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            } else {
                //返回多媒体文件id
                return jsonObj.getString("media_id");
            }
        }
        return null;
    }

    /**
     * 获取临时素材
     *
     * <p>
     * 本接口即为原“下载多媒体文件”接口。
     * </p>
     *
     * @param mediaId 媒体文件ID
     * @return 正确返回附件对象，否则返回null
     * @throws WeixinException
     */
    public Attachment get(String mediaId) throws WeixinException {
        //下载资源
        String url = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=" + weixin.getToken().getAccess_token() + "&media_id=" + mediaId;
        //创建请求对象
        HttpsClient http = new HttpsClient();
        return http.downloadHttps(url);
    }

    /**
     * 获取视频下载地址
     *
     * @param mediaId 视频媒体文件ID
     * @return 正确返回附件对象，否则返回null
     * @throws WeixinException
     */
    public String getVideoUrl(String mediaId) throws WeixinException {
        try {
            //下载资源，请注意，视频文件不支持https下载，调用该接口需http协议。
            String url = "http://api.weixin.qq.com/cgi-bin/media/get?access_token=" + weixin.getToken().getAccess_token() + "&media_id=" + mediaId;
            //创建请求对象
            HttpClient http = new HttpClient();
            Attachment attachment = http.download(url);
            //返回附件全名
            return attachment.getFullName();
        } catch (IOException ex) {
            throw new WeixinException("获取视频下载地址异常:", ex);
        }
    }

    /**
     * 高清语音素材获取接口
     *
     * <p>
     * 可以使用本接口获取从JSSDK的uploadVoice接口上传的临时语音素材，格式为speex，16K采样率。
     * </p>
     *
     * @param mediaId 媒体文件ID
     * @return 正确返回附件对象，否则返回null
     * @throws WeixinException
     */
    public Attachment getJssdkVoice(String mediaId) throws WeixinException {
        //下载资源
        String url = "https://api.weixin.qq.com/cgi-bin/media/get/jssdk?access_token=" + weixin.getToken().getAccess_token() + "&media_id=" + mediaId;
        //创建请求对象
        HttpsClient http = new HttpsClient();
        return http.downloadHttps(url);
    }
}
