 package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.Book;
import org.junit.jupiter.api.Test; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    void shouldFindAll() {
        List<Book> books = bookService.findAll();
        assertNotNull(books);
        assertTrue(books.size() > 0);
    }

    @Test
    void shouldFindById() {

        Book firstBook = findFirstBook();
        Integer id = firstBook.getBCID();
        Book book = bookService.findById(id);
        assertNotNull(book);
        assertEquals(firstBook.getBCID(), book.getBCID());
        assertEquals(firstBook.getAuthor(), book.getAuthor());
        assertEquals(firstBook.getName(), book.getName());
        assertEquals(firstBook.getAccess(), book.getAccess());
        assertEquals(firstBook.getStatus(), book.getStatus());
        assertEquals(firstBook.getCountry(), book.getCountry());
        assertEquals(firstBook.getCity(), book.getCity());
        assertEquals(firstBook.getStreet(), book.getStreet());
        assertEquals(firstBook.getHouse(), book.getHouse());
    }

    @Test
    void ShouldAddNewBook() {
        int countBefore = bookService.count();

        // add new book
        Book book = new Book();
        book.setAutor("Sample author");
        book.setName("Sample name");
        book.setCountry("Sample country");
        book.setCity("Sample city");
        book.setStreet("Sample street");
        book.setAccess(2);
        book = bookService.save(book);
        // verify
        int countAfter = bookService.count();
        assertTrue(countBefore == countAfter - 1);
        Book storedBook = bookService.findById(book.getBCID());
        assertEquals(book.getBCID(), storedBook.getBCID());
        assertEquals(book.getAuthor(), storedBook.getAuthor());
        assertEquals(book.getName(), storedBook.getName());
        assertEquals(book.getAccess(), storedBook.getAccess());
        assertEquals(book.getStatus(), storedBook.getStatus());
        assertEquals(book.getCountry(), storedBook.getCountry());
        assertEquals(book.getCity(), storedBook.getCity());
        assertEquals(book.getStreet(), storedBook.getStreet());
        assertEquals(book.getHouse(), storedBook.getHouse());
    }
    
    @Test
    void ShouldUpdateBook() {

        // update first book
        Book book = findFirstBook();
        book.setAutor("Updated Author");
        book.setName("Updated Name");
        book.setCountry("Updated country");
        book.setCity("Updated city");
        book.setStreet("Updated street");
        book.setHouse("48");
        book.setAccess(3);
        Book bookUpdated = bookService.save(book);
        Book storedBook = bookService.findById(bookUpdated.getBCID());
        assertEquals(bookUpdated.getBCID(), storedBook.getBCID());
        assertEquals(bookUpdated.getAuthor(), storedBook.getAuthor());
        assertEquals(bookUpdated.getName(), storedBook.getName());
        assertEquals(bookUpdated.getAccess(), storedBook.getAccess());
        assertEquals(bookUpdated.getStatus(), storedBook.getStatus());
        assertEquals(bookUpdated.getCountry(), storedBook.getCountry());
        assertEquals(bookUpdated.getCity(), storedBook.getCity());
        assertEquals(bookUpdated.getStreet(), storedBook.getStreet());
        assertEquals(bookUpdated.getHouse(), storedBook.getHouse());
    }

    @Test
    void shouldDeleteBook() {

        // create sample book
        Book book = new Book();
        book.setAutor("Sample author");
        book.setName("Sample name");
        book.setCountry("Sample country");
        book.setCity("Sample city");
        book.setStreet("Sample street");
        book.setAccess(2);
        book = bookService.save(book);
        int countBefore = bookService.count();
        // delete book
        bookService.delete(book);
        // verify
        int countAfter = bookService.count();
        assertTrue(countBefore == countAfter + 1);
    }

    private Book findFirstBook() {
        List<Book> books = bookService.findAll();
        return books.get(0);
    }

}