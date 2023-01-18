package door2door;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
public class declaration.
*/ 

public class GroupChat {
  JFrame frame = new JFrame();
  JLabel sendMessage;
  JTextField messageField;
  JButton messageButton;
  JLabel messageLabel;
  GroupChatGraphics gui;
  String message;
  Connection connection = null;
  PreparedStatement pst3 = null;
  public String myuser;
  public String areacode;
  Statement statement;
  String date;
  String datetime;
  PreparedStatement pst32;
  
  
   
  /**
  * The Class takes the parameters parentGui, userID, m, myuser and areacode. 
  * Saves the user's username and areacode in myuser and areacode variables.
  * Through the class GroupChatMessages, that takes the areacode as a parameter,
    it calls the showMessages method and prints the messages that exists in the groupchat.
  */
  public GroupChat(GroupChatGraphics parentGui, JTextField userId, 
      String myuser,JLabel mes, String areacode) {
    gui = parentGui;
    messageField = userId;
    messageLabel=mes;
    this.myuser = myuser;
    this.areacode = areacode;
  }
  /**
  * Uses groupchatmethod method to connect to the database.
  * Inside the method it inserts the user's username, message,    
       the date and time of the message and the areacode into the database.
  * Prints message when the values are successfully inserted. 
  */
  
  public boolean groupchatmethod() {  
    boolean flag = false;
    message = messageField.getText();
    messageLabel.setText("Message sent!");
    try {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection("jdbc:sqlite:mydb.db");
      statement = connection.createStatement();
      String pattern = ("HH:mm" + " " + "(dd-MM-YYYY)");
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
      String date = simpleDateFormat.format(new Date());
      datetime = date.toString();
      String sql = "INSERT INTO groupmess VALUES (?, ?, ?, ?, ?);";
      String sql2 = "INSERT INTO Likes VALUES (?, ?);";
                              
      Statement statement1 = connection.createStatement();
      ResultSet resultset1 = statement1.executeQuery("SELECT * FROM groupmess"
          + " WHERE message<>'null' ");
      int i = 1;
      while (resultset1.next()) {
        i++;
      }                     
      pst3 = connection.prepareStatement(sql);
      pst32 = connection.prepareStatement(sql2);
      pst32.setInt(1, 0);
      System.out.println(i);
      pst32.setInt(2, i + 1);
      pst3.setString(1, myuser);
      pst3.setString(2, message);
      pst3.setString(3, datetime);
      pst3.setString(4, areacode);
      pst3.setInt(5, i + 1);
      statement.executeUpdate(sql);
      pst3.execute();
      statement.executeUpdate(sql2);
      pst32.execute();
      flag = true;
      GroupChatMessages m = new GroupChatMessages(myuser, areacode);
      m.showMessages();
    } catch (Exception e5) {
      System.out.println("Problem with the sql connection " + e5);
    } finally {
      try { 
        if (connection != null)  {
          connection.close();
        }
      } catch (SQLException e12) {
        e12.printStackTrace();
      }
    }
    return flag;
  }

  public void messageSend() {
    boolean x = groupchatmethod();
  }
}



   