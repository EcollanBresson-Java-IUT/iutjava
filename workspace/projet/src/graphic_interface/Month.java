package graphic_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import session.Session;
import frame.MainFrame;
import graphic_interface.Week.WeekDayNames;

public class Month extends CurrentView implements ActionListener {
	
	private JPanel topPanel;
	private JPanel underPanel;
	private GregorianCalendar calendar;

	/**
	 * Constructor of Month class
	 */
	public Month () {
		super(ActiveView.MONTH_VIEW);
		this.calendar = new GregorianCalendar();
		this.changeMonth(1);
		this.setupMonth();
	}
		
	/**
	 * Initialise the month view to the current month
	 */
	public void setupMonth() {
		
		topPanel = new JPanel();
		underPanel = new JPanel();
		
		GridLayout daysOfMonthLayout = new GridLayout(5,7);		
		underPanel.setLayout(daysOfMonthLayout);
		this.setLayout(new BorderLayout());
		
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH) % 7 - 1;

		int indice = 0;
		Date date = (this.calendar.getTime());
		String currentDay = new SimpleDateFormat("EEEE").format(date).toLowerCase();

		String month = "";
		int currentMonth = calendar.get(Calendar.MONTH);
		String currentYear = String.valueOf(calendar.get(Calendar.YEAR));

		switch (currentMonth) {

		case 0 : month = Session.instance().getString("january");break;
		case 1 : month = Session.instance().getString("february");break;
		case 2 : month = Session.instance().getString("march");break;
		case 3 : month = Session.instance().getString("april");break;
		case 4 : month = Session.instance().getString("may");break;
		case 5 : month = Session.instance().getString("june");break;
		case 6 : month = Session.instance().getString("july");break;
		case 7 : month = Session.instance().getString("august");break;
		case 8 : month = Session.instance().getString("september");break;
		case 9 : month = Session.instance().getString("october");break;
		case 10 : month = Session.instance().getString("november");break;
		case 11 : month = Session.instance().getString("december");break;
		default : month = "not found";

		}

		JLabel monthDate = new JLabel(month + " " + currentYear);
		JButton previous = new JButton("Precedent");
		previous.addActionListener(this);
		JButton next = new JButton("Suivant");
		next.addActionListener(this);
		topPanel.add(previous);
		topPanel.add(monthDate);
		topPanel.add(next);
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		if (currentDay.equals(Session.instance().getString("monday").toLowerCase())) indice = 1;
		else if (currentDay.equals(Session.instance().getString("tuesday").toLowerCase())) indice = 2;
		else if (currentDay.equals(Session.instance().getString("wednesday").toLowerCase())) indice = 3;
		else if (currentDay.equals(Session.instance().getString("thursday").toLowerCase())) indice = 4 ;
		else if (currentDay.equals(Session.instance().getString("friday").toLowerCase())) indice = 5;
		else if (currentDay.equals(Session.instance().getString("saturday").toLowerCase())) indice = 6;
		else if (currentDay.equals(Session.instance().getString("sunday").toLowerCase())) indice = 7;
		
