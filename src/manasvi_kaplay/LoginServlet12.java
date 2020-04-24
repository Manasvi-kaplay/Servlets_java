package manasvi_kaplay;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet12")
public class LoginServlet12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String unm=request.getParameter("unm");
		String upass=request.getParameter("upass");
		if(upass.equals("123")) {
			out.println("<form action=http://localhost:8080/Servlets/LogoutServlet14 method=post>");
	        out.println("<button type=submit>Logout</button>");
	        out.println("</form>");
			out.println("<center>");
			out.println("<h3>Welcome "+unm+"</h3>");
			
			out.println("<form action=http://localhost:8080/Servlets/ProfileServlet13 method=post>");
	        out.println("<button type=submit>View your profile</button>");
	        out.println("</form>");
			out.println("</center>");
			Cookie ck=new Cookie("unm",unm);  
            response.addCookie(ck);  
		}
		else {
			request.getRequestDispatcher("login.html").include(request, response);
			out.println("<h3>Incorrect username or password! </h3>");
			
		}
	}

	

}
