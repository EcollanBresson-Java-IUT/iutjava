package edu.iut.app;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class AbstractApplicationLogTest {

	@Test
	public void getandsetMessagetest() {
		
		String message = "Test des methodes AbstractApplicationLog";
		ApplicationInfoLog testAppliLog = new ApplicationInfoLog();
		testAppliLog.setMessage(message);
		
		if (!message.equals(testAppliLog.getMessage())) fail("Error in setmessage or getmessage method");
		
	}

}
