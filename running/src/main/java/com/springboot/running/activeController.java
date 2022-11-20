package com.springboot.running;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value="activeService")
public class activeController {
	
	private String name;
	private String phoneNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
