package com.questionnare.model;

import java.util.ArrayList;

public class FullPaper {
	
	Paper paper;
	ArrayList<Question> questions=new ArrayList<Question>();
	
	public FullPaper(){
		
	}
	public FullPaper(Paper paper, ArrayList<Question> questions) {
		super();
		this.paper = paper;
		this.questions = questions;
	}
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	

}
