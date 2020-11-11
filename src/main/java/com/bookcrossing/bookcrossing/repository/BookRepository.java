/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.repository;

import com.bookcrossing.bookcrossing.domain.Book;

import java.util.List;

/**
 * @author Lenovo
 */
public interface BookRepository {

    void save(Book book);

    void delete(Book book);

    List<Book> getAll();

    Book getByBCID(Integer BCID);
}
