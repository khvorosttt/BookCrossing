/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.Book;
import com.bookcrossing.bookcrossing.domain.Comment;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Lenovo
 */
@SpringBootTest
public class CommentServiceTest {
    @Autowired
    BookService bookService;
    @Autowired
    CommentService commentService;

    @Test
    void shouldFindAll() {
        List<Comment> comments = commentService.findAll();
        assertNotNull(comments);
        assertTrue(comments.size() > 0);
    }
    
    private Comment findFirstComment() {
        List<Comment> comments = commentService.findAll();
        return comments.get(0);
    }
    
    @Test
    void shouldFindByBook() {

        Comment comment = findFirstComment();
        Book firstBook = bookService.findById(comment.getId_book());
        List<Comment> comments = commentService.findByBook(firstBook);
        assertNotNull(comments);
        assertEquals(comments.get(0).getId_comment(), comment.getId_book());
        assertEquals(comments.get(0).getId_user(), comment.getId_user());
        assertEquals(comments.get(0).getId_book(),comment.getId_book());
        assertEquals(comments.get(0).getTextComment(),comment.getTextComment());
        assertEquals(comments.get(0).getDate_Time(),comment.getDate_Time());
    }
    
    @Test
    void ShouldAddComment() {
        int countBefore = commentService.count();

        // add new book
        Comment comment = new Comment();
        comment.setId_user("0000000001");
        comment.setId_book(1);
        comment.setDate_Time((java.sql.Date.valueOf(LocalDate.now())));
        comment.setTextComment("Sample text");
        comment=commentService.save(comment);
        // verify
        int countAfter = commentService.count();
        assertTrue(countBefore == countAfter - 1);
        Comment storedComment = commentService.findById(comment.getId_comment());
        assertEquals(comment.getId_comment(), storedComment.getId_comment());
        assertEquals(comment.getId_user(), storedComment.getId_user());
        assertEquals(comment.getId_book(), storedComment.getId_book());
        assertEquals(comment.getTextComment(), storedComment.getTextComment());
        assertEquals(comment.getDate_Time(), storedComment.getDate_Time());
    }
}
