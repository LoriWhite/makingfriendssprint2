package user.details.testcases;

import static org.junit.Assert.*;


import org.junit.Test;

import user.details.validate;

public class validateDob {

	

	@Test
	public void testValidateDob() 
    {
		validate h1 = new validate();
		assertTrue(h1.validateBirthDate("01/24/1995"));
		assertFalse("not in dob format", h1.validateBirthDate("64456165"));
		assertFalse("month is not in the right format", h1.validateBirthDate("555/25/1987"));
		assertFalse("year is not in the right format", h1.validateBirthDate("01/24/19999"));
		assertFalse("month is out of range", h1.validateBirthDate("15/24/1995"));
		assertFalse("day is out of range", h1.validateBirthDate("01/32/1995"));
		assertFalse("year is out of range", h1.validateBirthDate("01/24/1800"));
		assertFalse("is null", h1.validateBirthDate(""));
    }

}
