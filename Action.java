import java.awt.*;
import java.awt.Component;
import java.lang.Object;
import java.lang.System;
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
		   		if(e.getSource()==SignUpButton)
					messageLabel.setText("You will proceed to sign up");
					SignUpPage signUpPage = new SignUpPage();
				}
				if (e.getSource() == LoginButton) {
		                    messageLabel.setText("You will proceed to log in");
			            LoginPage loginPage = new LoginPage();
				    loginPage.actionPerformed(e);
			            System.out.println("just pressed login");
			    }

       	}

	}
