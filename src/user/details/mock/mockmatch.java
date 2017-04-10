package user.details.mock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class mockmatch {
HashMap<String, Integer> hmap=new HashMap<String, Integer>();
	
	public HashMap<String, Integer> getUser(String uname)
	{
		System.out.println("here");
		System.out.println(uname);
	
		int count;
		String value = null;
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		 
		ArrayList<String> list2 = new ArrayList<String>();
		try
		{
			mockdbconnect db = new mockdbconnect();
			Connection con = db.connect();
			Statement st3 = con.createStatement();  
	        String q4 = "select concat_ws(\",\", (case when sports = 1 then 'sports' end),\n" +
             " (case when animation = 1 then 'animation' end),\n" +
             " (case when music = 1 then 'music' end),\n" +
              " (case when books = 1 then 'books' end)," +
              " (case when videogames = 1 then 'videogames' end)," +
              " (case when travel = 1 then 'travel' end),"+
              " (case when fitness = 1 then 'fitness' end),"+
              " (case when boardgames = 1 then 'boardgames' end),"+
              " (case when food = 1 then 'food' end),"+
              " (case when tvmovies = 1 then 'tvmovies' end),"+
              " (case when youtubemedia = 1 then 'youtubemedia' end),"+
              " (case when arts = 1 then 'arts' end)"+
             ") from interestmock where username='"+uname+"' ";
	        ResultSet rs3 = st3.executeQuery(q4);
            while(rs3.next())
            {
           	 
            	value =rs3.getString(1);
            	StringTokenizer str = new StringTokenizer(value,",");
            	while(str.hasMoreTokens())
            	{
            		String interestValues = str.nextToken();
            		System.out.println(interestValues);
            		list1.add(interestValues);        
            	}
            	 System.out.println("list of user logged in " + list1);
            }
            st3.close();
           Statement st = con.createStatement();
            String q1 = "select count(username)from userdatamock where username != '"+uname+"'";
            ResultSet rs = st.executeQuery(q1);
            while(rs.next())
            {
            	count = rs.getInt(1);
            	System.out.println(count);
            	Statement st1 = con.createStatement();
                String q2 = "select username from userdatamock where username != '"+uname+"'";
                ResultSet rs1 = st1.executeQuery(q2);
                while(rs1.next())
                {
                	String pname = rs1.getString(1);
                 	//System.out.println(pname);
                 	Statement st2 = con.createStatement();  
         	        String q3 = "select concat_ws(\",\", (case when sports = 1 then 'sports' end),\n" +
                         " (case when animation = 1 then 'animation' end),\n" +
                         " (case when music = 1 then 'music' end),\n" +
                          " (case when books = 1 then 'books' end)," +
                          " (case when videogames = 1 then 'videogames' end)," +
                          " (case when travel = 1 then 'travel' end),"+
                          " (case when fitness = 1 then 'fitness' end),"+
                          " (case when boardgames = 1 then 'boardgames' end),"+
                          " (case when food = 1 then 'food' end),"+
                          " (case when tvmovies = 1 then 'tvmovies' end),"+
                          " (case when youtubemedia = 1 then 'youtubemedia' end),"+
                          " (case when arts = 1 then 'arts' end)"+
                         ") from interestmock where username='"+pname+"' ";
         	         ResultSet rs2 = st2.executeQuery(q3);
         	         while(rs2.next())
         	         {
         	    	   		list = new ArrayList<String>();
         	    	   		value =rs2.getString(1);
         	    	   		StringTokenizer str = new StringTokenizer(value,",");
         	    	   		while(str.hasMoreTokens())
         	    	   		{
         	    	   			String interestValues = str.nextToken();
           	    	   			list.add(interestValues); 
         	    	   		}
         	    	   		list2.addAll(list1);
         	    	   		
         	    	   		list2.retainAll(list);
         	    	   		
         	    	   		if(list2.size()!=0)
         	    	   		{
         	    	   			hmap.put(pname, list2.size());
         	    	   		}
         	    	   		
         	            	list2.clear();
           	         	}
         	         	st2.close();
                	}
                	System.out.println(hmap);
                	st1.close();
            }
            st.close();
            
            con.close();
		}
		catch(SQLException e)
        {
            System.out.println(e.getMessage());    
        }
		return hmap ;
	}

}
