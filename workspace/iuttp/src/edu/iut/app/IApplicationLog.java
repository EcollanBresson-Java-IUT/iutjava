package edu.iut.app;

public interface IApplicationLog {
	/** TP1 : Créer les mÃ©thodes :*/

	void setMessage(String message);
	String getMessage();
	void addListener(IApplicationLogListener listener);
	IApplicationLogListener[] getpplicationLogListeners();

}
