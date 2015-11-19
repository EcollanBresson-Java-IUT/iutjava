package edu.iut.gui.widget.agenda;

import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.JPanel;

import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;
import edu.iut.app.ApplicationSession;

public class WeekPanel extends EventPanel {

	// Exercice 4
	
	private static ApplicationSession session = ApplicationSession.instance();
	
	public enum WeekDayNames {
		EMPTYDAY("",""),
		MONDAY(session.getString("monday"), session.getString("mon")),/* Internationalisation */
		TUESDAY(session.getString("tuesday"), session.getString("tue")),/* Internationalisation */
		WEDNESDAY(session.getString("wednesday"), session.getString("wed")),/* Internationalisation */
		THURSDAY(session.getString("thursday"), session.getString("thu")),/* Internationalisation */
		FRIDAY(session.getString("friday"), session.getString("fri")),/* Internationalisation */
		SATURDAY(session.getString("saturday"), session.getString("sat")),/* Internationalisation */
		SUNDAY(session.getString("sunday"), session.getString("sun"));/* Internationalisation */
		
		private String name;
		private String shortName;
		
		WeekDayNames(String name,String shortName) {
			this.name = name;
			this.shortName = shortName;
		}
		
		public String getShortName() {
			return shortName;
		}
		
		public String toString() {
			return name;
		}
	}
	
	public WeekPanel() {
		super(ActiveView.WEEK_VIEW);
		GridLayout daysOfWeekLayout = new GridLayout(1,7);		
		this.setLayout(daysOfWeekLayout);
		for (int di = 0;di<8;di++)	{
			this.add(new DayPanel(ActiveView.WEEK_VIEW,WeekDayNames.values()[di+1]));
		}
	}
}
