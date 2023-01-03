package d2d;



import java.lang.System;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;//javax.swing.JFrame + javax.swing.JButton + javax.swing.JTextField + javax.swing.JLabel;
import java.sql.*;
import java.util.Scanner;

public class Login extends JFrame implements ActionListener {
	
		JFrame frame = new JFrame();
		JLabel userIDLabel;
		JLabel userPasswordLabel;
		JTextField userIDField;
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
		Login(){ //CONSTRACTOR
			JFrame frame = new JFrame();//creates the frame of my application
			frame.setTitle("Log-in to Door2Door"); //sets title of my frame

			userIDLabel = new JLabel ("userID:");
			userIDLabel.setBounds(50,100,75,25);
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

	       
			Connection con=null;


			if(e.getSource()==loginButton){

				String sql1 = "SELECT * from users WHERE USERNAME = ? ; ";
				String sql2 = "SELECT * from users WHERE USERNAME = ? AND PASSWORD = ?;";
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
					    rs2 = pst2.executeQuery();
						if (rs2.next()) {//PASSWORD IS CORRECT

						    System.out.println("checking password");
							messageLabel.setText("Login successful");




							  System.out.println("1:Groupchat 2:DM");
							  Scanner scanner = new Scanner(System.in);

							  String answer=scanner.nextLine();

							  if (answer=="1") {
							
							 GroupChat  chat = new GroupChat(myuser);
						  }else {

								SearchBar s=new SearchBar(myuser);



						 //  }

							  if(con != null) {
									con.close();

								  pst2.close();

						} else
							messageLabel.setText("Wrong password");

						  }
						  } else 
						messageLabel.setText("User not found.Please sign up");
						//SignUpPage signUpPage = new SignUpPage();OR PUT A SIGN UP BOTTON

						}
				
				}catch(Exception e1){
					System.out.println(e1);
				}finally {
					try {

						if(con != null)
							con.close();
						  //pst2.close();
						  pst1.close();

					}catch ( SQLException e3) {
						e3.printStackTrace();

					}



				}


	}

		
//public void setmyuser(String myuser) {
			
			//this.myuser=myuser;
		//}
		
		 //  public String getmyuser () {
			 //  System.out.println(myuser);
			 //  return myuser;
			   
			   
				
			//}
	}
}
