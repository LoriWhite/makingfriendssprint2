package user.details.testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import user.details.validate;

public class validateto {

	
	@Test
	public void toTest() 
	{
		validate r = new validate();
		assertTrue(r.validateToTime("22:25", "2017-04-09"));
		assertFalse("the time is out of bounds", r.validateToTime("00:00", "2017-04-09"));
		assertFalse("the hour is before the current hour", r.validateToTime("04:45", "2017-04-09"));
		assertFalse("the hour is out of bounds", r.validateToTime("24:45", "2017-04-09"));
		assertFalse("the minute is before the current minute", r.validateToTime("11:10", "2017-04-09"));
		assertFalse("the minute is out of bounds", r.validateToTime("10:60", "2017-04-09"));
		assertFalse("the hour is out of bounds", r.validateToTime("24:45", "2017-04-09"));
	}

}
