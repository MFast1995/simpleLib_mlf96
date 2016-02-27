package edu.txstate.simpleLib_mlf96;

//
public class Faculty extends User{
	
    public Faculty(String nameUser, int userID)
    {
    	name = nameUser;
    	accountNumber = userID;
    	accountType = "faculty";
    	maxBookLimit = 12;
    }
}