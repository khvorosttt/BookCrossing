/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service.mapper;

import com.bookcrossing.bookcrossing.domain.ChatRoom;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lenovo
 */
@Component
public class ChatRoomRowMapper implements RowMapper<ChatRoom> {
    @Override
    public ChatRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setId(rs.getInt("Id"));
        chatRoom.setChatId(rs.getString("chatId"));
        chatRoom.setSenderId(rs.getString("senderId"));
        chatRoom.setRecipientId(rs.getString("recipientId"));
        return chatRoom;
    }
}
