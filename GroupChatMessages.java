import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


     
public class GroupChatMessages {
	
	String areacode;
	
	GroupChatMessages(String areacode) {
	   this.areacode=areacode;
	}
	
    public void showMessages() {

        System.out.println("connection");

        String message;

        Connection connection = null ;

        try {

            Class.forName("org.sqlite.JDBC");
         
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");

            System.out.println("after connection");
            System.out.println(areacode);

            Statement statement1 = connection.createStatement();
            ResultSet resultset1 = statement1.executeQuery("SELECT * FROM groupmess WHERE message<>'null' " );
          
            while (resultset1.next() ) {
        	 
                  if (resultset1.getString("area_code")==areacode) {
            	    message= resultset1.getString("fromid")
            		    + ": " + resultset1.getString("message") +  " " + resultset1.getString("date")   ;
            	    System.out.println(message);
                  }
            	    	  
                 
             }
        
        } catch (ClassNotFoundException | SQLException e) {
        	System.out.println("exception" + e);

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
