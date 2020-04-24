package manasvi_kaplay;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SearchStudent7")
public class SearchStudent7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdb","root","root");
            Statement stmt=con.createStatement();
            String name=request.getParameter("name");
            String sql="select * from student where name like'"+name+"%'";
            ResultSet rs=stmt.executeQuery(sql);
            out.println("<center>");
            out.println("<table cellpadding=10>");
            out.println("<tr>");
            out.println("<th>Roll no.</th>");
            out.println("<th>Name</th>");
            out.println("<th>Class</th>");
            out.println("<th>Section</th>");
            out.println("<th>Edit</th>");
            out.println("<th>Delete</th>");
            out.println("</tr>");
            while(rs.next()){
            	out.println("<tr>");
                out.println("\n<td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+"</td>");
                out.print("<td><a href=hjhj>Edit</a></td>"+"<td><form action=http://localhost:8080/Servlets/DeleteRecordServlet5 method=post><button type=submit>Delete</button></form></td>");
                out.println("</tr>");
                out.println("<br>");
            }
            out.println("</table>");
            out.println("<a href=http://localhost:8080/Servlets/AddStudent.html>Add a student</a>");
            out.println("</center>");
           out.close();
        }
        catch(Exception ex){
            System.out.println(ex);
            out.println(ex);
        }
    }
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
