package edu.txstate.simpleLib_mlf96;

//subclass of Documents for Books. 
//Has new attribute ISBN
public class Books extends Documents {
    
    public Books(String bookTitle, String bookPublisher, String publishDate, 
    		String bookISBN, int copies, String bookAuthor, String bookLocation)
    {
    	title = bookTitle;
    	publisher = bookPublisher;
    	publishedDate = publishDate;
    	ISBN = bookISBN;
    	numberOfCopies = copies;
    	authors = bookAuthor;
    	location = bookLocation;
    }

    public String ISBN; //ISBN of book
}