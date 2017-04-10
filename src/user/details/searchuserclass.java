package user.details;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class searchuserclass {
	ArrayList<String> list = new ArrayList<String>();
	public ArrayList<String> searchuser(String uname,String date2,Time from1,Time to1)
	{
		try
		{
			dbconnect db = new dbconnect();
			Connection con = db.connect();
			Statement st1 = con.createStatement();
            String q2 = "select username from freetime where (date1 = '"+date2+"' and ((from1 >= '"+from1+"' and to1 <= '"+to1+"') or (from1 > '"+from1+"' and from1 < '"+to1+"' and to1 > '"+to1+"') or (from1 < '"+from1+"' and to1 > '"+from1+"'))) and username != '"+uname+"' ";
            ResultSet rs1 = st1.executeQuery(q2);
            while(rs1.next())
            {
              	String person = rs1.getString(1);
            	System.out.println(person);
            	list.add(person);
            }
            st1.close();
		}
		catch(SQLException e)
        {
            System.out.println(e.getMessage());    
        }
		return list;
	}

}
