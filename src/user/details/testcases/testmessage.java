package user.details.testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import user.details.send;

public class testmessage {

			@Test
		public void checkMessageTest() 
		{
			send m = new send();
			
			assertTrue(m.checkMessage("Hi how are you?"));
			assertTrue(m.checkMessage("hiii "));
			assertFalse(m.checkMessage("..."));
			assertFalse(m.checkMessage("        "));
		}
		

	}

