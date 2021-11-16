/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.ChatRoom;
import com.bookcrossing.bookcrossing.service.mapper.ChatRoomRowMapper;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author Lenovo
 */
public class ChatRoomServiceImpl implements ChatRoomService{

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final ChatRoomRowMapper chatRoomRowMapper;

    public ChatRoomServiceImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, ChatRoomRowMapper chatRoomRowMapper) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.chatRoomRowMapper = chatRoomRowMapper;
    }
    
    @Override
    public List<ChatRoom> findByChatId(String senderId, String recipientId) {
        String chatId1=senderId+"_"+recipientId;
        String chatId2=recipientId+"_"+senderId;
        ChatRoom chat=namedParameterJdbcTemplate
                .queryForObject("SELECT * FROM chatRoom WHERE chatId = :chatId",
                        new MapSqlParameterSource().addValue("chatId", chatId1),
                        chatRoomRowMapper);
        if(chat == null){
            List<ChatRoom> chats=findAll();
            KeyHolder keyHolder = new GeneratedKeyHolder();
            if(chats.size()==0){
                namedParameterJdbcTemplate.update("INSERT INTO chatRoom (id, chatId, senderId, recipientId) VALUES (:id, :chatId,"
                        + " :senderId, :recipientId)",
                    new MapSqlParameterSource()
                            .addValue("id",0)
                            .addValue("chatId", chatId1)
                            .addValue("senderId", senderId)
                            .addValue("recipientId", recipientId),
                    keyHolder);
                namedParameterJdbcTemplate.update("INSERT INTO chatRoom (id, chatId, senderId, recipientId) VALUES (:id, :chatId,"
                        + " :senderId, :recipientId)",
                    new MapSqlParameterSource()
                            .addValue("id",1)
                            .addValue("chatId", chatId2)
                            .addValue("senderId", recipientId)
                            .addValue("recipientId", senderId),
                    keyHolder);
            }else{
                namedParameterJdbcTemplate.update("INSERT INTO chatRoom (id, chatId, senderId, recipientId) VALUES (:id, :chatId,"
                        + " :senderId, :recipientId)",
                    new MapSqlParameterSource()
                            .addValue("id",chats.get(chats.size()-1).getId()+1)
                            .addValue("chatId", chatId1)
                            .addValue("senderId", senderId)
                            .addValue("recipientId", recipientId),
                    keyHolder);
                namedParameterJdbcTemplate.update("INSERT INTO chatRoom (id, chatId, senderId, recipientId) VALUES (:id, :chatId,"
                        + " :senderId, :recipientId)",
                    new MapSqlParameterSource()
                            .addValue("id",chats.get(chats.size()-1).getId()+2)
                            .addValue("chatId", chatId2)
                            .addValue("senderId", recipientId)
                            .addValue("recipientId", senderId),
                    keyHolder);
            }
        }
        return namedParameterJdbcTemplate
                .query("SELECT * FROM chatRoom WHERE chatId = :chatId1 OR chatId=:chatId2",
                        new MapSqlParameterSource().addValue("chatId", chatId1)
                        .addValue("chatId2", chatId2),
                        chatRoomRowMapper);
    }

    @Override
    public List<ChatRoom> findBySenderId(String senderId) {
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
    public List<ChatRoom> findAll() {
        return namedParameterJdbcTemplate
                .query("SELECT * FROM chatRoom", chatRoomRowMapper);
    }
    
}
