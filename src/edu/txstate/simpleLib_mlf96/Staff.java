package edu.txstate.simpleLib_mlf96;

//
public class Staff extends User {
    
    public Staff(String nameUser, int userID)
    {
    	name = nameUser;
    	accountNumber = userID;
    	accountType = "librarian";
    	maxBookLimit = 12;
    }
}