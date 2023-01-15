package Door2Door;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Messages  {
JFrame frame;
String areacode;
String areacode1;
JLabel messageLabel;
JButton b;
Connection connection = null ;
JLabel likemessageLabel;
String myuser;
Statement statement1;
boolean flag;
JLabel countoflikes;
String fromid;
int likes;
int  numbermes;
MessagesGui g;
String message;
String date;

//constructor
Messages(MessagesGui g, String areacode, String myuser, JFrame frame) {
  this.areacode=areacode;
  this.myuser=myuser;
  this.g=g;
  this.frame=frame;
}

    public void showMessages() {
        try {

        	Class.forName("org.sqlite.JDBC");

        	connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");

         //System.out.println("after connection");
         //System.out.println(areacode);

        	Statement statement1 = connection.createStatement();
         	ResultSet resultset1 = statement1.executeQuery("SELECT * FROM groupmess WHERE message<>'null'  ORDER BY No DESC" );
       
         	int i=1;
    //&& resultset2.next()
         	while (resultset1.next()  ) {
       
         		numbermes = resultset1.getInt("No");
         		Statement statement2 = connection.createStatement();
         		ResultSet resultset2 = statement2.executeQuery("SELECT * FROM Likes  WHERE No =  '"+ numbermes +"'" );
            // System.out.println(numbermes);
         		areacode1= resultset1.getString("area_code");
         		if (areacode1.equals(areacode)) {
            	   fromid= resultset1.getString("fromid");
            	   message = resultset1.getString("message");
            	   date = resultset1.getString("date");
             	   likes = resultset2.getInt("likes");
             	   b=g.method3(i,fromid, message,date, likes); 
            	  //countoflikes=g.showmes3(i, likes);
            	   method2();
         		}
               i++;
             
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
    //*************************
    public void method2() {
    	System.out.println(myuser + " " + "Just Liked " + fromid +"'s Message");
  	  	countoflikes.setText(String.valueOf(likes +1 ) + " " + "Likes ");
  	  	try {
  		  Connection connection = null;
  		  try {
  			  Class.forName("org.sqlite.JDBC");
  		  } catch (ClassNotFoundException e1) {
  		 // TODO Auto-generated catch block
  			  e1.printStackTrace();
  		  }
  		  connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");

  		  int newlike= likes+1;
  		  String sql="UPDATE  Likes SET likes = '"+ newlike +"' WHERE No =  '"+ numbermes +"'";
  		  Statement statement1 = connection.createStatement();
  		  PreparedStatement pst3 = connection.prepareStatement(sql);
  		  statement1.executeUpdate(sql);
  		  pst3.execute();
   
   } catch (SQLException e1) {
  	// TODO Auto-generated catch block
  	e1.printStackTrace();
  	}finally {

  	    try {
  	        if(connection != null) {
  	            connection.close();
  	        }

  	    }catch ( SQLException e3) {
  	        e3.printStackTrace();
  	        flag=true;
  	    }
  	}
    }
    //**********************************
   
}