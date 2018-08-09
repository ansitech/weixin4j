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
 * 微信平台用户管理
 *
 * <p>
 * 通过<tt>Weixin</tt>产生一个请求对象，通过<code>getUser()</code>生成一个<tt>User</tt>，
 * 然后可以调用其他方法</p>
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class User {

    private String openid;          //用户的标识，对当前公众号唯一
    private String subscribe;       //用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
    private String nickname;        //用户的昵称
    private int sex;                //用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
    private String city;            //用户所在城市
    private String country;         //用户所在国家
    private String province;        //用户所在省份
    private String language;        //用户的语言，简体中文为zh_CN
    private String headimgurl;      //用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
    private long subscribe_time;    //用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
    private String unionid;         //只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
    private String remark;          //用户备注
    private String groupid;         //用户分组
    private int[] tagid_list;       //用户被打上的标签ID列表
    private String subscribe_scene; //返回用户关注的渠道来源，ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENEPROFILE LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_OTHERS 其他
    private String qr_scene;        //二维码扫码场景（开发者自定义）
    private String qr_scene_str;    //二维码扫码场景描述（开发者自定义）

    public User() {
    }

    /**
     * 获取 用户的标识
     *
     * <p>
     * 对当前公众号唯一</p>
     *
     * @return 用户的标识
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置 用户的标识
     *
     * <p>
     * 对当前公众号唯一</p>
     *
     * @param openId 用户的标识
     */
    public void setOpenid(String openId) {
        this.openid = openId;
    }

    /**
     * 获取 用户是否订阅该公众号标识
     *
     * <p>
     * 值为0时，代表此用户没有关注该公众号，拉取不到其余信息。</p>
     *
     * @return 用户是否订阅该公众号标识
     */
    public String getSubscribe() {
        return subscribe;
    }

    /**
     * 设置 用户是否订阅该公众号标识
     *
     * <p>
     * 值为0时，代表此用户没有关注该公众号，拉取不到其余信息。</p>
     *
     * @param subscribe 用户是否订阅该公众号标识
     */
    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    /**
     * 获取 用户的昵称
     *
     * @return 用户的昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置 用户的昵称
     *
     * @param nickName 用户的昵称
     */
    public void setNickname(String nickName) {
        this.nickname = nickName;
    }

    /**
     * 获取 用户的性别
     *
     * <p>
     * 值为1时是男性，值为2时是女性，值为0时是未知</p>
     *
     * @return 用户的性别
     */
    public int getSex() {
        return sex;
    }

    /**
     * 设置 用户的性别
     *
     * <p>
     * 值为1时是男性，值为2时是女性，值为0时是未知</p>
     *
     * @param sex 用户的性别
     */
    public void setSex(int sex) {
        this.sex = sex;
    }

    /**
     * 获取 用户所在城市
     *
     * @return 用户所在城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置 用户所在城市
     *
     * @param city 用户所在城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取 用户所在国家
     *
     * @return 用户所在国家
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * 设置 用户所在国家
     *
     * @param country 用户所在国家
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * 获取 用户所在省份
     *
     * @return 用户所在省份
     */
    public String getProvince() {
        return province;
    }

    /**
     *
     * 设置 用户所在省份
     *
     * @param province 用户所在省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取 用户的语言
     *
     * <p>
     * zh_CN 简体，zh_TW 繁体，en 英语</p>
     *
     * @return 用户的语言
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置 用户的语言
     *
     * <p>
     * zh_CN 简体，zh_TW 繁体，en 英语</p>
     *
     * @param language 用户的语言
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 获取 用户头像
     *
     * <p>
     * 最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选， <br>
     * 0代表640*640正方形头像），用户没有头像时该项为空</p>
     *
     * @return 用户头像
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * 设置 用户头像
     *
     * <p>
     * 最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选， <br>
     * 0代表640*640正方形头像），用户没有头像时该项为空</p>
     *
     * @param headimgUrl 用户头像
     */
    public void setHeadimgurl(String headimgUrl) {
        this.headimgurl = headimgUrl;
    }

    /**
     *
     * 获取 用户关注时间，为时间戳
     *
     * <p>
     * 如果用户曾多次关注，则取最后关注时间</p>
     *
     * @return 用户关注时间，为时间戳
     */
    public long getSubscribe_time() {
        return subscribe_time;
    }

    /**
     * 设置 用户关注时间，为时间戳
     *
     * @param subscribeTime 用户关注时间
     */
    public void setSubscribe_time(long subscribeTime) {
        this.subscribe_time = subscribeTime;
    }

    /**
     * 获取 用户备注
     *
     * @return 用户备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 用户备注
     *
     * @param remark 用户备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public int[] getTagid_list() {
        return tagid_list;
    }

    public void setTagid_list(int[] tagid_list) {
        this.tagid_list = tagid_list;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getSubscribe_scene() {
        return subscribe_scene;
    }

    public void setSubscribe_scene(String subscribe_scene) {
        this.subscribe_scene = subscribe_scene;
    }

    public String getQr_scene() {
        return qr_scene;
    }

    public void setQr_scene(String qr_scene) {
        this.qr_scene = qr_scene;
    }

    public String getQr_scene_str() {
        return qr_scene_str;
    }

    public void setQr_scene_str(String qr_scene_str) {
        this.qr_scene_str = qr_scene_str;
    }
}
