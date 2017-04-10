package user.details.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import user.details.validate;

public class validateUsername {



	@Test
	public void testValidateUsername() 
    {
		validate h1 = new validate();
        assertTrue("Username already exists",h1.validateusername("shanmukhi"));
        assertFalse("Username Does not exist", h1.validateusername("loriwhite"));
        assertFalse("Username Does not exist", h1.validateusername("saisusheel"));
    }
}
