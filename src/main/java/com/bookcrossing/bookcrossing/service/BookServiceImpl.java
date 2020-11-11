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
        if (book.getBCID() == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update("INSERT INTO book (author, title, access, status, country, city, street,"
                    + " house) VALUES (:author, :title, :access, :status, :country, :city, :street, :house)",
                    new MapSqlParameterSource()
                            .addValue("author", book.getAuthor())
                            .addValue("title", book.getName())
                            .addValue("access", book.getAccess())
                            .addValue("status", book.getStatus())
                            .addValue("country", book.getCountry())
                            .addValue("city", book.getCity())
                            .addValue("street", book.getStreet())
                            .addValue("house", book.getHouse()),
                    keyHolder);
            book.setBCID(keyHolder.getKey().intValue());
        } else {
            namedParameterJdbcTemplate.update("UPDATE book SET author = :author, title = :title, access = :access,"
                    + " status = :status, country = :country, city = :city, street = :street, house = :house WHERE bcid = :bcid",
                    new MapSqlParameterSource()
                            .addValue("bcid", book.getBCID())
                            .addValue("author", book.getAuthor())
                            .addValue("title", book.getName())
                            .addValue("access", book.getAccess())
                            .addValue("status", book.getStatus())
                            .addValue("country", book.getCountry())
                            .addValue("city", book.getCity())
                            .addValue("street", book.getStreet())
                            .addValue("house", book.getHouse()));
        }
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
                .query("SELECT bcid, author, title FROM book WHERE author = :author"
                        + " AND title = :title",
                        new MapSqlParameterSource()
                                .addValue("author", book.getAuthor())
                                .addValue("title", book.getName()), bookRowMapper);
    }
}
