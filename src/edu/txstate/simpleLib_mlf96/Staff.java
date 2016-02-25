package edu.txstate.simpleLib_mlf96;

import java.util.*;

/**
 * 
 */
public class Staff extends User {

    /**
     * Default constructor
     */
    public Staff() {
    }
    
    public Staff(String nameUser, int userID, String type)
    {
    	name = nameUser;
    	accountNumber = userID;
    	accountType = type;
    	maxBookLimit = 12;
    }

}