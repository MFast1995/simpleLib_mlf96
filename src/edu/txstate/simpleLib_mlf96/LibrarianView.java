package edu.txstate.simpleLib_mlf96;

public class LibrarianView extends ConsoleWindow {

	@Override
	protected void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("What would you like to do?\n"
					+ "\t[1] Search Library by Title\n"
					+ "\t[2] Search Library by Author\n"
					+ "\t[3] Search Library by Publisher\n"
					+ "\t[4] View Borrowed Books / Return Books\n"
					+ "\t[5] Add User\n"
					+ "\t[6] Add Document\n"
					+ "\t[7] View Checked Out Documents");

		receiveInput();
	}

	protected void receiveInput()
	{
		int input = sc.nextInt();
		sc.nextLine();
		int queryIndex;
		String query;

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
			case 5:
				addNewUser();
				break;
			case 6:
				addNewDocuments();
				break;
			case 7:
				viewCheckedOutDocuments();
			default:
				System.err.println("Please select a number between 1 and 7.");
				break;
		}

	}

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

	//Add a new user to the user file
	protected void addNewUser()
	{
		int query;
		String name;
		int accountID = 0;
		System.out.println("Enter name of new user: ");
		name = sc.nextLine();
		System.out.println("What type of account?\n"
				+ "\t[1] Student\n"
				+ "\t[2] Faculty\n"
				+ "\t[3] Librarian");
		query = sc.nextInt();
		sc.nextLine();
		if(query == 1)
		{
			accountID = libs.registration(name, "student");
			System.out.println("User account created\n"
					+ "\tAccount ID: " + accountID
					+ "\n\tFor: " + name);
		}
		else if(query == 2)
		{
			accountID = libs.registration(name, "faculty");
			System.out.println("User account created\n"
					+ "\tAccount ID: " + accountID
					+ "\n\tFor: " + name);
		}
		else if(query == 3)
		{
			accountID = libs.registration(name, "librarian");
			System.out.println("User account created\n"
					+ "\tAccount ID: " + accountID
					+ "\n\tFor: " + name);
		}
		else
			System.out.println("Invalid user type. Creation terminated.");
	}
	
	protected void addNewDocuments()
	{
		int userInput;
		System.out.println("What type of document?\n"
				+ "\t[1] Book\n"
				+ "\t[2] Journal\n");
		userInput = sc.nextInt();
		sc.nextLine();
		String title, publisher, date, ISBN, authors, articles;
		int copies, volume, issue;
		if(userInput == 1)
		{
			 System.out.print("Title: ");
			 title = sc.nextLine();
			 System.out.print("Publisher: ");
			 publisher = sc.nextLine();
			 System.out.print("Date published: ");
			 date = sc.nextLine();
			 System.out.print("ISBN: ");
			 ISBN = sc.nextLine();
			 System.out.print("Number of copies: ");
			 copies = sc.nextInt();
			 sc.nextLine();
			 System.out.print("Authors: ");
			 authors = sc.nextLine();
			 
			 University_Library.documents.add(new Books(title, publisher, date, ISBN,
					 copies, authors, "library"));
			 System.out.println("Doucment Created.");
		}
		else if(userInput == 2)
		{
			 System.out.print("Title: ");
			 title = sc.nextLine();
			 System.out.print("Publisher: ");
			 publisher = sc.nextLine();
			 System.out.print("Date published: ");
			 date = sc.nextLine();
			 System.out.print("Volume: ");
			 volume = sc.nextInt();
			 sc.nextLine();
			 System.out.print("Issue: ");
			 issue = sc.nextInt();
			 sc.nextLine();
			 System.out.print("Articles: ");
			 articles = sc.nextLine();
			 System.out.print("Number of copies: ");
			 copies = sc.nextInt();
			 sc.nextLine();
			 
			 University_Library.documents.add(new Journals(title, date, volume, issue,
					 publisher, articles, copies, "library"));
			 System.out.println("Doucment Created.");
		}
		else
			System.out.println("Invalid choice");
	}
	
	protected void viewCheckedOutDocuments()
	{
		for(User user: University_Library.users)
		{
			if(user.documentsCheckedOut.size() > 0)
			{
				System.out.println(user.name);
				for(Documents document: user.documentsCheckedOut)
					System.out.println("......" + document.title);		
				System.out.println();
			}
		}
	}
}
