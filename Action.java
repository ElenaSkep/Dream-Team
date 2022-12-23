import java.awt.*;
import java.awt.Component;
import java.lang.Object;
import java.lang.System;
import java.util.HashMap;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Action implements ActionListener{

	JFrame frame = new JFrame();
	JButton SignUpButton;
	JButton LoginButton;
	JLabel messageLabel;
	ActionGraphics a = new ActionGraphics();

	//constructor
	Action(){
    }
    @Override
			public void actionPerformed(ActionEvent e) {
		   		if(e.getSource()==SignUpButton){
                    System.out.println(e);
					messageLabel.setText("You will proceed to sign up");
					String name = "";
		        	String password = "";
					IDandPasswords iDandPasswords = new IDandPasswords();
					SignUpPage signUpPage = new SignUpPage();
				}
				if (e.getSource() == LoginButton) {
					messageLabel.setText("You will proceed to log in");
					IDandPasswords iDandPasswords = new IDandPasswords();
				    iDandPasswords.getLoginInfo();//makes subject to bring my hash map at the main class
			        LoginPage loginPage = new LoginPage(iDandPasswords.getLoginInfo());
			    }

       	}

	}