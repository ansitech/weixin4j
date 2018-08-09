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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.weixin4j.http.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.apache.commons.lang.StringUtils;
import org.weixin4j.Configuration;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.http.HttpsClient;
import org.weixin4j.model.qrcode.Qrcode;
import org.weixin4j.model.qrcode.QrcodeType;

/**
 * 生成带参数的二维码
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.0
 */
public class QrcodeComponent extends AbstractComponent {

    public QrcodeComponent(Weixin weixin) {
        super(weixin);
    }

    /**
     * 创建二维码ticket，整型值
     *
     * @param qrcodeType 二维码类型
     * @param scene_id 场景值ID
     * @param expire_seconds 临时二维码过期时间
     * @return 二维码ticket
     * @throws WeixinException
     */
    public Qrcode create(QrcodeType qrcodeType, int scene_id, int expire_seconds) throws WeixinException {
        return create(qrcodeType, scene_id, null, expire_seconds);
    }

    /**
     * 创建二维码ticket，字符串值
     *
     * @param qrcodeType 二维码类型
     * @param scene_str 场景值ID
     * @param expire_seconds 临时二维码过期时间
     * @return 二维码ticket
     * @throws WeixinException
     */
    public Qrcode create(QrcodeType qrcodeType, String scene_str, int expire_seconds) throws WeixinException {
        return create(qrcodeType, 0, scene_str, expire_seconds);
    }

    //内部公用方法
    private Qrcode create(QrcodeType qrcodeType, int scene_id, String scene_str, int expire_seconds) throws WeixinException {
        //内部业务验证
        switch (qrcodeType) {
            case QR_SCENE:
                if (scene_id <= 0) {
                    throw new IllegalStateException("场景id不能小于等于0");
                }
                break;
            case QR_LIMIT_SCENE:
                if (scene_id <= 0 || scene_id > 100000) {
                    throw new IllegalStateException("永久场景id参数只支持1-100000");
                }
                break;
            case QR_STR_SCENE:
            case QR_LIMIT_STR_SCENE:
                if (StringUtils.isEmpty(scene_str)) {
                    throw new IllegalStateException("场景scene_str不能为空");
                }
                break;
            default:
                throw new IllegalStateException("场景类型错误");
        }
        JSONObject ticketJson = new JSONObject();
        if (qrcodeType.equals(QrcodeType.QR_SCENE) || qrcodeType.equals(QrcodeType.QR_STR_SCENE)) {
            //临时二维码过期时间
            ticketJson.put("expire_seconds", expire_seconds);
        }
        //二维码类型
        ticketJson.put("action_name", qrcodeType.toString());

        JSONObject actionInfo = new JSONObject();
        JSONObject scene = new JSONObject();
        scene.put("scene_id", scene_id);
        actionInfo.put("scene", scene);
        //二维码详细信息
        ticketJson.put("action_info", actionInfo);
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用创建Tick的access_token接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + weixin.getToken().getAccess_token(), ticketJson);
        //根据请求结果判定，返回结果
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("/qrcode/create返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            } else {
                return JSONObject.toJavaObject(jsonObj, Qrcode.class);
            }
        }
        return null;
    }

    /**
     * 通过ticket换取二维码链接
     *
     * @param ticket 获取的二维码ticket
     * @return 二维码链接，或抛WechatException
     * @throws org.weixin4j.WeixinException
     */
    public String showQrcode(String ticket) throws WeixinException {
        try {
            return "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + URLEncoder.encode(ticket, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new WeixinException(e);
        }
    }

    /**
     * 保存二维码
     *
     * @param ticket 获取的二维码ticket
     * @param filePath 保存的地址
     * @throws WeixinException
     */
    public void saveQrcode(String ticket, String filePath) throws WeixinException {
        try {
            //通过ticket换取二维码
            URL url = new URL("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + ticket);
            // 打开连接
            URLConnection con = url.openConnection();
            // 输入流
            InputStream is = con.getInputStream();
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            OutputStream os = new FileOutputStream(filePath);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            os.close();
            is.close();
        } catch (MalformedURLException ex) {
            throw new WeixinException("通过ticket换取二维码异常：", ex);
        } catch (IOException ex) {
            throw new WeixinException("通过ticket换取二维码，下载二维码图片异常：", ex);
        }
    }
}
