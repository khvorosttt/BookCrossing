/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.controller;

import com.bookcrossing.bookcrossing.domain.Message;
import com.bookcrossing.bookcrossing.domain.ChatRoom;
import com.bookcrossing.bookcrossing.service.ChatRoomService;
import com.bookcrossing.bookcrossing.service.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    @Autowired
    private ChatRoomService chatRoomService; 
    
    @MessageMapping("/chat")
    public void processMessage(@Payload Message message) {
        String chatId=message.getId_sender()+"_"+message.getId_recipient();
        message.setChatId(chatId);

        Message saved = messageService.save(message);
        
        messagingTemplate.convertAndSendToUser(
                message.getId_recipient(),"/queue/messages",message);
    }
    @GetMapping("/chats")
    public String getBookPage(Model model) {
        List<ChatRoom> chats = chatRoomService.findAll();
        model.addAttribute("bookList", chats);
        return "chats";
    }
    /*@GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<?> findChatMessages ( @PathVariable String senderId,
                                                @PathVariable String recipientId) {
        return ResponseEntity
                .ok(chatMessageService.findChatMessages(senderId, recipientId));
    }*/
}
