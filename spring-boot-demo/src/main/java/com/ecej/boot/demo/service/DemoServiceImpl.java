package com.ecej.boot.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ecej.boot.demo.dao.DemoBaseDao;
import com.ecej.boot.demo.po.Demo;
import com.ecej.nove.base.po.BasePo;

@Service("demoService")
public class DemoServiceImpl implements DemoService {

	@Resource
	private DemoBaseDao demoBaseDao;

	@Override
	public void insertDemo(Demo demo) {
		demoBaseDao.insert(demo);
		System.out.println("调用到我得服务");
	}

	@Override
	public List<BasePo> selectDemo(Demo demo) {
		return demoBaseDao.selectList(demo);
	}
}
