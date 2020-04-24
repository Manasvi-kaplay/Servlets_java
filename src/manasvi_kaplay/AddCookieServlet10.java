package manasvi_kaplay;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCookieServlet10")
public class AddCookieServlet10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String unm=request.getParameter("unm");
		out.println("<h3>Welcome</h3>"+unm);
		try {
		Cookie c=new Cookie("unm",unm);
		response.addCookie(c);
		out.println("<form action=http://localhost:8080/Servlets/GetCookieServlet11  method=get>");
		out.println("<input type=submit value=go>");
		out.println("</form>");
		}
		catch(Exception e) {
			
		}
	}

}
