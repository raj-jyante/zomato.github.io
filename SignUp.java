package login;

 import java.io.IOException;
 import java.io.PrintWriter;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;
 import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUp extends  HttpServlet{
	static int count=0;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		int pno=Integer.parseInt(req.getParameter("pno"));
		String email=req.getParameter("email"); 
		String password1=req.getParameter("password");
 		insert(name,pno,email,password1,count);
		
	}
		
 		
 		
 	 void insert(String name,int pno,String email,String password1,int count) {
 		Connection connection=null;
 			Statement statement=null;
 		
 		 
 			 String url="jdbc:mysql://localhost:3306/details";
 			 String username="root";
 		 String password = "root";
 			 
 		 try {
 			 connection =DriverManager.getConnection(url, username, password);
 				  String sql="insert into `employee`" 
 						  +"(`name`,`p_number`,`email_id`,`password`)"
 						  +"values  (name, 'pno','email','password' ) ";
 					 statement = connection.createStatement();
 			        int i = statement.executeUpdate(sql);
 				        count=i;
 			 }catch(SQLException e) {
 				 e.printStackTrace();
 	 }
 		  		 
	 
	 }
	 
}
 
