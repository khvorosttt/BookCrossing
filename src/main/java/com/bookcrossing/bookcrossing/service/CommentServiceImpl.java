/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.Book;
import com.bookcrossing.bookcrossing.domain.Comment;
import com.bookcrossing.bookcrossing.service.mapper.CommentRowMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author Lenovo
 */
public class CommentServiceImpl implements CommentService {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    CommentRowMapper commentRowMapper;
    
    @Autowired
    public CommentServiceImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                           CommentRowMapper commentRowMapper) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.commentRowMapper = commentRowMapper;
    }
    @Override
    public Comment save(Comment comment) {
        if (comment.getId_comment() == null) {
            comment.setId_comment(count()+1);
            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update("INSERT INTO comment (Id_comment, Id_user, Id_book, textComment,"
                    + " date_time) VALUES (:id_comment, :id_user, :id_book, :textComment,"
                    + ":date_time)",
                    new MapSqlParameterSource()
                            .addValue("id_comment", comment.getId_comment())
                            .addValue("id_user", comment.getId_user())
                            .addValue("id_book", comment.getId_book())
                            .addValue("textComment", comment.getTextComment())
                            .addValue("date_time", comment.getDate_Time()),
                    keyHolder);
        } else {
            namedParameterJdbcTemplate.update("UPDATE comment SET Id_comment = :id_comment,"
                    + "Id_user = :id_user, Id_book=:idbook, textComment = :textComment, date_time = :date_time",
                    new MapSqlParameterSource()
                            .addValue("id_comment", comment.getId_comment())
                            .addValue("id_user", comment.getId_user())
                            .addValue("id_book", comment.getId_book())
                            .addValue("textComment", comment.getTextComment())
                            .addValue("date_time", comment.getDate_Time()));
        }
        return comment;
    }

    @Override
    public List<Comment> findAll() {
        return namedParameterJdbcTemplate
                .query("SELECT Id_comment, Id_user, Id_book, textComment, date_time FROM comment", commentRowMapper);
    }

    @Override
    public List<Comment> findByBook(Book book) {
        return namedParameterJdbcTemplate
                .query("SELECT * FROM comment WHERE Id_book = :id_book",
                        new MapSqlParameterSource().addValue("id_book", book.getBCID()),
                        commentRowMapper);
    }

    @Override
    public void delete(Comment comment) {
        namedParameterJdbcTemplate.update("DELETE FROM comment WHERE Id_comment = :id_comment",
                new MapSqlParameterSource()
                        .addValue("id_comment", comment.getId_comment()));
    }

    @Override
    public int count() {
        return namedParameterJdbcTemplate
                .queryForObject("SELECT count(*) FROM comment",
                        new MapSqlParameterSource(),
                        Integer.class);
    }
    
}
