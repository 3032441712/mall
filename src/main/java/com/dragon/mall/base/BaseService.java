package com.dragon.mall.base;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class BaseService {

    static Logger log = Logger.getLogger(BaseService.class);

    private static SqlSessionFactory sqlSessionFactory = null;

    private static JedisPool jedisPool = null;

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static JedisPool getJedisPool() {
        return jedisPool;
    }

    public static void initService() throws IOException {
        if (BaseService.sqlSessionFactory == null) {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            BaseService.sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(inputStream);
        }

        if (BaseService.jedisPool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(100);
            config.setMaxIdle(10);
            config.setMaxWaitMillis(1000);

            BaseService.jedisPool = new JedisPool(config, "localhost", 6379);
        }

        log.info("初始化 Service");
    }
}
