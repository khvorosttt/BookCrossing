/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.domain;
import java.sql.Date;
/**
 *
 * @author Lenovo
 */
public class Comment {
    private Integer id_comment;
    private String id_user;
    private int id_book;
    private String textComment;
    private Date date_time;
    
    public Integer getId_comment(){
        return id_comment;
    }
    
    public void setId_comment(Integer id_comment){
        this.id_comment=id_comment;
    }
    
    public String getId_user(){
        return id_user;
    }
    
    public void setId_user(String id_user){
        this.id_user=id_user;
    }
    
    public int getId_book(){
        return id_book;
    }
    
    public void setId_book(int id_book){
        this.id_book=id_book;
    }
    
    public String getTextComment(){
        return textComment;
    }
    
    public void setTextComment(String textComment){
        this.textComment=textComment;
    }
    
    public Date getDate_Time(){
        return date_time;
    }
    
    public void setDate_Time(Date date_time){
        this.date_time=date_time;
    }
}
