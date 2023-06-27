package com.mywork.app.mywork;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AppTest {

	@Test
	public void testIdIsAutomaticallyAssignedAsPositiveNumber() {
		Book book = new Book(null, 0, 0);
		// verify
		assertTrue("ID is positive", book.getId() > 0);
	}

	@Test
	public void testIdsAreIncremental() {
		Book book1 = new Book(null, 0, 0);
		Book book2 = new Book(null, 0, 0);
		assertTrue("Ids should be incremental", book1.getId() < book2.getId());
	}

	@Test
	public void testWhenSomeoneBuysBookTheInventoryIsDecreased() {
		
	}
	
	@Test
	public void testNewBookInInventory() {
		GestInventory invent= new GestInventory(null, null);
		Book book = new Book("This book",20,3);
		assertEquals(true,invent.newBookInInventory(book));
	}
	
	@Test
	public void testRemoveBookFromInventory() {
		GestInventory invent = new GestInventory(null,null);
		Book book = new Book("A book",15,4);
		invent.newBookInInventory(book);
		assertEquals(true,invent.removeBookFromInventory(book));
	}
	
	@Test
	public void testWhenSomeoneBuysTheMoneyIncreases() {
		BankAccount bank = new BankAccount(100);
		GestInventory invent = new GestInventory(bank,null);
		Book book = new Book("A book",15,4);
		invent.newBookInInventory(book);
		invent.someoneBuysABook(book);
		assertEquals(115,invent.getBank().getBalance());
	}
	
}
