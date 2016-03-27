package edu.txstate.simpleLib_mlf96;

//A user should be able to search, borrow, or return

public class UserView extends ConsoleWindow {
	@Override
	protected void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("What would you like to do?\n"
					+ "\t[1] Update Account\n"
					+ "\t[2] Search Library by Title\n" 
					+ "\t[3] Search Library by Author\n"
					+ "\t[4] View Borrowed Books / Return Books\n");
		receiveInput();
	}
	
	protected void receiveInput()
	{
		int input = sc.nextInt();
		String query;
		
		switch(input)
		{
			case 1:
				
				break;
			case 2:
				System.out.println("Enter your search query: ");
				query = sc.nextLine();
				libs.searchTitle(query);
				break;
			case 3:
				System.out.println("Enter your search query: ");
				query = sc.nextLine();
				libs.searchAuthor(query);
				break;
			case 4:
				
				break;
			default:
				
				break;
		}
		
	}
}
