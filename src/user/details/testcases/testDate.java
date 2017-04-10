package user.details.testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import user.details.validate;

public class testDate {

	
	@Test
	public void dateTest() 
	{
		validate r = new validate();
		assertTrue(r.validateDate("2017-04-09"));
		assertFalse("the year is before the current year", r.validateDate("2016-04-08"));
		assertFalse("the month is before the current month", r.validateDate("2017-03-08"));
		assertFalse("the month is out of bounds", r.validateDate("2017-13-08"));
		assertFalse("the day is before the current day", r.validateDate("2017-04-07"));
		assertFalse("the day is out of bounds", r.validateDate("2017-04-33"));
	}

}
