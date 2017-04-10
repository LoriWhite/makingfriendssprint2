package user.details.mock;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class mocksendmessage {
	public boolean insertintomessagemock(String uname,String recipient,String message,LocalDateTime now)
	{
		boolean send=false;
	try
	{
		mockdbconnect db = new mockdbconnect();
		Connection con = db.connect();
        Statement st = con.createStatement();
        String q1 = "insert into messagesmock values('"+uname+"','"+recipient+"','"+message+"','"+now+"')";
        st.executeUpdate(q1);
        send=true;
        System.out.println("inserted messages");
       	 st.close();
        con.close();
	}
	catch(SQLException e)
	{
		System.out.println(e.getMessage());
	}
	return send;
	}

}
