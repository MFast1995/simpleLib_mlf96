package edu.txstate.simpleLib_mlf96;

//
public class Student extends User {
	
	public Student(String nameUser, int userID)
    {
    	name = nameUser;
    	accountNumber = userID;
    	accountType = "student";
    	maxBookLimit = 6;
    }	
}