package user.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class send
 */
@WebServlet("/send")
public class send extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String uname;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public send() {
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
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String recipient = request.getParameter("recipient").toString();
		String message = request.getParameter("message").toString();
		System.out.println(recipient + message);
		if(recipientTest(recipient)==true)
		{
			System.out.println("yesss");
			if(checkMessage(message)==true)
			{
				System.out.println("second yess");
				try
				{
					dbconnect db = new dbconnect();
					Connection con = db.connect();
			        Statement st = con.createStatement();
			       LocalDateTime now = LocalDateTime.now();
			        System.out.println(now);
			       String q1 = "insert into messages values('"+uname+"','"+recipient+"','"+message+"','"+now+"')";
			        st.executeUpdate(q1);
		            System.out.println("inserted messages");
            		session.setAttribute("uname", uname);
            		RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
            	    dispatcher.forward(request, response);
            	    st.close();
			        con.close();
				}
				catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
			}
			else
			{
	           /*	RequestDispatcher dispatcher = request.getRequestDispatcher("/message.jsp");
		        request.setAttribute("sendError","No Message is Written");
	        	dispatcher.forward(request, response);*/
			}
		}
		else
		{
			/*RequestDispatcher dispatcher = request.getRequestDispatcher("/message.jsp");
	        request.setAttribute("sendError","Incorrect Recipient");
        	dispatcher.forward(request, response);*/
		}
		
	}
	public boolean recipientTest(String recipientName)
	{
		boolean check = false;
		
		matchuser m = new matchuser();
		HashMap<String, Integer> map = m.getUser(uname);
		Set s = map.entrySet();
		Iterator i = s.iterator();
		while(i.hasNext())
		{
			Map.Entry e = (Map.Entry) i.next();
			if(e.getKey().equals(recipientName))
				check = true;
		}
		
		return check;
	}
	
	public boolean checkMessage(String messageText)
	{
		boolean check = true;
		if(messageText.equals("") || messageText.matches("[^\\s]+"))
			check = false;
		return check;
	}

}
