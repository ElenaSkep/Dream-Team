package d2d2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ActionGraphics extends JFrame {

JFrame frame = new JFrame();

	JButton SignUpButton;
	JButton LoginButton;
	JLabel messageLabel;

	//constructor
	ActionGraphics(){
    JFrame frame = new JFrame();//creates the frame of my application
   		frame.setTitle("Sign up or login to Door2Door"); //sets title of my frame

   		SignUpButton = new JButton("Sign Up");
		SignUpButton.setBounds(125,200,100,25);
		SignUpButton.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e){
				messageLabel.setText("You will proceed to sign up");
				new SignUpPage2();
			}
		});//I wanted a subject of type Actionlistener//
		
		frame.add(SignUpButton);

		LoginButton = new JButton("Login");
		LoginButton.setBounds(225,200,100,25);
		LoginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				messageLabel.setText("You will proceed to Login");
				new Login2(); 
			}
			});//I wanted a subject of type Actionlistener//
		frame.add(LoginButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
		frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
		frame.setLayout(null);
		frame.setVisible(true);
   		frame.getContentPane().setBackground(new Color(204,204,204)); //change color of background


   		//Icon bug = new ImageIcon(getClass().getResource("door2doorlogo.jpg"));
		//messageLabel = new JLabel("Choose to log in or sign up", bug, SwingConstants.CENTER); //message that show if login was successful
   		messageLabel = new JLabel("Choose to log in or sign up");
		messageLabel.setBounds(115,240,240,120);
	    frame.add(messageLabel);
	}

	  


	}
