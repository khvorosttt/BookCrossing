/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.controller;

import com.bookcrossing.bookcrossing.domain.Book;
import com.bookcrossing.bookcrossing.domain.Reader;
import com.bookcrossing.bookcrossing.service.BookService;
import com.bookcrossing.bookcrossing.service.ReaderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReaderController {
    
    @Autowired
    private ReaderService readerService;
    @Autowired
    private BookService bookService;
    
    @RequestMapping("/login")
    public String login() {      
        return "login";
    }
    
    @GetMapping("/my-profile")
    public String getReaderInfo(Model model) {
        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Reader reader = readerService.findByLogin(user.getUsername());                
        List<Book> books = bookService.findByReader(reader.getId()); 
        model.addAttribute("bookList", books);
        model.addAttribute("reader",reader);
        return "readerInfo";
    }
    @GetMapping("/registration")
    public String registration(Model model) {
            return "registration";
    }
    @PostMapping("/registration")
    public String addNewReader(@RequestParam(value = "name") String name, @RequestParam(value = "login") String login,
                             @RequestParam(value = "pass") String pass, Model model) {
        Reader reader = new Reader();
        reader.setLogin(login);
        reader.setName(name);
        reader.setPassword(pass);
        reader.setRole("user");
        reader=readerService.save(reader);
        if(!(reader == null)){
            return "redirect:/login";}
        else{
            model.addAttribute("error","Пользователь с таким логином уже существует");
            return "registration";
        }
    }
}
   
