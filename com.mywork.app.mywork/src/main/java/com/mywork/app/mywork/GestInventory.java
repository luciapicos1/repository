package com.mywork.app.mywork;

import java.util.ArrayList;

public class GestInventory {
	private BankAccount bank;
	private ArrayList<Book> inventory;

	public GestInventory(BankAccount bank) {
		this.bank = bank;
		this.inventory = new ArrayList<Book>();
		

	}

	public BankAccount getBank() {
		return bank;
	}

	public ArrayList<Book> getInventory(){
		return inventory;
	}

	public Boolean newBookInInventory(Book newBook) {
		if(bank.getBalance()<newBook.getNumberOfCopies()*newBook.getPrivatePrice()) {
			return false;
		}
		inventory.add(newBook);
		bank.payMoney(newBook.getNumberOfCopies()*newBook.getPrivatePrice());
		return true;

	}

	public Object removeBookFromInventory(Book book) {
		if (!inventory.contains(book)) {
			return false;
		}else {
			inventory.remove(book);
			return true;
		}
	}

	public void someoneBuysABook(Book book) {
				if (inventory.contains(book)) {
			bank.makeMoney(book.getPrice());
			for (Book theBook : inventory) {
				if (book.equals(theBook)) {
					theBook.setNumberOfCopies(theBook.getNumberOfCopies() - 1);	
				}
			}
			if(book.getNumberOfCopies()==0) {
				inventory.remove(book);
			}
		}
	}
}
