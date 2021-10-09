/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service.mapper;

import com.bookcrossing.bookcrossing.domain.OrderBoard;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderBoardRowMapper implements RowMapper<OrderBoard> {
    @Override
    public OrderBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderBoard order_board = new OrderBoard();
        order_board.setAutor(rs.getString("author"));
        order_board.setName(rs.getString("title"));
        order_board.setReader(rs.getString("reader"));
        return order_board;
    }
}
