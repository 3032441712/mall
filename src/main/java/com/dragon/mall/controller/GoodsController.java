package com.dragon.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.mall.service.GoodsServiceI;
import com.dragon.mall.util.ResponseUtil;

@RestController
public class GoodsController {
    
    @Autowired
    private GoodsServiceI goodsService;
    
    @RequestMapping("/goods/info")
    public String info() {
        ResponseUtil responseUtil = new ResponseUtil();
        responseUtil.setCode(0);
        responseUtil.setMessage("success");
        
        goodsService.getGoodsById(137);
        return responseUtil.toJSON();
    }
    
    @RequestMapping("/goods/store")
    public String store() {
        return "";
    }
}
