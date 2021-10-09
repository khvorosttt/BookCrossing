/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.Book;
import com.bookcrossing.bookcrossing.domain.Comment;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface CommentService {
    
    Comment save(Comment comment);
    
    List<Comment> findAll();
    
    List<Comment> findByBook(Book book);
    
    void delete(Comment comment);
    
    Comment findById(Integer id_comment);
    
    int count();
}
