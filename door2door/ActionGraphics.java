package door2door;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
* ActionGraphics contains graphics.
*/

public class ActionGraphics extends JFrame {

  private static final long serialVersionUID = 1L;
  JFrame frame;
  JButton signUpButton;
  JButton loginButton;
  JLabel messageLabel;
  JLabel messageLabel2;


  /**
  * ActionGraphic's constructor.
  */

  ActionGraphics() {
    frame = new JFrame(); //creates the frame of my application
    frame.setTitle("Sign up or login to Door2Door"); //sets title of my frame
    
    ImageIcon image = new ImageIcon(getClass().getResource("/door2doorlogo2.png"));
    frame.setIconImage(image.getImage());
    
    signUpButton = new JButton("Sign Up");
    signUpButton.setBounds(100, 200, 100, 25);
    signUpButton.setFocusable(false);
    signUpButton.addActionListener(new ActionListener() {
      public  void actionPerformed(ActionEvent e) {
        messageLabel.setText("You will proceed to sign up");
        new SignUpGui();
        frame.dispose();
      }
    });
    frame.add(signUpButton);

    loginButton = new JButton("Login");
    loginButton.setBounds(200, 200, 100, 25);
    loginButton.setFocusable(false);
    loginButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        messageLabel.setText("You will proceed to Login");
        new LoginGui();
        frame.dispose();
      }
    });
    frame.add(loginButton);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
    frame.setSize(420, 420); //sets the x-dimension, and y-dimension of application
    frame.setLayout(null);
    frame.setVisible(true);
    frame.getContentPane().setBackground(new Color(204, 204, 204)); //change color of background
    messageLabel = new JLabel("Choose to log in or sign up"); 
    messageLabel.setBounds(130, 240, 240, 120);
    frame.add(messageLabel);
    messageLabel2 = new JLabel("The Door to Door universe...!");
    messageLabel2.setBounds(50, 50, 290, 120);
    messageLabel2.setFont(new Font("Verdana", Font.PLAIN, 18));
    frame.add(messageLabel2);
  }

  /**
  * main runs the program. 
  */

  public static void main(String [] args) {
    new ActionGraphics();
  }
}
