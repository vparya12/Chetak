package helpbook.servlet;

import helpbook.bean.UserDetails;
import helpbook.comman.Connect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails user = new UserDetails();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmailId(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setCollege(request.getParameter("college"));
		user.setMobileNumber(Long.parseLong(request.getParameter("mobile")));
		user.setDob(request.getParameter("dob"));
		user.setGender(request.getParameter("gender"));
		
		Connect cObj = new Connect();
		boolean flag=cObj.registerUser(user);
		PrintWriter out =response.getWriter();
		if(flag){
			response.sendRedirect("success.jsp");
		}else{
			out.print("Sorry for the Technical Hindrence");
		}
	}

}
