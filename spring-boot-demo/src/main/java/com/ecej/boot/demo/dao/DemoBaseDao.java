package com.ecej.boot.demo.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.ecej.nove.dao.base.BaseDao;

@Repository
public class DemoBaseDao extends BaseDao {

	@Resource
	public void setDemoSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
