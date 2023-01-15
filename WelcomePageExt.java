package Door2Door;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;


/**
 * public class declaration.
 */
public class WelcomePageExt {
  JButton b1;
  JButton b2;
  //JFrame frame = new JFrame();//creates the frame of my application
  String myuser;
  String tk;
  boolean flag;
  Connection con54 = null; 
  PreparedStatement pst19 = null; 
  ResultSet rs3 = null; 
  Statement stmt = null; 

  WelcomePageExt(String a, String b) {
    myuser = a;
    tk = b;
  } 
  
  /**
   * public method declaration.
   */

  public boolean messages1() {
    System.out.println(flag);
    try { 
      con54 = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
      stmt = con54.createStatement();
      rs3 = stmt.executeQuery("SELECT save, fromuser FROM messagesonetoone WHERE "
        + "touser = '" + myuser + "';");
      System.out.println("hello" + myuser);
      while (rs3.next()) {
        System.out.println(rs3.getString("fromuser")
            + ": " + rs3.getString("save"));

      } 
      stmt.close();
      con54.close();
    } catch (Exception e1) {
      System.out.println(e1);
    } finally {
      try {

        if (con54 != null) {
          con54.close();
        }
      } catch (SQLException e3) {
        e3.printStackTrace();
      } 
    } 
    flag = true;
    return flag;  
  } 
} 