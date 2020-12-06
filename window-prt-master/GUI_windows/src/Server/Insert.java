package Server;

import businessLogic.idGenerator;
import java.sql.*;

public class Insert {

	
	   static final String DB_URL = "jdbc:mysql://127.0.0.1/states";

	   static final String USER = "root";
	   static final String PASS = "password";
	   
	public void stateToDB(String fileName,String table) {
		idGenerator gen = new idGenerator();
		String _id = gen.randomString();
	Boolean success = false;
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   try{
	      Class.forName("com.mysql.jdbc.Driver");

	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	     String sql = "INSERT INTO statessaved(_id,name,state) VALUES (?,?,?)";
	     
	      stmt = conn.prepareStatement(sql);
	
	      stmt.setString(1, _id);
	      stmt.setString(2, fileName);
	      stmt.setString(3, table);
	      int rs = stmt.executeUpdate();
	      if (rs != 0) {
	          // Login Successful if match is found
	          success = true;
	          System.out.println("Done!");
	      }
	  } catch (Exception e) {
	      e.printStackTrace();
	  } finally {
	      try {
	          stmt.close();
	          conn.close();
	      } catch (Exception e) {
	      }
	  }
	}
}
