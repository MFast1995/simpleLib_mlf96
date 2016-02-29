package edu.txstate.simpleLib_mlf96;

//
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

    public int volume;
    public int issueNumber;
    public String articles;
}