package com.dragon.mall.model;

import com.alibaba.fastjson.JSON;
import com.dragon.mall.service.GoodsService;

public class GoodsModel {
    
    public static String info(Integer id) {
        return JSON.toJSONString(GoodsService.getGoodsInfo(id));
    }
}
