package edu.txstate.simpleLib_mlf96;

import java.util.ArrayList;

//
public class Faculty extends User{
	
    public Faculty(String nameUser, int userID)
    {
    	name = nameUser;
    	accountNumber = userID;
    	accountType = "faculty";
    	maxBookLimit = 12;
    	longLoanPeriod = 365;
    	documentsCheckedOut = new ArrayList<Documents>();
    }
}