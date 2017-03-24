package user.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
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
		 	boolean check=false;
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root","mylife@123");
	        Statement st = con.createStatement();
	        Statement st1 = con.createStatement();
	        String q1 = "select username from userdata where username ='"+username+"'";
            ResultSet rs = st.executeQuery(q1);
            while(rs.next())
            {
            	check=true;
            	String q2 = "select ppassword from userdata where username ='"+username+"'";
                ResultSet rs1 = st1.executeQuery(q2);
                while(rs1.next())
                {
                	if((rs1.getString("ppassword")).equals(password))
                	{
                		out.println("login successful");
                		//session.setAttribute("uname", username);
                		request.setAttribute("uname", username);
                		RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
                	      dispatcher.forward(request, response);

                	}
                	else
                	{
                		out.println("invalid credentials");
                	}
                }
            }
            if(check==false)
            {
            	out.println("invalid credentials-username");
            }
	        st.close();
	        st1.close();
	        con.close();
	        
	    }
	 catch(SQLException e)
	    {
	        System.out.println(e.getMessage());    
	    }
	}

}
