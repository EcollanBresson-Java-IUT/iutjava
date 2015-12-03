package edu.iut.app;

import java.util.ArrayList;

import edu.iut.app.Person.PersonFunction;

public class CriteriaPersonStudent implements CriteriaPerson {

	@Override
	public ArrayList<Person> meetCriteria(ArrayList<?> list) {
		// TODO Auto-generated method stub
		
		ArrayList<Person> pers = new ArrayList<Person>(); 
		for (Object event : list) {
			if(event.getClass().getName().toLowerCase().equals("edu.iut.app.person")){
				pers.add((Person) event);
			}
		}
		
		ArrayList<Person> studentPersons = new ArrayList<Person>(); 
	      
	      for (Person person : pers) {
	         if(person.getFunction() == PersonFunction.STUDENT){
	            studentPersons.add(person);
	         }
	      }
	      return studentPersons;
	}

}
