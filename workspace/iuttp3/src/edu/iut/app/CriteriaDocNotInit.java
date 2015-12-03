package edu.iut.app;

import java.util.ArrayList;

public class CriteriaDocNotInit implements CriteriaDocument {
	
	public ArrayList<Document> meetCriteria(ArrayList<?> list) {

		ArrayList<Document> doc = new ArrayList<Document>(); 
		for (Object obj : list) {
			if(obj.getClass().getName().toLowerCase().equals("edu.iut.app.document")){
				doc.add((Document) obj);
			}
		}
		
		ArrayList<Document> docNotSettled = new ArrayList<Document>(); 

		for (Document event : doc) {
			if(event.getDocumentURI().equals("")){
				docNotSettled.add(event);
			}
		}
		return docNotSettled;
		
	}

}
