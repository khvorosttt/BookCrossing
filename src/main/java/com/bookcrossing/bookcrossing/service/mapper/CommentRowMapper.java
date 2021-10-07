/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service.mapper;

import com.bookcrossing.bookcrossing.domain.Comment;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lenovo
 */
@Component
public class CommentRowMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setId_comment(rs.getInt("Id_comment"));
        comment.setId_user(rs.getString("Id_user"));
        comment.setId_book(rs.getInt("Id_book"));
        comment.setTextComment(rs.getString("textComment"));
        comment.setDate_Time(rs.getDate("date_time"));
        return comment;
    }
    
}
