package edu.iut.app;

import java.util.ArrayList;

public abstract class AbstractApplicationLog implements IApplicationLog {

	protected String message;
	/** TP1 : Tableau au sens des collections **/
	protected ArrayList<IApplicationLogListener> listeners;

	public AbstractApplicationLog() {
		message = null;
		listeners = new ArrayList<IApplicationLogListener>();
	}

	/** TP1 : Fonction venant de l'interface par héritage */

	public abstract void setMessage(String message);

	public void addListener(IApplicationLogListener l) {

		this.listeners.add(l);

	}

	public String getMessage() {

		return this.message;

	}
	
	public IApplicationLogListener[] getpplicationLogListeners() {

		int i = 0;
		IApplicationLogListener[] tab = new IApplicationLogListener[(this.listeners).size()];
		for (IApplicationLogListener ia : this.listeners) {
			
			tab[i] = ia;
			i++;
			
		}
		
		return tab;

	}


	/** Listener action */
	protected void fireMessage(String level, String message) {
		for (IApplicationLogListener listener_i : listeners) {
			listener_i.newMessage(level, message);
		}
	}

	
}
