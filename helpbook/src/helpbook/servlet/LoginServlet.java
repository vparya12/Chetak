package helpbook.servlet;

import helpbook.comman.Connect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("login");
		String password=request.getParameter("password");
		PrintWriter out = response.getWriter();
		Connect cObj= new Connect();
		boolean flag=cObj.checkLogin(email, password);
//		if(email.equals("vparya12@gmail.com") && password.equals("vparya12")){
//			response.sendRedirect("home_page.html");
		if(flag){
			response.sendRedirect("home_page.html");
	//out.print(email+password);
		}else{
			out.print("Not Match");
		}
	}

}
