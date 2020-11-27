/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);

    void delete(Book book);

    List<Book> findAll();

    Book findById(Integer BCID);
    List<Book> findByReader(String readerId);
    
    List<Book> findBook(Book book);

    int count();
}
