Welcome to the University Library

Upon opening, the program will initialize the user and documents
ArrayList from the specified files (declared at the top of the University_Library class)

Once initialized, the program will ask if you are a student, 
faculty, or librarian. Or if you want to exit the program. Exiting 
the program will save any changes made and terminate the program

Enter the account type you wish to access by pressing the 
corresponding number and pressing enter.

The program will then ask you to enter an account ID. This account ID
MUST match to an account with the same account type previously
specified. 

For sake of testing, the following are account types with valid IDs

Faculty 	1, 2, 7		Example: 7 Anne Ngu
Student 	3, 4, 8		Example: 8 Michelle Fast
Librarian 	5, 6		Example: 5 Cody Kern

When an account has been successfully entered, the account will then 
be marked as the active account. The screen will then pull up a 
list of options corresponding to the account type. Faculty and 
Student accounts are able to update account name, search library by 
title or author, or view books currently borrowed. Librarian 
accounts are able to also add documents to the library, register new 
users, and save any changes made to the system.

Update Account
	Requesting to update account will prompt user to enter a name
	Pressing enter will change the name of the active account.

Search Library by Title
	This will prompt the user to enter a title (case sensitive). The
	function will then search the library. If a document with the 
	matching title is found, it will then ask the user if they want 
	to borrow the document. If the user has not reached their max
	borrowing limit and there are still copies available, the user
	will successfully be able to borrow the document

	Example: Hadoop Big data
	Example: COMMON FRAMEWORK

Search Library by Author
	This will prompt the user to enter an author (case sensitive).
	The function will then search the library. If a document with
	a matching author is found, it will then ask the user if they
	want to borrow the document. If the user has not reached their
	max borrowing limit and there are still copies available, the
	user will successfully be able to borrow the document

	Example: Jo Wood

View Borrowed Books / Return Books
	This will display a list of all documents the user is currently 
	borrowing. It will then ask the user if they want to return a
	document. If the user chooses yes, the user will be asked to 
	enter the number corresponding to the document they wish to 
	return. Doing so will remove the document from thier borrowed
	list and add the document back to the documents ArrayList

Add User (Librarians Only)
	This will prompt the user for a name to go with the new account
	and the type of account.

Add Document (Librarians Only)
	This will prompt the user for what type of document they wish to 
	enter. Depending on document chosen, will prompt for various 
	attributes of the document one by one. 

Save System (Librarians Only)
	Saves any changes made to the system without closing the program



*************************
Errors and Issues
*************************
	+Program will crash if non-numerical input is given whenever a 
	number is expected

	+Searching is case sensitive and must be exact

	+Authors, even multiple, are stored as a string instead of 
	multiple Author classes