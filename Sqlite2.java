package Door2Door;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sqlite2 {
	
 public static void connectiontrial2 () {
		 
		 System.out.println("connection");
		 
	
	Connection connection = null ;
	
	try {
		
         Class.forName("org.sqlite.JDBC");
         
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
			
	Statement statement = connection.createStatement();
		ResultSet resultset = statement.executeQuery("SELECT * FROM users");
		
		while (resultset.next()) {
			
			System.out.println(resultset.getString("message")) ;
			}
	} catch (Exception e){//ClassNotFoundException | SQLException e) {
		System.out.println(e);

		
	}finally {
		
		try {
			if(connection != null) 
				connection.close();
			  	
		}catch ( SQLException e) {
			e.printStackTrace();
			
		}
	}
 }

}

