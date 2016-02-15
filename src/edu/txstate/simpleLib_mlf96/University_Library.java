package edu.txstate.simpleLib_mlf96;

import java.util.*;

/**
 * 
 */
public class University_Library {

    /**
     * Default constructor
     */
    public University_Library() {
    }

    /**
     * 
     */
    public double Hours;

    /**
     * 
     */
    public int Employees;

    /**
     * 
     */
    public String Location;



    /**
     * 
     */
    public void Registration() {
        // TODO implement here
    }

    /**
     * 
     */
    public void Payment() {
        // TODO implement here
    }

    /**
     * 
     */
    public void IssueDocument() {
        // TODO implement here
    }

    /**
     * 
     */
    public void OverdueReminder() {
    	
        // TODO implement here
    }

    /**
     * @param User
     */
    public boolean IsRegisted(User user) {
    	//TODO: Search through registered users 
        if(user.AccountNumber != 0)
        	return true;
        else
        	return false;
    }
    
    public static void main (String [] args){
    	System.out.println("Hello World! :D");
    }

}