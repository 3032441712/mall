package com.dragon.mall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.mall.model.GoodsModel;

@RestController
public class GoodsController {
    
    @RequestMapping("/goods/info")
    public String info() {
        return GoodsModel.info(138);
    }
}
