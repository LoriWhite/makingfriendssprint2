package user.details.testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import user.details.validate;

public class validatePassword {


	@Test
	public void testValidatePassword() 
    {
		validate h1 = new validate();
		assertTrue(h1.validatePassword("root@123"));
		assertFalse("doesn't have at least one non letter characters except spaces",h1.validatePassword("root123"));
		assertFalse("doesn't have at least one letter character", h1.validatePassword("@1237853"));
		assertFalse("doesn't have at least one number", h1.validatePassword("@lwhite"));
		assertFalse("has at least one space", h1.validatePassword("root @123"));
		assertFalse("has less than seven characters", h1.validatePassword("k@123"));
		assertFalse("has more than twelve characters", h1.validatePassword("root@12378535"));
		assertFalse("is null", h1.validatePassword(""));
    }

}
