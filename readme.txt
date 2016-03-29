Welcome to the University Library

Upon opening, the program will prompt the user what file they want
to receive input from. Two options are available: text file and
serial. Press the corresponding number to the file you want to
import. The program will then initialize the user and documents
ArrayList from the specified file.

Once initialized, the program will ask if you are a student, 
faculty, or librarian, or if you want to exit the program. Exiting 
the program will save any changes made and terminate the program.

Enter the account type you wish to access by pressing the 
corresponding number and pressing enter.

The program will then ask you to enter an account ID. This account ID
MUST match to an account with the same account type previously
specified. 

For sake of testing, the following are account types with valid IDs

Faculty 	1, 2, 7, 9	
Student 	3, 4, 8	
Librarian 	5, 6

When an account has been successfully entered, the account will then 
be marked as the active account. The screen will  pull up a 
list of options corresponding to the account type. Student (user) 
accounts are able to search documents, borrow, and return. Faculty
(admin) accounts are able to search the library, borrow, return, 
add users, and view/remove users. Librarian accounts  can search
documents, borrow, return, add users, add documents, and view
all documents that have been checked out.

Search Library by Title
	This will prompt the user to enter a title (case sensitive). The
	function will then search the library. If a document with the 
	matching title is found, it will then ask the user if they want 
	to borrow the document. If the user has not reached their max
	borrowing limit and there are still copies available, the user
	will successfully be able to borrow the document.

	Example: Hadoop Big data
	Example: COMMON FRAMEWORK

Search Library by Author
	This will prompt the user to enter an author (case sensitive).
	The function will then search the library. If a document with
	a matching author is found, it will then ask the user if they
	want to borrow the document. If the user has not reached their
	max borrowing limit and there are still copies available, the
	user will successfully be able to borrow the document.

	Example: Jo Wood

Search Library by Publisher
	This will prompt the user to enter a publisher (case sensitive).
	The function will then search the library. If a document with
	a matching author is found, it will then ask the user if they
	want to borrow the document. If the user has not reached their
	max borrowing limit and there are still copies available, the
	user will successfully be able to borrow the document.

	Example: CRC Press

View Borrowed Books / Return Books
	This will display a list of all documents the user is currently 
	borrowing. It will then ask the user if they want to return a
	document. If the user chooses yes, the user will be asked to 
	enter the number corresponding to the document they wish to 
	return. Doing so will remove the document from thier borrowed
	list and add the document back to the documents ArrayList.

Add User (Admin and Librarian View Only)
	This will prompt the user for a name to go with the new account
	and the type of account.

Add Document (Librarian View Only)
	This will prompt the user for what type of document they wish to 
	enter. Depending on document chosen, will prompt for various 
	attributes of the document one by one. 

View/Remove Users (Admin View Only)
	This will list all users that currently have an account ID with
	the library. It will then prompt the user if they want to 
	remove a user.

View Checked Out Documents (Librarian View Only)
	This will list all documents checked out the library along with
	the name of the borrower.


*************************
Errors and Issues
*************************
	+Searching is case sensitive and must be exact

	+Authors, even multiple, are stored as a string instead of 
	multiple Author classes