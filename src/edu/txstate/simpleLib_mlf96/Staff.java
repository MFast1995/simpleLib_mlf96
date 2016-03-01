package edu.txstate.simpleLib_mlf96;

import java.util.ArrayList;

//Subclass of User for librarians
//with special access in program
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