package edu.iut.app;

import java.util.ArrayList;

public class CriteriaDateInit implements CriteriaDate{

	public ArrayList<ExamEvent> meetCriteria(ArrayList<?> list) {

		ArrayList<ExamEvent> exEvent = new ArrayList<ExamEvent>(); 
		for (Object event : list) {
			if(event.getClass().getName().toLowerCase().equals("edu.iut.app.examevent")){
				exEvent.add((ExamEvent) event);
			}
		}
		
		ArrayList<ExamEvent> examDateSettled = new ArrayList<ExamEvent>(); 

		for (ExamEvent event : exEvent) {
			if(!(event.getExamDate() == null)){
				examDateSettled.add(event);
			}
		}
		return examDateSettled;
	}

}
