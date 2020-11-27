/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service.mapper;

import com.bookcrossing.bookcrossing.domain.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class ReaderRowMapper implements RowMapper<Reader> {
    @Override
    public Reader mapRow(ResultSet rs, int rowNum) throws SQLException {
        Reader reader = new Reader();
        reader.setLogin(rs.getString("login"));
        reader.setId(rs.getString("id"));
        reader.setName(rs.getString("name"));
        reader.setPassword(rs.getString("password"));
        reader.setRole(rs.getString("role"));
        return reader;
    }
}
