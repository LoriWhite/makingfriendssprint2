package user.details;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class notification
 */
@WebServlet("/notification")
public class notification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String uname;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public notification() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
		ArrayList<receivedMessage>text;
		text = new ArrayList<receivedMessage>();
		
			text=getnotification(uname);
            if(text.isEmpty())
    		{
    			
        		session.setAttribute("uname",uname);
    	      	RequestDispatcher dispatcher = request.getRequestDispatcher("/nonotifications.jsp");
    		    dispatcher.forward(request, response);
    		}
    		else
    		{
    			System.out.println("messages recieved");
    			session.setAttribute("messages",text);
    	      	session.setAttribute("uname",uname);
    	      	RequestDispatcher dispatcher = request.getRequestDispatcher("/notifications.jsp");
    		    dispatcher.forward(request, response);
    		}
           
		
	}
	public ArrayList<receivedMessage> getnotification(String uname)
	{
		ArrayList<receivedMessage>text1;
		text1 = new ArrayList<receivedMessage>();
		try
		{
			dbconnect db = new dbconnect();
			Connection con = db.connect();
			Statement st = con.createStatement();
            String q1 = "select username,message,date from messages where receiver = '"+uname+"'";
            ResultSet rs = st.executeQuery(q1);
            String sender=null,message=null;
            Timestamp datetime=null;
            while(rs.next())
            {
            	sender =rs.getString(1);
            	message = rs.getString(2);
            	datetime = rs.getTimestamp(3);
            	text1.add(new receivedMessage(sender,message,datetime));
             }
            System.out.println(sender + message + datetime);
		}
		catch(SQLException e)
        {
            System.out.println(e.getMessage());    
        }
		return text1;
	}

}
