package edu.iut.app;

import java.util.ArrayList;

public interface CriteriaDocument extends Criteria {
	public ArrayList<Document> meetCriteria(ArrayList<?> list);
}
