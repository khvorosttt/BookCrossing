/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.controller;

import com.bookcrossing.bookcrossing.domain.Message;
import com.bookcrossing.bookcrossing.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Lenovo
 */
@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    
    /*@MessageMapping("/chat")
    public void processMessage(@Payload Message message) {
        String chatId=message.getId_sender()+"_"+message.getId_recipient();
        message.setChatId(chatId);

        Message saved = messageService.save(message);
        
        messagingTemplate.convertAndSendToUser(
                message.getId_recipient(),"/queue/messages",message);
    }*/
}
