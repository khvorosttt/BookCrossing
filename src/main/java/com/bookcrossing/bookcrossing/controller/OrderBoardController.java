/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.controller;
;
import com.bookcrossing.bookcrossing.domain.OrderBoard;
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
        order_board.setAutor(author);
        order_board.setName(name);
        order_boardService.save(order_board);
        return "redirect:/order-board";
    }
}
