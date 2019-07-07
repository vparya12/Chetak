package helpbook.servlet;

import helpbook.bean.UserDetails;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName(request.getParameter("userName"));
		userDetails.setEmailId(request.getParameter("userEmail"));
		userDetails.setPassword(request.getParameter("userPassword"));
		userDetails.setDob(request.getParameter("userDOJ"));
		userDetails.setGender(request.getParameter("userGender"));
	}

}
