import java.lang.System;
import java.util.HashMap;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; //javax.swing.JFrame + javax.swing.JButton + javax.swing.JTextField + javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public abstract class LoginGraphics implements ActionListener{

	    JFrame frame = new JFrame();
		JLabel userIDLabel;
		JLabel userPasswordLabel;
		JTextField userIDField;
		JPasswordField userPasswordField;
		JButton loginButton;
		JLabel messageLabel;
	    HashMap<String,String> logininfo = new HashMap<String,String>();

	    LoginGraphics() {
		JFrame frame = new JFrame();//creates the frame of my application
		frame.setTitle("Login to Door2Door"); //sets title of my frame

		Icon bug1 = new ImageIcon(getClass().getResource("door2doorlogo.jpg"));
		messageLabel = new JLabel("The text about the access will appear here", bug1, SwingConstants.CENTER); //message that show if login was successful
		messageLabel.setBounds(115,240,240,120);
		frame.add(messageLabel);

		userIDLabel = new JLabel ("userID:");
		userIDLabel.setToolTipText("Set userID");
		userIDLabel.setBounds(50,100,75,25);//x,y,w,height
		frame.add(userIDLabel);

		userPasswordLabel = new JLabel ("password:");
		userPasswordLabel.setToolTipText("Set password");
		userPasswordLabel.setBounds(50,150,75,25);
		frame.add(userPasswordLabel);

		userIDField = new JTextField();
		userIDField.setBounds(125,100,200,25);
		frame.add(userIDField);

		userPasswordField = new JPasswordField();
		userPasswordField.setBounds(125,150,200,25);
		frame.add(userPasswordField);

		loginButton = new JButton("Login");
		loginButton.setBounds(125,200,100,25);
		loginButton.addActionListener(this);//I wanted a subject of type Actionlistener
		frame.add(loginButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
		frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
		frame.setLayout(null);
		frame.setVisible(true);
	    frame.getContentPane().setBackground(new Color(204,204,204)); //change color of background

	    ImageIcon logoImage = new ImageIcon("door2doorlogo.jpg");
		frame.setIconImage(logoImage.getImage());

	}

}