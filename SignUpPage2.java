package d2d2;

import java.lang.System;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;//javax.swing.JFrame + javax.swing.JButton + javax.swing.JTextField + javax.swing.JLabel;
import java.sql.*;



public class SignUpPage2 implements ActionListener {
	


	    JFrame frame = new JFrame();
		JLabel userIDLabel;
		JLabel userPasswordLabel;
		JLabel areacodeLabel;
		JTextField userIDField;
		JTextField areacodeField;
		JPasswordField userPasswordField;
		JButton SignUpButton;
		JButton ResetButton;
		JLabel messageLabel;
		int a;
		Connection con = null;//SQL VARIABLES
		PreparedStatement pst3 = null;//SQL VARIABLES
		ResultSet rs3 = null;//SQL VARIABLES
        public String name;
        boolean flag;
 
	   SignUpPage2() { //CONSTRACTOR

	   	JFrame frame = new JFrame();//creates the frame of my application
	   	frame.setTitle("Sing up to Door2Door"); //sets title of my frame

	   	userIDLabel = new JLabel ("Username:");
	   	userIDLabel.setBounds(50,100,75,25);//x,y,w,height
	   	frame.add(userIDLabel);

	   	userPasswordLabel = new JLabel ("Password:");
	   	userPasswordLabel.setBounds(50,150,75,25);
	   	frame.add(userPasswordLabel);
	   	
	   	areacodeLabel = new JLabel ("area code:");
		areacodeLabel.setBounds(50,200,75,25);
		frame.add(areacodeLabel);

	   	userIDField = new JTextField();
	   	userIDField.setBounds(125,100,200,25);
	   	frame.add(userIDField);

	   	userPasswordField = new JPasswordField();
	   	userPasswordField.setBounds(125,150,200,25);
	   	frame.add(userPasswordField);
	   	
	   	areacodeField = new JTextField();
		areacodeField.setBounds(125,200,200,25);
		frame.add(areacodeField);

	   	SignUpButton = new JButton("Sign Up");
	   	SignUpButton.setBounds(125,250,100,25);
	   	SignUpButton.setFocusable(false);
	   	SignUpButton.addActionListener(this);
	   	frame.add(SignUpButton);

	   	ResetButton = new JButton("Reset Up");
		ResetButton.setBounds(225,250,100,25);
		ResetButton.setFocusable(false);
		ResetButton.addActionListener(this);
	   	frame.add(ResetButton);

	   	messageLabel = new JLabel("The text about the access will appear here");//message that show if login was successful
	   	messageLabel.setBounds(125,300,250,35);
	   	frame.add(messageLabel);

	   	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
	   	frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
	   	frame.setLayout(null);
	   	frame.setVisible(true);
	   	frame.getContentPane().setBackground(new Color(50,180,0)); //change color of background

	   	ImageIcon logoImage = new ImageIcon("logo.png");
	   	frame.setIconImage(logoImage.getImage());

		}


	   public void actionPerformed(ActionEvent e) {
		   //value:"surevalue"-"surevalue";
		  
	   		if(e.getSource()==SignUpButton){
				try{
					 //Sqlite2.connectiontrial2(); // makes the connection WITH MY DB IN SQL
					String sql = "INSERT INTO users VALUES (?,?,?);";
					
					
					
					Class.forName("org.sqlite.JDBC");
			         
			        
			
						
					Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
					
					//con=Sqlite2.connectiontrial2();
					
					Statement statement = con.createStatement();
					
					pst3 = con.prepareStatement(sql); //remember: [PreparedStatement pst3 = null;] at first lines
					
					//boolean flag=false;
					
					
					
					//while (flag==false) {
					
						
						if (userIDField.getText().isEmpty()==true||userIDField.getText()=="testing" ||String. valueOf(userPasswordField.getPassword()).isEmpty()== true ) {
						
							//messageLabel.setText("Please enter username & password");
							
							//Thread.sleep(1000);
							
							 SignUpPage2 s2 = new SignUpPage2();
							 messageLabel.setText("Please enter username & password");
							//userIDField.getText();
							//userPasswordField.getPassword();
							//SignUpButton.setText(userIDField.getText());
							//SignUpButton.setText(String.valueOf(userPasswordField.getPassword()));
					        
					     
							
						}else {
							 flag = true;
							name=userIDField.getText();
						pst3.setString(1,name);
						
						pst3.setString(2,String.valueOf(userPasswordField.getPassword()));
						pst3.setString(3,areacodeField.getText());

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
	   
	   public void setname(String name) {
		   this.name=name;
		 
		  
	   }
	   public String getname() {
		   return name;
		 
		  
	   }
	   public boolean getflag() {
		   return flag;
	   }
	   
	   

}

