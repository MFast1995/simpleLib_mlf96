package edu.txstate.simpleLib_mlf96;

import java.util.InputMismatchException;

public class MainMenuConsoleWindow extends ConsoleWindow{
	
	//default constructor
	public MainMenuConsoleWindow(){	}
	
	protected void printMenu() {
		System.out.println(
				"Are you: \n" 
					+ "\t[1] Student\n" 
					+ "\t[2] Faculty\n"
					+ "\t[3] Librarian\n"
					+ "\t[4] Exit Program\n"
				+ "Input Here: ");
	}
	
	public void start() {
		int choice = 0, accountID = 0;
		boolean exitProgram = false;
		do {
			printMenu();
			try {
				choice = sc.nextInt();
				sc.nextLine(); //clear the new line character from the input
				switch (choice) {
					case 1: 
						System.out.println("What is your ID number? ");
						accountID = sc.nextInt();
						activeUser = libs.searchUser(accountID, "student");
						if(activeUser != null)
						{
							UserView userView = new UserView(); 
							System.out.println("Hello " + activeUser.name);
							userView.printMenu();
						}
						else
							System.out.println("Invalid ID");
						break;
					case 2: 
						System.out.println("What is your ID number? ");
						accountID = sc.nextInt();
						activeUser = libs.searchUser(accountID, "faculty");
						if(activeUser != null)
						{
							AdminView adminView = new AdminView();
							adminView.printMenu();
						}
						else
							System.out.println("Invalid ID");
						break;
					case 3: 
						System.out.println("What is your ID number? ");
						accountID = sc.nextInt();
						activeUser = libs.searchUser(accountID, "librarian");
						if(activeUser != null)
						{
							LibrarianView librarianView = new LibrarianView();
							librarianView.printMenu();
						}
						else
							System.out.println("Invalid ID");
						break;
					case 4: 
						exitProgram = true; 
						break;
					default: 
						System.err.println("Please select a number between 1 and 4.");
			}
			} catch (InputMismatchException ex) {
				System.err.println("Input mismatch. Please Try again. \n" + ex);
				sc.nextLine(); //clear the new line character from the input
			} catch (UnsupportedOperationException ex) {
				ex.printStackTrace(); //For debugging purposes only.
			} catch (Exception ex) {
				System.err.println( "An unknown error has occured. \n" + ex);
			}
		} while (!exitProgram);
	}
}