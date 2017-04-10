package user.details.testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import user.details.validate;

public class validatefrom {

	
	@Test
	
	public void fromTest() 
	{
		validate r = new validate();
		assertTrue(r.validateFromTime("22:00", "2017-04-09"));
		assertFalse("the time is out of bounds", r.validateFromTime("23:35", "2017-04-08"));
		assertFalse("the hour is before the current hour", r.validateFromTime("04:45", "2017-04-09"));
		assertFalse("the hour is out of bounds", r.validateFromTime("24:45", "2017-04-09"));
		assertFalse("the minute is before the current minute", r.validateFromTime("11:20", "2017-04-09"));
		assertFalse("the minute is out of bounds", r.validateFromTime("23:60", "2017-04-09"));
	}

}
