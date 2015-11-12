package edu.iut.gui.listeners;

import edu.iut.app.IApplicationLogListener;

public abstract class AbstractApplicationMessageDialog implements IApplicationLogListener {

	@Override
	public void newMessage(String level, String message) {
	 /* TP1 : CODE A FOURNIR */
		showMessage(level, message);
		
	}
	
	/* TP1 ajouter une méthode abstraite showMessage */
	protected abstract void showMessage(String level, String message);

}
