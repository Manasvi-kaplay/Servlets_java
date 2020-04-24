package manasvi_kaplay;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@WebServlet("/ViewAllServlet3")
public class ViewAllServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdb","root","root");
            Statement stmt=con.createStatement();
            String sql="select * from student";
            ResultSet rs=stmt.executeQuery(sql);
            out.println("<center>");
            out.println("<h1><i>Student list</i></h1>");
            out.println("</center>");
            
            out.println("<form action=http://localhost:8080/Servlets/SearchStudent7 method=get>");
            out.println("<input name=name type=text placeholder=SearchByName>");
            out.println("<button type=submit>Submit</button>");
            out.println("</form>");
            
            out.print("<form action=http://localhost:8080/Servlets/SearchByClass8 method=get>");
            out.print("<label>Select class:</label>");
            out.print("<select  name=class>");
            out.print("<option value=1>1</option>");
            out.print("<option value=2>2</option>");
            out.print("<option value=3>3</option>");
            out.print("<option value=4>4</option>");
            out.print("</select>");
            out.print("<button type=submit>Submit</button>");
            out.print("</form>");
            
            out.print("<form action=http://localhost:8080/Servlets/SearchBySection9 method=get>");
            out.print("<label>Select section:</label>");
            out.print("<select  name=section>");
            out.print("<option value=A>A</option>");
            out.print("<option value=B>B</option>");
            out.print("<option value=C>C</option>");
            out.print("</select>");
            out.print("<button type=submit>Submit</button>");
            out.print("</form>");
      
            out.print("<center>");
            out.print("<table cellpadding=10>");
            out.print("<tr>");
            out.print("<th>Roll no.</th>");
            out.print("<th>Name</th>");
            out.print("<th>Class</th>");
            out.print("<th>Section</th>");
            out.print("<th>Edit</th>");
            out.print("<th>Delete</th>");
            out.print("</tr>");
            
            while(rs.next()){
            	out.println("<tr>");
                out.println("\n<td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+"</td>");
                int rno = rs.getInt(1);
                
                out.print("<td><a href=http://localhost:8080/Servlets/UpdateRecordServlet6>Edit</a></td>"+"<td><a href=http://localhost:8080/Servlets/DeleteRecordServlet5>Delete</a></td>");
                
                out.println("</tr>");
                out.println("<br>");
            }
            //RequestDispatcher dis = request.getRequestDispatcher("Servlet2");

            		//((Object) request).Forward(request,response);
            out.println("</table>");
            out.println("<a href=http://localhost:8080/Servlets/AddStudent.html>Add a student</a>");
            out.println("</center>");
        }
        catch(Exception ex){
            out.println(ex);
        }
	}
}
