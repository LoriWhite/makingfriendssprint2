package user.details;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class sendmessage {
	public boolean insertintomessage(String uname,String recipient,String message,LocalDateTime now)
	{
		boolean send=false;
	try
	{
		dbconnect db = new dbconnect();
		Connection con = db.connect();
        Statement st = con.createStatement();
        String q1 = "insert into messages values('"+uname+"','"+recipient+"','"+message+"','"+now+"')";
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
