package edu.txstate.simpleLib_mlf96;

//Subclass of documents with
//new attributes volume, issueNumber, and articles
public class Journals extends Documents {
    
    public Journals(String journalTitle, String journalPublishDate, int journalVolume,
			int journalIssue, String journalPublisher, String journalArticles, int copies, String journalLocation)
    {
    	title = journalTitle;
    	publishedDate = journalPublishDate;
    	volume = journalVolume;
    	issueNumber = journalIssue;
    	publisher = journalPublisher;
    	articles = journalArticles;
    	numberOfCopies = copies;
    	location = journalLocation;
    }

    public int volume;		//volume of journal
    public int issueNumber; //issue number of journal
    public String articles; //list of articles in journal
}