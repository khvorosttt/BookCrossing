/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.domain;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class Message {
    private Integer id_message;
    private String chatId;
    private String id_sender;
    private String id_recipient;
    private Date date_time;
    private String textMessage;
    private boolean is_read;
    
    public Integer getId_message(){
        return id_message;
    }
    
    public void setId_message(Integer id_message){
        this.id_message=id_message;
    }
    
    public String getChatId(){
        return chatId;
    }
    
    public void setChatId(String chatId){
        this.chatId=chatId;
    }
    
    public String getId_sender(){
        return id_sender;
    }
    
    public void setId_sender(String id_sender){
        this.id_sender=id_sender;
    }
    
    public String getId_recipient(){
        return id_recipient;
    }
    
    public void setId_recipient(String id_recipient){
        this.id_recipient=id_recipient;
    }
    
    public Date getDate_Time(){
        return date_time;
    }
    
    public void setDate_Time(Date date_time){
        this.date_time=date_time;
    }
    
    public String getTextMessage(){
        return textMessage;
    }
    
    public void setTextMessage(String textMessage){
        this.textMessage=textMessage;
    }
    
    public boolean getIs_read(){
        return is_read;
    }
    
    public void setIs_read(boolean is_read){
        this.is_read=is_read;
    }
}
