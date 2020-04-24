package manasvi_kaplay;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet15")
public class Servlet15 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

	      PrintWriter out = response.getWriter();
	      String title = "Reading Checkbox Data";
	      String docType =
	         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

	      out.println(docType +
	         "<html>\n" +
	            "<head><title>" + title + "</title></head>\n" +
	            "<body bgcolor = \"#f0f0f0\">\n" +
	               "<h1 align = \"center\">" + title + "</h1>\n" +
	               "<ul>\n" +
	                  "  <li><b>Maths Flag : </b>: "
	                  + request.getParameter("maths") + "\n" +
	                  "  <li><b>Physics Flag: </b>: "
	                  + request.getParameter("physics") + "\n" +
	                  "  <li><b>Chemistry Flag: </b>: "
	                  + request.getParameter("chemistry") + "\n" +
	               "</ul>\n");
	      
	          out.println( "</body>");
	         out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
