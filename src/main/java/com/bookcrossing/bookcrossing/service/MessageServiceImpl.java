/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.Message;
import com.bookcrossing.bookcrossing.service.mapper.MessageRowMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class MessageServiceImpl implements MessageService {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    MessageRowMapper messageRowMapper;
    @Autowired
    private ChatRoomService chatRoomService;
    
    @Autowired
    public MessageServiceImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                           MessageRowMapper messageRowMapper) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.messageRowMapper = messageRowMapper;
    }
    
    @Override
    public Message save(Message message) {
        if (message.getId_message() == null) {
            message.setId_message(count()+1);
            KeyHolder keyHolder = new GeneratedKeyHolder();
            chatRoomService.findByChatId(message.getId_sender(), message.getId_recipient());
            namedParameterJdbcTemplate.update("INSERT INTO message (id_message, chatId, id_sender, id_recipient, sender, recipient, textMessage,"
                    + " date_time, is_read) VALUES (:id_message, :chatId, :id_sender, :id_recipient, :sender, :recipient, :textMessage,"
                    + ":date_time, :is_read)",
                    new MapSqlParameterSource()
                            .addValue("id_message", message.getId_message())
                            .addValue("chatId", message.getChatId())
                            .addValue("id_sender", message.getId_sender())
                            .addValue("id_recipient", message.getId_recipient())
                            .addValue("sender", message.getSender())
                            .addValue("recipient", message.getRecipient())
                            .addValue("textMessage", message.getTextMessage())
                            .addValue("date_time", message.getDate_Time())
                            .addValue("is_read", message.getIs_read()),
                    keyHolder);
        } else {
            namedParameterJdbcTemplate.update("UPDATE message SET id_sender = :id_sender, sender=:sender, recipient=:recipient,"
                    + "id_recipient = :id_recipient, textMessage = :textMessage, date_time = :date_time, is_read = :is_read",
                    new MapSqlParameterSource()
                            .addValue("id_sender", message.getId_sender())
                            .addValue("id_recipient", message.getId_recipient())
                            .addValue("sender", message.getSender())
                            .addValue("recipient", message.getRecipient())
                            .addValue("textMessage", message.getTextMessage())
                            .addValue("date_time", message.getDate_Time())
                            .addValue("is_read", message.getIs_read()));
        }
        return message;
    }

    @Override
    public List<Message> findAll() {
        return namedParameterJdbcTemplate
                .query("SELECT * FROM message", messageRowMapper);
    }

    @Override
    public List<Message> findBySender(Message message) {
        return namedParameterJdbcTemplate
                .query("SELECT * FROM message WHERE id_sender = :id_sender",
                        new MapSqlParameterSource().addValue("id_sender", message.getId_sender()),
                        messageRowMapper);
    }

    @Override
    public List<Message> findBySenderRecipient(Message message) {
        return namedParameterJdbcTemplate
                .query("SELECT * FROM message WHERE id_sender = :id_sender AND id_recipient=:id_recipient",
                        new MapSqlParameterSource().addValue("id_sender", message.getId_sender())
                        .addValue("id_recipient", message.getId_recipient()),
                        messageRowMapper);
    }

    @Override
    public void delete(Message message) {
        namedParameterJdbcTemplate.update("DELETE FROM message WHERE id_message = :id_message",
                new MapSqlParameterSource()
                        .addValue("id_message", message.getId_message()));
    }

    @Override
    public int count() {
        return namedParameterJdbcTemplate
                .queryForObject("SELECT count(*) FROM message",
                        new MapSqlParameterSource(),
                        Integer.class);
    }

    @Override
    public Message findByChatId(Message message) {
        return namedParameterJdbcTemplate
                .queryForObject("SELECT * FROM message WHERE chatId = :chatId",
                        new MapSqlParameterSource().addValue("chatId", message.getChatId()),
                        messageRowMapper);
    }
    
}
