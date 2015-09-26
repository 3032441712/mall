package com.dragon.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.mall.dao.GoodsMapper;
import com.dragon.mall.service.GoodsServiceI;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsServiceI {

    @Autowired
    private GoodsMapper goodsMapper;

    public void getGoodsById(Integer goodsId) {
        System.out.println(goodsMapper.selectGoodsInfo(goodsId));
    }

}
