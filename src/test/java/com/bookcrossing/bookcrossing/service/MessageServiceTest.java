/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.Message;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Lenovo
 */
@SpringBootTest
public class MessageServiceTest {

    @Autowired
    MessageService messageService;

    @Test
    void shouldFindAll() {
        List<Message> messages = messageService.findAll();
        assertNotNull(messages);
        assertTrue(messages.size() > 0);
    }

    @Test
    void ShouldFindBySenderId() {
        List<Message> messages = messageService.findAll();
        Message message = messages.get(messages.size() - 1);
        List<Message> storedMessages = messageService.findBySender(message);
        assertNotNull(storedMessages);
        Message storedMessage = storedMessages.get(storedMessages.size() - 1);
        // verify
        assertEquals(message.getId_message(), storedMessage.getId_message());
        assertEquals(message.getChatId(), storedMessage.getChatId());
        assertEquals(message.getId_sender(), storedMessage.getId_sender());
        assertEquals(message.getId_recipient(), storedMessage.getId_recipient());
        assertEquals(message.getDate_Time(), storedMessage.getDate_Time());
        assertEquals(message.getTextMessage(), storedMessage.getTextMessage());
        assertEquals(message.getIs_read(), storedMessage.getIs_read());
    }

    @Test
    void ShouldFindBySenderIdRecipient() {
        List<Message> messages = messageService.findAll();
        Message message = messages.get(messages.size() - 1);
        List<Message> storedMessages = messageService.findBySenderRecipient(message);
        assertNotNull(storedMessages);
        Message storedMessage = storedMessages.get(storedMessages.size() - 1);
        // verify
        assertEquals(message.getId_message(), storedMessage.getId_message());
        assertEquals(message.getChatId(), storedMessage.getChatId());
        assertEquals(message.getId_sender(), storedMessage.getId_sender());
        assertEquals(message.getId_recipient(), storedMessage.getId_recipient());
        assertEquals(message.getDate_Time(), storedMessage.getDate_Time());
        assertEquals(message.getTextMessage(), storedMessage.getTextMessage());
        assertEquals(message.getIs_read(), storedMessage.getIs_read());
    }

    @Test
    void ShouldAddNewMessage() {
        int countBefore = messageService.count();

        // add new message
        Message message = new Message();
        message.setChatId("0000000000_0000000001");
        message.setId_sender("0000000000");
        message.setId_recipient("0000000001");
        message.setDate_Time((java.sql.Date.valueOf(LocalDate.now())));
        message.setTextMessage("Hello, world!");
        message.setIs_read(false);
        message = messageService.save(message);
        // verify
        int countAfter = messageService.count();
        assertTrue(countBefore == countAfter - 1);
        Message storedMessage = messageService.findByChatId(message);
        assertEquals(message.getId_message(), storedMessage.getId_message());
        assertEquals(message.getChatId(), storedMessage.getChatId());
        assertEquals(message.getId_sender(), storedMessage.getId_sender());
        assertEquals(message.getId_recipient(), storedMessage.getId_recipient());
        assertEquals(message.getDate_Time(), storedMessage.getDate_Time());
        assertEquals(message.getTextMessage(), storedMessage.getTextMessage());
        assertEquals(message.getIs_read(), storedMessage.getIs_read());
    }
    
    @Test
    void shouldDeleteMessage() {

        // create sample message
        Message message = new Message();
        message.setChatId("0000000000_0000000001");
        message.setId_sender("0000000000");
        message.setId_recipient("0000000001");
        message.setDate_Time((java.sql.Date.valueOf(LocalDate.now())));
        message.setTextMessage("Hello, sample world!");
        message.setIs_read(false);
        message = messageService.save(message);
        // verify
        int countBefore = messageService.count();
        // delete message
        messageService.delete(message);
        // verify
        int countAfter = messageService.count();
        assertTrue(countBefore == countAfter + 1);
    }
}
