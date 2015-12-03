package edu.iut.app;

import java.util.ArrayList;

public interface CriteriaPerson extends Criteria {
	public ArrayList<Person> meetCriteria(ArrayList<?> persons);
}
