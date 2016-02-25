package edu.txstate.simpleLib_mlf96;

import java.util.*;

/**
 * 
 */
public class Books extends Documents {

    /**
     * Default constructor
     */
    public Books() {
    }
    
    public Books(String bookTitle, String bookPublisher, String publishDate, 
    		String bookISBN, int copies, String bookAuthor)
    {
    	title = bookTitle;
    	publisher = bookPublisher;
    	publishedDate = publishDate;
    	ISBN = bookISBN;
    	numberOfCopies = copies;
    	authors = bookAuthor;
    }

    /**
     * 
     */
    public String ISBN;

    /**
     * 
     */
    public int pages;

}