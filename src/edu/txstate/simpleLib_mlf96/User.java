package edu.txstate.simpleLib_mlf96;

import java.util.ArrayList;

/**
 * 
 */
public class User {

    //Default Constructor
    public User() {
    	name = "John Smith";
    	accountNumber = -1;
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

    protected String name;
    protected int accountNumber;
    protected String accountType;
    protected int maxBookLimit;
    protected ArrayList<Documents> documentsCheckedOut;
    protected int shortLoanPeriod = 3;
    protected int longLoanPeriod;

    //
    public void updateInfo(String nameUpdate) {
        name = nameUpdate;
    }
}