package com.dragon.mall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @RequestMapping("/order/info")
    public String info() {
        return "";
    }
    
    @RequestMapping("/order/list")
    public String orderList() {
        return "";
    }
}
