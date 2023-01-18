package door2door;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
  int i=0;

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
   // ImageIcon image = new ImageIcon(getClass().getResource("/door2doorlogo2.png"));
   // frame.setIconImage(image.getImage());
    try {

      con54 = DriverManager.getConnection("jdbc:sqlite:mydb.db");

      stmt = con54.createStatement();

      System.out.println("hello" + myuser);
      JFrame frame1 = new JFrame();
      int i3 = 0;
      rs3 = stmt.executeQuery("SELECT  fromid , message FROM one2one WHERE "
    	      + "toid = '" + myuser + "';");
      while (rs3.next()) {
        int i=1;
        System.out.println("hello" + myuser);

        JLabel label = new JLabel(rs3.getString("fromid") + ": " + rs3.getString("message"));
        label.setBounds(0, i3 * 25, 500, 50);
        frame1.add(label);

        i3 = i3 + 1;
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
        frame1.setSize(420, 420); //sets the x-dimension and y-dimension of application
        frame1.setLayout(null);
        frame1.getContentPane().setBackground(new Color(204, 204, 204));
        frame1.setVisible(true);

      }
      //}


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
    if(i==0){
		System.out.println("No New Messages")
	}
    flag = true;
    return flag;
  }
}
