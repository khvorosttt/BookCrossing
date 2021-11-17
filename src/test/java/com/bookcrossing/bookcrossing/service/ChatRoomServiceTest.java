/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bookcrossing.bookcrossing.domain.ChatRoom;
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
        List<ChatRoom> chatRoom = chatRoomService.findAll();
        assertNotNull(chatRoom);
        assertTrue(chatRoom.size()>0);
    }
    
}
