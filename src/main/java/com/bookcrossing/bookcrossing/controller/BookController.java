/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.controller;

import com.bookcrossing.bookcrossing.domain.Book;
import com.bookcrossing.bookcrossing.domain.Comment;
import com.bookcrossing.bookcrossing.domain.OrderBoard;
import com.bookcrossing.bookcrossing.domain.Reader;
import com.bookcrossing.bookcrossing.service.BookService;
import com.bookcrossing.bookcrossing.service.CommentService;
import com.bookcrossing.bookcrossing.service.OrderBoardService;
import com.bookcrossing.bookcrossing.service.ReaderService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private OrderBoardService order_boardService;
    @Autowired
    private ReaderService readerService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public String getBookPage(Model model) {
        List<Book> books = bookService.findAll();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!user.isAccountNonLocked()){
            Reader reader = readerService.findByLogin(user.getUsername());
        
        model.addAttribute("reader", reader);
        }
        model.addAttribute("bookList", books);
        return "book";
    }

    @RequestMapping("/add-{id}")
    public String addBook(Model model, @PathVariable(value = "id") int id) {
        Book book = bookService.findById(id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Reader reader = readerService.findByLogin(user.getUsername());
        if(book.getStatus()){
            book.setReader(reader.getId());
            book.setStatus(false);
            bookService.save(book);
        }
        return "redirect:/"; 
    }

    @GetMapping("/add-new-book")
    public String addNewBookPage() {
        return "addNewBook";
    }

    @PostMapping("/add-new-book")
    public String addNewBook(@RequestParam(value = "author") String author, @RequestParam(value = "name") String name,
            @RequestParam(value = "country") String country, @RequestParam(value = "city") String city,
            @RequestParam(value = "street") String street, @RequestParam(value = "house") String house,
            @RequestParam(value = "access") int access) {
        Book book = new Book();
        book.setAutor(author.trim());
        book.setName(name.trim());
        book.setReader(null);
        book.setCountry(country.trim());
        book.setCity(city.trim());
        book.setStreet(street.trim());
        if(!house.isEmpty()&&house.charAt(0)=='-'){
            house=house.substring(1);
        }
        book.setHouse(house.trim());
        book.setAccess(access);
        book.setStatus(true);
        bookService.save(book);
        OrderBoard order_board = new OrderBoard();
        order_board.setAutor(author.trim());
        order_board.setName(name.trim());
        List<OrderBoard> findBook = order_boardService.findOrderBoard(order_board);
        if (findBook.size() > 0) {
            order_boardService.delete(findBook.get(0));
        }
        return "redirect:/";
    }

    @GetMapping("/find-book")
    public String FindBook(Model model) {
        model.addAttribute("bookList", null);
        return "findBook";
    }

    @PostMapping("/find-book")
    public String getFindBook(Model model, @RequestParam(value = "author") String author,
            @RequestParam(value = "name") String name) {
        Book book = new Book();
        book.setAutor(author.trim());
        book.setName(name.trim());
        List<Book> books = bookService.findBook(book);
        model.addAttribute("bookList", books);
        return "findBook";
    }

    @GetMapping("/book-{id}-info")
    public String getBookInfo(@PathVariable("id") int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        List<Comment> comments=commentService.findByBook(book);
        model.addAttribute("commentList", comments);
        return "bookInfo";
    }
    
    @RequestMapping("/delete-{id}-from-profile")
    public String deleteBookFromProfile(@PathVariable(value = "id") int id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Reader reader = readerService.findByLogin(user.getUsername());
        Book book = bookService.findById(id);
        if (book.getReader().equals(reader.getId())) {
            book.setReader(null);
            book.setStatus(true);
            bookService.save(book);
        }
        return "redirect:/my-profile";
    }
    
    @RequestMapping("/delete-{id}-from-library")
    public String deleteBookFromLibrary(@PathVariable(value = "id") int id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Reader reader = readerService.findByLogin(user.getUsername());
        Book book = bookService.findById(id);
        if (book.getReader().equals(reader.getId())) {
            bookService.delete(book);
        }
        return "redirect:/my-profile";
    }
    

    @GetMapping("/edit-{id}")
    public String getBookEdit(@PathVariable("id") int id, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Reader reader = readerService.findByLogin(user.getUsername());
        Book book = bookService.findById(id);
        if (book.getReader().equals(reader.getId())) {
            model.addAttribute("book", book);
            return "editBook";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/edit-{id}")
    public String editBook(@PathVariable(value = "id") int id, @RequestParam(value = "author") String author, @RequestParam(value = "name") String name,
            @RequestParam(value = "country") String country, @RequestParam(value = "city") String city,
            @RequestParam(value = "street") String street, @RequestParam(value = "house") String house,
            @RequestParam(value = "access") int access) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Reader reader = readerService.findByLogin(user.getUsername());
        Book book = bookService.findById(id);
        book.setAutor(author.trim());
        book.setName(name.trim());
        book.setCountry(country.trim());
        book.setCity(city.trim());
        book.setStreet(street.trim());
        if(house.isEmpty()&&house.charAt(0)=='-'){
            house=house.substring(1);
        }
        book.setHouse(house.trim());
        book.setAccess(access);
        book.setStatus(false);
        bookService.save(book);
        return "redirect:/";
    }
}
