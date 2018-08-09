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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.weixin4j.Configuration;
import org.weixin4j.model.user.Data;
import org.weixin4j.model.user.Followers;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.http.HttpsClient;
import org.weixin4j.http.Response;
import org.weixin4j.model.user.User;

/**
 * 用户管理组件
 * 
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.0
 */
public class UserComponent extends AbstractComponent {

    public UserComponent(Weixin weixin) {
        super(weixin);
    }

    /**
     * 设置用户备注名
     *
     * @param openid 用户标识
     * @param remark 新的备注名，长度必须小于30字符
     * @throws WeixinException
     */
    public void updateRemark(String openid, String remark) throws WeixinException {
        //内部业务验证
        if (StringUtils.isEmpty(openid)) {
            throw new IllegalArgumentException("openid can't be null or empty");
        }
        if (StringUtils.isEmpty(remark)) {
            throw new IllegalArgumentException("remark can't be null or empty");
        }
        //拼接参数
        JSONObject postParam = new JSONObject();
        postParam.put("openid", openid);
        postParam.put("remark", remark);
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=" + weixin.getToken().getAccess_token(), postParam);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj == null) {
            throw new WeixinException(getCause(-1));
        }
        if (Configuration.isDebug()) {
            System.out.println("updateremark返回json：" + jsonObj.toString());
        }
        //判断是否修改成功
        //正常时返回 {"errcode": 0, "errmsg": "ok"}
        //错误时返回 示例：{"errcode":40013,"errmsg":"invalid appid"}
        int errcode = jsonObj.getIntValue("errcode");
        //登录成功，设置accessToken和过期时间
        if (errcode != 0) {
            //返回异常信息
            throw new WeixinException(getCause(errcode));
        }
    }

    /**
     * 获取用户基本信息（包括UnionID机制）
     *
     * @param openid 普通用户的标识，对当前公众号唯一
     * @return 用户对象
     * @throws WeixinException
     */
    public User info(String openid) throws WeixinException {
        //默认简体中文
        return info(openid, "zh_CN");
    }

    /**
     * 获取用户基本信息（包括UnionID机制）
     *
     * @param openid 普通用户的标识，对当前公众号唯一
     * @param lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return 用户对象
     * @throws WeixinException
     */
    public User info(String openid, String lang) throws WeixinException {
        if (StringUtils.isEmpty(openid)) {
            throw new IllegalArgumentException("openid can't be null or empty");
        }
        if (StringUtils.isEmpty(lang)) {
            throw new IllegalArgumentException("lang can't be null or empty");
        }
        //拼接参数
        String param = "?access_token=" + weixin.getToken().getAccess_token() + "&openid=" + openid + "&lang=" + lang;
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.get("https://api.weixin.qq.com/cgi-bin/user/info" + param);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj == null) {
            return null;
        }
        if (Configuration.isDebug()) {
            System.out.println("getUser返回json：" + jsonObj.toString());
        }
        Object errcode = jsonObj.get("errcode");
        if (errcode != null) {
            //返回异常信息
            throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
        }
        //设置公众号信息
        return JSONObject.toJavaObject(jsonObj, User.class);
    }

    /**
     * 获取用户基本信息（包括UnionID机制）
     *
     * @param openids 普通用户的标识数组，对当前公众号唯一
     * @return 用户对象
     * @throws WeixinException
     */
    public List<User> batchGet(String[] openids) throws WeixinException {
        if (openids == null || openids.length == 0) {
            throw new IllegalArgumentException("openids can't be null or empty");
        }
        return batchGet(openids, "zh_CN");
    }

    /**
     * 获取用户基本信息（包括UnionID机制）
     *
     * @param openids 普通用户的标识数组，对当前公众号唯一
     * @param lang 国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为zh-CN
     * @return 用户对象
     * @throws WeixinException
     */
    public List<User> batchGet(String[] openids, String lang) throws WeixinException {
        if (StringUtils.isEmpty(lang)) {
            throw new IllegalArgumentException("lang can't be null or empty");
        }
        String[] langs = new String[openids.length];
        for (int i = 0; i < langs.length; i++) {
            langs[i] = lang;
        }
        return batchGet(openids, langs);
    }

    /**
     * 获取用户基本信息（包括UnionID机制）
     *
     * @param openids 普通用户的标识数组，对当前公众号唯一
     * @param langs 国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为zh-CN
     * @return 用户对象
     * @throws WeixinException
     */
    public List<User> batchGet(String[] openids, String[] langs) throws WeixinException {
        //内部业务验证
        if (openids == null || openids.length == 0) {
            throw new IllegalArgumentException("openids can't be null or empty");
        }
        if (langs == null || langs.length == 0) {
            throw new IllegalArgumentException("langs can't be null or empty");
        }
        if (openids.length != langs.length) {
            throw new IllegalArgumentException("openids length are not same to langs length");
        }
        //拼接参数
        JSONObject postUserList = new JSONObject();
        JSONArray userList = new JSONArray();
        for (int i = 0; i < openids.length; i++) {
            JSONObject postUser = new JSONObject();
            postUser.put("openid", openids[i]);
            postUser.put("lang", langs[i]);
            userList.add(postUser);
        }
        postUserList.put("user_list", userList);
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=" + weixin.getToken().getAccess_token(), postUserList);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj == null) {
            return null;
        }
        if (Configuration.isDebug()) {
            System.out.println("batchGetUser返回json：" + jsonObj.toString());
        }
        Object errcode = jsonObj.get("errcode");
        if (errcode != null) {
            //返回异常信息
            throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
        }
        //获取用户列表
        JSONArray userlistArray = jsonObj.getJSONArray("user_info_list");
        List<User> users = new ArrayList<User>();
        for (Object userObj : userlistArray) {
            //转换为User对象
            users.add(JSONObject.toJavaObject((JSONObject) userObj, User.class));
        }
        return users;
    }

    /**
     * 获取所有用户列表
     *
     * 公众号粉丝数量超过1万，推荐使用请分页获取。
     *
     * @return 关注者列表对象
     * @throws WeixinException
     */
    public Followers getAll() throws WeixinException {
        Followers allFollower = new Followers();
        int toatl = 0;
        int count = 0;
        Data data = new Data();
        data.setOpenid(new ArrayList<String>());
        allFollower.setData(data);
        String next_openid = "";
        do {
            Followers f = get(next_openid);
            if (f == null) {
                break;
            }
            if (f.getCount() > 0) {
                count += f.getCount();
                toatl += f.getTotal();
                List<String> openids = f.getData().getOpenid();
                for (String openid : openids) {
                    allFollower.getData().getOpenid().add(openid);
                }
            }
            next_openid = f.getNext_openid();
        } while (next_openid != null && !next_openid.equals(""));
        allFollower.setCount(count);
        allFollower.setTotal(toatl);
        return allFollower;
    }

    /**
     * 获取用户列表
     *
     * @param next_openid 第一个拉取的OPENID，不填默认从头开始拉取
     * @return 关注者列表对象
     * @throws WeixinException
     */
    public Followers get(String next_openid) throws WeixinException {
        //拼接参数
        String param = "?access_token=" + weixin.getToken().getAccess_token() + "&next_openid=";
        //第一次获取不添加参数
        if (next_openid != null && !next_openid.equals("")) {
            param += next_openid;
        }
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.get("https://api.weixin.qq.com/cgi-bin/user/get" + param);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj == null) {
            return null;
        }
        if (Configuration.isDebug()) {
            System.out.println("getUserList返回json：" + jsonObj.toString());
        }
        Object errcode = jsonObj.get("errcode");
        if (errcode != null) {
            //返回异常信息
            throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
        }
        return (Followers) JSONObject.toJavaObject(jsonObj, Followers.class);
    }

    /**
     * 获取标签下所有粉丝列表
     *
     * @param tagid 标签ID
     * @return 关注者对象
     * @throws WeixinException
     */
    public Followers tagGetAll(int tagid) throws WeixinException {
        Followers allFollower = new Followers();
        int toatl = 0;
        int count = 0;
        Data data = new Data();
        data.setOpenid(new ArrayList<String>());
        allFollower.setData(data);
        String next_openid = "";
        do {
            Followers f = tagGet(tagid, next_openid);
            if (f == null) {
                break;
            }
            if (f.getCount() > 0) {
                count += f.getCount();
                toatl += f.getTotal();
                List<String> openids = f.getData().getOpenid();
                for (String openid : openids) {
                    allFollower.getData().getOpenid().add(openid);
                }
            }
            next_openid = f.getNext_openid();
        } while (next_openid != null && !next_openid.equals(""));
        allFollower.setCount(count);
        allFollower.setTotal(toatl);
        return allFollower;
    }

    /**
     * 获取标签下粉丝列表
     *
     * <p>
     * 通过公众号，返回用户对象，进行用户相关操作</p>
     *
     * @param tagid 标签ID
     * @param next_openid 第一个拉取的OPENID，不填默认从头开始拉取
     * @return 关注者对象
     * @throws WeixinException when Weixin service or network is unavailable, or
     * the user has not authorized
     */
    public Followers tagGet(int tagid, String next_openid) throws WeixinException {
        //拼接参数
        String param = "?access_token=" + weixin.getToken().getAccess_token() + "&tagid=" + tagid + "&next_openid=";
        //第一次获取不添加参数
        if (next_openid != null && !next_openid.equals("")) {
            param += next_openid;
        }
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取标签下粉丝列表接口
        Response res = http.get("https://api.weixin.qq.com/cgi-bin/user/tag/get" + param);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        Followers follower = null;
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("getTagUserList返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            }
            follower = (Followers) JSONObject.toJavaObject(jsonObj, Followers.class);
        }
        return follower;
    }
}
