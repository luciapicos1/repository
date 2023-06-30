package com.mywork.app.mywork;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class InventorySystemIT {
	@Test
	public void testInventorySystem() {
		BankAccount bank = new BankAccount(100);
		GestInventory inventory = new GestInventory(bank);
		
		Book book1 = new Book("Book 1", 20, 3, 10);
		Book book2 = new Book("Book 2", 15, 5, 8);
		Book book3 = new Book("Book 3", 10, 2, 6);
		
		assertTrue(inventory.newBookInInventory(book1));//100-30=70
		assertTrue(inventory.newBookInInventory(book2));//70-(8*5)=30
		assertTrue(inventory.newBookInInventory(book3));//30-12=18
		assertEquals(18,(double)bank.getBalance(),0.01);
		
		ArrayList<Book> inventoryList = inventory.getInventory();
		assertTrue(inventoryList.contains(book1));
		assertTrue(inventoryList.contains(book2));
		assertTrue(inventoryList.contains(book3));
		
		//Buy a book
		assertTrue(inventory.someoneBuysABook(book1));//18+20
		assertEquals(38,(double)bank.getBalance(),0.01);
		assertEquals(2, book1.getNumberOfCopies());
		
		//Try to buy a book that is not in the inventory
		Book book4 = new Book("Book 4", 25,1,12);
		assertFalse(inventory.someoneBuysABook(book4));
		
		//buy more copies of a book
		assertTrue(inventory.addingMoreCopiesOfABook(book2, 2));//38-16=22
		assertEquals(7, book2.getNumberOfCopies());
		
		//adding more copies of a book that is not in the inventory
		Book book5 = new Book("Book 5",30,2,15);
		assertFalse(inventory.addingMoreCopiesOfABook(book5,2));
		
		assertFalse(inventory.addingMoreCopiesOfABook(book3,-1));
		
		//Remove a book
		assertEquals(true,inventory.removeBookFromInventory(book3));
		assertFalse(inventoryList.contains(book3));
	}
}
