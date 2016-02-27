package edu.txstate.simpleLib_mlf96;

import java.util.*;
import java.io.*;

/* This class contains the main portion of the program.
 * University Library is a system to allow users to search, borrow, and return various
 * documents including books and journals
 */
public class University_Library {
	private static ArrayList<Documents> documents;
	private static ArrayList<User> users;
	private static Scanner sn;

	// Function is called when the program is started
	// Initializes all users stored in user file
	private static void initializeUsers() {
		users = new ArrayList<User>();
		String userFile = "input/users.txt";

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
				if (type == "librarian")
					users.add(new Staff(name, userID));
				else if (type == "faculty")
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

	// Function is called when the program is started
	// Initializes all documents stored in various document files
	// (such as books and journals)
	private static void initializeDocuments() {
		documents = new ArrayList<Documents>();
		String bookFile = "input/books.txt";
		String journalFile = "input/journals.txt";

		try {
			FileReader fileReader = new FileReader(bookFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String bookTitle = "";
			String bookPublisher = "";
			String bookPublishDate = "";
			String ISBN = "";
			int copiesAvailable = 0;
			String bookAuthor = "";

			while ((bookTitle = bufferedReader.readLine()) != null) {
				bookPublisher = bufferedReader.readLine();
				bookPublishDate = bufferedReader.readLine();
				ISBN = bufferedReader.readLine();
				copiesAvailable = Integer.parseInt(bufferedReader.readLine());
				bookAuthor = bufferedReader.readLine();
				bufferedReader.readLine();
				documents.add(new Books(bookTitle, bookPublisher, bookPublishDate, ISBN, copiesAvailable, bookAuthor));
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

			while ((journalTitle = bufferedReader.readLine()) != null) {
				journalPublishDate = bufferedReader.readLine();
				journalVolume = Integer.parseInt(bufferedReader.readLine());
				journalIssue = Integer.parseInt(bufferedReader.readLine());
				journalPublisher = bufferedReader.readLine();
				journalArticles = bufferedReader.readLine();
				bufferedReader.readLine();
				documents.add(new Journals(journalTitle, journalPublishDate, journalVolume, journalIssue,
						journalPublisher, journalArticles));
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Can't open documents file: " + ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	// Function to search through User ArrayList to find target User
	// Returns found User or null 
	private static User searchUser(int accountID, String accountType) {
		User activeUser = null;
		for (User user : users)
			if (user.accountNumber == accountID && user.accountType == accountType)
				activeUser = user;
		return activeUser;
	}
	
	//
	private static boolean issueDocument(User user, Documents document) {
		user.documentsCheckedOut.add(document);
		document.numberOfCopies--;
		return true;
	}

	//
	private static boolean isRegistered(User user) {
		if(searchUser(user.accountNumber, user.accountType) != null)
			return true;
		else
			return false;
	}
	
	//
	private static void registration(String name, String type) {
		if (type == "faculty")
			users.add(new Faculty(name, 123));
		else if (type == "librarian")
			users.add(new Staff(name, 123));
		else
			users.add(new Student(name, 123));
	}

	//
	private static void studentOptions() {
		System.out.println("Please input accountID: ");
		sn = new Scanner(System.in);
		int userInput = sn.nextInt();;
		User activeUser = searchUser(userInput, "student");
		if (activeUser == null)
			System.out.println("Invalid UserID");
		else
		{
			boolean loop = true;
			do
			{
				System.out.println("Hello " + activeUser.name + "\n" + "What would you like to do?\n"
								+ "[1] Update Account\n"
								+ "[2] Search Library\n" 
								+ "[3] Return Book\n");
				userInput = sn.nextInt();
				switch(userInput)
				{
					case 1:
						activeUser.updateInfo();
						break;
					case 2:
						
						break;
					case 3:
						
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

	//
	private static void facultyOptions() {
	}

	//
	private static void librarianOptions() {
		
	}

	//
	public static void main(String[] args) {
		documents = new ArrayList<Documents>();
		System.out.println("Initializing Library...");
		System.out.println("Importing users...");
		initializeUsers();
		System.out.println("Importing documents...");
		initializeDocuments();
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
					+ "Input Here: ");
			userInput = sn.nextInt(); // receive input from user
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
				default:
					System.out.println("\n*************************"
									+ "\nInvalid Input!!!"
									+ "\n*************************\n");
					break;
			}
			
			System.out.println("Would you like to exit this program?\n"
							+ "\t[1] Yes\n"
							+ "\t[2] No\n");
			userInput = sn.nextInt();
			if(userInput == 1)
				loop = false;
		} while (loop);
		
		System.out.println("\nGood-Bye!");
		sn.close();
	}
}