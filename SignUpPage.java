package connection2;

import java.lang.System;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;//javax.swing.JFrame + javax.swing.JButton + javax.swing.JTextField + javax.swing.JLabel;
import java.sql.*;



public class SignUpPage implements ActionListener {
	


	    JFrame frame = new JFrame();
		JLabel userIDLabel;
		JLabel userPasswordLabel;
		JTextField userIDField;
		JPasswordField userPasswordField;
		JButton SignUpButton;
		JButton ResetButton;
		JLabel messageLabel;
		int a;
		Connection con = null;//SQL VARIABLES
		PreparedStatement pst3 = null;//SQL VARIABLES
		ResultSet rs3 = null;//SQL VARIABLES


	   SignUpPage() { //CONSTRACTOR

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
				try{
					 //Sqlite2.connectiontrial2(); // makes the connection WITH MY DB IN SQL
					String sql = "INSERT INTO users VALUES (?,?);";
					
					
					
					Class.forName("org.sqlite.JDBC");
			         
			        
			
						
					Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
					
					//con=Sqlite2.connectiontrial2();
					
					Statement statement = con.createStatement();
					
					pst3 = con.prepareStatement(sql); //remember: [PreparedStatement pst3 = null;] at first lines
					
					//boolean flag=false;
					
					
					
					//while (flag==false) {
					
						
						if (userIDField.getText().isEmpty()==true||String. valueOf(userPasswordField.getPassword()).isEmpty()== true ) {
						
							//messageLabel.setText("Please enter username & password");
							
							//Thread.sleep(1000);
							
							 SignUpPage s2 = new SignUpPage();
							//userIDField.getText();
							//userPasswordField.getPassword();
							//SignUpButton.setText(userIDField.getText());
							//SignUpButton.setText(String.valueOf(userPasswordField.getPassword()));
					        
					     
							
						}else {
						//	flag=true;
						pst3.setString(1,userIDField.getText());
						
						pst3.setString(2,String.valueOf(userPasswordField.getPassword()));

	                    statement.executeUpdate(sql);
					
						
						
						pst3.execute();
						a=1;
						messageLabel.setText("Sign up successful");
						
						}
						
					//}
					
					
					
	 			//will transfer to my welcome page
				}catch(Exception e2){
					System.out.println("registration failed" + e2);
				}finally {
					
					try {
						if(con != null) 
							con.close();
						  pst3.close();
				
					}catch ( SQLException e12) {
						e12.printStackTrace();
						
					}
				}
			
	   		} else if(e.getSource()==ResetButton){
				System.out.println("works");
				userIDField.setText("");
				userPasswordField.setText("");
			
				messageLabel.setText("Reset successful");
				//will transfer to my welcome page
			}

	   		
	}
	   
	   public int getA() {
		 
		   return a;
	   }

}




