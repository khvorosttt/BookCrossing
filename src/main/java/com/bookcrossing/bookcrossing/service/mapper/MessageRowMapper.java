/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service.mapper;

import com.bookcrossing.bookcrossing.domain.Message;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lenovo
 */
@Component
public class MessageRowMapper implements RowMapper<Message> {

    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        Message message=new Message();
        message.setId_message(rs.getInt("id_message"));
        message.setChatId(rs.getString("chatId"));
        message.setId_sender(rs.getString("id_senger"));
        message.setId_recipient(rs.getString("id_recipient"));
        message.setTextMessage(rs.getString("textMessage"));
        message.setDate_Time(rs.getDate("date_time"));
        return message;
    }
    
}
