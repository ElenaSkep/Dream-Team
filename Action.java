package d2d2;



import java.lang.System;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Action extends JFrame {

	JFrame frame = new JFrame();
	JButton SignUpButton;
	JButton LoginButton;
	JLabel messageLabel;
	ActionGraphics a = new ActionGraphics();

	//constructor
	Action() {
		JButton SignUpButton = new JButton("Sign up");
		SignUpButton.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e){
				messageLabel.setText("You will proceed to sign up");
				new SignUpPage2();
			}
		});
		JButton LoginButton = new JButton("Login");
		LoginButton.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e){
				messageLabel.setText("You will proceed to sign up");
				new Login2();
			}
		});
		
	}
   

	

	}