package edu.iut.app;

import java.util.ArrayList;

public class CriteriaClassroomInit implements CriteriaClassroom {

	@Override
	public ArrayList<Classroom> meetCriteria(ArrayList<?> list) {
		// TODO Auto-generated method stub
		ArrayList<Classroom> classroom = new ArrayList<Classroom>(); 
		for (Object event : list) {
			if(event.getClass().getName().toLowerCase().equals("edu.iut.app.classroom")){
				classroom.add((Classroom) event);
			}
		}
		
		ArrayList<Classroom> classInit = new ArrayList<Classroom>(); 

		for (Classroom event : classroom) {
			if(!((event.getClassRoomNumber().toLowerCase().equals("not affected")) || (event.getClassRoomNumber().toLowerCase().equals(""))) ){
				classInit.add(event);
			}
		}
		return classInit;
	}

}
