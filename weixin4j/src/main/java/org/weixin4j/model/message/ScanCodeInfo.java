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
package org.weixin4j.model.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 扫描信息
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
@XmlRootElement(name = "ScanCodeInfo")
public class ScanCodeInfo {

    //扫描类型，一般是qrcode
    private String ScanType;
    //扫描结果，即二维码对应的字符串信息
    private String ScanResult;

    public String getScanType() {
        return ScanType;
    }

    @XmlElement(name = "ScanType")
    public void setScanType(String ScanType) {
        this.ScanType = ScanType;
    }

    public String getScanResult() {
        return ScanResult;
    }

    @XmlElement(name = "ScanResult")
    public void setScanResult(String ScanResult) {
        this.ScanResult = ScanResult;
    }
}
