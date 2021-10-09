/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.domain;

/**
 *
 * @author Lenovo
 */
public class OrderBoard {
    
    private String reader;
    private String author;
    private String name;
    
    public String getReader(){
        return reader;
    }
    
    public void setReader(String reader){
        this.reader=reader;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAutor(String author) {
        this.author = author;
    }
}
