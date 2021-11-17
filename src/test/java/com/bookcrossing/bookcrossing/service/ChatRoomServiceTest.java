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
    
    
    
    
    /*@Test
    void ShouldAddChatRoom() {
        int countBefore = chatRoomService.count();

        // add new book
        Chat chatRoom = new Chat();
        chatRoom.setId(0);
        chatRoom.setSenderId("0000000000");
        chatRoom.setRecipientId("0000000001");
        chatRoom.setChatId("0000000000_0000000001");
        chatRoomService.save();
        // verify
        int countAfter = chatRoomService.count();
        assertTrue(countBefore == countAfter - 1);
        Chat storedComment = chatRoomService.findAll().get(0);
        assertEquals(chatRoom.getChatId(), storedComment.getChatId());
        assertEquals(chatRoom.getSenderId(), storedComment.getSenderId());
        assertEquals(chatRoom.getRecipientId(), storedComment.getRecipientId());
    }*/
    @Test
    void shouldFindAll() {
        List<Chat> chatRooms = chatRoomService.findAll();
        assertNotNull(chatRooms);
        assertTrue(chatRooms.size()>0);
    }
    @Test
    void ShouldAddChatRoom() {
        int countBefore = chatRoomService.count();

        // add new book
        //Chat chatRoom = new Chat();
        //chatRoom.setSenderId("0000000000");
        //chatRoom.setRecipientId("0000000001");
        //chatRoom.setChatId("0000000000_0000000001");
        Chat chatRoom = chatRoomService.findByChatId("0000000000", "0000000001");
        // verify
        int countAfter = chatRoomService.count();
        assertTrue(countBefore == countAfter - 2);
        Chat storedComment = chatRoomService.findAll().get(chatRoomService.count()-2);
        assertEquals(chatRoom.getChatId(), storedComment.getChatId());
        assertEquals(chatRoom.getSenderId(), storedComment.getSenderId());
        assertEquals(chatRoom.getRecipientId(), storedComment.getRecipientId());
    }
    
}
