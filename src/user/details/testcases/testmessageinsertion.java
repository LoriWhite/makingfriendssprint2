package user.details.testcases;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import org.junit.Test;


import user.details.mock.mockdbconnect;
import user.details.mock.mocksendmessage;

public class testmessageinsertion {

	
	@Test
	public void testmessagesend() {
		
		mocksendmessage m = new mocksendmessage();
		LocalDateTime now = LocalDateTime.now();
  		assertTrue(m.insertintomessagemock("lwhite","shanmukhi","Hi shanmukhi!", now));
  		try
		{
			mockdbconnect db = new mockdbconnect();
			Connection con = db.connect();
			Statement st = con.createStatement();
			String q2 = "select message from messagesmock where username='lwhite'";
			ResultSet rs1 = st.executeQuery(q2);
			String we="";
            while(rs1.next())
            {
            	we=rs1.getString(1);
            }
            assertEquals(we,"Hi shanmukhi!");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
