package edu.iut.app;

import java.util.ArrayList;

public class Agenda extends ArrayList<ExamEvent> {
	public Agenda() {
		super();
	}
	
	public void addCheckedEvent(ExamEvent examEvent) {
		this.add(examEvent);
	}
	
}
