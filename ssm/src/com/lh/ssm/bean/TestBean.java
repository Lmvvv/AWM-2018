package com.lh.ssm.bean;

/**
 * @Title:  TestBean.java   
 * @Package com.lh.ssm.bean   
 * @Description:    TODO
 * @author: LH李恒    
 * @date:   2019年8月9日 下午1:22:24
 */
public class TestBean {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestBean [name=" + name + "]";
	}
	
	
}
