package edu.txstate.simpleLib_mlf96;

import java.util.*;

/**
 * 
 */
public class User {

    //Default Constructor
    public User() {
    	
    }
    
    public User(String nameUser, int userID, String type)
    {
    	name = nameUser;
    	accountNumber = userID;
    	accountType = type;
    }

    protected String name;
    protected int accountNumber;
    protected String accountType;
    protected int maxBookLimit;
    protected Double fines;
    protected ArrayList<Documents> documentsCheckedOut;
    protected int shortLoanPeriod = 3;
    protected int longLoanPeriod;

    //
    public void updateInfo() {
        // TODO implement here
    }

    //
    public void extendLoan() {
        // TODO implement here
    }
}