/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.Book;
import com.bookcrossing.bookcrossing.service.mapper.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lenovo
 */
@Service
public class BookServiceImpl implements BookService {

    @Override
    public List<Book> findByReader(String readerId) {
        return namedParameterJdbcTemplate
                .query("SELECT * FROM book WHERE reader = :reader",
                        new MapSqlParameterSource().addValue("reader", readerId),
                        bookRowMapper);
    }

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final BookRowMapper bookRowMapper;

    @Autowired
    public BookServiceImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
            BookRowMapper bookRowMapper) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.bookRowMapper = bookRowMapper;
    }

    @Override
    public Book save(Book book) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update("INSERT INTO book (author, title) VALUES (:author, :title)",
                    new MapSqlParameterSource()
                            .addValue("author", book.getAuthor())
                            .addValue("title", book.getName())
                    , keyHolder);
        return book;
    }

    @Override
    public void delete(Book book) {
        namedParameterJdbcTemplate.update("DELETE FROM book WHERE bcid = :bcid",
                new MapSqlParameterSource()
                        .addValue("bcid", book.getBCID()));
    }

    @Override
    public List<Book> findAll() {
        return namedParameterJdbcTemplate
                .query("SELECT * FROM book", bookRowMapper);
    }

    @Override
    public Book findById(Integer id) {
        return namedParameterJdbcTemplate
                .queryForObject("SELECT * FROM book WHERE bcid = :bcid",
                        new MapSqlParameterSource().addValue("bcid", id),
                        bookRowMapper);
    }

    @Override
    public int count() {
        return namedParameterJdbcTemplate
                .queryForObject("SELECT count(*) FROM book",
                        new MapSqlParameterSource(),
                        Integer.class);
    }

    @Override
    public List<Book> findBook(Book book) {
        return namedParameterJdbcTemplate
                .query("SELECT *  FROM book WHERE UPPER(author) = UPPER(:author)"
                        + " AND UPPER(title) = UPPER(:title)",
                        new MapSqlParameterSource()
                                .addValue("author", book.getAuthor())
                                .addValue("title", book.getName()), 
                        bookRowMapper);
    }
}
