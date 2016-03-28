package edu.txstate.simpleLib_mlf96;

import java.util.ArrayList;

//Superclass for Staff, Faculty, and Student class.
public class User {

    //Default Constructor
    public User() {
    	accountType = "none";
    	documentsCheckedOut = new ArrayList<Documents>();
    }
    
    public User(String nameUser, int userID, String type)
    {
    	name = nameUser;
    	accountNumber = userID;
    	accountType = type;
    	documentsCheckedOut = new ArrayList<Documents>();
    }

    protected String name;				//name of user
    protected int accountNumber;		//accountID for user
    protected String accountType;		//account type of use (Librarian, Student, or Faculty)
    protected int maxBookLimit;			//maximum books the user of account can borrow
    protected ArrayList<Documents> documentsCheckedOut;	//list of documents the user is currently borrowing
    protected int shortLoanPeriod = 3;	//period of time the user can borrow journals
    protected int longLoanPeriod;		//period of time the user can borrow most documents

    //function to allow user to change name on account
    //public void updateInfo(String nameUpdate) {
    //    name = nameUpdate;
    //}
}