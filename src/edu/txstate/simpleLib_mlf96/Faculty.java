package edu.txstate.simpleLib_mlf96;

import java.util.*;

/**
 * 
 */
public class Faculty extends User{

    /**
     * Default constructor
     */
    public Faculty() {
    }
    
    public Faculty(String nameUser, int userID, String type)
    {
    	name = nameUser;
    	accountNumber = userID;
    	accountType = type;
    	maxBookLimit = 12;
    }
}