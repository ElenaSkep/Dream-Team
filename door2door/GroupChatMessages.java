package door2door;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GroupChatMessages{

  JFrame frame = new JFrame();
  JLabel sendMessage;
  JTextField messageField;
  JButton messageButton;
  JLabel messageLabel;
  GroupchatGraphics1 gui;
  String message;
  Connection connection = null ;
  PreparedStatement pst3 = null;
  public String myuser;
  public String areacode;
  PreparedStatement pst32;
  int i;
  boolean flag;

  public GroupChatMessages(GroupchatGraphics1 parentGui,JTextField userID,JLabel m,String myuser,String areacode){
	  gui = parentGui;
	  messageField = userID;
	  messageLabel = m;
      this.myuser=myuser;
      this.areacode=areacode;
  }

  public boolean groupchatmethod() {
	  flag=true;
	  try {
		  MessageGui2 rec = new MessageGui2(areacode,myuser);

	  } catch(Exception s) {
		  System.out.println("exception"+ s);
		  flag=false;
	  }finally {
		  try {
			  if(connection != null)
				  connection.close();

		  }catch ( SQLException e12) {
			  e12.printStackTrace();

		  }

	  }

  message = messageField.getText();
  messageLabel.setText("Message sent!");
  
  try {
  Class.forName("org.sqlite.JDBC");
         connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
         Statement statement = connection.createStatement();


         String pattern = ("HH:mm" + " " + "(dd-MM-YYYY)");
         SimpleDateFormat simpleDateFormat= new SimpleDateFormat(pattern);
         String date= simpleDateFormat.format(new Date());
         String datetime= date.toString();

         String sql="INSERT INTO groupmess VALUES (?,?,?,?,?);";
         String sql2="INSERT INTO Likes VALUES (?,?);";
                     
                     
         Statement statement1 = connection.createStatement();
         ResultSet resultset1 = statement1.executeQuery("SELECT * FROM groupmess WHERE message<>'null' " );
        
         int i =1;
         while (resultset1.next() ) {
        	 i++;
         }
         
         
         pst3 = connection.prepareStatement(sql);

         pst32 = connection.prepareStatement(sql2);
         pst32.setInt(1,0);
         System.out.println(i);
         pst32.setInt(2, i+1);

         pst3.setString(1,myuser);
         pst3.setString(2,message);
         pst3.setString(3,datetime);
         pst3.setString(4,areacode);
         pst3.setInt(5,i+1);

                    statement.executeUpdate(sql);
         pst3.execute();
         statement.executeUpdate(sql2);
         pst32.execute();
                   // System.out.println("success");
         new MessagesGui (areacode , myuser);
         flag=true;
 
         
  	}catch(Exception e5){
  		System.out.println("man you cant do this because of" + e5);

  	}finally {

  		try {
  			if(connection != null)
  				connection.close();
  // pst3.close();

  		}catch ( SQLException e12) {
  			e12.printStackTrace();

  		}
  	}
  return flag;
  }

  }


