package edu.txstate.simpleLib_mlf96;

import java.util.ArrayList;

//
public class Staff extends User {
    
    public Staff(String nameUser, int userID)
    {
    	name = nameUser;
    	accountNumber = userID;
    	accountType = "librarian";
    	maxBookLimit = 12;
    	longLoanPeriod = 365;
    	documentsCheckedOut = new ArrayList<Documents>();
    }
}