package edu.txstate.simpleLib_mlf96;

//
public class Journals extends Documents {

    //Default Constructor
    public Journals() {
    }
    
    public Journals(String journalTitle, String journalPublishDate, int journalVolume,
			int journalIssue, String journalPublisher, String journalArticles)
    {
    	title = journalTitle;
    	publishedDate = journalPublishDate;
    	volume = journalVolume;
    	issueNumber = journalIssue;
    	publisher = journalPublisher;
    	articles = journalArticles;
    }

    public int volume;
    public int issueNumber;
    public String articles;
}