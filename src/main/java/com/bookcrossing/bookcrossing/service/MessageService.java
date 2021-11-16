/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.Message;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface MessageService {
    
    //Message save(Message message);

    List<Message> findAll();

    List<Message> findBySender(Message message);
    
    List<Message> findBySenderRecipient(Message message);
    
    void delete(Message message);
    
    int count();
}
