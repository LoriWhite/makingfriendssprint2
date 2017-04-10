package user.details.testcases;

import static org.junit.Assert.*;


import org.junit.Test;

import user.details.send;

public class testrecipient {

		@Test
	public void recipientCheckTest()
    {
        send m = new send();
        assertTrue(m.recipientTest("santhosh1", "lwhite"));
        assertFalse(m.recipientTest("anjani", "lwhite"));
        assertFalse(m.recipientTest("", "lwhite"));
        assertFalse(m.recipientTest("", ""));
    }

}
