package com.springboot.running;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;

@SuppressWarnings("deprecation")
@Scope(value = "session")
@ManagedBean(name="obj")
public class WebController {

	private String name = "MURASAKI";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
