package Door2Door;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpGui extends JFrame{

	SignUp signup;
	String userID;
	String code;
	JFrame frame;
	JLabel userIDLabel;
	JLabel areacodeLabel;
	JLabel userPasswordLabel;
	JTextField userIDField;
	JTextField areacodeField;
	JPasswordField userPasswordField;
	JLabel messageLabel;
	JButton SignUpButton;
	JButton ResetButton;
	
	private static final long serialVersionUID = 1L;

	SignUpGui(){
		frame = new JFrame();//creates the frame of my application
		frame.setTitle("Sing up to Door2Door"); //sets title of my frame
		
	
		userIDLabel = new JLabel ("Username:");
		userIDLabel.setBounds(50,100,75,25);//x,y,w,height
		frame.add(userIDLabel);

		userPasswordLabel = new JLabel ("Password:");
		userPasswordLabel.setBounds(50,150,75,25);
		frame.add(userPasswordLabel);
		
		messageLabel = new JLabel("The text about the access will appear here"); //message that show if login was successful
		messageLabel.setBounds(115,240,240,120);
		frame.add(messageLabel);
		
		areacodeField = new JTextField();
		areacodeField.setBounds(125,200,200,25);
		frame.add(areacodeField); 
		 
		areacodeLabel = new JLabel ("Postal Code:");
		areacodeLabel.setBounds(50,200,75,25);
		frame.add(areacodeLabel);
		 
		userIDField = new JTextField();
   		userIDField.setBounds(125,100,200,25);
   		frame.add(userIDField);

   		userPasswordField = new JPasswordField();
   		userPasswordField.setBounds(125,150,200,25);
   		frame.add(userPasswordField);

   		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
   		frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
   		frame.setLayout(null);
   		frame.setVisible(true);
   		frame.getContentPane().setBackground(new Color(204,204,204)); //change color of background
 
   		signup = new SignUp(this,userIDField, userPasswordField,messageLabel,areacodeField);
   		
		JButton SignUpButton = new JButton("Sign Up");
		SignUpButton.setBounds(125,240,100,25);
		SignUpButton.setFocusable(false);
		SignUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				boolean flag = signup.signUp1();
				System.out.println(flag);
				if (flag==true) {
					frame.dispose();
					System.out.println(flag);
				}
				}
			});
   		frame.add(SignUpButton);
   		
   		JButton ResetButton = new JButton("Reset");
   		ResetButton.setBounds(225,240,100,25);
   		ResetButton.setFocusable(false);
   		ResetButton.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e){
				signup.reset();
				 System.out.println("works");
					}
				});
   		frame.add(ResetButton);
   		
	}   
        
}

