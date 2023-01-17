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
* The class SignUpGui contains graphics for class SignUp.
* The classes SignUpGui and SignUp communicate without interfering with each other.
*/

public class SignUpGui extends JFrame {
  SignUp signup;
  String userId;
  String code;
  JFrame frame;
  JLabel userIdLabel;
  JLabel areacodeLabel;
  JLabel userPasswordLabel;
  JTextField userIdField;
  JTextField areacodeField;
  JPasswordField userPasswordField;
  JLabel messageLabel;
  JButton signUpButton;
  JButton resetButton;
  boolean flag;

  private static final long serialVersionUID = 1L;

  /**
  * Class's SignUpGui constructor.
  */
  
  SignUpGui() {
    frame = new JFrame(); //creates the frame of my application
    frame.setTitle("Sing up to Door2Door"); //sets title of my frame
    
    ImageIcon image = new ImageIcon(getClass().getResource("/door2doorlogo2.png"));
    frame.setIconImage(image.getImage());

    userIdLabel = new JLabel("Username:");
    userIdLabel.setBounds(50, 100, 75, 25); //x,y,w,height
    frame.add(userIdLabel);

    userPasswordLabel = new JLabel("Password:");
    userPasswordLabel.setBounds(50, 150, 75, 25);
    frame.add(userPasswordLabel);

    messageLabel = new JLabel("The text about the access will appear here"); 
    //message that show if login was successful
    messageLabel.setBounds(115, 240, 240, 120);
    frame.add(messageLabel);

    areacodeField = new JTextField();
    areacodeField.setBounds(125, 200, 200, 25);
    frame.add(areacodeField);

    areacodeLabel = new JLabel("Postal Code:");
    areacodeLabel.setBounds(50, 200, 75, 25);
    frame.add(areacodeLabel);

    userIdField = new JTextField();
    userIdField.setBounds(125, 100, 200, 25);
    frame.add(userIdField);

    userPasswordField = new JPasswordField();
    userPasswordField.setBounds(125, 150, 200, 25);
    frame.add(userPasswordField);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
    frame.setSize(420, 420); //sets the x-dimension, and y-dimension of application
    frame.setLayout(null);
    frame.setVisible(true);
    frame.getContentPane().setBackground(new Color(204, 204, 204)); //change color of background
 
    signup = new SignUp(this, userIdField, userPasswordField, messageLabel, areacodeField);
   
    signUpButton = new JButton("Sign Up");
    signUpButton.setBounds(125, 240, 100, 25);
    signUpButton.setFocusable(false);
    signUpButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        flag = signup.signUp1(); //We call the signUp1() method of class SignUp
        //System.out.println(flag);
        if (flag == true) {
          new WelcomePageGui(userIdField.getText(), areacodeField.getText());
          frame.dispose();
        }
      }
    });
    frame.add(signUpButton);
   
    JButton resetButton = new JButton("Reset");
    resetButton.setBounds(225, 240, 100, 25);
    resetButton.setFocusable(false);
    resetButton.addActionListener(new ActionListener() {
      public  void actionPerformed(ActionEvent e) {
        signup.reset();
        }
      });
    frame.add(resetButton);
   
  }  
       
}


