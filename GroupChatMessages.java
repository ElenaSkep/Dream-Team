import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class GroupChatMessages {

    public static void showMessages() {

        System.out.println("connection");

        String message;

        Connection connection = null ;

        try {

            Class.forName("org.sqlite.JDBC");

            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");

            System.out.println("after connection");

            Statement statement1 = connection.createStatement();
            ResultSet resultset1 = statement1.executeQuery("SELECT * FROM groupmess WHERE message<>'null'" );

            while (resultset1.next() ) {


            	    message= resultset1.getString("fromid")
            		    + ": " + resultset1.getString("message") +  " " + resultset1.getString("dates")   ;
            	    System.out.println(message);


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
