/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.OrderBoard;
import com.bookcrossing.bookcrossing.service.mapper.OrderBoardRowMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

@Service
public class OrderBoardServiceImpl implements OrderBoardService {
    
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    OrderBoardRowMapper order_boardRowMapper;

    @Autowired
    public OrderBoardServiceImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                           OrderBoardRowMapper order_boardRowMapper) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.order_boardRowMapper = order_boardRowMapper;
    }
    
    @Override
    public OrderBoard save(OrderBoard order_board) {
        if(namedParameterJdbcTemplate
                .query("SELECT author, title, Reader FROM order_board WHERE author = :author AND title= :title AND Reader=:Reader",
                        new MapSqlParameterSource()
                        .addValue("author", order_board.getAuthor())
                        .addValue("title", order_board.getName())
                        .addValue("Reader", order_board.getReader()),
                        order_boardRowMapper).size()>0){
            return null;
        }else{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update("INSERT INTO order_board (author, title,reader) VALUES (:author, :title, :reader)",
                    new MapSqlParameterSource()
                            .addValue("author", order_board.getAuthor())
                            .addValue("title", order_board.getName())
                            .addValue("reader", order_board.getReader())
                    , keyHolder);
            return order_board;
        }
    }

    @Override
    public List<OrderBoard> findAll() {
        return namedParameterJdbcTemplate
                .query("SELECT author, title, reader FROM order_board", order_boardRowMapper);
    }
    
    @Override
    public List<OrderBoard> findOrderBoard(OrderBoard order_board) {
        return namedParameterJdbcTemplate
                .query("SELECT author, title,reader FROM order_board WHERE UPPER(author) = UPPER(:author)"
                        + " AND UPPER(title) = UPPER(:title)",
                        new MapSqlParameterSource()
                        .addValue("author", order_board.getAuthor())
                        .addValue("title", order_board.getName()), order_boardRowMapper);
    }

    @Override
    public void delete(OrderBoard order_board) {
        namedParameterJdbcTemplate.update("DELETE FROM order_board WHERE author = :author AND title= :title",
                new MapSqlParameterSource()
                        .addValue("author", order_board.getAuthor())
                        .addValue("title", order_board.getName()));
    }
    
    @Override
    public int count() {
        return namedParameterJdbcTemplate
                .queryForObject("SELECT count(*) FROM order_board",
                        new MapSqlParameterSource(),
                        Integer.class);
    }    
}
