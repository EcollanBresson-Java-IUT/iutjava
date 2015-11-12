package edu.iut.app;

import java.util.ArrayList;


public class ApplicationLogs extends ArrayList<IApplicationLog> {

	public ApplicationLogs() {
	}

	public ArrayList<IApplicationLog> getErrors() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		// une boucle à faire ici, penser à utiliser instanceof
		for (IApplicationLog listener : this) {

			if(listener instanceof ApplicationErrorLog ) filteredLogs.add(listener);

		}
		return filteredLogs;
	}
	public ArrayList<IApplicationLog> getWarnings() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		// une boucle à faire ici, penser à utiliser instanceof
		for (IApplicationLog listener : this) {

			if(listener instanceof ApplicationWarningLog ) filteredLogs.add(listener);

		}
		return filteredLogs;
	}
	public ArrayList<IApplicationLog> getInfos() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		// une boucle à faire ici, penser à utiliser instanceof
		for (IApplicationLog listener : this) {

			if(listener instanceof ApplicationInfoLog ) filteredLogs.add(listener);

		}
		return filteredLogs;
	}


}
