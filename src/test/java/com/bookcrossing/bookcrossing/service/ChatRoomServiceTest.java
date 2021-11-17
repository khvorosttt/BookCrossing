/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.Chat;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Lenovo
 */
@SpringBootTest
public class ChatRoomServiceTest {
    @Autowired
    ChatRoomService chatRoomService;
    @Test
    void shouldFindAll() {
        List<Chat> chatRooms = chatRoomService.findAll();
        assertNotNull(chatRooms);
        assertTrue(chatRooms.size()>0);
    }
    @Test
    void ShouldAddChatRoom() {
        int countBefore = chatRoomService.count();
        Chat chatRoom = chatRoomService.findByChatId("0000000000", "0000000001");
        // verify
        int countAfter = chatRoomService.count();
        assertTrue(countBefore == countAfter - 2);
        Chat storedChat = chatRoomService.findAll().get(chatRoomService.count()-2);
        assertEquals(chatRoom.getChatId(), storedChat.getChatId());
        assertEquals(chatRoom.getSenderId(), storedChat.getSenderId());
        assertEquals(chatRoom.getRecipientId(), storedChat.getRecipientId());
    }
    @Test
    void ShouldFindBySenderId() {
        List<Chat> chats=chatRoomService.findAll();
        Chat chatRoom=chats.get(chatRoomService.count()-1);
        List<Chat> storedChats=chatRoomService.findBySenderId(chatRoom.getSenderId());
        assertNotNull(storedChats);
        Chat storedChat=storedChats.get(storedChats.size()-1);
        // verify
        Chat storedComment = chatRoomService.findAll().get(chatRoomService.count()-2);
        assertEquals(chatRoom.getId(), storedChat.getId());
        assertEquals(chatRoom.getChatId(), storedChat.getChatId());
        assertEquals(chatRoom.getSenderId(), storedChat.getSenderId());
        assertEquals(chatRoom.getRecipientId(), storedChat.getRecipientId());
    }
}
