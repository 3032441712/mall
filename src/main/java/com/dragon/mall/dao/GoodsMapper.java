package com.dragon.mall.dao;

import java.util.Map;

public interface GoodsMapper {
    public Map<String, Object> selectDemo(Integer id);

    public Map<String, Object> selectGoodsInfo(Integer id);
}
