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
    	accountNumber = 0;
    }

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private int accountNumber;

    /**
     * 
     */
    private String accountType;

    /**
     * 
     */
    private int maxBookLimit;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private Double fines;

    /**
     * 
     */
    private ArrayList<Documents> documentsCheckedOut;

    /**
     * 
     */
    private int shortLoanPeriod;

    /**
     * 
     */
    private int longLoanPeriod;



    /**
     * 
     */
    public void payFine() {
        // TODO implement here
    }

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

    /**
     * 
     */
    public void overdueReminder() {
        // TODO implement here
    }

}