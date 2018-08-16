package com.ansitech.example;

import org.weixin4j.loader.ITicketLoader;
import org.weixin4j.model.js.Ticket;
import org.weixin4j.model.js.TicketType;

/**
 * MyTicketLoader
 * 
 * @author yangqisheng
 */
public class MyTicketLoader implements ITicketLoader{

    @Override
    public Ticket get(TicketType ticketType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void refresh(Ticket ticket) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
