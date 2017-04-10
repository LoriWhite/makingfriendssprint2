package user.details;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class matchuser
 */
@WebServlet("/matchuser")
public class matchuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String uname;
	HashMap<String, Integer> hmap;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public matchuser() {
        super();
        hmap = new HashMap<String, Integer>();
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
			match p = new match();
            hmap = p.getUser(uname);
            System.out.println("returned");
            Map<Integer, String> map = sortByValues(hmap); 
      	  	System.out.println("After Sorting:");
      	  	Set set2 = map.entrySet();
      	  	Iterator iterator2 = set2.iterator();
      	  	while(iterator2.hasNext()) 
      	  	{
                Map.Entry me2 = (Map.Entry)iterator2.next();
                System.out.print(me2.getKey() + ": ");
                System.out.println(me2.getValue());
                
           }
      	  if((map.isEmpty())==false)
      	  {
      	  session.setAttribute("map",map);
      	 session.setAttribute("uname",uname);
      	 RequestDispatcher dispatcher = request.getRequestDispatcher("/match.jsp");
	     dispatcher.forward(request, response);
      	  }
      	  else
      	  {
      		session.setAttribute("uname",uname);
      		RequestDispatcher dispatcher = request.getRequestDispatcher("/nomatch.jsp");
   	     dispatcher.forward(request, response);
      	  }
		
				
	}
	private static HashMap sortByValues(HashMap map) { 
	       List list = new LinkedList(map.entrySet());
	       // Defined Custom Comparator here
	       Collections.sort(list, new Comparator() {
	            public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o2)).getValue())
	                  .compareTo(((Map.Entry) (o1)).getValue());
	            }
	       });
	       HashMap sortedHashMap = new LinkedHashMap();
	       for (Iterator it = list.iterator(); it.hasNext();) {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
	 }

	
}

