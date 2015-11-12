package edu.iut.gui.widget.agenda;

import java.awt.GridLayout;
import java.lang.Math;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JPanel;

import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;
import edu.iut.gui.widget.agenda.WeekPanel.WeekDayNames;

public class MonthPanel extends EventPanel {

	public MonthPanel() {
		super(ActiveView.MONTH_VIEW);
		GridLayout daysOfMonthLayout = new GridLayout(7,5);		
		this.setLayout(daysOfMonthLayout);
		GregorianCalendar calendar = new GregorianCalendar();	
		int dayOfMonth = calendar.get(calendar.DAY_OF_MONTH) % 7 - 1;
		
		int indice = 0;
		Date date = (new GregorianCalendar()).getTime();
	    String currentDay = new SimpleDateFormat("EEEE").format(date);
		
		if (currentDay.equals("lundi")) indice = 1;
		else if (currentDay.equals("mardi")) indice = 2;
		else if (currentDay.equals("mercredi")) indice = 3;
		else if (currentDay.equals("jeudi")) indice = 4 ;
		else if (currentDay.equals("vendredi")) indice = 5;
		else if (currentDay.equals("samedi")) indice = 6;
		else if (currentDay.equals("dimanche")) indice = 7;
		
		for (int i = dayOfMonth ; i > 0 ; i--) {
			indice--;
			if(indice == 0) indice = 7;
		}
		
		
		for (int di = 0;di<calendar.getActualMaximum(Calendar.DAY_OF_MONTH);di++) {
			JPanel day = new DayPanel(ActiveView.MONTH_VIEW,WeekDayNames.values()[indice]);
			if(indice == 7) indice = 0;
			indice++;
			this.add(day);
		}
	}

	private int abs(int indice) {
		// TODO Auto-generated method stub
		if (indice < 0) return -indice;
		return indice;
	}
}
