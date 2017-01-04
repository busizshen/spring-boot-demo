package com.ecej.boot.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecej.boot.demo.po.Demo;
import com.ecej.boot.demo.service.DemoService;

@RestController
public class DemoController {

	@Resource
	private DemoService demoService;

	@RequestMapping("/insertDemo")
	public void insertDemo() {

		Demo demo = new Demo();
		demo.setName("qiang");
		demo.setAge(18);

		demoService.insertDemo(demo);
		System.out.println("插入成功");
	}
}
