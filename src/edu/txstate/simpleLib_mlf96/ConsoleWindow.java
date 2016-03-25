package edu.txstate.simpleLib_mlf96;

import java.util.Scanner;

public abstract class ConsoleWindow {
	
	protected static University_Library libs;
	protected static Scanner sc = new Scanner(System.in );
	/**
	* Abstract method. To be implemented by subclasses.
	*/
	protected abstract void printMenu();
}
