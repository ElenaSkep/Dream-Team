import java.lang.System;
import java.util.HashMap;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;//javax.swing.JFrame + javax.swing.JButton + javax.swing.JTextField + javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LoginPage extends JFrame implements ActionListener {

	JFrame frame = new JFrame();
	JLabel userIDLabel;
	JLabel userPasswordLabel;
	JTextField userIDField;
	JPasswordField userPasswordField;
	JButton loginButton;
	JLabel messageLabel;
	HashMap<String,String> logininfo = new HashMap<String,String>();

	//constractor that has a hashmap as input.To make subjects with my hashmap
	LoginPage(HashMap<String,String> loginInfoOriginal) {

	logininfo = loginInfoOriginal;

    }

	@Override

	public void actionPerformed(ActionEvent e) {
		//LoginGraphics l = new LoginGraphics();//
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

				WelcomePage k = new WelcomePage();

				}else{
					messageLabel.setText("User not found.Please sign in");
				}
			}
		}
	}

