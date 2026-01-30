package com.example.demo;

public class Hello {
	String name;
	String emailId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "Hello [name=" + name + ", emailId=" + emailId + "]";
	}
	public Hello(String name, String emailId) {
		super();
		this.name = name;
		this.emailId = emailId;
	}
	
	

}
