/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.OrderBoard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderBoardServiceTest {
    
    @Autowired
    OrderBoardService order_boardService;
    
    @Test
    void ShouldAddNewOrderBoard(){
        int countBefore = order_boardService.count();
        OrderBoard order_board= new OrderBoard();
        order_board.setAutor("Sample author");
        order_board.setName("Sample title");
        order_board=order_boardService.save(order_board);
        int countAfter = order_boardService.count();
        assertTrue(countBefore == countAfter - 1);
        List<OrderBoard> stored_order_board = order_boardService.findOrderBoard(order_board);
        assertNotNull(stored_order_board);
        assertTrue(stored_order_board.size()>0);
        assertEquals(order_board.getAuthor(), stored_order_board.get(0).getAuthor());
        assertEquals(order_board.getName(), stored_order_board.get(0).getName());
    }
    
    @Test
    void ShoulNotdAddNewOrderBoard(){
        int countBefore = order_boardService.count();
        List<OrderBoard> order_boards= order_boardService.findAll();
        assertNotNull(order_boards);
        assertTrue(order_boards.size()>0);
        OrderBoard order_board=order_boardService.save(order_boards.get(0));
        int countAfter = order_boardService.count();
        assertTrue(countBefore == countAfter);       
    }

    private OrderBoard findFirstOrderBoard() {
        List<OrderBoard> order_boards = order_boardService.findAll();
        return order_boards.get(0);
    }
    
    @Test
    void ShouldFindOrderBoard(){
        OrderBoard firstOrderBoard=findFirstOrderBoard();
        List<OrderBoard> order_boards=order_boardService.findOrderBoard(firstOrderBoard);
        assertNotNull(order_boards);
        assertTrue(order_boards.size()>0);
        assertEquals(firstOrderBoard.getAuthor(), order_boards.get(0).getAuthor());
        assertEquals(firstOrderBoard.getName(), order_boards.get(0).getName());
    }
    
    @Test
    void shouldFindAll() {
        List<OrderBoard> order_boards = order_boardService.findAll();
        assertNotNull(order_boards);
        assertTrue(order_boards.size() > 0);
    }
    @Test
    void shouldDeleteBook() {

        // create sample book
        OrderBoard order_board = new OrderBoard();
        order_board.setAutor("Sample author");
        order_board.setName("Sample name");        
        order_board = order_boardService.save(order_board);
        int countBefore = order_boardService.count();
        // delete book
        order_boardService.delete(order_board);
        // verify
        int countAfter = order_boardService.count();
        assertTrue(countBefore == countAfter + 1);
    }
    
}
