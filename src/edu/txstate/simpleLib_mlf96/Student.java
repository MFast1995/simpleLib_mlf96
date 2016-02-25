package edu.txstate.simpleLib_mlf96;

public class Student extends User {

	public Student()
	{
		
	}
	
	public Student(String nameUser, int userID, String type)
    {
    	name = nameUser;
    	accountNumber = userID;
    	accountType = type;
    	maxBookLimit = 6;
    }	
}