package user.details;

import java.io.IOException;

import java.sql.Connection;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String uname;
	ArrayList<String> list = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		uname = (String) session.getAttribute("uname");
	
		response.setContentType("text/html");
		ArrayList<String> listp = new ArrayList<String>();
		try
		{
			dbconnect db = new dbconnect();
			Connection con = db.connect();
			Statement st = con.createStatement();
            String q1 = "select date1,from1,to1 from freetime where username = '"+uname+"'";
            ResultSet rs = st.executeQuery(q1);
            String date2="";
            Time from1=null,to1 = null;
            while(rs.next())
            {
            	date2 =rs.getString(1);
            	from1 = rs.getTime(2);
            	to1 = rs.getTime(3);
            }
            
            System.out.println(date2 + from1 + to1);
            st.close();
            searchuserclass suc=new searchuserclass();
            listp= suc.searchuser(uname,date2,from1,to1);
            if(listp.isEmpty())
            {
            	
                session.setAttribute("uname", uname);
        		RequestDispatcher dispatcher = request.getRequestDispatcher("/nosearch.jsp");
        	    dispatcher.forward(request, response);
            }
            else
            {
            session.setAttribute("list1", listp);
            session.setAttribute("uname", uname);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp");
    	    dispatcher.forward(request, response);
            }
    	    
  	        con.close();
  	        
		}
		catch(SQLException e)
        {
            System.out.println(e.getMessage());    
        }
	}
	
}
