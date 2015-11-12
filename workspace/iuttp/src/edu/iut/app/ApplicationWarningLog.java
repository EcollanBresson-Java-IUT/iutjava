package edu.iut.app;

public class ApplicationWarningLog extends AbstractApplicationLog {

	/** On profite de l'héritage en conservant le tableau. */
	public ApplicationWarningLog() {
		super();
	}
	
	@Override
	public void setMessage(String message) {
		this.message = message;
		super.fireMessage("[WARNING]", this.message);
	}

}
