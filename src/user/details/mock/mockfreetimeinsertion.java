package user.details.mock;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class mockfreetimeinsertion {
	public boolean insertfreetime(String uname,String datex,String fromx,String tox)
	{
		boolean ip1=false;
		try{
			
			mockdbconnect db = new mockdbconnect();
			Connection con = db.connect();
			Statement st = con.createStatement();
	 	    String q1 = "insert into freetimemock values('"+uname+"',STR_TO_DATE('"+datex+"','%Y-%m-%d'),TIME_FORMAT('"+fromx+"','%H:%i'),TIME_FORMAT('"+tox+"','%H:%i'))";
	        st.executeUpdate(q1);
	        ip1=true;
            System.out.println("inserted freetime");
            st.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return ip1;
	}
	public boolean updatefreetime(String uname,String datex,String fromx,String tox)
	{
		boolean up1=false;
		try{
		mockdbconnect db = new mockdbconnect();
		Connection con = db.connect();
		String query = "update freetimemock set date1 = STR_TO_DATE(?,'%Y-%m-%d'),from1 = TIME_FORMAT(?,'%H:%i'),to1 = TIME_FORMAT(?,'%H:%i') where username = ?";
        java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1,datex);
        preparedStmt.setString(2,fromx);
        preparedStmt.setString(3,tox);
        preparedStmt.setString(4,uname);
        preparedStmt.executeUpdate();
        up1=true;
        preparedStmt.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return up1;
	}

}
