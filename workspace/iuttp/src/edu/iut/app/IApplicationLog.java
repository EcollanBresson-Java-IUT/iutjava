package edu.iut.app;

public interface IApplicationLog {
	/** TP1 : Cr�er les méthodes :*/

	void setMessage(String message);
	String getMessage();
	void addListener(IApplicationLogListener listener);
	IApplicationLogListener[] getpplicationLogListeners();

}
