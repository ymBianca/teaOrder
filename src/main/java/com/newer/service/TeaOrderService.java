package com.newer.service;

import com.newer.domain.TeaOrder;
import com.newer.mapper.TeaOrderMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TeaOrderService {

    private TeaOrderMapper teaOrderMapper;
    private SqlSession sqlSession;

    public TeaOrderService() {
        //初始化数据库操映射接口
        sqlSession = SqlSessionUtil.getSqlSession();
        teaOrderMapper = sqlSession.getMapper(TeaOrderMapper.class);
    }

    public int addOrder(TeaOrder teaOrder) {
        //添加订单业务操作
        int rows = teaOrderMapper.addOrder(teaOrder);
        sqlSession.commit();
        return rows;
    }

    public void close() {
        if (sqlSession != null) {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }
}
