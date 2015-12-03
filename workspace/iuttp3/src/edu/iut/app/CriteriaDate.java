
package edu.iut.app;

import java.util.ArrayList;

public interface CriteriaDate extends Criteria {
	public ArrayList<ExamEvent> meetCriteria(ArrayList<?> dateEvent);
}
