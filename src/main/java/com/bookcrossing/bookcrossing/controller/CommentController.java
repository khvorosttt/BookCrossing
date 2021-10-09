/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.controller;

import com.bookcrossing.bookcrossing.domain.Book;
import com.bookcrossing.bookcrossing.domain.Comment;
import com.bookcrossing.bookcrossing.domain.Reader;
import com.bookcrossing.bookcrossing.service.BookService;
import com.bookcrossing.bookcrossing.service.CommentService;
import com.bookcrossing.bookcrossing.service.ReaderService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Lenovo
 */

@Controller
public class CommentController {
    
    @Autowired
    private BookService bookService;
    
    @Autowired
    private ReaderService readerService;
    
    @Autowired
    private CommentService commentService;
    
    @PostMapping("/book-{id}-info")
    public String setBookInfo(@PathVariable("id") int id, Model model, @RequestParam(value = "textComment") String textComment) {
        Book book = bookService.findById(id);
        List<Comment> comments = new ArrayList<Comment>();
        Comment comment = new Comment();
        comment.setId_book(id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Reader reader = readerService.findByLogin(user.getUsername());
        comment.setId_user(reader.getId());
        //Date date = new Date();
        //comment.setDate_Time((java.sql.Date.valueOf(LocalDate.now())));
        comment.setTextComment(textComment);
        Comment saved = commentService.save(comment);
        comments=commentService.findByBook(book);
        model.addAttribute("book", book);
        model.addAttribute("commentList", comments);
        return "bookInfo";
    }
    
}
