package door2door;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GroupChatGraphics extends JFrame {
GroupChatMessages g;
JFrame frame = new JFrame();
JLabel sendMessage;
JTextField messageField;
JButton messageButton;
JLabel messageLabel;
String myuser;
String areacode;

    private static final long serialVersionUID = 1L;

    GroupChatGraphics(String myuser,String areacode) {
    this.myuser=myuser;
    this.areacode=areacode;
    JFrame frame = new JFrame();
    frame.setTitle("Send a message to Door2Door");

sendMessage = new JLabel ("message:");
sendMessage.setBounds(50,100,75,25);
frame.add(sendMessage);

messageButton = new JButton("Message");
messageButton.setBounds(125,200,100,25);
messageButton.setFocusable(false);
frame.add(messageButton);

messageLabel = new JLabel("Send a message to your neighbours");
messageLabel.setBounds(115,240,240,120);
frame.add(messageLabel);

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
frame.setLayout(null);
frame.setVisible(true);
frame.getContentPane().setBackground(new Color(204,204,204));

messageField = new JTextField();
messageField.setBounds(125,100,200,25);
   frame.add(messageField);
 
        
   
   GroupChat g = new GroupChat(this, messageField, messageLabel, myuser,  areacode);

   messageButton.addActionListener(new ActionListener() {
  public  void actionPerformed(ActionEvent e){

   g.messageSend();

}
});
 

}

}

