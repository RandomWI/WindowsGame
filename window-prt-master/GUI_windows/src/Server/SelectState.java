package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class SelectState {

	   static final String DB_URL = "jdbc:mysql://127.0.0.1/states";

	   static final String USER = "root";
	   static final String PASS = "password";
	   
	public String select(String fileName) {
	   Connection conn = null;
	   String result = "";
	   PreparedStatement stmt = null;
	   try{
	      Class.forName("com.mysql.jdbc.Driver");

	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	     String sql = "SELECT * FROM statessaved Where name LIKE ?";
	     stmt = conn.prepareStatement(sql);
	      stmt.setString(1,fileName);
	   

	      ResultSet rs = stmt.executeQuery();
	     
	      while(rs.next()){
	          result = rs.getString("state");
	      }
	      if (rs != null) {
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
	return result;
	}
}
