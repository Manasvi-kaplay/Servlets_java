package manasvi_kaplay;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AddRecordServlet4")
public class AddRecordServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdb","root","root");
            //Statement stmt=con.createStatement();
            int rno=Integer.parseInt(request.getParameter("rno"));
            String name=request.getParameter("name");
            int cls=Integer.parseInt(request.getParameter("class"));
            String section=request.getParameter("section");
            String sql="INSERT INTO student(`rno`, `name`, `class`, `section`) VALUES (?,?,?,?)";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1, rno);
            stmt.setString(2,name);
            stmt.setInt(3, cls);
            stmt.setString(4, section);
           int x=stmt.executeUpdate();
           if(x==1){
               System.out.println("Row inserted!");
               out.println("Row inserted successfully");
           }
           else{
               System.out.println("Row could not be inserted!");
           }
           out.close();
        }
        catch(Exception ex){
            System.out.println(ex);
            out.println(ex);
        }
    }

	}