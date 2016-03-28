package edu.txstate.simpleLib_mlf96;

//An Admin should be able to add user, remove user, or list users.

public class AdminView extends ConsoleWindow {

	@Override
	protected void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("What would you like to do?\n"
					+ "\t[1] Search Library by Title\n" 
					+ "\t[2] Search Library by Author\n"
                    + "\t[3] Search Library by Publisher\n"
					+ "\t[4] View Borrowed Books / Return Books\n"
					+ "\t[5] Add User\n"
                    + "\t[6] View/Remove Users\n");

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
				break;
			case 2:
				System.out.println("Enter your search query: ");
				query = sc.nextLine();
				queryIndex = libs.searchAuthor(query);
				break;
			case 3:
                System.out.println("Enter your search query: ");
                query = sc.nextLine();
                queryIndex = libs.searchPublisher(query);
				break;
            case 4:
                borrowedDocs();
                break;
            case 5:
                addNewUser();
                break;
            case 6:
                viewUsers();
                break;
			default:

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

    protected void viewUsers()
    {
        int input;
        System.out.println("User List:");
        libs.listUsers();

        System.out.println("Would you like to remove a user?\n"
                + "\t[1] Yes\n"
                + "\t[2] No");
        input = sc.nextInt();
        sc.nextLine();

        System.out.println("Sorry you can't remove users who still have books checked out!");
    }

}
