/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.controller;

import com.bookcrossing.bookcrossing.domain.Chat;
import com.bookcrossing.bookcrossing.domain.Message;
import com.bookcrossing.bookcrossing.domain.Reader;
import com.bookcrossing.bookcrossing.service.ChatRoomService;
import com.bookcrossing.bookcrossing.service.MessageService;
import com.bookcrossing.bookcrossing.service.ReaderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
    @Autowired
    private ReaderService readerService;
    
    @MessageMapping("/chat")
    public void processMessage(@Payload Message message) {
        String chatId=message.getId_sender()+"_"+message.getId_recipient();
        message.setChatId(chatId);

        Message saved = messageService.save(message);
        
        messagingTemplate.convertAndSendToUser(
                message.getId_recipient(),"/queue/messages",message);
    }
    @GetMapping("/messages")
    public String getChatRoomPage(Model model) {
        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Reader reader = readerService.findByLogin(user.getUsername());
        List<Chat> chats = chatRoomService.findBySenderId(reader.getId());
        model.addAttribute("chatList", chats);
        return "chats";
    }
    @GetMapping("/messages/{senderId}/{recipientId}")
    public String findChatMessages ( @PathVariable String senderId,
                                                @PathVariable String recipientId, Model model) {
        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Reader reader = readerService.findByLogin(user.getUsername());
        if(senderId.equals(reader.getId())){
            Message message=new Message();
            message.setId_sender(chatRoomService.findByChatId(senderId, recipientId).getSenderId());
            message.setId_recipient(chatRoomService.findByChatId(senderId, recipientId).getRecipientId());
            List<Message> messages=messageService.findBySenderRecipient(message);
            model.addAttribute("messageList",messages);
            return "index";
        }
        return "redirect:/";
    }
    /*
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
    @GetMapping("/chat")
    public String getChat() {
        return "index";
    }
    */
    /*@GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<?> findChatMessages ( @PathVariable String senderId,
                                                @PathVariable String recipientId) {
        return ResponseEntity
                .ok(chatMessageService.findChatMessages(senderId, recipientId));
    }*/
    /*@MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
    @GetMapping("/chat")
    public String getChat() {
        return "index";
    }*/
}
