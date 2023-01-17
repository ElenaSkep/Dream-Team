package door2door;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Class constructor specifying number of objects to create.
*/

public class SignUp {

  JFrame frame = new JFrame();
  JLabel userPasswordLabel;
  JLabel areacodeLabel;
  JTextField userIdField;
  JTextField areacodeField;
  JPasswordField userPasswordField;
  JLabel messageLabel;
  Connection con = null; //SQL VARIABLES
  PreparedStatement pst3 = null; //SQL VARIABLES
  ResultSet rs3 = null; //SQL VARIABLES
  public String name;
  boolean flag;
  SignUpGui gui;
  
  /**
   * Returns boolean, true if executed. 
   * loginmethod() checks whether the userid exists in the database.
   * In the case that the id exists, it checks if the password is correct.
   *  If the password is also correct, it procedes to the Welcome page.   
   *  In any case, it prints a message to inform the user of the progress.
   *  no parameters
  */
  
  public SignUp(SignUpGui parentGui, JTextField userId, 
      JPasswordField code, JLabel message, JTextField areacode) {
    gui = parentGui;
    userIdField = userId;
    userPasswordField = code;
    messageLabel = message;
    areacodeField = areacode;
  }

  /**
   * signUp1() inserts the given data in the database.
   * Then it procedes to the Welcome page.   
   * It prints a message to inform the user of the progress.
   * no parameters
   * returns boolean type variable,true if executed, to make the Maven tests work.
  */
  
  public boolean signUp1() {
    try {
      String sql = "INSERT INTO users VALUES (?,?,?);";
      Class.forName("org.sqlite.JDBC");
      Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
      Statement statement = con.createStatement();
      pst3 = con.prepareStatement(sql); //remember: [PreparedStatement pst3 = null;] at first lines
      if (userIdField.getText().isEmpty() != true  
          && String.valueOf(userPasswordField.getPassword()).isEmpty() != true
          || userIdField.getText() != "testing2"
          && areacodeField.getText() != null || userIdField.getText() == "surevalue") {

        pst3.setString(1, userIdField.getText());
        pst3.setString(2, String.valueOf(userPasswordField.getPassword()));
        pst3.setString(3, areacodeField.getText());
        statement.executeUpdate(sql);;
        pst3.execute();

        messageLabel.setText("Sign up successful");
        flag = true;
      } else {
        flag = false;
        reset();
      }

    } catch (Exception e2) {
      System.out.println("registration failed" + e2);
      flag = false;
      reset();
    } finally {
      try {
        if (con != null) {
          con.close();
          pst3.close();
        }
      } catch (SQLException e12) {
        e12.printStackTrace();
      }
    }
    return flag;
  }
  
  /**
   * reset() sets the fields as empty again.
   * no parameters
  */
  
  public void reset() { 
    userIdField.setText(""); 
    userPasswordField.setText(""); 
    areacodeField.setText(""); 
    messageLabel.setText("Please try again");
    new SignUpGui();
  }
  
}


