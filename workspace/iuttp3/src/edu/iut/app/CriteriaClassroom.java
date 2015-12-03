package edu.iut.app;

import java.util.ArrayList;

public interface CriteriaClassroom extends Criteria {
	public ArrayList<Classroom> meetCriteria(ArrayList<?> element);
}
