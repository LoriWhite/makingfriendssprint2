package user.details.mock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mockdbconnect {
Connection con = null;
	
	public Connection connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root","mylife@123");
			return con;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return con;
	}

}