		JPanel day = new JPanel();
		if(dayOfMonth == -1) {
			indice++;
		}else{
			for (int i = dayOfMonth ; i > 0 ; i--) {
				indice--;
				if(indice == 0) indice = 7;
			}
		}
		for (int i = 0 ; i < indice; i++){
			day = new Day(ActiveView.MONTH_VIEW, WeekDayNames.EMPTYDAY);
			underPanel.add(day);
		}
		for (int di = 0;di<calendar.getActualMaximum(Calendar.DAY_OF_MONTH);di++) {

			day = new Day(ActiveView.MONTH_VIEW,WeekDayNames.values()[indice]);
			day.setBorder(BorderFactory.createLineBorder(Color.black));
			if(indice == 7) indice = 0;
			indice++;
			underPanel.add(day);
		}
		this.add(topPanel, BorderLayout.PAGE_START);
		this.add(underPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Change the current month of the GregorianCalendar attribute
	 * @param month
	 */
	public void changeMonth(int month){
		this.calendar.add(this.calendar.MONTH, month);
		this.changeMonthView();
	}
	
	/**
	 * Change the view depending of changes like a movement in time or a change of language
	 */
	public void changeMonthView() {
		topPanel = new JPanel();
		underPanel = new JPanel();
		
		GridLayout daysOfMonthLayout = new GridLayout(5,7);		
		underPanel.setLayout(daysOfMonthLayout);
		this.setLayout(new BorderLayout());
		
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH) % 7 - 1;

		int indice = 0;
		Date date = (this.calendar.getTime());
		String currentDay = new SimpleDateFormat("EEEE").format(date).toLowerCase();

		String month = "";
		int currentMonth = calendar.get(Calendar.MONTH);
		String currentYear = String.valueOf(calendar.get(Calendar.YEAR));

		switch (currentMonth) {

		case 0 : month = Session.instance().getString("january");break;
		case 1 : month = Session.instance().getString("february");break;
		case 2 : month = Session.instance().getString("march");break;
		case 3 : month = Session.instance().getString("april");break;
		case 4 : month = Session.instance().getString("may");break;
		case 5 : month = Session.instance().getString("june");break;
		case 6 : month = Session.instance().getString("july");break;
		case 7 : month = Session.instance().getString("august");break;
		case 8 : month = Session.instance().getString("september");break;
		case 9 : month = Session.instance().getString("october");break;
		case 10 : month = Session.instance().getString("november");break;
		case 11 : month = Session.instance().getString("december");break;
		default : month = "not found";

		}

		JLabel monthDate = new JLabel(month + " " + currentYear);
		JButton previous = new JButton("Precedent");
		previous.addActionListener(this);
		JButton next = new JButton("Suivant");
		next.addActionListener(this);
		topPanel.add(previous);
		topPanel.add(monthDate);
		topPanel.add(next);
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		if (currentDay.equals(Session.instance().getString("monday").toLowerCase())) indice = 1;
		else if (currentDay.equals(Session.instance().getString("tuesday").toLowerCase())) indice = 2;
		else if (currentDay.equals(Session.instance().getString("wednesday").toLowerCase())) indice = 3;
		else if (currentDay.equals(Session.instance().getString("thursday").toLowerCase())) indice = 4 ;
		else if (currentDay.equals(Session.instance().getString("friday").toLowerCase())) indice = 5;
		else if (currentDay.equals(Session.instance().getString("saturday").toLowerCase())) indice = 6;
		else if (currentDay.equals(Session.instance().getString("sunday").toLowerCase())) indice = 7;
		
		JPanel day = new JPanel();
		if(dayOfMonth == -1) {
			indice++;
		}else{
			for (int i = dayOfMonth ; i > 0 ; i--) {
				indice--;
				if(indice == 0) indice = 7;
			}
		}
		for (int i = 0 ; i < indice; i++){
			day = new Day(ActiveView.MONTH_VIEW, WeekDayNames.EMPTYDAY);
			underPanel.add(day);
		}
		for (int di = 0;di<calendar.getActualMaximum(Calendar.DAY_OF_MONTH);di++) {

			day = new Day(ActiveView.MONTH_VIEW,WeekDayNames.values()[indice]);
			day.setBorder(BorderFactory.createLineBorder(Color.black));
			if(indice == 7) indice = 0;
			indice++;
			underPanel.add(day);
		}
		this.remove(topPanel);
		this.remove(underPanel);
		this.add(topPanel);
		this.add(underPanel);
		this.validate();
	}


	/**
	 * Move forward or backward in the agenda, depending of the ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String BoutonPresse = ((String) arg0.getActionCommand().toLowerCase());
		switch(BoutonPresse) {
		case "suivant" :
			this.changeMonth(1);
			
			//Répercuter le changement sur la JFrame
			break;
		case "precedent" :
			this.changeMonth(-1);
			//Répercuter le changement sur la JFrame
			break;
		default:break;
		}
		
	}
}