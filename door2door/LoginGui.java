package door2door;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
* LoginGui contains graphics for class Login.
* The classes LoginGui and Login communicate without interfering with each other 
*/

public class LoginGui extends JFrame {

  Login login;
  JFrame frame;
  JLabel userIdlabel;
  JLabel userPasswordLabel;
  JLabel postalCodeLabel;
  JTextField userIdfield;
  JPasswordField userPasswordField;
  JTextField postalCodeField;
  JButton loginButton;
  JLabel messageLabel;
  String code;
  boolean xx;  

  private static final long serialVersionUID = 1L;
  
  /**
   * Class's LoginGui constructor.
   */
  
  LoginGui() {
    frame = new JFrame(); //creates the frame of my application
    frame.setTitle("Log-in to Door2Door"); //sets title of my frame
    
    ImageIcon image = new ImageIcon(getClass().getResource("/door2doorlogo2.png"));
    frame.setIconImage(image.getImage());

    userIdlabel = new JLabel("userID:");
    userIdlabel.setBounds(50, 100, 75, 25);
    frame.add(userIdlabel);

    userPasswordLabel = new JLabel("password:");
    userPasswordLabel.setBounds(50, 150, 75, 25);
    frame.add(userPasswordLabel);

    postalCodeLabel = new JLabel("Postal Code:");
    postalCodeLabel.setBounds(50, 200, 75, 25);
    frame.add(postalCodeLabel);

    userIdfield = new JTextField();
    userIdfield.setBounds(125, 100, 200, 25);
    frame.add(userIdfield);

    userPasswordField = new JPasswordField();
    userPasswordField.setBounds(125, 150, 200, 25);
    frame.add(userPasswordField);

    postalCodeField = new JTextField();
    postalCodeField.setBounds(125, 200, 200, 25);
    frame.add(postalCodeField);

    messageLabel = new JLabel("The text about the access will appear here"); 
    //message that show if login was successful
    messageLabel.setBounds(125, 350, 250, 35);
    frame.add(messageLabel);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
    frame.setSize(420, 420); //sets the x-dimension, and y-dimension of application
    frame.setLayout(null);
    frame.setVisible(true);
    frame.getContentPane().setBackground(new Color(204, 204, 204)); //change colour of background
    
    login = new Login(this, userIdfield, userPasswordField, messageLabel, postalCodeField);

    loginButton = new JButton("Login");
    loginButton.setBounds(125, 300, 100, 25);
    loginButton.setFocusable(false);
    loginButton.addActionListener(new ActionListener() {
      public  void actionPerformed(ActionEvent e) {
        xx = login.loginmethod();
        if (xx == true) {
          frame.dispose();
        }
      }
    });
    frame.add(loginButton);

  }

}
