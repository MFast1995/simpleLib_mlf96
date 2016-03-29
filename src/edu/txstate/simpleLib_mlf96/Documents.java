package edu.txstate.simpleLib_mlf96;

import java.io.Serializable;

//Super class for Books and Journals.
//For documents stored in or borrowed from library
public class Documents implements Serializable {

	//Default Constructor
    public Documents() {
    	title = "Document";
    	numberOfCopies = 0;
    }
    
    protected String title;			//title of document
    protected String authors;		//author of document
    protected String publisher;		//publisher of document
    protected String publishedDate;	//date of publication for document
    protected int numberOfCopies;	//number of copies in the library
    protected String location;		//location of document (either in library or with user)
}