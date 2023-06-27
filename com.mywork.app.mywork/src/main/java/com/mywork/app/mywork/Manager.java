package com.mywork.app.mywork;

public class Manager {
	private int ManagerNumber;
	private String name;
	private static int EmployerNumber=0;
		
	
	public Manager(String name) {
		this.ManagerNumber = ++EmployerNumber;
		this.setName(name);
	}
	
	
	public int getManagerNumber() {
		return ManagerNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
