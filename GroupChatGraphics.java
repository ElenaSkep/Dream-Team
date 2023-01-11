import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GroupChatGraphics extends JFrame {
	GroupChat g;
	JFrame frame = new JFrame();
	JLabel sendMessage;
	JTextField messageField;
	JButton messageButton;
	JButton b1;
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



		messageLabel = new JLabel("The text about the access will appear here");
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

        //GroupChatMessages gr= new GroupChatMessages(areacode);
		GroupChat g = new GroupChat(this,messageField,messageLabel,myuser,areacode);

		messageButton = new JButton("Send");
		messageButton.setBounds(125,200,100,25);
		messageButton.setFocusable(false);
		messageButton.addActionListener(new ActionListener() {
		public  void actionPerformed(ActionEvent e){
			g.groupchatmethod();
			//gr.showMessages();
			}
		}); //I wanted a subject of type Actionlistener
		frame.add(messageButton);

		frame.setLayout(new BorderLayout());

		b1 = new JButton("Back");
		b1.setBounds(125,200,100,25);
		b1.setFocusable(false);
		b1.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e){
				dispose();
				System.out.println(e);
				WelcomePagewith3button k = new WelcomePagewith3button(myuser);
			}
		} );
		frame.add(b1, BorderLayout.SOUTH);


		ImageIcon logoImage = new ImageIcon("door2doorlogo.jpg");
		frame.setIconImage(logoImage.getImage());

		}

}

