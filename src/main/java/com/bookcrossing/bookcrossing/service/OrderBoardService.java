/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.OrderBoard;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface OrderBoardService {
    OrderBoard save(OrderBoard order_board);

    List<OrderBoard> findAll();

    List<OrderBoard> findOrderBoard(OrderBoard order_board);
    
    void delete(OrderBoard order_board);
    
    int count();
}
