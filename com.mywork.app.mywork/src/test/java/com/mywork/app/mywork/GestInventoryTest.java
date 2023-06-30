package com.mywork.app.mywork;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class GestInventoryTest {

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
	public void testBuyMoreCopiesOfABookThatIsInTheInventory() {
		BankAccount bank = new BankAccount(100);
		GestInventory invent= new GestInventory(bank);
		Book book = new Book("This book",20,3,10);
		invent.newBookInInventory(book);
		assertTrue(invent.addingMoreCopiesOfABook(book, 3));
		assertEquals(6, book.getNumberOfCopies());
		assertEquals((double)40, (double)bank.getBalance(), (double)0.01);
	}
	@Test
	public void testNumberOfCopiesIsNegative() {
		BankAccount bank = new BankAccount(100);
		GestInventory invent= new GestInventory(bank);
		Book book = new Book("This book",20,3,10);
		invent.newBookInInventory(book);
		assertEquals(false,invent.addingMoreCopiesOfABook(book, -1));
		assertEquals(false, invent.addingMoreCopiesOfABook(book, 0));
	}
	
	@Test
	public void testBuyMoreCopiesButBookIsNotInInventory() {
		BankAccount bank = new BankAccount(100);
		GestInventory invent= new GestInventory(bank);
		Book book = new Book("This book",20,3,10);
		assertEquals(false, invent.addingMoreCopiesOfABook(book, 2));
	}
	
	@Test
	public void testBuyMoreCopiesButNotEnoughMoney() {
		BankAccount bank = new BankAccount(40);
		GestInventory invent= new GestInventory(bank);
		Book book = new Book("This book",20,3,10);
		invent.newBookInInventory(book);
		assertTrue(bank.getBalance()<book.getPrivatePrice()*2);
		assertEquals(false,invent.addingMoreCopiesOfABook(book, 2));
		
	}
	
	@Test
	public void testBuyMoreCopiesWithJustEnoughMoney() {
		BankAccount bank = new BankAccount(40);
		GestInventory invent= new GestInventory(bank);
		Book book = new Book("This book",20,3,10);
		invent.newBookInInventory(book);
		assertTrue(invent.addingMoreCopiesOfABook(book, 1));
		assertEquals((double)0,(double)bank.getBalance(),(double)0.01);
	}
	
	@Test
	public void testRemoveBookFromInventory() {
		BankAccount bank = new BankAccount(100);
		GestInventory invent = new GestInventory(bank);
		Book book = new Book("A book",15,4,3);
		invent.newBookInInventory(book);
		assertEquals(true,invent.removeBookFromInventory(book));
		assertEquals(false,invent.getInventory().contains(book));
	}
	
	
	
	@Test
	public void testWhenSomeoneBuysTheTransactionGoesOK() {
		BankAccount bank = new BankAccount(100);
		GestInventory invent = new GestInventory(bank);
		Book book = new Book("A book",15,4,0);
		invent.newBookInInventory(book);
		assertEquals(true,invent.someoneBuysABook(book));
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
	
	@Test
	public void testSomeoneBuysABookThatIsNotInTheInventory() {
		BankAccount bank = mock(BankAccount.class);
		GestInventory invent = new GestInventory(bank);
		Book book = new Book("A book",15,1,4);
		assertEquals(false,invent.someoneBuysABook(book));
	}
	
	@Test
	public void testWhenBalanceIsTheSameAsThePriceOfTheBooksIsAllowed() {
		BankAccount bank = new BankAccount(10);
		GestInventory invent = new GestInventory(bank);
		Book book = new Book("A book",15,2,5);
		invent.newBookInInventory(book);
		assertEquals((double)0,(double)bank.getBalance(), (double)0.01);
	}
}
