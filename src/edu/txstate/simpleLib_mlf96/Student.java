package edu.txstate.simpleLib_mlf96;

import java.util.ArrayList;

//Subclass of User with minimum 
//privleges and limits.
public class Student extends User {
	
	public Student(String nameUser, int userID)
    {
    	name = nameUser;
    	accountNumber = userID;
    	accountType = "student";
    	maxBookLimit = 6;
    	longLoanPeriod = 182;
    	documentsCheckedOut = new ArrayList<Documents>();
    }	
}