package edu.txstate.simpleLib_mlf96;

import java.util.*;

/**
 * 
 */
public class User {

    /**
     * Default constructor
     */
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
    private Double fines;
    private ArrayList<Documents> documentsCheckedOut;
    private int shortLoanPeriod;
    private int longLoanPeriod;

    /**
     * 
     */
    public void updateInfo() {
        // TODO implement here
    }

    /**
     * 
     */
    public void checkOut() {
        // TODO implement here
    }

    /**
     * 
     */
    public void extendLoan() {
        // TODO implement here
    }
}