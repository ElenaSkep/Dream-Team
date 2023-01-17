package door2door;

import java.lang.System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
* The class Login.
*/
public class Login {
  JFrame frame = new JFrame();
  JLabel userIdLabel; 
  JLabel userPasswordLabel; 
  JTextField userIdField; 
  JPasswordField userPasswordField; 
  JTextField areacode; 
  JButton loginButton; 
  JLabel messageLabel; 
  LoginGui gui; 
  String myuser = "s"; 
  Connection con = null; //SQL
  PreparedStatement pst1 = null; //SQL
  PreparedStatement pst2 = null; //SQL
  ResultSet rs1 = null; //SQL
  ResultSet rs2 = null; //SQL
  String areacode1; 
  int aa; 
  boolean flag;
  
  /**
  * Constructor of Login 
  *  parameter parentGui is used for the grapgics.
  *  parameter userId the string value the user inputted as username.
  *  parameter code the string value the user inputted as password.
  *  parameter m the message JLabel parameter of graphics in order to use it in this class.
  *  parameter areacode the value the user inputted as postal code.
  */
  public Login(LoginGui parentGui, JTextField userId, 
         JPasswordField code, JLabel m, JTextField areacode) { //CONSTRACTOR
    gui = parentGui; 
    userIdField = userId; 
    userPasswordField = code; 
    messageLabel = m; 
    this.areacode = areacode; 
  }
  
  /**
  * loginmethod() checks whether the userid exists in the database.
  * In the case that the id exists, it checks if the password is correct.
  *  If the password is also correct, it procedes to the Welcome page.   
  *  In any case, it prints a message to inform the user of the progress.
  * no parameters
  * returns boolean, true if executed, to make the Maven tests work.
  */
  public boolean loginmethod() {
    try {
      System.out.println("works");
      //Sqlite2.connectiontrial2(); // makes the connection WITH MY DB IN SQL
      String sql1 = "SELECT * from users WHERE USERNAME = ? ; ";
      String sql2 = "SELECT * from users WHERE USERNAME = ? AND PASSWORD = ?; AND AREA_CODE = ?;";
      con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
      pst1 = con.prepareStatement(sql1); 
      pst1.setString(1, userIdField.getText()); 
      rs1 = pst1.executeQuery(); 
      if (rs1.next()) { //ID EXISTS
        myuser = userIdField.getText(); 
        areacode1 = areacode.getText(); 
        pst2 = con.prepareStatement(sql2); 
        pst2.setString(1, userIdField.getText()); //userIDField.getText()
        myuser = userIdField.getText(); 
        pst2.setString(2, String.valueOf(userPasswordField.getPassword()));
        //pst2.setString(3,areacode.getText());
        rs2 = pst2.executeQuery(); 
        if (rs2.next()) { //PASSWORD IS CORRECT
          System.out.println("checking password");
          messageLabel.setText("Login successful");
          flag = true;
          //Thread(2000);
          new WelcomePageGui(myuser, areacode1);
          if (con != null) {
            con.close();
            pst2.close();
          }
          //return flag;
        } else {
          messageLabel.setText("Wrong password");
        }
      } else {
        messageLabel.setText("User not found.Please sign up");
      }
    } catch (Exception e1) {
      System.out.println(e1);
    } finally {
      try {
        if (con != null) {
          con.close();
          pst1.close();
        }
      } catch (SQLException e3) {
        e3.printStackTrace();
      }
    }
    return flag;
  }
 
}



