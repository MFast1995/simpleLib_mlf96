package edu.txstate.simpleLib_mlf96;
import java.util.*;
import java.io.*;

/* This class contains the main portion of the program.
 * University Library is a system to allow users to search, borrow, and return various
 * documents including books and journals
 */
public class University_Library {
    static ArrayList<Documents> documents;
    static ArrayList<User> users;

    //Function is called when the program is started
    //Initializes all users stored in user file
    static void initializeUsers()
    {
    	users = new ArrayList<User>();
    	String userFile = "input/users.txt";
    	
    	try
    	{
    		FileReader fileReader = new FileReader(userFile);
    		BufferedReader bufferedReader = new BufferedReader(fileReader);
    		String name = "";
    		int userID = 0;
    		String type = "";
    		while((name = bufferedReader.readLine()) != null)
    		{
    			userID = Integer.parseInt(bufferedReader.readLine());
    			type = bufferedReader.readLine();
    			bufferedReader.readLine();
    			if(type == "librarian")
    				users.add(new Staff(name, userID, type));
    			else if(type == "faculty")
    				users.add(new Faculty(name, userID, type));
    			else
    				users.add(new Student(name, userID, type));
    		}
    		bufferedReader.close();
    	}
    	catch(FileNotFoundException ex)
    	{
    		System.out.println("Cannot open user file: " + ex);
    	}
    	catch(IOException ex)
    	{
    		System.out.println(ex);
    	}
    }
    
    //Function is called when the program is started
    //Initializes all documents stored in various document files 
    //(such as books and journals)
    static void initializeDocuments()
    {
    	documents = new ArrayList<Documents>();
    	String bookFile = "input/books.txt";
    	String journalFile = "input/journals.txt";
    	
    	try
    	{	
    		FileReader fileReader = new FileReader(bookFile);
    		BufferedReader bufferedReader = new BufferedReader(fileReader);
    		String bookTitle = "";
    		String bookPublisher = "";
    		String bookPublishDate = "";
    		String ISBN = "";
    		int copiesAvailable = 0;
    		String bookAuthor = "";
    		
    		while((bookTitle = bufferedReader.readLine()) != null)
    		{
    			bookPublisher = bufferedReader.readLine();
    			bookPublishDate = bufferedReader.readLine();
    			ISBN = bufferedReader.readLine();
    			copiesAvailable = Integer.parseInt(bufferedReader.readLine());
    			bookAuthor = bufferedReader.readLine();
    			bufferedReader.readLine();
    			documents.add(new Books(bookTitle, bookPublisher, bookPublishDate, ISBN,
    					copiesAvailable, bookAuthor));
    		}
    		bufferedReader.close();
    		
    		fileReader = new FileReader(journalFile);
    		bufferedReader = new BufferedReader(fileReader);
    		String journalTitle = "";
    		String journalPublishDate = "";
    		int journalVolume = 0;
    		int journalIssue = 0;
    		String journalPublisher = "";
    		String journalArticles = "";
    		
    		while((journalTitle = bufferedReader.readLine()) != null)
    		{
    			journalPublishDate = bufferedReader.readLine();
    			journalVolume = Integer.parseInt(bufferedReader.readLine());
    			journalIssue = Integer.parseInt(bufferedReader.readLine());
    			journalPublisher = bufferedReader.readLine();
    			journalArticles = bufferedReader.readLine();
    			bufferedReader.readLine();
    			documents.add(new Journals(journalTitle, journalPublishDate, journalVolume,
    					journalIssue, journalPublisher, journalArticles));
    		}
    		bufferedReader.close();
    	}
    	catch(FileNotFoundException ex)
    	{
    		System.out.println("Can't open documents file: " + ex);
    	}
    	catch(IOException ex)
    	{
    		System.out.println(ex);
    	}
    }
    
    /**
     * 
     */
    public void registration(String name, String type) {
    	
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
     * @param User
     */
    public boolean isRegistered(User user) {
    	//TODO: Search through registered users 
    	return true;
    }
    
    public static void main (String [] args){
    	documents = new ArrayList<Documents>();
    	System.out.println("Initializing Library...");
    	System.out.println("Importing users...");
    	initializeUsers();
    	System.out.println("Importing documents...");
    	initializeDocuments();
    	System.out.println("Complete!\n\n");
    	
    	Scanner sn = new Scanner(System.in); //initialize Scanner
    	//Initialize users
    	
    	int userInput = 0;
    	System.out.println("Welcome to the University Library");
    	System.out.print("Are you: \n"
    						+ "\t[1] Student\n"
    						+ "\t[2] Faculty\n"
    						+ "\t[3] Librarian\n"
    						+ "Input Here: ");
    	int i = sn.nextInt(); //receive input from user
    	switch(i){
    		case 1: 
    			userInput = 1;
    			break;
    		case 2: 
    			userInput = 2;
    			break;
    		case 3: 
    			userInput = 3;
    			break;
    		default: 
    			System.out.println("Please input valid input");
    			break;
    	}   	
  	
    	sn.close();
    }
}