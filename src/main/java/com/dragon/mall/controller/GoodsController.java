package com.dragon.mall.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.mall.base.BaseService;
import com.dragon.mall.dao.DemoMapper;

@RestController
public class GoodsController {
    
    @RequestMapping("/goods/info")
    public String info() {
        SqlSession session = BaseService.getSqlSessionFactory().openSession();
        DemoMapper demo = session.getMapper(DemoMapper.class);
        System.out.println(demo.selectDemo(2));
        session.close();
        
        return "{\"code\":\"100\"}";
    }
}
