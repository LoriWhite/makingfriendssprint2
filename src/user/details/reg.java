package user.details;
import user.details.validate;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class reg
 */
@WebServlet("/reg")
public class reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		String name,email,dateofbirth,address,username,password,cpassword;
		//String[] hobbies = new String[20];
		name = request.getParameter("name").toString();
		email = request.getParameter("email").toString();
		dateofbirth = request.getParameter("dob").toString();
		address = request.getParameter("address").toString();
		username = request.getParameter("username").toString();
		password = request.getParameter("password").toString();
		cpassword = request.getParameter("confirmpassword").toString();
		int count = 0;
		int sports,animation,music,books,videogames,travel,fitness,boardgames,food,tvmovies,youtubemedia,arts;
		if(request.getParameter("sports") == null)
		{
		   //handle unchecked case
		   sports = 0;
		}
		else
		{
		   //handle checked case
		   sports = 1;
		   count++;
		}
		if(request.getParameter("animation") == null)
		{
		   //handle unchecked case
		   animation = 0;
		}
		else
		{
		   //handle checked case
		   animation = 1;
		   count++;
		}
		if(request.getParameter("music") == null)
		{
		   //handle unchecked case
		   music = 0;
		}
		else
		{
		   //handle checked case
		   music = 1;
		   count++;
		}
		if(request.getParameter("books") == null)
		{
		   //handle unchecked case
		   books = 0;
		}
		else
		{
		   //handle checked case
		   books = 1;
		   count++;
		}
		if(request.getParameter("videogames") == null)
		{
		   //handle unchecked case
			videogames = 0;
		}
		else
		{
		   //handle checked case
			videogames = 1;
			count++;
		}
		if(request.getParameter("travel") == null)
		{
		   //handle unchecked case
			travel = 0;
		}
		else
		{
		   //handle checked case
			travel = 1;
			count++;
		}
		if(request.getParameter("fitness") == null)
		{
		   //handle unchecked case
			fitness = 0;
		}
		else
		{
		   //handle checked case
			fitness = 1;
			count++;
		}
		if(request.getParameter("boardgames") == null)
		{
		   //handle unchecked case
			boardgames = 0;
		}
		else
		{
		   //handle checked case
			boardgames = 1;
			count++;
		}
		if(request.getParameter("food") == null)
		{
		   //handle unchecked case
			food = 0;
		}
		else
		{
		   //handle checked case
			food = 1;
			count++;
		}
		if(request.getParameter("tvmovies") == null)
		{
		   //handle unchecked case
			tvmovies = 0;
		}
		else
		{
		   //handle checked case
			tvmovies = 1;
			count++;
		}
		if(request.getParameter("youtubemedia") == null)
		{
		   //handle unchecked case
			youtubemedia = 0;
			
		}
		else
		{
		   //handle checked case
			youtubemedia = 1;
			count++;
		}
		if(request.getParameter("arts") == null)
		{
		   //handle unchecked case
			arts = 0;
		}
		else
		{
		   //handle checked case
			arts = 1;
			count++;
		}
		System.out.println(count);
		/*String checkbox;
		if(request.getParameter("agree") != null)
		{
			//out.println("insert data");
		}
		else
		{
			out.println("please agree to conditions");
		}*/
		
		String wemail="",wname="",wdob="",winterest="",waddress="",wusername="",wpassword="";
		int checkcount = 0;
		validate p = new validate();
		if(p.validateEmail(email)==true)
		{
			System.out.println("email validated");
			wemail="";
			checkcount++;
		}
		else
		{
			wemail = "Invalid Email";
		}
		if(p.validateName(name)==true)
		{
			System.out.println("name validated");
			wname="";
			checkcount++;
			
		}
		else
		{
			wname = "Invalid Name.only letters";
		}
		if(p.validateBirthDate(dateofbirth)==true)
		{
			System.out.println("DOB validated");
			wdob="";
			checkcount++;
		}
		else
		{
			wdob = "Invalid Date of Birth.Expects mm/dd/yyyy";
		}
		if(count == 0)
		{
			winterest = "Select atleast one interest";
		}
		else
		{
			System.out.println("Interest selected");
			winterest="";
			checkcount++;
		}
		if(address.equals(""))
		{
			waddress = "Address Required";
		}
		else
		{
			waddress = "";
			checkcount++;
			System.out.println("Address Validated");
		}
		boolean uservalid = p.validateusername(username);
		if((uservalid == false)&&(!username.equals("")))
		{
			System.out.println("Username Validated");
			wusername="";
			checkcount++;
		}
		else
		{
			wusername = "Username already Exists";
			
		}
		boolean userpass = p.validatePassword(password);
		if(userpass == true)
		{
			System.out.println( "Password okay");
			if(password.equals(cpassword))
			{
				wpassword="";
				checkcount++;
				System.out.println("Password Validated");
			}
			else
			{
				wpassword="Password Mismatch";
			}
		}
		else
		{
			wpassword="Password Criteria not met Must Contain alphabet digit special character";
		}
		if(checkcount == 7)
		{
			insert i = new insert();
			i.insertdb(name, email, dateofbirth, address, username, password,cpassword, sports, animation, music, books, videogames, travel, fitness, boardgames, food, tvmovies, youtubemedia, arts);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/successreg.jsp");
  	      	dispatcher.forward(request, response);
		}
		else
		{
			String error = wname + "\r\n" + wemail + "\r\n" + wdob + "\r\n" + winterest + "\r\n" + waddress + "\r\n" + wusername + "\r\n" + wpassword;
			System.out.println(error);
			request.getSession().setAttribute("Errormessage", error);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/retry.jsp");
  	        dispatcher.include(request, response);

		}					

}
}
