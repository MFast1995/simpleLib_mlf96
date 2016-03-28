package edu.txstate.simpleLib_mlf96;

//A user should be able to search, borrow, or return

public class UserView extends ConsoleWindow {
	@Override
	protected void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("What would you like to do?\n"
					+ "\t[1] Search Library by Title\n" 
					+ "\t[2] Search Library by Author\n"
					+ "\t[3] Search Library by Publisher\n"
					+ "\t[4] View Borrowed Books / Return Books\n");
		receiveInput();
	}
	
	protected void receiveInput()
	{
		int input = sc.nextInt();
		sc.nextLine();
		String query;
		int queryIndex = -1;
		
		switch(input)
		{
			case 1:
				System.out.println("Enter your search query: ");
				query = sc.nextLine();
				queryIndex = libs.searchTitle(query);
				if(queryIndex != -1)
				{
					System.out.println("\nTitle of Document\t\tNumber Of Copies");
					System.out.println(libs.documents.get(queryIndex).title + "\t\t\t" 
							+ libs.documents.get(queryIndex).numberOfCopies + "\n");
					System.out.println("Would you like to check out this document?\n"
										+ "\t[1] Yes\n"
										+ "\t[2] No");
					input = sc.nextInt();
					sc.nextLine();
					if(input == 1)
					{
						if(libs.issueDocument(activeUser, queryIndex))
							System.out.println("You have checked out " + query);
						else
							System.out.println("Unable to check out document!");
					}
				}
				else
					System.out.println("Document not found!");
				break;
			case 2:
				System.out.println("Enter your search query: ");
				query = sc.nextLine();
				queryIndex = libs.searchAuthor(query);
				if(queryIndex != -1)
				{
					System.out.println("\nTitle of Document\t\tNumber Of Copies");
					System.out.println(libs.documents.get(queryIndex).title + "\t\t\t" 
							+ libs.documents.get(queryIndex).numberOfCopies + "\n");
					System.out.println("Would you like to check out this document?\n"
										+ "\t[1] Yes\n"
										+ "\t[2] No");
					input = sc.nextInt();
					sc.nextLine();
					if(input == 1)
					{
						if(libs.issueDocument(activeUser, queryIndex))
							System.out.println("You have checked out " + query);
						else
							System.out.println("Unable to check out document!");
					}
				}
				else
					System.out.println("Document not found!");
				break;
			case 3:
				System.out.println("Enter your search query: ");
				query = sc.nextLine();
				queryIndex = libs.searchPublisher(query);
				if(queryIndex != -1)
				{
					System.out.println("\nTitle of Document\t\tNumber Of Copies");
					System.out.println(libs.documents.get(queryIndex).title + "\t\t\t" 
							+ libs.documents.get(queryIndex).numberOfCopies + "\n");
					System.out.println("Would you like to check out this document?\n"
										+ "\t[1] Yes\n"
										+ "\t[2] No");
					input = sc.nextInt();
					sc.nextLine();
					if(input == 1)
					{
						if(libs.issueDocument(activeUser, queryIndex))
							System.out.println("You have checked out " + query);
						else
							System.out.println("Unable to check out document!");
					}
				}
				else
					System.out.println("Document not found!");
				break;
			case 4: 
				
				break;
			default:
				
				break;
		}
		
	}
}
