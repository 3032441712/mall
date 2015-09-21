package com.dragon.mall.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.mall.base.BaseService;
import com.dragon.mall.dao.GoodsMapper;

@RestController
public class GoodsController {
    
    @RequestMapping("/goods/info")
    public String info() {
        SqlSession session = BaseService.getSqlSessionFactory().openSession();
        GoodsMapper demo = session.getMapper(GoodsMapper.class);
        System.out.println(demo.selectDemo(134));
        session.close();
        
        return "{\"code\":\"100\"}";
    }
}
