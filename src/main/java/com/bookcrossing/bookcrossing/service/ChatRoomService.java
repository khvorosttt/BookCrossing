/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.ChatRoom;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface ChatRoomService {
    
    List<ChatRoom> findByChatId(String senderId, String recipientId);
    
    List<ChatRoom> findBySenderId(String senderId);
    
    List<ChatRoom> findAll();
    
    int count();
}
