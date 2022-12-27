import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Sqlite3 {

    public static void connectiontrial3 () {

        System.out.println("connection");

        String message;

        Connection connection = null ;

        try {

            Class.forName("org.sqlite.JDBC");

            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");

            System.out.println("after connection");

            Statement statement1 = connection.createStatement();

            ResultSet resultset1 = statement1.executeQuery("SELECT * FROM groupmessages");

            while (resultset1.next() ) {

                if ( resultset1.getString("messages")!= null && resultset1.getString("username")!=null
           		    && resultset1.getString("datetime")!=null) {

            	    message= resultset1.getString("username")
            		    + ": " + resultset1.getString("messages") + " (" + resultset1.getString("datetime") + ")"   ;

            	    System.out.println(message);

                 }
             }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }finally {

            try {

                if(connection != null) {

                    connection.close();

                }

            }catch ( SQLException e) {

                e.printStackTrace();

            }

        }

    }
}




