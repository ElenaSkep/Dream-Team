package d2d2;
import java.lang.System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DMGraphics extends JFrame{
	JButton SendButton;
	JFrame frame = new JFrame();
	JLabel userIDLabel;
	JTextField userIDField;
	JTextField messageField;
	JButton SearchButton;
	JLabel messageLabel;
	private static final long serialVersionUID = 1L;



	DMGraphics() {
	
	JFrame frame = new JFrame();
	
	frame.setTitle("Send a DM ");
	userIDLabel = new JLabel ("To:");
	  userIDLabel.setBounds(50,100,75,25);//x,y,w,height
	  frame.add(userIDLabel);

	  messageLabel = new JLabel ("Message:");
	  messageLabel.setBounds(50,150,75,25);
	  frame.add(messageLabel);

	  userIDField = new JTextField();
	  userIDField.setBounds(125,100,200,25);
	  frame.add(userIDField);

	  messageField = new JTextField();
	  messageField.setBounds(125,150,200,25);
	  frame.add(messageField);

		SendButton = new JButton("Send");
	   	SendButton.setBounds(125,200,100,25);
	   	
	   	frame.add(SendButton);


	messageLabel = new JLabel("The text about the access will appear here");//message that show if login was successful
	  messageLabel.setBounds(125,250,250,35);
	  frame.add(messageLabel);
	 
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
	  frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
	  frame.setLayout(null);
	  frame.setVisible(true);
	  frame.getContentPane().setBackground(new Color(50,180,0)); //change color of background
	  

	   Dm a = new Dm(this,userIDField,messageField,messageLabel);
	 
	   SendButton.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e){
				a.try1();
				}
			});
  		frame.add(SendButton);

			ImageIcon logoImage = new ImageIcon("door2doorlogo.jpg");
			frame.setIconImage(logoImage.getImage());


	}
	}




