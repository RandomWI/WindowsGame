package Server;
import businessLogic.idGenerator;
import java.sql.*;

public class CREATE {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/8080";

	   //  Database credentials
	   static final String USER = "username";
	   static final String PASS = "password";
	   
	public void stateToDB(String fileName,String table) {
		idGenerator gen = new idGenerator();
		String _id = gen.randomString();
	
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      
	      //Create table missing!
	      
	      sql = "INSERT INTO `states`(`_id`, `name`, `state`) VALUES\r\n" + 
	      		"('"+_id+"','"+fileName+"','"+table+"'";
	      
	      ResultSet rs = stmt.executeQuery(sql);

	     
	      /*while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("id");
	         int age = rs.getInt("age");
	         String first = rs.getString("first");
	         String last = rs.getString("last");

	         //Display values
	         System.out.print("ID: " + id);
	         System.out.print(", Age: " + age);
	         System.out.print(", First: " + first);
	         System.out.println(", Last: " + last);
	      }*/
	      rs.close();
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}
}