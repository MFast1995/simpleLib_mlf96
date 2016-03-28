package edu.txstate.simpleLib_mlf96;

import java.util.Scanner;

public abstract class ConsoleWindow {
	
	protected static University_Library libs = new University_Library();
	protected static Scanner sc = new Scanner(System.in );
	static User activeUser;
	
	// Abstract method. To be implemented by subclasses.
	protected abstract void printMenu();
}
