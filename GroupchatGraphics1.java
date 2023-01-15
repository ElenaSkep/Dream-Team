package Door2Door;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GroupchatGraphics1 extends JFrame {
	GroupChatMessages g;
	JFrame frame;
	JLabel sendMessage;
	JTextField messageField;
	JButton messageButton;
	JLabel messageLabel;
	String myuser;
	String areacode;
	boolean flag;
	
    private static final long serialVersionUID = 1L;

    GroupchatGraphics1(String myuser,String areacode) {
    	
    	this.myuser=myuser;
       	this.areacode=areacode;
        frame = new JFrame();
        frame.setTitle("Send a message to Door2Door");

        sendMessage = new JLabel ("message:");
        sendMessage.setBounds(50,100,75,25);
        frame.add(sendMessage);

        messageLabel = new JLabel("Type your message");
        messageLabel.setBounds(110,200,240,120);
        frame.add(messageLabel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
        frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(0,102,0));

        messageField = new JTextField();
        messageField.setBounds(120,100,190,25);
        frame.add(messageField);
     
            //GroupChatMessages gr= new GroupChatMessages(areacode);
       
        g = new GroupChatMessages(this, messageField, messageLabel, myuser,  areacode);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
   		frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
   		frame.setLayout(null);
   		frame.setVisible(true);
   		frame.getContentPane().setBackground(new Color(204,204,204)); 
        
        messageButton = new JButton("Message");
        messageButton.setBounds(125,200,100,25);
        messageButton.setFocusable(false);
        messageButton.addActionListener(new ActionListener() {
    	   public  void actionPerformed(ActionEvent e){

    		   flag=g.groupchatmethod();
    		   if (flag==true) {
					frame.dispose();
				}

    	   }
        });
        frame.add(messageButton);
 
    }

}