package manasvi_kaplay;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProfileServlet13")
public class ProfileServlet13 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<form action=http://localhost:8080/Servlets/LogoutServlet14 method=post>");
        out.println("<button type=submit>Logout</button>");
        out.println("</form>");
        Cookie ck[]=request.getCookies();
        out.println("<center>");
        out.println("<h3>This is your profile</h3>");
        out.println("<h3>Hi "+ck[0].getValue()+"</h3>");
        out.println("<center>");
	}

}
