package com.mywork.app.mywork;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class AppTest {

	@Test
	public void testIdIsAutomaticallyAssignedAsPositiveNumber() {
		Book book = new Book(null, 0, 0,4);
		// verify
		assertTrue("ID is positive", book.getId() > 0);
	}

	@Test
	public void testIdsAreIncremental() {
		Book book1 = new Book(null, 0, 0,0);
		Book book2 = new Book(null, 0, 0,0);
		assertTrue("Ids should be incremental", book1.getId() < book2.getId());
	}

	
	
	@Test
	public void testNewBookInInventory() {
		BankAccount bank = new BankAccount(100);
		GestInventory invent= new GestInventory(bank);
		Book book = new Book("This book",20,3,3);
		assertEquals(true,invent.newBookInInventory(book));
	}
	
	@Test 
	public void testNewBooksPaidWithMoneyFromTheAccount() {
		BankAccount bank = new BankAccount(100);
		GestInventory invent= new GestInventory(bank);
		Book book = new Book("This book",20,3,10);
		invent.newBookInInventory(book);
		assertEquals((double)70,(double)bank.getBalance(),(double)0.01);
	}
	
	@Test
	public void testNotEnoughMoneyToGetMoreInventory() {
		BankAccount bank = new BankAccount(10);
		GestInventory invent= new GestInventory(bank);
		Book book = new Book("This book",20,3,10);
		assertFalse(invent.newBookInInventory(book));
		
	}
	
	
	@Test
	public void testRemoveBookFromInventory() {
		BankAccount bank = new BankAccount(100);
		GestInventory invent = new GestInventory(bank);
		Book book = new Book("A book",15,4,3);
		invent.newBookInInventory(book);
		invent.removeBookFromInventory(book);
		assertEquals(false,invent.getInventory().contains(book));
	}
	
	@Test
	public void testWhenSomeoneBuysTheMoneyIncreases() {
		BankAccount bank = new BankAccount(100);
		GestInventory invent = new GestInventory(bank);
		Book book = new Book("A book",15,4,0);
		invent.newBookInInventory(book);
		invent.someoneBuysABook(book);
		assertEquals((double)115.0,(double)invent.getBank().getBalance(),(double)0.01);
	}
	
	@Test
	public void testWhenSomeoneBuysThereIsACopyLessInInventory() {
		BankAccount bank = new BankAccount(100);
		GestInventory invent = new GestInventory(bank);
		Book book = new Book("A book",15,4,4);
		invent.newBookInInventory(book);
		invent.someoneBuysABook(book);
		assertEquals(3,book.getNumberOfCopies());
	}
	
	@Test
	public void testWhenThereAre0CopiesBookGetDeletedOfInventory() {
		BankAccount bank = new BankAccount(100);
		GestInventory invent = new GestInventory(bank);
		Book book = new Book("A book",15,1,4);
		invent.newBookInInventory(book);
		invent.someoneBuysABook(book);
		assertEquals(false,invent.getInventory().contains(book));
	}
	


	@Test
	public void testWhenYouTryToRemoveBookButTheBookIsNotOnTheInventory() {
		BankAccount bank = mock(BankAccount.class);
		GestInventory invent = new GestInventory(bank);
		Book book = new Book("A book",15,1,4);
		assertEquals(false,invent.removeBookFromInventory(book));
	}
}
