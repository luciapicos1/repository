package com.mywork.app.mywork;

public class Book {
	private int id;
	private String name;
	private float publicPrice;//the price the public pays for the book
	private float privatePrice;//the price the bookshop pays for the book
	private int numberOfCopies;
	private static int lastId=0;
	
	  public Book(String name, float price, int numberOfCopies, float privatePrice) {
		this.id = ++lastId;
		if(name!=null) {
			this.name=name;
		}
		if(price>0) {
			this.publicPrice = price;
		}
		if (numberOfCopies>=0) {
			this.numberOfCopies=numberOfCopies;
		}
		if(privatePrice>0) {
			this.privatePrice=privatePrice;
		}
	}
  

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return publicPrice;
	}

	public void setPrice(float price) {
		this.publicPrice = price;
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

	 @Override
	    public boolean equals(Object obj) {
	      
	        if (this == obj) {
	            return true;
	        }

	        
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }

	        
	        Book otroLibro = (Book) obj;
	        return name.equals(otroLibro.name);
	    }


	public float getPrivatePrice() {
		return privatePrice;
	}


	public void setPrivatePrice(float privatePrice) {
		this.privatePrice = privatePrice;
	}

	
}
