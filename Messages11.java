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


public class Messages11 {
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
String mes;
String date;
MessageGui2 mgui;

Messages11(MessageGui2 g,String areacode,String myuser) {
  this.areacode=areacode;
  this.myuser=myuser;
  mgui=g;
  
 
}

    public void showMessages() {
     try {
    	 mgui.method1();

    	 System.out.println("works1");

    	 Class.forName("org.sqlite.JDBC");

    	 connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
    	 Statement statement1 = connection.createStatement();
    	 ResultSet resultset1 = statement1.executeQuery("SELECT * FROM groupmess WHERE message<>'null'  ORDER BY No DESC" );
   
    	 int i=1;
    	 while (resultset1.next()  ) {

    		 System.out.println("works2");
   
    		 numbermes = resultset1.getInt("No");
    		 Statement statement2 = connection.createStatement();
    		 ResultSet resultset2 = statement2.executeQuery("SELECT * FROM Likes  WHERE No =  '"+ numbermes +"'" );
    		 areacode1= resultset1.getString("area_code");
    		 
    		 if (areacode1.equals(areacode)) {
    			fromid= resultset1.getString("fromid");
    			mes=resultset1.getString("message");
    			date=resultset1.getString("date");
        	    likes = resultset2.getInt("likes");
        	    System.out.println("the likes are :"+likes);
        	    mgui.method2(i, likes, fromid, date, mes);
        	    mgui.setCountoflikes(i, likes);
        	    //countoflikes=mgui.setCountoflikes(i, likes);
        	    mgui.createButton(i);
        	    System.out.println("works3");
    
         /*//**********************************************
    b.addActionListener(new ActionListener() {
    public  void actionPerformed(ActionEvent e){
           //Like l = new Like();
          // int newlikescount=l.count(likescount);
   
       
        }
     });
*/
//*******************************************************
    
     
     }
     i++;
         
    }
 
    	 mgui.createFrame();
 
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
    public void body() {
    	 mgui.updateScreen(myuser, fromid, likes);
         try {
         Connection connection = null;
         try {
         	Class.forName("org.sqlite.JDBC");
         } catch (ClassNotFoundException e1) {
         	// TODO Auto-generated catch block
         	e1.printStackTrace();
         }
         connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");

 	     System.out.println("Body works");
         int newlike= likes+1;
         System.out.println(newlike);
         mgui.createFrame();
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
         		
         	}
         	flag=true;

         }
    }
}
