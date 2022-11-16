import java.lang.System;
import java.util.HashMap;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;//javax.swing.JFrame + javax.swing.JButton + javax.swing.JTextField + javax.swing.JLabel;

public class LoginPage implements ActionListener {
	
	JFrame frame = new JFrame();
	JLabel userIDLabel;
	JLabel userPasswordLabel;
	JTextField userIDField;
	JPasswordField userPasswordField;
	JButton loginButton;
	JLabel messageLabel;
	HashMap<String,String> logininfo = new HashMap<String,String>();

	//constractor that has a hashmap as input.To make subjects with my hashmap
	LoginPage(HashMap<String,String> loginInfoOriginal){

	logininfo = loginInfoOriginal; //my subject will have its hashmap with its own name and password
		
	JFrame frame = new JFrame();//creates the frame of my application
	frame.setTitle("Log-in to Door2Door"); //sets title of my frame
		
	userIDLabel = new JLabel ("userID:");
	userIDLabel.setBounds(50,100,75,25);//x,y,w,height
	frame.add(userIDLabel);

	userPasswordLabel = new JLabel ("password:");
	userPasswordLabel.setBounds(50,150,75,25);
	frame.add(userPasswordLabel);

	userIDField = new JTextField();
	userIDField.setBounds(125,100,200,25);
	frame.add(userIDField);

	userPasswordField = new JPasswordField();
	userPasswordField.setBounds(125,150,200,25);
	frame.add(userPasswordField);

	loginButton = new JButton("Login");
	loginButton.setBounds(125,200,100,25);	
	loginButton.addActionListener(this);//I wanted a subject of type Actionlistener
	frame.add(loginButton);
		
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
