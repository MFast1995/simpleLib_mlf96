package edu.txstate.simpleLib_mlf96;

//An Admin should be able to add user, remove user, or list users.

public class AdminView extends ConsoleWindow {

	@Override
	protected void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("What would you like to do?\n"
					+ "\t[1] Update Account\n"
					+ "\t[2] Search Library by Title\n" 
					+ "\t[3] Search Library by Author\n"
					+ "\t[4] View Borrowed Books / Return Books\n"
					+ "\t[5] Add User\n");
	}

}
