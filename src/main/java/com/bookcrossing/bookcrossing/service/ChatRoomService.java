/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.Chat;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface ChatRoomService {
    
    Chat findByChatId(String senderId, String recipientId);
    
    List<Chat> findBySenderId(String senderId);
    
    List<Chat> findAll();
    
    int count();
    
    Chat save();
}
