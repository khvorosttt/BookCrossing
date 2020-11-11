package com.bookcrossing.bookcrossing.service.mapper;

import com.bookcrossing.bookcrossing.domain.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBCID(rs.getInt("bcid"));
        book.setAutor(rs.getString("author"));
        book.setName(rs.getString("title"));
        book.setCountry(rs.getString("country"));
        book.setCity(rs.getString("city"));
        book.setStreet(rs.getString("street"));
        book.setHouse(rs.getString("house"));
        book.setReader(rs.getString("reader"));
        book.setAccess(rs.getInt("access"));
        book.setStatus(rs.getBoolean("status"));
        return book;
    }
}
