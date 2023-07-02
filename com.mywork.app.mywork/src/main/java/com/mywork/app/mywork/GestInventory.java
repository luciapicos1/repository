package com.mywork.app.mywork;

import java.util.ArrayList;

public class GestInventory implements GestView{
	private BankAccount bank;
	private ArrayList<Book> inventory;

	public GestInventory(BankAccount bank) {
		this.bank = bank;
		this.inventory = new ArrayList<Book>();

	}

	public BankAccount getBank() {
		return bank;
	}

	public ArrayList<Book> getInventory() {
		return inventory;
	}

	public Boolean newBookInInventory(Book newBook) {
		if (bank.getBalance() < newBook.getNumberOfCopies() * newBook.getPrivatePrice()) {
			return false;
		} else {
			inventory.add(newBook);
			bank.payMoney(newBook.getNumberOfCopies() * newBook.getPrivatePrice());
			return true;
		}
	}
	
	 
	public Boolean addingMoreCopiesOfABook(Book book, int copies) {
		if (copies > 0) {
			if (bank.getBalance() >= book.getPrivatePrice() * copies) {
				if (inventory.contains(book)) {
					book.setNumberOfCopies(book.getNumberOfCopies() + copies);
					bank.payMoney(book.getPrivatePrice() * copies);
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}

		} else {
			return false;
		}
		
	}

	public Object removeBookFromInventory(Book book) {
		if (!inventory.contains(book)) {
			return false;
		} else {
			inventory.remove(book);
			return true;
		}
	}

	public boolean someoneBuysABook(Book book) {
		if (inventory.contains(book)) {
			bank.makeMoney(book.getPrice());
			book.setNumberOfCopies(book.getNumberOfCopies() - 1);
			if (book.getNumberOfCopies() == 0) {
				inventory.remove(book);
			}
			return true;
		} else {
			return false;
		}
	}
}
