package d2d2;

import java.lang.System;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;//javax.swing.JFrame + javax.swing.JButton + javax.swing.JTextField + javax.swing.JLabel;
import java.sql.*;
import java.util.Scanner;

public class Login2 extends JFrame implements ActionListener {
	
		JFrame frame = new JFrame();
		JLabel userIDLabel;
		JLabel userPasswordLabel;
		JLabel areacodeLabel;
		JTextField userIDField;
		JTextField areacodeField;
		JPasswordField userPasswordField;
		JButton loginButton;
		JLabel messageLabel;
		 //LoginGraphics l = new LoginGraphics();
        public String myuser="s";
		Connection con = null;//SQL
		PreparedStatement pst1 = null;//SQL
		PreparedStatement pst2 = null;//SQL
		ResultSet rs1 = null;//SQL
		ResultSet rs2 = null;//SQL
		String answer;
		boolean flag;
		//LoginGraphics l2=new LoginGraphics();
		Login2(){ //CONSTRACTOR
			JFrame frame = new JFrame();//creates the frame of my application
			frame.setTitle("Log-in to Door2Door"); //sets title of my frame

			userIDLabel = new JLabel ("userID:");
			userIDLabel.setBounds(50,100,75,25);
			frame.add(userIDLabel);

			userPasswordLabel = new JLabel ("password:");
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

			loginButton = new JButton("Login");
			loginButton.setBounds(125,250,100,25);
			loginButton.addActionListener(this);//I wanted a subject of type Actionlistener
			frame.add(loginButton);

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

	       
			Connection con=null;


			if(e.getSource()==loginButton){

				String sql1 = "SELECT * from users WHERE USERNAME = ? ; ";
				String sql2 = "SELECT * from users WHERE USERNAME = ? AND PASSWORD = ? AND AREA_CODE = ?;";
				try{

						con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");


					pst1 = con.prepareStatement(sql1);

					pst1.setString(1,userIDField.getText());
					
					rs1 = pst1.executeQuery();

					if (rs1.next()) { //ID EXISTS
						 
                        myuser=userIDField.getText();
						pst2 = con.prepareStatement(sql2);
						pst2.setString(1,userIDField.getText()); //userIDField.getText()
						myuser=userIDField.getText();
					    pst2.setString(2,String.valueOf(userPasswordField.getPassword()));
					    pst2.setString(3, areacodeField.getText());
					    rs2 = pst2.executeQuery();
						if (rs2.next()) {//PASSWORD IS CORRECT

		
							messageLabel.setText("Login successful");

                            flag=true;


							// System.out.println("1:Groupchat 2:DM");
							// Scanner scanner = new Scanner(System.in);

							// answer=scanner.nextLine();

							  //if (answer=="1") {
							
							 
							 
							 //} else if(answer=="2") {

								



						  // }

							 
						   } else {
							messageLabel.setText("Wrong password");
                              flag=false;}
						  
						  } else 
							  
						messageLabel.setText("User not found.Please sign up");
						//SignUpPage signUpPage = new SignUpPage();OR PUT A SIGN UP BOTTON

						
				
				}catch(Exception e1){
					System.out.println(e1);
				}finally {
					try {
                       
						if(con != null) {
							con.close();
						 
						}

					}catch ( SQLException e3) {
						e3.printStackTrace();
               }

				
			
				if (flag==true) {
					WelcomePage w=new WelcomePage(myuser);
					//System.out.println("1:GROUPCHAT 2:ONE2ONE");
					//Scanner s=new Scanner(System.in);
					//int a= s.nextInt();
					//if(a==1) {
						//GroupChat2 c=new GroupChat2(myuser);
					//}else if(a==2) { 
					   // SearchBar2 sb=new SearchBar2(myuser);
					//}
						;
					//s.actionPerformed(e);
					
					
					//System.out.println("pote");
					//System.out.println(s.getflag());
					//if(s.getflag()==true) {
						//System.out.print("come on call chat");
						//Chat2 c=new Chat2(myuser,s.getuser());
						
					}
		
//public void setmyuser(String myuser) {
			
			//this.myuser=myuser;
		}
		}
		
		   
		}
		}
