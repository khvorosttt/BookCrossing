 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.controller;

import com.bookcrossing.bookcrossing.domain.Book;
import com.bookcrossing.bookcrossing.domain.OrderBoard;
import com.bookcrossing.bookcrossing.service.BookService;
import com.bookcrossing.bookcrossing.service.OrderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderBoardService order_boardService;
    
    @GetMapping("/")
    public String getBookPage(Model model) {
        List<Book> books = bookService.findAll(); 
        model.addAttribute("bookList", books);
        return "book";
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
        book.setAutor(author);
        book.setName(name);
        book.setReader(null);
        book.setCountry(country);
        book.setCity(city);
        book.setStreet(street);
        book.setHouse(house);
        book.setAccess(access);  
        book.setStatus(true);
        bookService.save(book);
        OrderBoard order_board=new OrderBoard();
        order_board.setAutor(author);
        order_board.setName(name);
        List<OrderBoard> findBook = order_boardService.findOrderBoard(order_board);
        if(findBook.size()>0){
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
    public String getFindBook(Model model,@RequestParam(value = "author") String author, @RequestParam(value = "name") String name) { 
        Book book = new Book();
        book.setAutor(author);
        book.setName(name);
        List<Book> books = bookService.findBook(book); 
        model.addAttribute("bookList", books);
        return "findBook";
    }
    
    @GetMapping("/book-{id}-info")
    public String getBookInfo(@PathVariable("id") int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "bookInfo";
    }
}
