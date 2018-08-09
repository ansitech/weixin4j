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

/**
 * 附件
 *
 * @author 杨启盛<qsyang@ansitech.com>
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
