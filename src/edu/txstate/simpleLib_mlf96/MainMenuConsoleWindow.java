package edu.txstate.simpleLib_mlf96;

import java.util.InputMismatchException;

//*Note* I just copied and pasted from the instructions to here, this
//does not work in any way whatsoever

public class MainMenuConsoleWindow extends ConsoleWindow{
	public MainMenuConsoleWindow(University_Library lib) {
			MainMenuConsoleWindow.libs = lib;
	}
	
	protected void printMenu() {
		System.out.println(
				"\n1. Switch to user view. \n"
				+ "2. Switch to librarian view. \n"
				+"3. Switch to Admin view. \n"
				+ "4. Exit program.");
		}
	public void start() {
		int choice = 0;
		boolean exitProgram = false;
		do {
			printMenu();
			
			try {
				choice = sc.nextInt();
				sc.nextLine(); //clear the new line character from the input
				switch (choice) {
					case 1: 
						UserView(); 
						break;
					case 2: 
						LibrarianView(); 
						break;
					case 3: 
						AdminView(); 
						break;
					case 4: 
						exitProgram = true; 
						break;
					default: 
						System.err .println(
						"Please select a number between 1 and 4.");
			}
			} catch (InputMismatchException ex) {
				System.err.println("Input missmatch. Please Try again.", ex);
				sc.nextLine(); //clear the new line character from the input
			} catch (UnsupportedOperationException ex) {
				ex.printStackTrace(); //For debugging purposes only.
			} catch (Exception ex) {
				System.err.println( "An unknown error has occured.", ex);
			}
		} while (!exitProgram);
	}
}