import java.awt.*;
import java.awt.Component;
import java.lang.Object;
import java.lang.System;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class SearchBar implements ActionListener {//Maybe a WlcomePage is needed

	JFrame frame = new JFrame();
	JLabel userIDLabel;
	JTextField userIDField;
	JButton SearchButton;
	JLabel messageLabel;

	  String username;
	  String users[];

	  SearchBar(String users[]){

		 this.users = users;

		 JFrame frame = new JFrame();//creates the frame of my application
		 frame.setTitle("Sing up to Door2Door"); //sets title of my frame

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

		messageLabel = new JLabel("The text about the search will appear here");//message that show if login was successful
		messageLabel.setBounds(125,250,250,35);
		frame.add(messageLabel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
		frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
		frame.setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(50,180,0)); //change color of background

		ImageIcon logoImage = new ImageIcon("logo.png");
		frame.setIconImage(logoImage.getImage());
	}
		boolean flag = false;
	@Override
			public void actionPerformed(ActionEvent e) {
	   		if(e.getSource()==SearchButton) {
	   			username = userIDField.getText();
	   			System.out.println(username);
				for (int i = 0; i < users.length; i++){
					if (users[i].equals(username)) {
						flag = true;
						System.out.println("works2");
						messageLabel.setText("User found");
						//Goes to chat
					}
				}
				if (flag == false) {
					messageLabel.setText("User not found");
					System.out.println("works3");
				}
		}
	}
}
