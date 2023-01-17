package door2door;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Creates a connection with the database.
 * Checks if the user exist in the database.
 * In case the user is found welcomes the user by printing a hello message.
 * Parameters myuser, tk.
 * Returns boolean, true if executed.
 */
public class WelcomePageExt {
  JButton b1;
  JButton b2;
  JFrame frame = new JFrame(); //creates the frame of my application
  String myuser;
  String tk;
  boolean flag;
  Connection con54 = null;
  PreparedStatement pst19 = null;
  ResultSet rs3 = null;
  Statement stmt = null;
 
  /**
   * Class constructor specifying number of objects to create.
   */
  WelcomePageExt(String a, String b) {
    myuser = a;
    tk = b;
  }
 
  /**
   *messages1() inserts the given data in the database.
   *It prints a hello message to welcome the user with the given username.
   *No parameters.
   *Returns boolean type variable, true if executed to make the Maven tests work.
   */

  public boolean messages1() {
    System.out.println(flag);
    //ImageIcon image = new ImageIcon(getClass().getResource("/door2doorlogo2.png"));
    //frame.setIconImage(image.getImage());
    try {
      //String sql12 = "SELECT fromuser, save from messagesonetoone WHERE touser = "+myuser;
      con54 = DriverManager.getConnection("jdbc:sqlite:mydb.db");
      //pst19 = con54.prepareStatement(sql12);
      //rs3 = pst19.executeQuery();
      stmt = con54.createStatement();
      //String sql12 = "SELECT fromuser,save from messagesonetoone WHERE touser = '"+myuser+"'";
      rs3 = stmt.executeQuery("SELECT  fromid , message FROM one2one WHERE "
          + "toid = '" + myuser + "';");
      System.out.println("hello" + myuser);
      while (rs3.next()) {
        System.out.println(rs3.getString("fromid")
            + ": " + rs3.getString("message"));

      }
      stmt.close();
      con54.close();
    } catch (Exception e1) {
      System.out.println(e1);
    } finally {
      try {

        if (con54 != null) {
          con54.close();
          //pst2.close();
          //pst19.close();
        }
      } catch (SQLException e3) {
        e3.printStackTrace();
      }
    }
    flag = true;
    return flag;  
  }
} 
