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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.weixin4j.Configuration;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.http.HttpsClient;
import org.weixin4j.http.Response;
import org.weixin4j.model.tags.Tag;

/**
 * 用户标签管理组件
 * 
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.0
 */
public class TagsComponent extends AbstractComponent {

    public TagsComponent(Weixin weixin) {
        super(weixin);
    }

    /**
     * 创建标签
     *
     * <p>
     * 一个公众号，最多可以创建100个标签。</p>
     *
     * @param name 标签名，UTF8编码
     * @return 包含标签ID的对象
     * @throws org.weixin4j.WeixinException
     */
    public Tag create(String name) throws WeixinException {
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //拼接参数
        JsonObject postTag = new JsonObject();
        JsonObject postName = new JsonObject();
        postName.addProperty("name", name);
        postTag.add("tag", postName);

        //调用获创建标签接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/tags/create?access_token=" + weixin.getToken().getAccess_token(), postTag);
        //根据请求结果判定，是否验证成功
        JsonObject jsonObj = res.asJsonObject();
        //成功返回如下JSON:
        //{"tag":{"id":134, name":"广东"}}
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("获取/tags/create返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.get("errcode").getAsInt()));
            } else {
                JsonObject tagJson = jsonObj.get("tag").getAsJsonObject();
                if (tagJson != null) {
                    return new Gson().fromJson(tagJson, Tag.class);
                }
            }
        }
        return null;
    }

    /**
     * 获取公众号已创建的标签
     *
     * @return 公众号标签列表
     * @throws org.weixin4j.WeixinException
     */
    public List<Tag> get() throws WeixinException {
        List<Tag> tagList = new ArrayList<Tag>();
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取jsapi_ticket接口
        Response res = http.get("https://api.weixin.qq.com/cgi-bin/tags/get?access_token=" + weixin.getToken().getAccess_token());
        //根据请求结果判定，是否验证成功
        JsonObject jsonObj = res.asJsonObject();
        //成功返回如下JSON:
        //{"tags":[{"id":1,"name":"黑名单","count":0},{"id":2,"name":"星标组","count":0},{"id":127,"name":"广东","count":5}]}
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("获取/tags/get返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.get("errcode").getAsInt()));
            } else {
                JsonArray tags = jsonObj.getAsJsonArray("tags");
                if (tags != null) {
                    for (int i = 0; i < tags.size(); i++) {
                        JsonObject jsonTag = tags.get(i).getAsJsonObject();
                        Tag tag = (Tag) new Gson().fromJson(jsonTag, Tag.class);
                        tagList.add(tag);
                    }
                }
            }
        }
        return tagList;
    }

    /**
     * 编辑标签
     *
     * @param id 标签id，由微信分配
     * @param name 标签名，UTF8编码（30个字符以内）
     * @throws WeixinException 编辑标签异常
     */
    public void update(int id, String name) throws WeixinException {
        //内部业务验证
        if (id < 0) {
            throw new IllegalStateException("id can not <= 0!");
        }
        if (name == null || name.equals("")) {
            throw new IllegalStateException("name is null!");
        }
        //拼接参数
        JsonObject postTag = new JsonObject();
        JsonObject postName = new JsonObject();
        postName.addProperty("id", id);
        postName.addProperty("name", name);
        postTag.add("tag", postName);
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/tags/update?access_token=" + weixin.getToken().getAccess_token(), postTag);
        //根据请求结果判定，是否验证成功
        JsonObject jsonObj = res.asJsonObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("/tags/update返回json：" + jsonObj.toString());
            }
            //判断是否修改成功
            //正常时返回 {"errcode": 0, "errmsg": "ok"}
            //错误时返回 示例：{"errcode":45158,"errmsg":"标签名长度超过30个字节"}
            int errcode = jsonObj.get("errcode").getAsInt();
            //登录成功，设置accessToken和过期时间
            if (errcode != 0) {
                //返回异常信息
                throw new WeixinException(getCause(errcode));
            }
        }
    }

    /**
     * 删除标签
     *
     * @param id 标签Id
     * @throws WeixinException 删除分组异常
     */
    public void delete(int id) throws WeixinException {
        //拼接参数
        JsonObject postParam = new JsonObject();
        JsonObject postId = new JsonObject();
        postId.addProperty("id", id);
        postParam.add("tag", postId);
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=" + weixin.getToken().getAccess_token(), postParam);
        //根据请求结果判定，是否验证成功
        JsonObject jsonObj = res.asJsonObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("/tags/delete返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.get("errcode").getAsInt()));
            }
        }
    }

    /**
     * 批量为用户打标签
     *
     * @param tagid 标签ID
     * @param openids 粉丝OpenId集合
     * @throws org.weixin4j.WeixinException
     */
    public void membersBatchtagging(int tagid, String[] openids) throws WeixinException {
        JsonObject json = new JsonObject();
        json.addProperty("tagid", tagid);
        json.add("openid_list", new JsonParser().parse(new Gson().toJson(openids)).getAsJsonArray());
        //创建请求对象
        HttpsClient http = new HttpsClient();
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=" + weixin.getToken().getAccess_token(), json);
        //根据请求结果判定，是否验证成功
        JsonObject jsonObj = res.asJsonObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("/tags/members/batchtagging返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.get("errcode").getAsInt()));
            }
        }
    }

    /**
     * 批量为用户取消标签
     *
     * @param tagid 标签ID
     * @param openids 粉丝OpenId集合
     * @throws org.weixin4j.WeixinException
     */
    public void membersBatchuntagging(int tagid, String[] openids) throws WeixinException {
        JsonObject json = new JsonObject();
        json.addProperty("tagid", tagid);
        json.add("openid_list", new JsonParser().parse(new Gson().toJson(openids)).getAsJsonArray());
        //创建请求对象
        HttpsClient http = new HttpsClient();
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=" + weixin.getToken().getAccess_token(), json);
        //根据请求结果判定，是否验证成功
        JsonObject jsonObj = res.asJsonObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("/tags/members/batchuntagging返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.get("errcode").getAsInt()));
            }
        }
    }

    /**
     * 获取用户身上的标签列表
     *
     * @param openid 粉丝OpenId
     * @return 公众号标签ID集合
     * @throws org.weixin4j.WeixinException
     */
    public Integer[] getIdList(String openid) throws WeixinException {
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取用户身上的标签列表接口
        Response res = http.get("https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=" + weixin.getToken().getAccess_token());
        //根据请求结果判定，是否验证成功
        JsonObject jsonObj = res.asJsonObject();
        //成功返回如下JSON:
        //{"tagid_list":[134,2]}
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("获取/tags/getidlist返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.get("errcode").getAsInt()));
            } else {
                JsonArray tags = jsonObj.getAsJsonArray("tagid_list");
                if (tags != null) {
                    return new Gson().fromJson(tags, Integer[].class);
                }
            }
        }
        return null;
    }
}
