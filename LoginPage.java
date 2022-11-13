import static java.lang.System.out;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage implements ActionListener {

	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel ("userID:");
	JLabel userPasswordLabel = new JLabel ("password:");
	JLabel messageLabel = new JLabel("The text about the access will appear here");//message that show if login was successful
	HashMap<String,String> logininfo = new HashMap<String,String>();

	//constractor that has a hashmap as input
	LoginPage(HashMap<String,String> loginInfoOriginal){
		logininfo = loginInfoOriginal; //my subject will have its hashmap with its own name and password

		userIDLabel.setBounds(50,100,75,25);//x,y,w,height
		userPasswordLabel.setBounds(50,150,75,25);
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		loginButton.setBounds(125,200,100,25);
		messageLabel.setBounds(125,250,250,35);

		//messageLabel.setFont(new Font(null,Font.ITALIC,25));
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==loginButton){
				System.out.println("works");
				String userID = userIDField.getText();
				String password = String.valueOf(userPasswordField.getPassword());//I am at password field thats why im using valueOf

				if(logininfo.containsKey(userID)) {//logininfo is my HashMap
					if(logininfo.get(userID).equals(password)){//remember HashMap is value and key so I "get" the password with the ID as my key
						System.out.println("works");
						messageLabel.setText("Login successful");
						//will transfer to my welcome page
					}else{
						messageLabel.setText("Wrong password");
					}

				}else{
					messageLabel.setText("User not found.Please sign in");
				}
			}
		}
}
