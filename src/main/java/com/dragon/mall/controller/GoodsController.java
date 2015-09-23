package com.dragon.mall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.mall.model.GoodsModel;
import com.dragon.mall.util.ResponseUtil;

@RestController
public class GoodsController {
    
    @RequestMapping("/goods/info")
    public String info() {
        ResponseUtil responseUtil = new ResponseUtil();
        responseUtil.setCode(0);
        responseUtil.setMessage("success");
        responseUtil.setResponse(GoodsModel.info(17795));
        
        return responseUtil.toJSON();
    }
    
    @RequestMapping("/goods/store")
    public String store() {
        return "";
    }
}
