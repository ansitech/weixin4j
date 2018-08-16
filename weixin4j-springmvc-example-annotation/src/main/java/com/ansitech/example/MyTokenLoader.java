package com.ansitech.example;

import org.springframework.stereotype.Component;
import org.weixin4j.loader.ITokenLoader;
import org.weixin4j.model.base.Token;

/**
 * MyTokenLoader
 * 
 * @author yangqisheng
 */
@Component
public class MyTokenLoader implements ITokenLoader{

    @Override
    public Token get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void refresh(Token accessToken) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
