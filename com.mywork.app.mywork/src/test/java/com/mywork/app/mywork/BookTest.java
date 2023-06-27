package com.mywork.app.mywork;

import static org.junit.Assert.*;


import org.junit.Test;

public class BookTest {

	@Test
	public void testIdIsAutomaticallyAssignedAsPositiveNumber() {
		Book book = new Book(null,0,0,4);
		//verify
		assertTrue("ID is positive",book.getId()>0);
	}

}
