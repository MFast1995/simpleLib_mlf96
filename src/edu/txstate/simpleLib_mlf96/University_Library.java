package edu.txstate.simpleLib_mlf96;
import java.util.*;

/* This class contains the main portion of the program.
 * University Library is a system to allow users to search, borrow, and return various
 * documents including books and journals
 */
public class University_Library {

    //Default constructor
    public University_Library() {
    	
    }

    static ArrayList<Documents> documents;
    

    /**
     * 
     */
    public void registration(User name) {
        
    }

    /**
     * 
     */
    public void payment() {
        // TODO implement here
    }

    /**
     * 
     */
    public void issueDocument() {
        // TODO implement here
    }

    /**
     * 
     */
    public void overdueReminder() {
    	
        // TODO implement here
    }

    /**
     * @param User
     */
    public boolean isRegisted(User user) {
    	//TODO: Search through registered users 
    	return true;
    }
    
    public static void main (String [] args){
    	Scanner sn = new Scanner(System.in); //initialize Scanner
    	//Initialize documents in library
    	documents = new ArrayList<Documents>();
    	//Initialize users
    	
    	int userType = 0;
    	System.out.println("Welcome to the University Library");
    	System.out.print("Are you: \n"
    						+ "\t[1] Student\n"
    						+ "\t[2] Faculty\n"
    						+ "\t[3] Librarian\n"
    						+ "Input Here: ");
    	int i = sn.nextInt(); //receive input from user
    	switch(i){
    		case 1: 
    			userType = 1;
    			break;
    		case 2: 
    			userType = 2;
    			break;
    		case 3: 
    			userType = 3;
    			break;
    		default: 
    			System.out.println("Please input valid input");
    			break;
    	}
    	
    	System.out.println(userType);
    	sn.close();
    }
}