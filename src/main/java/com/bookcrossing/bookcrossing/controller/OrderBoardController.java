/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.controller;
;
import com.bookcrossing.bookcrossing.domain.Book;
import com.bookcrossing.bookcrossing.domain.OrderBoard;
import com.bookcrossing.bookcrossing.service.BookService;
import com.bookcrossing.bookcrossing.service.OrderBoardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderBoardController {
    
    @Autowired
    private OrderBoardService order_boardService;
    @Autowired
    private BookService bookService;
    
    
    @GetMapping("/order-board")
    public String getOrderBoardPage(Model model) {
        List<OrderBoard> order_boards = order_boardService.findAll();
        model.addAttribute("order_boardList", order_boards);
        return "orderBoard";
    }
    @PostMapping("/order-board")
    public String addNewOrderBoard(@RequestParam(value = "author") String author,
            @RequestParam(value = "name") String name) {
        OrderBoard order_board = new OrderBoard();
        Book book=new Book();
        order_board.setAutor(author.trim());
        book.setAutor(author.trim());
        order_board.setName(name.trim());
        book.setName(name.trim());
        List<Book> books = bookService.findBook(book);
        if(books.size()>0){
            return "redirect:/book-"+books.get(0).getBCID()+"-info";
        }
        order_boardService.save(order_board);
        return "redirect:/order-board";
    }
}
