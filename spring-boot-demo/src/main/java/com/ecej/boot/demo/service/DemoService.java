package com.ecej.boot.demo.service;

import java.util.List;

import com.ecej.boot.demo.po.Demo;
import com.ecej.nove.base.po.BasePo;

public interface DemoService {

	public void insertDemo(Demo demo);

	public List<BasePo> selectDemo(Demo demo);
}
