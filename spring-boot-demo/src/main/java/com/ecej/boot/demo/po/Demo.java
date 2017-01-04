package com.ecej.boot.demo.po;

import com.ecej.nove.base.po.BasePo;

public class Demo extends BasePo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7149428671814386315L;

	private Integer id;
	private String name;

	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
