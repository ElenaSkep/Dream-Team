import java.awt.*;
import java.awt.Component;
import java.lang.Object;
import java.lang.System;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.awt.Color;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;//javax.swing.JFrame + javax.swing.JButton + javax.swing.JTextField + javax.swing.JLabel;

public class SignUpPage extends Action implements ActionListener {

    JFrame frame = new JFrame();
	JLabel userIDLabel;
	JLabel userPasswordLabel;
	JTextField userIDField;
	JPasswordField userPasswordField;
	JButton SignUpButton;
	JButton ResetButton;
	JLabel messageLabel;

	 private String username;
	 private String password;
	 int count = 0;

     String[] usernames;
	 String[] passwords;

   SignUpPage(String[] usernames, String[] passwords){

	this.usernames = usernames;
	this.passwords = passwords;

	//BufferedWriter writer = new BufferedWriter(new FileWriter("myFile.txt", false));

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

	/*public void setCount() {
		count++;
	}
	public void setUsernames() {
			count++;
	}
	public void setCount() {
			count++;
	}
*/
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}

   @Override
		public void actionPerformed(ActionEvent e) {
   		if(e.getSource()==SignUpButton) {
   			this.username = userIDField.getText();
   			this.password = String.valueOf(userPasswordField.getPassword());//I am at password field thats why im using valueOf
   			usernames[count] = getUsername();
   			System.out.println(usernames[count]);
			passwords[count] = getPassword();
			count++;
			try {
				PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
				writer.println("The first line");
				writer.println("The second line");
				writer.close();
			} catch (IOException a) {
				System.out.println("An error has occured");
			}
			//writer.write(usernames[count].toString());
            //writer.newLine();
			//writer.write(passwords[count].toString());
            //writer.newLine();
			//setCount();
			System.out.println("works");
			messageLabel.setText("Sign up successful");
 				//will transfer to my welcome page
 				//WelcomePage welcome = new WelcomePage();
			}
			if(e.getSource()==ResetButton){
			   	userIDField.setText("");
			   	userPasswordField.setText("");
					System.out.println("works");
					messageLabel.setText("Reset successful");
			 		//will transfer to my welcome page
			}
			for (int i = 0; i <= count; i++) {
			System.out.println(usernames[count]);
		}
		//writer.close();
		//writer.flush();
      	System.out.println("Data Entered in to the file successfully");
	}
}

