/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.repository;

import com.bookcrossing.bookcrossing.domain.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lenovo
 */
public class BookRepositoryImpl implements BookRepository {
    private List<Book> books = new ArrayList<Book>();

    public BookRepositoryImpl() {
        Book book = new Book();
        book.setAutor("Лермонтов М.Ю.");
        book.setName("Герой нашего времени");
        book.setBCID(1);
        books.add(book);
        Book book2 = new Book();
        book2.setAutor("Тургенев И.С.");
        book2.setName("Отцы и дети");
        book2.setBCID(books.get(books.size() - 1).getBCID() + 1);
        books.add(book2);

    }

    @Override
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public void delete(Book book) {
        books.remove(book);
    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public Book getByBCID(Integer BCID) {
        return books.get(BCID);
    }
}
