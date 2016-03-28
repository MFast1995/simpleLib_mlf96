package edu.txstate.simpleLib_mlf96;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

// This class contains the main portion of the program.
// University Library is a system to allow users to search, borrow, and return various
// documents, including books and journals.
public class University_Library {
	protected static ArrayList<Documents> documents; //an array list of all documents of the library
	protected static ArrayList<User> users; //an array list of all registered users
	private static String libraryData = "input/LibData.txt"; 	//file to contain all library data
	
	private static void initializeLibrary()
	{
		users = new ArrayList<User>();
		documents = new ArrayList<Documents>();
		
		try {
			FileReader fileReader = new FileReader(libraryData);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			User activeUser;
			String dataType = "", name = "", type = "", documentType, title,
					publisher, publishDate, ISBN, authors, articles, location;
			int userID = 0, documentsCheckedOut = 0, issue, volume, copiesAvailable;
			
			while ((dataType = bufferedReader.readLine()) != null) {
				if(dataType.equals("User"))
				{
					name = bufferedReader.readLine();
					userID = Integer.parseInt(bufferedReader.readLine());
					type = bufferedReader.readLine();
					if (type.equals("librarian"))
						activeUser = new Staff(name, userID);
					else if (type.equals("faculty"))
						activeUser = new Faculty(name, userID);
					else
						activeUser = new Student(name, userID);
					users.add(activeUser);
					documentsCheckedOut = Integer.parseInt(bufferedReader.readLine());
					for(int x = 0; x < documentsCheckedOut; x++)
					{
						documentType = bufferedReader.readLine();
						if(documentType.equals("Books"))
						{
							title = bufferedReader.readLine();
							publisher = bufferedReader.readLine();
							publishDate = bufferedReader.readLine();
							ISBN = bufferedReader.readLine();
							authors = bufferedReader.readLine();
							activeUser.documentsCheckedOut.add(new Books(title, publisher, publishDate, ISBN, 1, authors, name));
						}
						else
						{
							title = bufferedReader.readLine();
							publishDate = bufferedReader.readLine();
							volume = Integer.parseInt(bufferedReader.readLine());
							issue = Integer.parseInt(bufferedReader.readLine());
							publisher = bufferedReader.readLine();
							articles = bufferedReader.readLine();
							activeUser.documentsCheckedOut.add(new Journals(title, publishDate, volume, issue, publisher, articles, 1, name));
						}
					}
					bufferedReader.readLine();	
				}
				else if(dataType.equals("Books"))
				{
					title = bufferedReader.readLine();
					publisher = bufferedReader.readLine();
					publishDate = bufferedReader.readLine();
					ISBN = bufferedReader.readLine();
					copiesAvailable = Integer.parseInt(bufferedReader.readLine());
					authors = bufferedReader.readLine();
					location = bufferedReader.readLine();
					bufferedReader.readLine();
					documents.add(new Books(title, publisher, publishDate, 
							ISBN, copiesAvailable, authors, location));
				}
				else if(dataType.equals("Journals"))
				{
					title = bufferedReader.readLine();
					publishDate = bufferedReader.readLine();
					volume = Integer.parseInt(bufferedReader.readLine());
					issue = Integer.parseInt(bufferedReader.readLine());
					publisher = bufferedReader.readLine();
					articles = bufferedReader.readLine();
					copiesAvailable = Integer.parseInt(bufferedReader.readLine());
					location = bufferedReader.readLine();
					bufferedReader.readLine();
					documents.add(new Journals(title, publishDate, volume, issue,
							publisher, articles, copiesAvailable, location));
				}
				else
					System.err.println("help"); //for debugging uses
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Cannot open user file: " + ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}
	
	private static void saveLibData()
	{
		try{
			PrintWriter write = new PrintWriter(libraryData);
			for(User user : users)
			{
				write.write("User\n");
				write.write(user.name + "\n");
				write.write(user.accountNumber + "\n");
				write.write(user.accountType + "\n");
				write.write(user.documentsCheckedOut.size() + "\n");
				for(Documents document : user.documentsCheckedOut)
				{	
					if(document instanceof Books)
					{
						write.write("Books\n");
						write.write(document.title + "\n");
						write.write(document.publisher + "\n");
						write.write(document.publishedDate + "\n");
						write.write(((Books)document).ISBN + "\n");
						write.write(document.authors + "\n");
					}
					else if(document instanceof Journals)
					{
						write.write("Journals\n");
						write.write(document.title + "\n");
						write.write(document.publishedDate + "\n");
						write.write(((Journals)document).volume + "\n");
						write.write(((Journals)document).issueNumber + "\n");
						write.write(document.publisher + "\n");
						write.write(((Journals)document).articles + "\n");
					}
					else
						System.out.println("Error saving: " + document.title + "\nWill not be saved\n");
				}
				write.write("\n");
			}
			for(Documents document : documents)
			{	
				if(document instanceof Books)
				{
					write.write("Books\n");
					write.write(document.title + "\n");
					write.write(document.publisher + "\n");
					write.write(document.publishedDate + "\n");
					write.write(((Books)document).ISBN + "\n");
					write.write(document.numberOfCopies + "\n");
					write.write(document.authors + "\n");
					write.write(document.location + "\n\n");
				}
				else if(document instanceof Journals)
				{
					write.write("Journals\n");
					write.write(document.title + "\n");
					write.write(document.publishedDate + "\n");
					write.write(((Journals)document).volume + "\n");
					write.write(((Journals)document).issueNumber + "\n");
					write.write(document.publisher + "\n");
					write.write(((Journals)document).articles + "\n");
					write.write(document.numberOfCopies + "\n");
					write.write(document.location + "\n\n");
				}
				else
					System.out.println("Error saving: " + document.title + "\nIt will not be saved\n");
			}
			write.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Can't open documents file: " + ex);
		}
	}
	

	
	// Function to search through User ArrayList to find target User
	// Returns found User or null
	// accountID: specifies ID of desired User
	// accountType: specifies type of account to find
	protected User searchUser(int accountID, String accountType) {
		User activeUser = null;
		for (User user : users)
			if (user.accountNumber == accountID && user.accountType.equals(accountType))
				activeUser = user;
		return activeUser;
	}

    //Function to search and display all users in ArrayList.
    //Doesn't return anything.
    protected void listUsers(){
        for (User user : users) {
            System.out.println("[" + user.accountNumber + "] " + user.name);
        }
    }
	
	// Function to register user and add to users ArrayList
	// name: name of new user
	// type: type of account to be created
	protected int registration(String name, String type) {
		int accountID = users.size() + 1;
		if (type.equals("faculty"))
			users.add(new Faculty(name, accountID));
		else if (type.equals("librarian"))
			users.add(new Staff(name, accountID));
		else
			users.add(new Student(name, accountID));
		return accountID;
	}
	
	//function to search documents ArrayList by Author
	protected int searchAuthor(String query)
	{
		for (Documents document : documents)
			if(document.authors.equals(query))
				return documents.indexOf(document); 
		return -1;
	}
	
	//function to search documents ArrayList by Title
	protected int searchTitle(String query)
	{
		for(Documents document : documents)
			if(document.title.equals(query))
				return documents.indexOf(document);
		return -1;
	}
	
	//function to search documents list by Publisher
	protected int searchPublisher(String query)
	{	
		for(Documents document : documents)
			if(document.publisher.equals(query))
				return documents.indexOf(document);
		return -1;
	}
	
	//function to allow user to borrow specified document
	protected boolean issueDocument(User user, int documentIndex) {
		int booksCheckedOut = user.documentsCheckedOut.size();
		if(documents.get(documentIndex).numberOfCopies > 0 && booksCheckedOut < user.maxBookLimit)
		{
			if(documents.get(documentIndex) instanceof Books)
			{
				Books checkOut = new Books(documents.get(documentIndex).title, documents.get(documentIndex).publisher, 
						documents.get(documentIndex).publishedDate, ((Books) documents.get(documentIndex)).ISBN, 
						1, documents.get(documentIndex).authors, user.name);
				user.documentsCheckedOut.add(checkOut);
				documents.get(documentIndex).numberOfCopies--;
				return true;
			}
			else if(documents.get(documentIndex) instanceof Journals)
			{
				Journals checkOut = new Journals(documents.get(documentIndex).title, documents.get(documentIndex).publishedDate, 
						((Journals) documents.get(documentIndex)).volume, ((Journals) documents.get(documentIndex)).issueNumber,
						documents.get(documentIndex).publisher, ((Journals) documents.get(documentIndex)).articles, 1, user.name);
				user.documentsCheckedOut.add(checkOut);
				documents.get(documentIndex).numberOfCopies--;
				return true;
			}
		}
		return false;
	}

	//function to allow user to return specified document
	protected boolean returnDocument(User user, int documentIndex){						
		for(Documents document : documents)
			if(document.title.equals(user.documentsCheckedOut.get(documentIndex).title))
			{
				document.numberOfCopies += 1;
				user.documentsCheckedOut.remove(documentIndex);
				return true;
			}
		return false;
	}

	//Main function of program. Includes main page of program and routes users
	//based on specified account type
	public static void main(String[] args) {		
		initializeLibrary();
		System.out.println("Welcome to the University Library");
		
		MainMenuConsoleWindow mainMenu = new MainMenuConsoleWindow();
		mainMenu.start();

		saveLibData();
		System.out.println("\nGood-Bye!");
	}
}