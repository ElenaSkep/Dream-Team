import java.awt.*;
import java.awt.Component;
import java.lang.Object;
import java.lang.System;
import java.util.HashMap;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;//javax.swing.JFrame + javax.swing.JButton + javax.swing.JTextField + javax.swing.JLabel;

public class SignUpPage extends JFrame implements ActionListener{
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
   //SignUpPageGraphics k = new SignUpPageGraphics();
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
