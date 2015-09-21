package com.dragon.mall.base;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class BaseService {
    
    static Logger log = Logger.getLogger(BaseService.class);
        
    private static SqlSessionFactory sqlSessionFactory = null;
    
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static void initService() throws IOException {
        if (sqlSessionFactory == null) {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            BaseService.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        log.info("初始化 Service");
        log.info(BaseService.sqlSessionFactory);
    }
}
