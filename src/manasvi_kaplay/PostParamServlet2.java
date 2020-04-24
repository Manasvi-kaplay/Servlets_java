package manasvi_kaplay;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PostParamServlet2")
public class PostParamServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		// Get enumeration of parameter names.
		Enumeration e = request.getParameterNames();
		// Display parameter names and values.
		//int sum=0;
		while(e.hasMoreElements()) 
		{
		String pname = (String)e.nextElement();
		pw.println(pname + " = ");
		String pvalue = request.getParameter(pname);
		//sum+=Integer.parseInt(pvalue);
		pw.println(pvalue);
		}
		//pw.println("Sum = "+sum);
		pw.close();
		    }
	}

