package door2door;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**.
 *This class is responsible for the graphics of one to one messages.
 *
 *@author DreamTeam.
*/
public class Dmgraphics extends JFrame {
  JButton sendButton;
  JFrame frame = new JFrame();
  JLabel userIdlabel;
  JTextField userIdfield;
  JTextField messageField;
  JButton searchButton;
  JLabel messageLabel;
  String myuser;
  private static final long serialVersionUID = 1L;
  /**.
   *This method creates the frame for one to one messages.
   *
   *@author DreamTeam.
   *
   *@param  myuser user is my username in the app.
   */
  
  Dmgraphics(String myuser) {
    this.myuser = myuser;
    JFrame frame = new JFrame();
    frame.setTitle("Send a DM ");
    userIdlabel = new JLabel("To:");
    userIdlabel.setBounds(50, 100, 75, 25); //x,y,w,height
    frame.add(userIdlabel);
    messageLabel = new JLabel("Message:");
    messageLabel.setBounds(50, 150, 75, 25);
    frame.add(messageLabel);
    userIdfield = new JTextField();
    userIdfield.setBounds(125, 100, 200, 25);
    frame.add(userIdfield);
    messageField = new JTextField();
    messageField.setBounds(125, 150, 200, 25);
    frame.add(messageField);
    sendButton = new JButton("Send");
    sendButton.setBounds(125, 200, 100, 25);
    frame.add(sendButton);
    messageLabel = new 
      JLabel("The text about the access will appear here");
    //message that show if login was successful
    messageLabel.setBounds(125, 250, 250, 35);
    frame.add(messageLabel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
    frame.setSize(420, 420); //sets the x-dimension, and y-dimension of application
    frame.setLayout(null);
    frame.setVisible(true);
    frame.getContentPane().setBackground(new Color(50, 180, 0)); //change color of background
    final Dm a = new Dm(this, userIdfield, messageField, messageLabel, myuser);
    sendButton.addActionListener(new ActionListener() {
      public  void actionPerformed(ActionEvent e) {
        a.try1();
      }
      });
    frame.add(sendButton);
    ImageIcon logoImage = new ImageIcon("door2doorlogo.jpg");
    frame.setIconImage(logoImage.getImage());
  }
}

