//package Door2Door;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;

public class LoginGui extends JFrame {

	Login login;
	JFrame frame = new JFrame();
	JLabel userIDLabel;
	JLabel userPasswordLabel;
	JLabel PostalCodeLabel;
	JTextField userIDField;
	JPasswordField userPasswordField;
	JTextField PostalCodeField;
	JButton loginButton;
	JLabel messageLabel;
	String code;

	private static final long serialVersionUID = 1L;

	LoginGui() {

		JFrame frame = new JFrame();//creates the frame of my application
		frame.setTitle("Log-in to Door2Door"); //sets title of my frame

		userIDLabel = new JLabel ("userID:");
		userIDLabel.setBounds(50,100,75,25);
		frame.add(userIDLabel);

		userPasswordLabel = new JLabel ("password:");
		userPasswordLabel.setBounds(50,150,75,25);
		frame.add(userPasswordLabel);

		PostalCodeLabel = new JLabel ("Postal Code:");
		PostalCodeLabel.setBounds(50,200,75,25);
		frame.add(PostalCodeLabel);

		userIDField = new JTextField();
		userIDField.setBounds(125,100,200,25);
		frame.add(userIDField);

		userPasswordField = new JPasswordField();
		userPasswordField.setBounds(125,150,200,25);
		frame.add(userPasswordField);

		PostalCodeField = new JTextField();
		PostalCodeField.setBounds(125,200,200,25);
		frame.add(PostalCodeField);

		messageLabel = new JLabel("The text about the access will appear here");//message that show if login was successful
		messageLabel.setBounds(125,350,250,35);
		frame.add(messageLabel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
		frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
		frame.setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(50,180,0)); //change color of background

		Login login = new Login(this,userIDField, userPasswordField,messageLabel);

		loginButton = new JButton("Login");
		loginButton.setBounds(125,300,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e){
				login.loginmethod();
				}
			}); //I wanted a subject of type Actionlistener
		frame.add(loginButton);

		ImageIcon logoImage = new ImageIcon("door2doorlogo.jpg");
		frame.setIconImage(logoImage.getImage());

	}

}


