package com.dragon.mall.model;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.dragon.mall.service.GoodsService;

public class GoodsModel {

    public static String info(Integer id) {
        Map<String, Object> data = GoodsService.getGoodsInfo(id);
        String content = JSON.toJSONString(data);

        return content;
    }
}
