/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.domain;

/**
 *
 * @author Lenovo
 */
public class ChatRoom {
    private Integer id;
    private String chatId;
    private String senderId;
    private String recipientId;
    
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id=id;
    }
    
    public String getChatId(){
        return chatId;
    }
    
    public void setChatId(String chatId){
        this.chatId=chatId;
    }
    
    public String getSenderId(){
        return senderId;
    }
    
    public void setSenderId(String senderId){
        this.senderId=senderId;
    }
    
    public String getRecipientId(){
        return recipientId;
    }
    
    public void setRecipientId(String recipientId){
        this.recipientId=recipientId;
    }
}
