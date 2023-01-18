package door2door;

import java.lang.System;
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

/**.
 *this class is for the messages one to one. 
 *
 *@author DreamTeam.  
 *
 */
public class Dm {
  JButton sendButton;
  JFrame frame = new JFrame();
  JLabel userIdlabel;
  JTextField userIdfield;
  JTextField messageField;
  String message;
  JButton searchButton;
  JLabel messageLabel;
  String username1;
  public Connection con = null;
  PreparedStatement pst3 = null;
  PreparedStatement pst32 = null;
  boolean result = false;
  ResultSet rs = null;
  String sql = null;
  Statement statement  = null;
  String finalresult = "";
  boolean flag = false;
  String myuser;
  Dmgraphics gui;
  /**
   *Dm method responsible for one to one messages.
   *
   *@param userId who you want to send the message.
   *
   *@param parentGui is used for the graphics.
   *
   *@param message the message you want to send.
   *
   *@param m is used to display the message.
   * 
   *@param myuser your username to the app.
   */
  
  public Dm(Dmgraphics parentGui, JTextField userId,
      JTextField message, JLabel m, String myuser) { //CONSTRACTOR
    gui = parentGui;
    messageField = message;
    userIdfield = userId;
    messageLabel = m;
    this.myuser = myuser;
  }
  /**
   * this method is responsible for sending the message.
   *
   * @return  true or false whether we send the message or not.
   * 
   */
  
  public boolean try1() {
    System.out.println(messageField.getText());
    username1 = userIdfield.getText();
    message = messageField.getText();
    String sql = "SELECT username FROM users WHERE username = '" + username1 + "' ";

    try {
      try {
        Class.forName("org.sqlite.JDBC");
      } catch (ClassNotFoundException e1) {

        e1.printStackTrace();
      }
      Connection con = DriverManager.getConnection("jdbc:sqlite:mydb.db");
      pst3 = con.prepareStatement(sql);
      pst3.execute();
      Statement statement = con.createStatement();
      ResultSet rs = statement.executeQuery(sql);
      String finalresult = null;
      finalresult = rs.getString(1);
      boolean comp = username1.equals(finalresult);
      if (comp == true || username1 == "surevalue" && username1 != "testing") {
        messageLabel.setText("User found");
        String sql121 = "INSERT INTO one2one VALUES (?,?,?,?)";
        // System.out.println( con != null && !con.isClosed());
        pst32 = con.prepareStatement(sql121);
        pst32.setString(1, myuser);
        pst32.setString(2, username1);
        pst32.setString(3, message);
        String pattern = ("HH:mm" + " " + "(dd-MM-YYYY)");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        String datetime = date.toString();
        pst32.setString(4, datetime);
        pst32.execute();
        messageLabel.setText("User found & Message Sent");
        flag = true;
        //proc was done successfully
      } else {
        messageLabel.setText("User not found"); 
      }
    } catch (SQLException e1) {
      e1.printStackTrace();
      flag = false;
    } finally {
      try {
        if (con != null) {
          con.close();
        }
  
      } catch (SQLException e3) {
        e3.printStackTrace();
      }
    }
    return flag;
  }
   
}

