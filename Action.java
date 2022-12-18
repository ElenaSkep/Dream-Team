import java.awt.*;
import java.awt.Component;
import java.lang.Object;
import java.lang.System;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Action implements ActionListener{


	String[] usernames = new String[5000];
	String[] passwords = new String[5000];

	JFrame frame = new JFrame();

	JButton SignUpButton;
	JButton LoginButton;
	JLabel messageLabel;

	//constructor
	Action(){
		JFrame frame = new JFrame();//creates the frame of my application
   		frame.setTitle("Sing up or login to Door2Door"); //sets title of my frame

   		SignUpButton = new JButton("Sign Up");
		SignUpButton.setBounds(125,200,100,25);
		SignUpButton.addActionListener(this);//I wanted a subject of type Actionlistener
		frame.add(SignUpButton);

		LoginButton = new JButton("Login");
		LoginButton.setBounds(225,200,100,25);
		LoginButton.addActionListener(this);//I wanted a subject of type Actionlistener
		frame.add(LoginButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
		frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
		frame.setLayout(null);
		frame.setVisible(true);
   		frame.getContentPane().setBackground(new Color(50,180,0)); //change color of background

   		messageLabel = new JLabel("Choose to log in or sign up");//message that show if login was successful
		messageLabel.setBounds(125,250,250,35);
    	frame.add(messageLabel);
}

   	@Override
			public void actionPerformed(ActionEvent e) {
		   		if(e.getSource() == SignUpButton){
					messageLabel.setText("You will proceed to sign up");
					SignUpPage signUpPage = new SignUpPage(usernames, passwords);
				}
				if (e.getSource() == LoginButton) {
					messageLabel.setText("You will proceed to log in");
			        LoginPage loginPage = new LoginPage(usernames, passwords);
			    }

       	}

	}

