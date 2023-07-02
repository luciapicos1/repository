package com.mywork.app.mywork;

import java.util.ArrayList;

public interface GestView {
    BankAccount getBank();
    
    ArrayList<Book> getInventory();
    
    boolean newBookInInventory(Book newBook);
    
    boolean addingMoreCopiesOfABook(Book book, int copies);
    
    boolean removeBookFromInventory(Book book);
    
    boolean someoneBuysABook(Book book);
}
