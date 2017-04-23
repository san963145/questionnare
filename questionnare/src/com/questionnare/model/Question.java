package com.questionnare.model;

public class Question {
	
	String questionID;
	String title;
	String type;
	String itemA;
	String itemB;
	String itemC;
	String itemD;
	String itemE;
	String itemF;
	String paperID;
	
	public Question(){
		
	}
	
	public Question(String questionID, String title, String type, String itemA, String itemB, String itemC,
			String itemD, String itemE, String itemF, String paperID) {
		super();
		this.questionID = questionID;
		this.title = title;
		this.type = type;
		this.itemA = itemA;
		this.itemB = itemB;
		this.itemC = itemC;
		this.itemD = itemD;
		this.itemE = itemE;
		this.itemF = itemF;
		this.paperID = paperID;
	}
	public String getQuestionID() {
		return questionID;
	}
	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getItemA() {
		return itemA;
	}
	public void setItemA(String itemA) {
		this.itemA = itemA;
	}
	public String getItemB() {
		return itemB;
	}
	public void setItemB(String itemB) {
		this.itemB = itemB;
	}
	public String getItemC() {
		return itemC;
	}
	public void setItemC(String itemC) {
		this.itemC = itemC;
	}
	public String getItemD() {
		return itemD;
	}
	public void setItemD(String itemD) {
		this.itemD = itemD;
	}
	public String getItemE() {
		return itemE;
	}
	public void setItemE(String itemE) {
		this.itemE = itemE;
	}
	public String getItemF() {
		return itemF;
	}
	public void setItemF(String itemF) {
		this.itemF = itemF;
	}
	public String getPaperID() {
		return paperID;
	}
	public void setPaperID(String paperID) {
		this.paperID = paperID;
	}
	
	

}
