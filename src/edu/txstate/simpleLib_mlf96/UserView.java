package edu.txstate.simpleLib_mlf96;

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
					System.out.println(University_Library.documents.get(queryIndex).title + "\t\t\t" 
							+ University_Library.documents.get(queryIndex).numberOfCopies + "\n");
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
					System.out.println(University_Library.documents.get(queryIndex).title + "\t\t\t" 
							+ University_Library.documents.get(queryIndex).numberOfCopies + "\n");
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
					System.out.println(University_Library.documents.get(queryIndex).title + "\t\t\t" 
							+ University_Library.documents.get(queryIndex).numberOfCopies + "\n");
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
                borrowedDocs();
				break;
			default:
				System.err.println("Please select a number between 1 and 4.");
				break;
		}
		
	}

    //Method to see if the user has borrowed books.
    protected void borrowedDocs()
    {
        int query;
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
            query = sc.nextInt();
            sc.nextLine();
            if(query == 1)
            {
                System.out.println("Which book?");
                query = sc.nextInt();
                sc.nextLine();
                if(query >= activeUser.documentsCheckedOut.size()
                        || query < 0)
                    System.out.println("Cannot Return Document!");
                else
                {
                    if(libs.returnDocument(activeUser, query))
                        System.out.println("Return successful");
                    else
                        System.out.println("Return NOT Successful");
                }
            }
        }
    }
}
