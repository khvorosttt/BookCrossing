/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.Reader;
import com.bookcrossing.bookcrossing.service.mapper.ReaderRowMapper;
import java.util.List;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

@Service
public class ReaderServiceImpl implements ReaderService {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final ReaderRowMapper readerRowMapper;

    @Autowired
    public ReaderServiceImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
            ReaderRowMapper readerRowMapper) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.readerRowMapper = readerRowMapper;
    }

    @Override
    public Reader save(Reader reader) {
        if (reader.getId() == null) {
            if (findByLogin(reader.getLogin()) == null) {
                int newId = count() + 1;
                char[] chars = new char[10 - Integer.toString(newId).length()];
                Arrays.fill(chars, '0');
                String Id = new String(chars) + Integer.toString(newId);
                reader.setId(Id);
                KeyHolder keyHolder = new GeneratedKeyHolder();
                namedParameterJdbcTemplate.update("INSERT INTO reader (id, login, name, password, role) "
                        + "VALUES (:id, :login, :name, :password, :role)",
                        new MapSqlParameterSource()
                                .addValue("id", reader.getId())
                                .addValue("login", reader.getLogin())
                                .addValue("name", reader.getName())
                                .addValue("password", reader.getPassword())
                                .addValue("role", reader.getRole()),
                         keyHolder);
            } else {
                reader = null;
            }
        } else {
            namedParameterJdbcTemplate.update("UPDATE reader SET login = :login, name = :name, "
                    + "password = :password WHERE id = :id",
                    new MapSqlParameterSource()
                            .addValue("id", reader.getId())
                            .addValue("login", reader.getLogin())
                            .addValue("name", reader.getName())
                            .addValue("password", reader.getPassword()));
        }
        return reader;
    }

    @Override
    public void delete(Reader reader) {
        namedParameterJdbcTemplate.update("DELETE FROM reader WHERE id = :id",
                new MapSqlParameterSource()
                        .addValue("id", reader.getId()));
    }

    @Override
    public List<Reader> findAll() {
        return namedParameterJdbcTemplate
                .query("SELECT * FROM reader", readerRowMapper);
    }

    @Override
    public Reader findById(String Id) {
        return namedParameterJdbcTemplate
                .queryForObject("SELECT * FROM reader WHERE id = :id",
                        new MapSqlParameterSource().addValue("id", Id),
                        readerRowMapper);
    }

    @Override
    public Reader findByLogin(String login) {
        try{
        return namedParameterJdbcTemplate
                .queryForObject("SELECT * FROM reader WHERE login = :login",
                        new MapSqlParameterSource().addValue("login", login),
                        readerRowMapper);
        } catch (EmptyResultDataAccessException e) {
        return null;
    }
    }

    @Override
    public int count() {
        return namedParameterJdbcTemplate
                .queryForObject("SELECT count(*) FROM reader",
                        new MapSqlParameterSource(),
                        Integer.class);
    }

}
