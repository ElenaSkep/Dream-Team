package door2door;

//public class MessagesAllTogether {

//}

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MessagesAllTogether  {
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

MessagesAllTogether(String areacode,String myuser) {
  this.areacode=areacode;
  this.myuser=myuser;
 
}

    public void showMessages() {
   

    frame = new JFrame();
    frame.setTitle("GroupChatMessages in " + areacode);
    

   try {

     Class.forName("org.sqlite.JDBC");

     connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");

     //System.out.println("after connection");
     //System.out.println(areacode);

     Statement statement1 = connection.createStatement();
     ResultSet resultset1 = statement1.executeQuery("SELECT * FROM groupmess WHERE message<>'null'  ORDER BY No DESC" );
   
    int i =1;
//&& resultset2.next()
     while (resultset1.next()  ) {
   
         numbermes = resultset1.getInt("No");
         Statement statement2 = connection.createStatement();
         ResultSet resultset2 = statement2.executeQuery("SELECT * FROM Likes  WHERE No =  '"+ numbermes +"'" );
        // System.out.println(numbermes);
         areacode1= resultset1.getString("area_code");

           if (areacode1.equals(areacode)) {
        	   	fromid= resultset1.getString("fromid");
        	   	messageLabel= new JLabel(resultset1.getString("fromid")
        	   			+ ": " + resultset1.getString("message") +  " " + resultset1.getString("date") )  ;
         
        	   	messageLabel.setBounds(170,i*35,500,20);
       
        	   	frame.add(messageLabel);
        	    JButton b=new JButton("Like" );
                frame.add(b);
                b.setBounds(0,i*35,100,20);
                frame.setSize(150,150);
        	   	frame.setSize(150,150);
          // System.out.println(resultset2.getInt("likes"));
        	   	likes = resultset2.getInt("likes");
        	   	countoflikes= new JLabel(String.valueOf(likes) + " " + "Likes ");
        	   	countoflikes.setBounds(105,i*35,50,20);
        	   	frame.add(countoflikes);
           
           
         //***********************************************
    b.addActionListener(new ActionListener() {
    public  void actionPerformed(ActionEvent e){
           //Like l = new Like();
          // int newlikescount=l.count(likescount);
   
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
        		
        	}
      
        	flag=true;

        }
        }
     });
//*******************************************************
    
     
     }
     i++;
         
    }
     

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
    frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
    frame.setLayout(null);
    frame.setVisible(true);
    frame.getContentPane().setBackground(new Color(50,180,0)); //change color of backgrounds
          //System.out.println("here");
       ;//creates the frame of my application
 

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
