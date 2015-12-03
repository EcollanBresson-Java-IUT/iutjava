package edu.iut.gui.frames;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import edu.iut.gui.widget.agenda.AgendaPanelFactory;
import edu.iut.gui.widget.agenda.ControlAgendaViewPanel;
import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;


public class SchedulerFrame extends JFrame {
	JPanel contentPane;
	CardLayout layerLayout;
	AgendaPanelFactory agendaPanelFactory;	
	JPanel dayView;
	JPanel weekView;
	JPanel monthView;

	protected void setupUI() {

		contentPane = new JPanel();
		layerLayout = new CardLayout();
		contentPane.setLayout(layerLayout);
		ControlAgendaViewPanel agendaViewPanel = new ControlAgendaViewPanel(layerLayout,contentPane);
		agendaPanelFactory = new AgendaPanelFactory();
		dayView = agendaPanelFactory.getAgendaView(ActiveView.DAY_VIEW);
		weekView = agendaPanelFactory.getAgendaView(ActiveView.WEEK_VIEW);
		monthView = agendaPanelFactory.getAgendaView(ActiveView.MONTH_VIEW);

		contentPane.add(dayView,ActiveView.DAY_VIEW.name());
		contentPane.add(weekView,ActiveView.WEEK_VIEW.name());
		contentPane.add(monthView,ActiveView.MONTH_VIEW.name());

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,agendaViewPanel, contentPane);
		this.setContentPane(splitPane);


		JMenuBar menuBar = new JMenuBar();
		JMenu menu, menuSub;		
		JMenuItem menuItem;


		/* File Menu */
		/** EX4 : MENU : UTILISER L'AIDE FOURNIE DANS LE TP**/
		// Menu File
				menu = new JMenu("File");
				menuBar.add(menu);
					menuItem = new JMenuItem("Load");
					menuItem.addActionListener(new MessageBoxListener());
					menu.add(menuItem);
					menuItem = new JMenuItem("Save");
					menuItem.addActionListener(new MessageBoxListener());
					menu.add(menuItem);
					menuItem = new JMenuItem("Quit");
					menuItem.addActionListener(new MessageBoxListener());
					menu.add(menuItem);
				
				// Menu Edit
				menu = new JMenu("Edit");
				menuBar.add(menu);
					menuSub = new JMenu("View");
					menu.add(menuSub);
						menuItem = new JMenuItem("Month");
						menuItem.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
							    layerLayout.show(contentPane, ActiveView.MONTH_VIEW.name());			
							}			
						});
						menuSub.add(menuItem);
						menuItem = new JMenuItem("Week");
						menuItem.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
							    layerLayout.show(contentPane, ActiveView.WEEK_VIEW.name());			
							}			
						});
						menuSub.add(menuItem);
						menuItem = new JMenuItem("Day");
						menuItem.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
							    layerLayout.show(contentPane, ActiveView.DAY_VIEW.name());			
							}			
						});
						menuSub.add(menuItem);
			
				// Menu Help
				menu = new JMenu("Help");
				menuBar.add(menu);
					menuItem = new JMenuItem("Display");
					menuItem.addActionListener(new MessageBoxListener());
					menu.add(menuItem);
					menuItem = new JMenuItem("About");
					menuItem.addActionListener(new MessageBoxListener());
					

					
				this.setJMenuBar(menuBar);
				this.pack();
				layerLayout.next(contentPane);
	}
	
	// ActionLister permettant de faire un evenement lorsque l'on clique sur un item du menu
		public class MessageBoxListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame messageBox = new JFrame();
				JOptionPane.showMessageDialog(messageBox,"Fonctionnalité non dispobible");
				
			}	
		}

	public SchedulerFrame() {
		super();

		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
		contentPane = null;
		dayView = null;
		weekView = null;
		monthView = null;
		agendaPanelFactory = null;
		setupUI();

	}
	public SchedulerFrame(String title) {
		super(title);
		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
		setupUI();
	}

}
