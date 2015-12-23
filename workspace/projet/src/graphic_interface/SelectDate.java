package graphic_interface;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import session.Session;

public class SelectDate extends JPanel {
	
	CardLayout agendaViewLayout;
	JPanel contentPane;
	
	int selectedYear;
	int selectedMonth;
	int selectedDay;
	
	/**
	 * Constructor for the SelectDate object. Create one spinner and two ComboBox to represent a Date
	 * @param layerLayout
	 * @param contentPane
	 */
	public SelectDate(CardLayout layerLayout, final JPanel contentPane) {

		this.agendaViewLayout = layerLayout;
		this.contentPane = contentPane;
		JPanel commandPanel = new JPanel();
		JPanel bottom = new JPanel();
		commandPanel.setLayout(new BoxLayout(commandPanel, BoxLayout.PAGE_AXIS));
		Calendar calendar = Calendar.getInstance();
        SpinnerNumberModel dateModel = new SpinnerNumberModel(calendar.get(Calendar.YEAR),
        												calendar.get(Calendar.YEAR)-5,
        												calendar.get(Calendar.YEAR)+5,
        												1);
        JSpinner  yearsSpinner       = new JSpinner(dateModel);
        yearsSpinner.setEditor(new JSpinner.NumberEditor(yearsSpinner, "#"));
		JComboBox monthComboBox      = new JComboBox(Session.instance().getMonths());
		JComboBox daysOfWeekComboBox = new JComboBox(Session.instance().getDays());
		commandPanel.add(yearsSpinner);
		commandPanel.add(monthComboBox);
		commandPanel.add(daysOfWeekComboBox);
		this.add(commandPanel, BorderLayout.CENTER);
        this.add(bottom, BorderLayout.PAGE_END);
	}
	
	public int getYear() {
		return selectedYear;
	}
	public int getMonth() {
		return selectedMonth;
	}
	public int getDay() {
		return selectedDay;
	}

}
