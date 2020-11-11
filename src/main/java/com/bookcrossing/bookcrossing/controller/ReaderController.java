/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.controller;

import com.bookcrossing.bookcrossing.domain.Reader;
import com.bookcrossing.bookcrossing.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReaderController {
    
    @Autowired
    private ReaderService readerService;
    
    @GetMapping("/login")
    public String getLoginPage() {       
        return "login";
    }
    
    @PostMapping("/login")
    public String addNewBook(@RequestParam(value = "name") String name, @RequestParam(value = "login") String login,
                             @RequestParam(value = "pass") String pass) {
        Reader reader = new Reader();
        reader.setLogin(login);
        reader.setReaderName(name);
        reader.setPassword(pass);
        reader=readerService.save(reader);
        if(reader!= null){
            return "redirect:/";
        }else{
            return "redirect:/login";
        }
    }
    
    @GetMapping("/sign-in")
    public String getSingInPage() {       
        return "signin";
    }
}
