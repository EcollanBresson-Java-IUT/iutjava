package edu.iut.app;

import java.util.ArrayList;

public class CriteriaDateNotInit implements CriteriaDate {
	
	public ArrayList<ExamEvent> meetCriteria(ArrayList<?> list) {

		ArrayList<ExamEvent> exEvent = new ArrayList<ExamEvent>(); 
		for (Object event : list) {
			if(event.getClass().getName().toLowerCase().equals("edu.iut.app.examevent")){
				exEvent.add((ExamEvent) event);
			}
		}
		
		ArrayList<ExamEvent> examDateNotSettled = new ArrayList<ExamEvent>(); 

		for (ExamEvent event : exEvent) {
			if(event.getExamDate() == null){
				examDateNotSettled.add(event);
			}
		}
		return examDateNotSettled;
	}

}