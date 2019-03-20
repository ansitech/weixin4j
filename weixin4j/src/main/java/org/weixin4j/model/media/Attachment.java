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
package org.weixin4j.model.media;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 附件
 *
 * @author yangqisheng
 * @since 0.0.1
 */
public class Attachment {

    private String fileName;
    private String fullName;
    private String suffix;
    private String contentLength;
    private String contentType;
    private BufferedInputStream fileStream;
    private String error;

    /**
     * 附件名称
     *
     * @return 附件名称
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置 附件名称
     *
     * @param fileName 附件名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 附件全名
     *
     * @return 附件全名
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 设置附件全名
     *
     * @param fullName 附件全名
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * 附件后缀
     *
     * @return 附件后缀
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * 设置 附件后缀
     *
     * @param suffix 附件后缀
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * 内容长度
     *
     * @return 内容长度
     */
    public String getContentLength() {
        return contentLength;
    }

    /**
     * 设置内容长度
     *
     * @param contentLength 内容长度
     */
    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    /**
     * 文件类型
     *
     * @return 文件类型
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * 设置 文件类型
     *
     * @param contentType 文件类型
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * 文件输入流
     *
     * @return 文件输入流
     */
    public BufferedInputStream getFileStream() {
        return fileStream;
    }

    /**
     * 设置 文件输入流
     *
     * @param fileStream 文件输入流
     */
    public void setFileStream(BufferedInputStream fileStream) {
        this.fileStream = fileStream;
    }

    /**
     * 保存为图片
     *
     * @param filePath 文件路径
     * @param fileName 文件名称
     * @return 文件对象
     * @throws java.io.FileNotFoundException
     */
    public File saveToImageFile(String filePath, String fileName) throws FileNotFoundException, IOException {
        String defaultSubffix = ".jpg";
        if (fileName.contains(".")) {
            defaultSubffix = fileName.substring(fileName.lastIndexOf("."));
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
        }
        return saveToFile(filePath, fileName, defaultSubffix);
    }

    /**
     * 保存到文件
     *
     * @param filePath 文件路径
     * @param fileName 文件名称(不包含后缀)
     * @param defaultSubffix 默认文件后缀
     * @return 文件对象
     * @throws java.io.FileNotFoundException
     */
    public File saveToFile(String filePath, String fileName, String defaultSubffix) throws FileNotFoundException, IOException {
        if (this.error == null) {
            //默认格式
            String subffix = defaultSubffix;
            //校验文件格式
            if (contentType.startsWith("image")) {
                //图片文件
                if (contentType.equals("image/jpeg")) {
                    subffix = "jpg";
                } else if (contentType.equals("image/jpeg")) {
                    subffix = "png";
                } else if (contentType.equals("image/gif")) {
                    subffix = "gif";
                } else {
                    subffix = "jpg";
                }
            } else if (contentType.startsWith("voice") || contentType.startsWith("audio")) {
                //音频文件
                if (contentType.equals("voice/mp3") || contentType.equals("audio/mp3")) {
                    subffix = "mp3";
                } else if (contentType.equals("voice/amr") || contentType.equals("audio/amr")) {
                    subffix = "amr";
                } else if (contentType.equals("voice/speex")) {
                    subffix = "speex";
                } else {
                    subffix = "mp3";
                }
            } else if (contentType.startsWith("video")) {
                //视频文件
                subffix = "mp4";

            }
            filePath = filePath.replace("/", File.separator);
            filePath = filePath.endsWith(File.separator) ? filePath : filePath + File.separator;
            File directory = new File(filePath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File file = new File(filePath + fileName + (subffix.indexOf(".") == 0 ? subffix : "." + subffix));
            FileOutputStream out = new FileOutputStream(file);
            byte[] bs = new byte[1024];
            int len;
            while ((len = fileStream.read(bs)) != -1) {
                out.write(bs, 0, len);
            }
            return file;
        }
        return null;
    }

    /**
     * 错误消息
     *
     * @return 错误消息
     */
    public String getError() {
        return error;
    }

    /**
     * 设置 错误消息
     *
     * @param error 错误消息
     */
    public void setError(String error) {
        this.error = error;
    }
}
