package com.questionnare.model;

public class Paper {
	
	String paperID;
	String title;
	String description;
	String userID;
	int questionCount;
	int finishedCount;
	
	public Paper(){
		
	}
    public Paper(String paperID,String title,String description,String userID,int questionCount,int finishedCount){
		this.paperID=paperID;
		this.title=title;
		this.description=description;
		this.userID=userID;
		this.questionCount=questionCount;
		this.finishedCount=finishedCount;
	}
	public String getPaperID() {
		return paperID;
	}
	public void setPaperID(String paperID) {
		this.paperID = paperID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}
	public int getFinishedCount() {
		return finishedCount;
	}
	public void setFinishedCount(int finishedCount) {
		this.finishedCount = finishedCount;
	}
}
