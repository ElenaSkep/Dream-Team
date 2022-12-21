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



public abstract class SearchBarGraphics implements ActionListener {
	JLabel userIDLabel;
	JTextField userIDField;
	JButton SearchButton;
    JLabel messageLabel;
    JFrame frame = new JFrame();//creates the frame of my application

    SearchBarGraphics() {
	frame.setTitle("Door2Door Search Bar"); //sets title of my frame

	userIDLabel = new JLabel ("Search Bar");
	userIDLabel.setBounds(50,100,75,25);//x,y,w,height
	frame.add(userIDLabel);

	userIDField = new JTextField();
	userIDField.setBounds(125,100,200,25);
	frame.add(userIDField);

	SearchButton = new JButton("Search");
	SearchButton.setBounds(125,200,100,25);
	SearchButton.setFocusable(false);
	SearchButton.addActionListener(this);//I wanted a subject of type Actionlistener
	frame.add(SearchButton);


	Icon bug1 = new ImageIcon(getClass().getResource("door2doorlogo.jpg"));
	messageLabel = new JLabel("The text about the search will appear here", bug1, SwingConstants.CENTER);//message that show if login was successful
	messageLabel.setBounds(115,240,240,120);
	frame.add(messageLabel);

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
	frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
	frame.setLayout(null);
	frame.setVisible(true);
	frame.getContentPane().setBackground(new Color(204, 204, 204)); //change color of background

	ImageIcon logoImage = new ImageIcon("logo.png");
	frame.setIconImage(logoImage.getImage());
}
}
