package com.mywork.app.mywork;

public class Book {
	private int id;
	private String name;
	private float price;
	private int numberOfCopies;
	private static int lastId=0;
	
	  public Book(String name, float price, int numberOfCopies) {
		this.id = ++lastId;
		if(name!=null) {
			this.name=name;
		}
		if(price>0) {
			this.price = price;
		}
		if (numberOfCopies>=0) {
			this.numberOfCopies=numberOfCopies;
		}
	}
  

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNumberOfCopies() {
		return numberOfCopies;
	}

	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}


	public int getId() {
		return id;
	}


	
}
