import java.awt.*;
import java.awt.Component;
import java.lang.Object;
import java.lang.System;
import java.util.HashMap;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;//javax.swing.JFrame + javax.swing.JButton + javax.swing.JTextField + javax.swing.JLabel;

public class SignUpPage implements ActionListener{

    JFrame frame = new JFrame();
	JLabel userIDLabel;
	JLabel userPasswordLabel;
	JTextField userIDField;
	JPasswordField userPasswordField;
	JButton SignUpButton;
	JButton ResetButton;
	JLabel messageLabel;

	HashMap<String,String> signUp = new HashMap<String,String>();

	 private String username;

	 private String password;
//HashMap<String,String> SignUpInfoOriginal

   SignUpPage(){

	//signUp = SignUpInfoOriginal;


   	JFrame frame = new JFrame();//creates the frame of my application
   	frame.setTitle("Sing up to Door2Door"); //sets title of my frame

   	userIDLabel = new JLabel ("Username:");
   	userIDLabel.setBounds(50,100,75,25);//x,y,w,height
   	frame.add(userIDLabel);

   	userPasswordLabel = new JLabel ("Password:");
   	userPasswordLabel.setBounds(50,150,75,25);
   	frame.add(userPasswordLabel);

   	userIDField = new JTextField();
   	userIDField.setBounds(125,100,200,25);
   	frame.add(userIDField);

   	userPasswordField = new JPasswordField();
   	userPasswordField.setBounds(125,150,200,25);
   	frame.add(userPasswordField);

   	SignUpButton = new JButton("Sign Up");
   	SignUpButton.setBounds(125,200,100,25);
   	SignUpButton.setFocusable(false);
   	SignUpButton.addActionListener(this);//I wanted a subject of type Actionlistener
   	frame.add(SignUpButton);

   	ResetButton = new JButton("Reset Up");
	ResetButton.setBounds(225,200,100,25);
	ResetButton.setFocusable(false);
	ResetButton.addActionListener(this);//I wanted a subject of type Actionlistener
   	frame.add(ResetButton);

   	messageLabel = new JLabel("The text about the access will appear here");//message that show if login was successful
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

   @Override
		public void actionPerformed(ActionEvent e) {
   		if(e.getSource()==SignUpButton){
   			 this.username = userIDField.getText();
   			 this.password = String.valueOf(userPasswordField.getPassword());//I am at password field thats why im using valueOf
				System.out.println("works");
				messageLabel.setText("Sign up successful");
 				//will transfer to my welcome page
			}
			if(e.getSource()==ResetButton){
			   	userIDField.setText("");
			   	userPasswordField.setText("");
					System.out.println("works");
					messageLabel.setText("Reset successful");
			 		//will transfer to my welcome page
			}

	}
	//signUp.setSignUp(username, password);
}

