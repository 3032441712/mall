package com.dragon.mall.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dragon.mall.base.BaseService;
import com.dragon.mall.dao.GoodsMapper;

public class GoodsService {
    public static Map<String, Object> getGoodsInfo(Integer id) {
        Map<String, Object> goodsInfo = null;
        SqlSession session = BaseService.getSqlSessionFactory().openSession();
        GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
        goodsInfo = goodsMapper.selectGoodsInfo(id);
        session.close();

        return goodsInfo;
    }
}
