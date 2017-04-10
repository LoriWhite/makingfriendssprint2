package user.details.testcases;

import static org.junit.Assert.*;


import org.junit.Test;

import user.details.mock.mockdbconnect;

public class testdatabaseconnection {


	@Test
	public void databaseConnectionTest()
	{
		mockdbconnect h1 = new mockdbconnect();
		assertNotNull(h1.connect());
		
	}
}
