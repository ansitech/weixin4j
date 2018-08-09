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
package org.weixin4j.loader;

import org.weixin4j.model.base.Token;
import org.apache.commons.lang.StringUtils;

/**
 * 内存式AccessToken存储器
 *
 * 单项目时使用（生产环境不推荐）
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.1.0
 */
public class DefaultTokenLoader implements ITokenLoader {

    /**
     * AccessToken对象
     */
    private Token token = null;

    @Override
    public Token get() {
        return (token == null
                || StringUtils.isEmpty(token.getAccess_token())
                || token.isExprexpired()) ? null : token;
    }

    @Override
    public void refresh(Token token) {
        if (null == token || StringUtils.isEmpty(token.getAccess_token())) {
            throw new IllegalStateException("access_token is null or empty");
        }
        if (token.getCreate_time() <= 0) {
            throw new IllegalStateException("createtime can not be zero");
        }
        if (token.isExprexpired()) {
            throw new IllegalStateException("access_token is exprexpired");
        }
        this.token = token;
    }

}
