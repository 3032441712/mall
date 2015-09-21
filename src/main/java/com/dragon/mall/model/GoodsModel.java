package com.dragon.mall.model;

import java.util.Map;

import redis.clients.jedis.Jedis;

import com.alibaba.fastjson.JSON;
import com.dragon.mall.base.BaseService;
import com.dragon.mall.service.GoodsService;

public class GoodsModel {
    
    public static String info(Integer id) {
        Jedis jedis = BaseService.getJedisPool().getResource();
        String content = jedis.get("goods:info:"+String.valueOf(id));
        if (content == null) {
            Map<String, Object> data = GoodsService.getGoodsInfo(id);
            data.put("code", "1");
            data.put("message", "success");
            content = JSON.toJSONString(data);
            jedis.set("goods:info:"+String.valueOf(id), content);
            jedis.incr("goods:info:num:"+String.valueOf(id));
        }
        jedis.close();

        return content;
    }
}
