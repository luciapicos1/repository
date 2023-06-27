package com.mywork.app.mywork;

import java.util.ArrayList;

public class GestInventory {
	private BankAccount bank;
	private ArrayList<Book> inventory;

	public GestInventory(BankAccount bank, ArrayList<Book> inventory) {
		this.bank = bank;
		if (inventory != null) {
			this.inventory = inventory;
		} else {
			this.inventory = new ArrayList<Book>();
		}

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
		if (inventory.contains(newBook)) {
			return true;
		}
		return false;
	}

	public Object removeBookFromInventory(Book book) {
		inventory.remove(book);
		if (inventory.contains(book)) {
			return false;
		}
		return true;
	}

	public void someoneBuysABook(Book book) {
		// pasos : aumenta el dinero del banco, decrece el numero de copias, si pasa a 0
		// copias se elimina
		// chequear si tenemos el libro en inventario
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
