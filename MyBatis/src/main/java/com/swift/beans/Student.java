package com.swift.beans;

public class Student {
	private String name;
	private String account;
	private int age;
	public Student()
	{
		
	}
	public Student(String account2, String name2, int age2) {
		// TODO Auto-generated constructor stub
		name=name2;
		account=account2;
		age=age2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
