/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.Chat;
import com.bookcrossing.bookcrossing.service.mapper.ChatRoomRowMapper;
import java.util.List;
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
public class ChatRoomServiceImpl implements ChatRoomService {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final ChatRoomRowMapper chatRoomRowMapper;

    public ChatRoomServiceImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, ChatRoomRowMapper chatRoomRowMapper) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.chatRoomRowMapper = chatRoomRowMapper;
    }

    @Override
    public Chat findByChatId(String senderId, String recipientId) {
        List<Chat> chats = findAll();
        String chatId1 = senderId + "_" + recipientId;
        String chatId2 = recipientId + "_" + senderId;
        Chat chat1= new Chat();
        chat1.setId(chats.get(chats.size()-1).getId()+1);
        chat1.setChatId(chatId1);
        chat1.setSenderId(senderId);
        chat1.setRecipientId(recipientId);
        Chat chat2= new Chat();
        chat2.setId(chats.get(chats.size()-1).getId()+2);
        chat2.setChatId(chatId2);
        chat2.setSenderId(recipientId);
        chat2.setRecipientId(senderId);
        List<Chat> chat = namedParameterJdbcTemplate
                .query("SELECT * FROM chatRoom WHERE chatId = :chatId",
                        new MapSqlParameterSource().addValue("chatId", chatId1),
                        chatRoomRowMapper);
        if (chat.isEmpty()) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update("INSERT INTO chatRoom (Id, chatId, senderId, recipientId) VALUES (:id, :chatId,"
                    + " :senderId, :recipientId)",
                    new MapSqlParameterSource()
                            .addValue("id",chat1.getId() )
                            .addValue("chatId", chat1.getChatId())
                            .addValue("senderId", chat1.getSenderId())
                            .addValue("recipientId", chat1.getRecipientId()),
                    keyHolder);
            namedParameterJdbcTemplate.update("INSERT INTO chatRoom (Id, chatId, senderId, recipientId) VALUES (:id, :chatId,"
                    + " :senderId, :recipientId)",
                    new MapSqlParameterSource()
                            .addValue("id",chat2.getId())
                            .addValue("chatId", chat2.getChatId())
                            .addValue("senderId", chat2.getSenderId())
                            .addValue("recipientId", chat2.getRecipientId()),
                    keyHolder);
        }
        return chat1;
    }

    @Override
    public List<Chat> findBySenderId(String senderId) {
        return namedParameterJdbcTemplate
                .query("SELECT * FROM chatRoom WHERE senderId = :senderId",
                        new MapSqlParameterSource().addValue("senderId", senderId),
                        chatRoomRowMapper);
    }

    @Override
    public int count() {
        return namedParameterJdbcTemplate
                .queryForObject("SELECT count(*) FROM chatRoom",
                        new MapSqlParameterSource(),
                        Integer.class);
    }

    @Override
    public List<Chat> findAll() {
        return namedParameterJdbcTemplate
                .query("SELECT * FROM chatRoom", chatRoomRowMapper);
    }

    @Override
    public Chat save() {
        Chat chat = new Chat();
        chat.setId(0);
        chat.setChatId("0000000000_0000000001");
        chat.setSenderId("0000000000");
        chat.setRecipientId("0000000001");
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update("INSERT INTO chatRoom (Id, chatId, senderId, recipientId) VALUES (:id, :chatId,"
                + ":senderId, :recipientId)",
                new MapSqlParameterSource()
                        .addValue("id", chat.getId())
                        .addValue("chatId", chat.getChatId())
                        .addValue("senderId", chat.getSenderId())
                        .addValue("recipientId", chat.getRecipientId()),
                keyHolder);
        return chat;
    }

}
