package edu.iut.app;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import edu.iut.app.Person.PersonFunction;

public class CriteriaTest {

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		ArrayList<Person> persons = new ArrayList<Person>();
		ArrayList<ExamEvent> date = new ArrayList<ExamEvent>();
		ArrayList<Document> doc = new ArrayList<Document>();
		ArrayList<Classroom> classroom = new ArrayList<Classroom>();

		persons.add(new Person(PersonFunction.JURY,"Jean", "Singleton", "jean.singleton@orange.fr", "+33 6 04 52 32 15"));
		persons.add(new Person(PersonFunction.JURY,"Natasha", "Rampalaoui", "rampage@yopmail.fr", "+33 6 04 52 32 15"));
		persons.add(new Person(PersonFunction.STUDENT,"Steve", "Ennyon", "stiviWonder@outlook.com", "+33 6 04 52 32 15"));
		persons.add(new Person(PersonFunction.STUDENT,"Charles", "Ecollan", "charlesLeCollant@dalprog.com", "+33 6 04 52 32 15"));
		persons.add(new Person(PersonFunction.NONE,"Sylvie", "Sanpeur", "pompier@caramail.fr", "+33 6 04 52 32 15"));
		persons.add(new Person(PersonFunction.NONE,"Lara", "Clette", "laRaclette@hotmail.fr", "+33 6 66 66 66 66"));

		doc.add(new Document("Fiche localisation"));
		doc.add(new Document("Convention de stage"));
		doc.add(new Document(""));
		doc.add(new Document("Fiche enrolement legion etrangere"));
		doc.add(new Document("Fiche de fish"));
		doc.add(new Document());

		classroom.add(new Classroom("128"));
		classroom.add(new Classroom("126"));
		classroom.add(new Classroom("202"));
		classroom.add(new Classroom(""));
		classroom.add(new Classroom("121"));
		classroom.add(new Classroom());

		date.add(new ExamEvent(new Date(),persons.get(0), new ArrayList<Person>(), classroom.get(0), new ArrayList<Document>()));
		date.add(new ExamEvent(new Date(),persons.get(1), new ArrayList<Person>(), classroom.get(1), new ArrayList<Document>()));
		date.add(new ExamEvent(new Date(),persons.get(2), new ArrayList<Person>(), classroom.get(2), new ArrayList<Document>()));
		date.add(new ExamEvent(new Date(),persons.get(3), new ArrayList<Person>(), classroom.get(3), new ArrayList<Document>()));
		date.add(new ExamEvent(new Date(),persons.get(4), new ArrayList<Person>(), classroom.get(4), new ArrayList<Document>()));
		date.add(new ExamEvent());

		Criteria jury = new CriteriaPersonJury();
		Criteria student = new CriteriaPersonStudent();

		Criteria docInit = new CriteriaDocInit();

		Criteria dateInit = new CriteriaDateInit();
		
		Criteria classInit = new CriteriaClassroomInit();

		System.out.println("Membres de jurys : ");
		printPersons((ArrayList<Object>) jury.meetCriteria(persons));
		System.out.println("\nEleves : ");
		printPersons((ArrayList<Object>) student.meetCriteria(persons));

		
		System.out.println("\nDocument initialis�s : \n");
		printPersons((ArrayList<Object>) docInit.meetCriteria(doc));
		
		System.out.println("\nExamen avec une date definie : \n");
		printPersons((ArrayList<Object>) dateInit.meetCriteria(date));

		System.out.println("\nClasses avec un numero initialis� : \n");
		printPersons((ArrayList<Object>) classInit.meetCriteria(classroom));

	}

	public static void printPersons(ArrayList<Object> list){

		for (Object element : list) {
			switch (element.getClass().getName().toLowerCase()) {
			
			case "edu.iut.app.person" :
				System.out.print("\nNom : " + ((Person) element).getFirstname() + "\t");
				System.out.print("\nPrenom : " + ((Person) element).getLastname() + "\t");
				System.out.print("\nEmail : " + ((Person) element).getEmail() + "\t");
				System.out.println("\nTelephone : " + ((Person) element).getPhone());
				break;
			case "edu.iut.app.classroom" :
				System.out.println("Numero de la salle : " + ((Classroom) element).getClassRoomNumber());
				break;
			case "edu.iut.app.document" :
				System.out.println("Nom du document : " + ((Document) element).getDocumentURI());
				break;
			case "edu.iut.app.examevent" :
				System.out.println("Date de l'examen : " + ((ExamEvent) element).getExamDate() + "\t");
				break;
			default : fail("Donn�es des crit�res incorrectes");
			}
		}
	}

}
