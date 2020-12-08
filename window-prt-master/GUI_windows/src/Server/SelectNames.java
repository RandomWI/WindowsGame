package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectNames {

	static final String DB_URL = "jdbc:mysql://127.0.0.1/states";

	static final String USER = "root";
	static final String PASS = "password";

	public String[] select() {
		Connection conn = null;
		String [] result = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//stmt = conn.createStatement();
			stmt = conn.createStatement(
				    ResultSet.TYPE_SCROLL_INSENSITIVE, 
				    ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT name FROM statessaved";
			ResultSet rs = stmt.executeQuery(sql);
			rs.last();
		    int size = rs.getRow();
		    rs.beforeFirst();
			result = new String[size];

			// STEP 5: Extract data from result set
			int i = 0;
			while (rs.next()) {
				// Retrieve by column name

				String returnName = rs.getString("name");

				result[i] = returnName;
				i++;
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
