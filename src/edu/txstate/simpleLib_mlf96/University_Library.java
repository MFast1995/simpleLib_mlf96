package edu.txstate.simpleLib_mlf96;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

// This class contains the main portion of the program.
// University Library is a system to allow users to search, borrow, and return various
// documents including books and journals
public class University_Library {
	private static ArrayList<Documents> documents; //an array list of all documents of the library
	private static ArrayList<User> users; //an array list of all registered users
	private static String userFile = "input/users.txt"; //file containing users for saving
	private static String bookFile = "input/books.txt"; //file containing books for saving
	private static String journalFile = "input/journals.txt"; //file contains journals for saving
	private static Scanner sn; //Scanner declaration for accepting user input

	// Function is called when the program is started
	// Initializes all users stored in user file
	private static void initializeUsers() {
		users = new ArrayList<User>();

		try {
			FileReader fileReader = new FileReader(userFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String name = "";
			int userID = 0;
			String type = "";
			while ((name = bufferedReader.readLine()) != null) {
				userID = Integer.parseInt(bufferedReader.readLine());
				type = bufferedReader.readLine();
				bufferedReader.readLine();
				
				if (type.equals("librarian"))
					users.add(new Staff(name, userID));
				else if (type.equals("faculty"))
					users.add(new Faculty(name, userID));
				else
					users.add(new Student(name, userID));
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Cannot open user file: " + ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}
	
	//Upon closing the program, saves the user to respective file
	//in proper format for future initialization
	private static void saveUsers(){
		try{
			PrintWriter write = new PrintWriter(userFile);
			for(User user : users)
			{
				write.write(user.name + "\n");
				write.write(user.accountNumber + "\n");
				write.write(user.accountType + "\n\n");
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
	private static User searchUser(int accountID, String accountType) {
		User activeUser = null;
		for (User user : users)
			if (user.accountNumber == accountID && user.accountType.equals(accountType))
				activeUser = user;
		return activeUser;
	}
	
	// Function to register user and add to users ArrayList
	// name: name of new user
	// type: type of account to be created
	private static int registration(String name, String type) {
		int accountID = users.size() + 1;
		if (type.equals("faculty"))
			users.add(new Faculty(name, accountID));
		else if (type.equals("librarian"))
			users.add(new Staff(name, accountID));
		else
			users.add(new Student(name, accountID));
		return accountID;
	}
	
	// Function is called when the program is started
	// Initializes all documents stored in various document files
	// (such as books and journals)
	private static void initializeDocuments() {
		documents = new ArrayList<Documents>();

		try {
			FileReader fileReader = new FileReader(bookFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String bookTitle = "";
			String bookPublisher = "";
			String bookPublishDate = "";
			String ISBN = "";
			int copiesAvailable = 0;
			String bookAuthor = "";
			String bookLocation = "";

			while ((bookTitle = bufferedReader.readLine()) != null) {
				bookPublisher = bufferedReader.readLine();
				bookPublishDate = bufferedReader.readLine();
				ISBN = bufferedReader.readLine();
				copiesAvailable = Integer.parseInt(bufferedReader.readLine());
				bookAuthor = bufferedReader.readLine();
				bookLocation = bufferedReader.readLine();
				bufferedReader.readLine();
				documents.add(new Books(bookTitle, bookPublisher, bookPublishDate, 
						ISBN, copiesAvailable, bookAuthor, bookLocation));
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
			int journalCopies = 0;
			String journalLocation = "";

			while ((journalTitle = bufferedReader.readLine()) != null) {
				journalPublishDate = bufferedReader.readLine();
				journalVolume = Integer.parseInt(bufferedReader.readLine());
				journalIssue = Integer.parseInt(bufferedReader.readLine());
				journalPublisher = bufferedReader.readLine();
				journalArticles = bufferedReader.readLine();
				journalCopies = Integer.parseInt(bufferedReader.readLine());
				journalLocation = bufferedReader.readLine();
				bufferedReader.readLine();
				documents.add(new Journals(journalTitle, journalPublishDate, journalVolume, journalIssue,
						journalPublisher, journalArticles, journalCopies, journalLocation));
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Can't open documents file: " + ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}
	
	//Upon closing the program, saves the documents to respective files
	//in proper format
	private static void saveDocuments(){
		try{
			PrintWriter writeBook = new PrintWriter(bookFile);
			PrintWriter writeJournal = new PrintWriter(journalFile);
			for(Documents document : documents)
			{	
				if(document instanceof Books)
				{
					writeBook.write(document.title + "\n");
					writeBook.write(document.publisher + "\n");
					writeBook.write(document.publishedDate + "\n");
					writeBook.write(((Books)document).ISBN + "\n");
					writeBook.write(document.numberOfCopies + "\n");
					writeBook.write(document.authors + "\n");
					writeBook.write(document.location + "\n\n");
				}
				else if(document instanceof Journals)
				{
					writeJournal.write(document.title + "\n");
					writeJournal.write(document.publishedDate + "\n");
					writeJournal.write(((Journals)document).volume + "\n");
					writeJournal.write(((Journals)document).issueNumber + "\n");
					writeJournal.write(document.publisher + "\n");
					writeJournal.write(((Journals)document).articles + "\n");
					writeJournal.write(document.numberOfCopies + "\n");
					writeJournal.write(document.location + "\n\n");
				}
				else
					System.out.println("Error saving: " + document.title + "\nWill not be saved\n");
			}
			writeBook.close();
			writeJournal.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Can't open documents file: " + ex);
		}
	}
	
	//function to search documents ArrayList by Author
	private static int searchAuthor(String query)
	{
		for (Documents document : documents)
			if(document.authors.equals(query))
				return documents.indexOf(document); 
		return -1;
	}
	
	//function to search documents ArrayList by Title
	private static int searchTitle(String query)
	{
		for(Documents document : documents)
			if(document.title.equals(query))
				return documents.indexOf(document);
		return -1;
	}
	
	//function to allow user to borrow specified document
	private static boolean issueDocument(User user, int documentIndex) {
		int booksCheckedOut = 0;
		if(!user.documentsCheckedOut.isEmpty())
		{	
			booksCheckedOut = user.documentsCheckedOut.size();
		}
		if(documents.get(documentIndex).numberOfCopies > 0 && booksCheckedOut < user.maxBookLimit)
		{
			if(documents.get(documentIndex) instanceof Books)
			{
				Books checkOut = new Books(documents.get(documentIndex).title, documents.get(documentIndex).publisher, 
						documents.get(documentIndex).publishedDate, ((Books) documents.get(documentIndex)).ISBN, 
						1, documents.get(documentIndex).authors, user.name);
				user.documentsCheckedOut.add(checkOut);
				documents.add(checkOut);
				documents.get(documentIndex).numberOfCopies--;
				return true;
			}
			else if(documents.get(documentIndex) instanceof Journals)
			{
				Journals checkOut = new Journals(documents.get(documentIndex).title, documents.get(documentIndex).publishedDate, 
						((Journals) documents.get(documentIndex)).volume, ((Journals) documents.get(documentIndex)).issueNumber,
						documents.get(documentIndex).publisher, ((Journals) documents.get(documentIndex)).articles, 1, user.name);
				user.documentsCheckedOut.add(checkOut);
				documents.add(checkOut);
				documents.get(documentIndex).numberOfCopies--;
			}
		}
		return false;
	}

	//function to allow user to return specified document
	private static boolean returnDocument(User user, int documentIndex){						
		for(Documents document : documents)
			if(document.title.equals(user.documentsCheckedOut.get(documentIndex).title) 
			&& document.authors.equals(user.documentsCheckedOut.get(documentIndex).authors)
			&& document.location.equals("library"))
			{
				document.numberOfCopies += 1;
				user.documentsCheckedOut.remove(documentIndex);
				return true;
			}
		return false;
	}

	//Displays and maintains options for student account
	private static void studentOptions() {
		System.out.println("Please input accountID: ");
		sn = new Scanner(System.in);
		int userInput = sn.nextInt();
		User activeUser = searchUser(userInput, "student");
		if (activeUser == null)
			System.out.println("Invalid UserID");
		else
		{
			boolean loop = true;
			do
			{
				System.out.println("Hello " + activeUser.name + "\n" 
								+ "What would you like to do?\n"
									+ "\t[1] Update Account\n"
									+ "\t[2] Search Library by Title\n" 
									+ "\t[3] Search Library by Author\n"
									+ "\t[4] View Borrowed Books / Return Books\n");
				userInput = sn.nextInt();
				sn.nextLine();
				String query = "";
				int searchIndex = -1;
				switch(userInput)
				{
					case 1:
						System.out.println("Please input your new name: ");
						query = sn.nextLine();
						activeUser.updateInfo(query);
						break;
					case 2:
						System.out.println("Enter Search Query: ");
						query = sn.nextLine();
						searchIndex = searchTitle(query);
						if(searchIndex != -1)
						{
							System.out.println("\nTitle of Document\t\tNumber Of Copies");
							System.out.println(documents.get(searchIndex).title + "\t\t\t" 
									+ documents.get(searchIndex).numberOfCopies + "\n");
							System.out.println("Would you like to check out this document?\n"
												+ "\t[1] Yes\n"
												+ "\t[2] No");
							userInput = sn.nextInt();
							sn.nextLine();
							if(userInput == 1)
								issueDocument(activeUser, searchIndex);
						}
						else
							System.out.println("Document not found!");
						break;
					case 3:
						System.out.println("Enter Search Query: ");
						query = sn.nextLine();
						searchIndex = searchAuthor(query);
						if(searchIndex != -1)
						{
							System.out.println("\nTitle of Document\t\tNumber Of Copies");
							System.out.println(documents.get(searchIndex).title + "\t\t\t" 
									+ documents.get(searchIndex).numberOfCopies + "\n");
							System.out.println("Would you like to check out this document?\n"
												+ "\t[1] Yes\n"
												+ "\t[2] No");
							userInput = sn.nextInt();
							sn.nextLine();
							if(userInput == 1)
							{
								if(issueDocument(activeUser, searchIndex))
									System.out.println("You have checked out " + query);
								else
									System.out.println("Unable to check out document!");
							}
						}
						else
							System.out.println("Document not found!");
						break;
					case 4:
						if(activeUser.documentsCheckedOut.size() <= 0)
							System.out.println("No Documents have been checked out!");
						else
						{
							for(Documents document : activeUser.documentsCheckedOut)
								System.out.println("[" + activeUser.documentsCheckedOut.indexOf(document)
									+ "] " + document.title);
							System.out.println("Would you like to return a document?\n"
												+ "\t[1] Yes\n"
												+ "\t[2] No");
							userInput = sn.nextInt();
							sn.nextLine();
							if(userInput == 1)
							{
								System.out.println("Which book?");
								userInput = sn.nextInt();
								sn.nextLine();
								if(userInput >= activeUser.documentsCheckedOut.size()
										|| userInput < 0)
									System.out.println("Cannot Return Document!");
								else
								{
									if(returnDocument(activeUser, userInput))
										System.out.println("Return succesful");
									else
										System.out.println("Return NOT Successful");
								}
							}
						}
						break;
					default:
						System.out.println("\n*************************"
									+ "\nInvalid Input!!!"
									+ "\n*************************\n");
						break;
				}
				System.out.println("Would you like to return to the main menu?\n"
									+ "\t[1] Yes\n"
									+ "\t[2] No\n");
				userInput = sn.nextInt();
				if(userInput == 1)
					loop = false;
			}while(loop);
		}
	}

	//Displays and maintains options for faculty accounts
	private static void facultyOptions() {
		System.out.println("Please input accountID: ");
		sn = new Scanner(System.in);
		int userInput = sn.nextInt();;
		User activeUser = searchUser(userInput, "faculty");
		if (activeUser == null)
			System.out.println("Invalid UserID");
		else
		{
			boolean loop = true;
			do
			{
				System.out.println("Hello " + activeUser.name + "\n" 
								+ "What would you like to do?\n"
									+ "\t[1] Update Account\n"
									+ "\t[2] Search Library by Title\n" 
									+ "\t[3] Search Library by Author\n"
									+ "\t[4] View Borrowed Books / Return Books\n");
				userInput = sn.nextInt();
				sn.nextLine();
				String query = "";
				int searchIndex = 0;
				switch(userInput)
				{
					case 1:
						System.out.println("Please input your new name: ");
						query = sn.nextLine();
						activeUser.updateInfo(query);
						break;
					case 2:
						System.out.println("Enter Search Query: ");
						query = sn.nextLine();
						searchIndex = searchTitle(query);
						if(searchIndex != -1)
						{
							System.out.println("\nTitle of Document\t\tNumber Of Copies");
							System.out.println(documents.get(searchIndex).title + "\t\t\t" 
									+ documents.get(searchIndex).numberOfCopies + "\n");
							System.out.println("Would you like to check out this document?\n"
												+ "\t[1] Yes\n"
												+ "\t[2] No");
							userInput = sn.nextInt();
							sn.nextLine();
							if(userInput == 1)
							{
								if(issueDocument(activeUser, searchIndex))
									System.out.println("You have checked out " + query);
								else
									System.out.println("Unable to check out document!");
							}
						}
						else
							System.out.println("Document not found!");
						break;
					case 3:
						System.out.println("Enter Search Query: ");
						query = sn.nextLine();
						searchIndex = searchAuthor(query);
						if(searchIndex != -1)
						{
							System.out.println("\nTitle of Document\t\tNumber Of Copies");
							System.out.println(documents.get(searchIndex).title + "\t\t\t" 
									+ documents.get(searchIndex).numberOfCopies + "\n");
							System.out.println("Would you like to check out this document?\n"
												+ "\t[1] Yes\n"
												+ "\t[2] No");
							userInput = sn.nextInt();
							sn.nextLine();
							if(userInput == 1)
								issueDocument(activeUser, searchIndex);
						}
						else
							System.out.println("Document not found!");
						break;
					case 4:
						if(activeUser.documentsCheckedOut.size() <= 0)
							System.out.println("No Documents have been checked out!");
						else
						{
							for(Documents document : activeUser.documentsCheckedOut)
								System.out.println("[" + activeUser.documentsCheckedOut.indexOf(document)
									+ "] " + document.title);
							System.out.println("Would you like to return a document?\n"
												+ "\t[1] Yes\n"
												+ "\t[2] No");
							userInput = sn.nextInt();
							sn.nextLine();
							if(userInput == 1)
							{
								System.out.println("Which book?");
								userInput = sn.nextInt();
								sn.nextLine();
								if(userInput >= activeUser.documentsCheckedOut.size()
										|| userInput < 0)
									System.out.println("Cannot Return Document!");
								else
								{
									if(returnDocument(activeUser, userInput))
										System.out.println("Return succesful");
									else
										System.out.println("Return NOT Successful");
								}
							}
						}
						break;
					default:
						System.out.println("\n*************************"
									+ "\nInvalid Input!!!"
									+ "\n*************************\n");
						break;
				}
				System.out.println("Would you like to return to the main menu?\n"
									+ "\t[1] Yes\n"
									+ "\t[2] No\n");
				userInput = sn.nextInt();
				if(userInput == 1)
					loop = false;
			}while(loop);
		}
	}

	//Displays and maintains options for Librarian account
	private static void librarianOptions() {
		System.out.println("Please input accountID: ");
		sn = new Scanner(System.in);
		int userInput = sn.nextInt();;
		User activeUser = searchUser(userInput, "librarian");
		if (activeUser == null)
			System.out.println("Invalid UserID");
		else
		{
			boolean loop = true;
			do
			{
				System.out.println("Hello " + activeUser.name + "\n" 
								+ "What would you like to do?\n"
									+ "\t[1] Update Account\n"
									+ "\t[2] Search Library by Title\n" 
									+ "\t[3] Search Library by Author\n"
									+ "\t[4] View Borrowed Books / Return Books\n"
									+ "\t[5] Add User\n"
									+ "\t[6] Add Document\n"
									+ "\t[7] Save System\n");
				userInput = sn.nextInt();
				sn.nextLine();
				int searchIndex = 0;
				String query = "";
				switch(userInput)
				{
					case 1:
						System.out.println("Please input your new name: ");
						query = sn.nextLine();
						activeUser.updateInfo(query);
						break;
					case 2:
						System.out.println("Enter Search Query: ");
						query = sn.nextLine();
						searchIndex = searchTitle(query);
						if(searchIndex != -1)
						{
							System.out.println("\nTitle of Document\t\tNumber Of Copies");
							System.out.println(documents.get(searchIndex).title + "\t\t\t" 
									+ documents.get(searchIndex).numberOfCopies + "\n");
							System.out.println("Would you like to check out this document?\n"
											+ "\t[1] Yes\n"
											+ "\t[2] No");
							userInput = sn.nextInt();
							sn.nextLine();
							if(userInput == 1)
								issueDocument(activeUser, searchIndex);
						}
						else
							System.out.println("Document not found!");
						break;
					case 3:
						System.out.println("Enter Search Query: ");
						query = sn.nextLine();
						searchIndex = searchAuthor(query);
						if(searchIndex != -1)
						{
							System.out.println("\nTitle of Document\t\tNumber Of Copies");
							System.out.println(documents.get(searchIndex).title + "\t\t\t" 
									+ documents.get(searchIndex).numberOfCopies + "\n");
							System.out.println("Would you like to check out this document?\n"
												+ "\t[1] Yes\n"
												+ "\t[2] No");
							userInput = sn.nextInt();
							sn.nextLine();
							if(userInput == 1)
							{
								if(issueDocument(activeUser, searchIndex))
									System.out.println("You have checked out " + query);
								else
									System.out.println("Unable to check out document!");
							}
						}
						else
							System.out.println("Document not found!");
						break;
					case 4:
						if(activeUser.documentsCheckedOut.size() <= 0)
							System.out.println("No Documents have been checked out!");
						else
						{
							for(Documents document : activeUser.documentsCheckedOut)
								System.out.println("[" + activeUser.documentsCheckedOut.indexOf(document)
									+ "] " + document.title);
							System.out.println("Would you like to return a document?\n"
												+ "\t[1] Yes\n"
												+ "\t[2] No");
							userInput = sn.nextInt();
							sn.nextLine();
							if(userInput == 1)
							{
								System.out.println("Which book?");
								userInput = sn.nextInt();
								sn.nextLine();
								if(userInput >= activeUser.documentsCheckedOut.size()
										|| userInput < 0)
									System.out.println("Cannot Return Document!");
								else
								{
									if(returnDocument(activeUser, userInput))
										System.out.println("Return succesful");
									else
										System.out.println("Return NOT Successful");
								}
							}
						}
						break;
					case 5:
						String name;
						int accountID = 0;
						System.out.println("Enter name of new user: ");
						name = sn.nextLine();
						System.out.println("What type of account?\n"
										+ "\t[1] Student\n"
										+ "\t[2] Faculty\n"
										+ "\t[3] Librarian");
						userInput = sn.nextInt();
						sn.nextLine();
						if(userInput == 1)
						{
							accountID = registration(name, "student");
							System.out.println("User account created\n"
										+ "\tAccount ID: " + accountID
										+ "\n\tFor: " + name);
						}
						else if(userInput == 2)
						{
							accountID =registration(name, "faculty");
							System.out.println("User account created\n"
									+ "\tAccount ID: " + accountID
									+ "\n\tFor: " + name);
						}
						else if(userInput == 3)
						{
							accountID = registration(name, "librarian");
							System.out.println("User account created\n"
									+ "\tAccount ID: " + accountID
									+ "\n\tFor: " + name);
						}
						else
							System.out.println("Invalid user type. Creation terminated.");
						break;
					case 6:
						System.out.println("What type of document?\n"
										+ "\t[1] Book\n"
										+ "\t[2] Journal\n");
						userInput = sn.nextInt();
						sn.nextLine();
						String title, publisher, date, ISBN, authors, articles;
						int copies, volume, issue;
						if(userInput == 1)
						{
							 System.out.print("Title: ");
							 title = sn.nextLine();
							 System.out.print("Publisher: ");
							 publisher = sn.nextLine();
							 System.out.print("Date published: ");
							 date = sn.nextLine();
							 System.out.print("ISBN: ");
							 ISBN = sn.nextLine();
							 System.out.print("Number of copies: ");
							 copies = sn.nextInt();
							 sn.nextLine();
							 System.out.print("Authors: ");
							 authors = sn.nextLine();
							 
							 documents.add(new Books(title, publisher, date, ISBN,
									 copies, authors, "library"));
							 System.out.println("Doucment Created.");
						}
						else if(userInput == 2)
						{
							 System.out.print("Title: ");
							 title = sn.nextLine();
							 System.out.print("Publisher: ");
							 publisher = sn.nextLine();
							 System.out.print("Date published: ");
							 date = sn.nextLine();
							 System.out.print("Volume: ");
							 volume = sn.nextInt();
							 sn.nextLine();
							 System.out.print("Issue: ");
							 issue = sn.nextInt();
							 sn.nextLine();
							 System.out.print("Articles: ");
							 articles = sn.nextLine();
							 System.out.print("Number of copies: ");
							 copies = sn.nextInt();
							 sn.nextLine();
							 
							 documents.add(new Journals(title, date, volume, issue,
									 publisher, articles, copies, "library"));
							 System.out.println("Doucment Created.");
						}
						else
							System.out.println("Invalid choice");
						break;
					case 7:
						saveDocuments();
						saveUsers();
						System.out.println("System Saved!");
						break;
					default:
						System.out.println("\n*************************"
									+ "\nInvalid Input!!!"
									+ "\n*************************\n");
						break;
				}
				System.out.println("Would you like to return to the main menu?\n"
									+ "\t[1] Yes\n"
									+ "\t[2] No\n");
				userInput = sn.nextInt();
				if(userInput == 1)
					loop = false;
			}while(loop);
		}
	}

	public static void main(String[] args) {
		documents = new ArrayList<Documents>();
		System.out.println("Initializing Library...");
		System.out.println("Importing documents...");
		initializeDocuments();
		System.out.println("Importing users...");
		initializeUsers();
		System.out.println("Complete!\n\n");
		System.out.println("Welcome to the University Library");
		
		sn = new Scanner(System.in);
		int userInput;
		boolean loop = true;
		do {
			System.out.print(
					"Are you: \n" 
							+ "\t[1] Student\n" 
							+ "\t[2] Faculty\n" 
							+ "\t[3] Librarian\n"
							+ "\t[4] Exit Program\n"
					+ "Input Here: ");
			userInput = sn.nextInt(); // receive int input from user
			sn.nextLine();
			switch (userInput) {
				case 1:
					studentOptions();
					break;
				case 2:
					facultyOptions();
					break;
				case 3:
					librarianOptions();
					break;
				case 4:
					loop = false;
					break;
				default:
					System.out.println("\n*************************"
									+ "\nInvalid Input!!!"
									+ "\n*************************\n");
					break;
			}
		} while (loop);
		
		saveDocuments();
		saveUsers();
		System.out.println("\nGood-Bye!");
		sn.close();
	}
}