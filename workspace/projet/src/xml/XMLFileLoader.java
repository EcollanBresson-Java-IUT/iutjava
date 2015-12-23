package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import presentation.Classroom;
import presentation.Person;
import presentation.Person.PersonFunction;
import presentation.Presentation;
import frame.MainFrame;

public class XMLFileLoader {
	
	/**Load the information in a xml file selected by the user and return an ArrayList of Presentation Object from this file.
	 * @return ArrayList<Presentation>
	 * @throws Exception
	 */
	public ArrayList<Presentation> LoadXMLFile() throws Exception {
		
		ArrayList<Presentation> presentations = new ArrayList<Presentation>();
		try{
			
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse (new File(this.chooseFile()));
			
			doc.getDocumentElement().normalize();
			
			NodeList listOfPresentation = doc.getElementsByTagName("presentation");
            for (int event_i = 0 ; event_i < listOfPresentation.getLength() ; event_i++) {
            	
            	Classroom c1 = new Classroom();
            	ArrayList<presentation.Document> docPres = new ArrayList<presentation.Document>();
            	Person student = new Person();
            	ArrayList<Person> jury = new ArrayList<Person>();
            	Date date = new Date();
            	
            	NodeList val;
            	
            	Element presentation = (Element) listOfPresentation.item(event_i);
            	String attr1 = presentation.getAttribute("date");
            	String attr2 = presentation.getAttribute("duration");
            	
            	date = XMLFileSave.convertStringToDate(attr1);
            	
            	NodeList studentList = presentation.getElementsByTagName("Student");
            	val = studentList.item(0).getChildNodes();
            	String firstname = val.item(1).getTextContent();
            	String lastName = val.item(2).getTextContent();
            	String email = val.item(3).getTextContent();
            	String phone = val.item(4).getTextContent();
            	student = new Person(PersonFunction.STUDENT, firstname, lastName, email, phone);
            	
            	NodeList juryList = presentation.getElementsByTagName("Jury_Members");
            	for (int i = 0 ; i < juryList.getLength(); i++) {
            		val = juryList.item(i).getChildNodes();
            		firstname = val.item(0).getTextContent();
                	lastName = val.item(1).getTextContent();
                	email = val.item(2).getTextContent();
                	phone = val.item(3).getTextContent();
                	jury.add(new Person(PersonFunction.JURY, firstname, lastName, email, phone));
            	}
            	
            	NodeList classList = presentation.getElementsByTagName("Room");
            	Element e = (Element) classList.item(0);
            	String classroomnumber =  e.getAttribute("Number");
            	c1.setClassroomNumber(classroomnumber);
            	
            	String docName = "";
            	NodeList docList = presentation.getElementsByTagName("Document");
            	for (int i = 0 ; i < juryList.getLength(); i++) {
            		val = docList.item(i).getChildNodes();
            		docName = val.item(0).getTextContent();
                	docPres.add(new presentation.Document(docName));
            	}
            	presentations.add(new Presentation(date, student, jury, c1, docPres));
            }
			
		}catch(Exception e){
			System.err.println("Error while loading the XML file");
		}
		
		return presentations;
	}
	
	/**This method demand to the user to select a xml file, by using a JFileChooser Object
	 * The selected xml file must contain the correct informations in order to be used
	 * @return
	 */
	private String chooseFile(){
		
		JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "XML files", "xml");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(MainFrame.instance());
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	    }
		
		return chooser.getSelectedFile().getAbsolutePath();
	}

}
