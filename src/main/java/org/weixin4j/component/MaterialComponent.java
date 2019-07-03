package org.weixin4j.component;

import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.lang.WordUtils;
import org.weixin4j.Configuration;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.http.HttpClient;
import org.weixin4j.http.HttpsClient;
import org.weixin4j.model.material.Media;
import org.weixin4j.model.media.Attachment;
import org.weixin4j.model.message.MediaType;

/**
 * 素材组件
 *
 * @author yangqisheng
 * @since 0.1.0
 */
public class MaterialComponent extends AbstractComponent {

    public MaterialComponent(Weixin weixin) {
        super(weixin);
    }

    /**
     * 新增临时素材
     *
     * @param mediaType 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @param file form-data中媒体文件标识，有filename、filelength、content-type等信息
     * @return 上传成功返回素材Id，否则返回null
     * @throws org.weixin4j.WeixinException 微信操作异常
     * @since 0.1.4
     */
    public Media upload(MediaType mediaType, File file) throws WeixinException {
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //上传素材，返回JSON数据包
        String jsonStr = http.uploadHttps("https://api.weixin.qq.com/cgi-bin/media/upload?access_token=" + weixin.getToken().getAccess_token() + "&type=" + mediaType.toString(), file);
        JSONObject jsonObj = JSONObject.parseObject(jsonStr);
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("新增临时素材返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            } else {
                //转换为Media对象
                Media media = new Media();
                media.setMediaType(MediaType.valueOf(WordUtils.capitalize(jsonObj.getString("type"))));
                media.setMediaId(jsonObj.getString("media_id"));
                //转换为毫秒数
                long time = jsonObj.getLongValue("created_at") * 1000L;
                media.setCreatedAt(new Date(time));
                //返回多媒体文件id
                return media;
            }
        }
        return null;
    }

    /**
     * 获取临时素材(不支持视频)
     *
     * <p>
     * 本接口即为原“下载多媒体文件”接口。
     * </p>
     *
     * @param mediaId 媒体文件ID
     * @return 正确返回附件对象，否则返回null
     * @throws org.weixin4j.WeixinException 微信操作异常
     */
    public Attachment get(String mediaId) throws WeixinException {
        //下载资源
        String url = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=" + weixin.getToken().getAccess_token() + "&media_id=" + mediaId;
        //创建请求对象
        HttpsClient http = new HttpsClient();
        return http.downloadHttps(url);
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
     * @throws org.weixin4j.WeixinException 微信操作异常
     */
    public Attachment getJssdkVoice(String mediaId) throws WeixinException {
        //下载资源
        String url = "https://api.weixin.qq.com/cgi-bin/media/get/jssdk?access_token=" + weixin.getToken().getAccess_token() + "&media_id=" + mediaId;
        //创建请求对象
        HttpsClient http = new HttpsClient();
        return http.downloadHttps(url);
    }
}
