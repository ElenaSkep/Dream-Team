package connection2;

import java.lang.System;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;//javax.swing.JFrame + javax.swing.JButton + javax.swing.JTextField + javax.swing.JLabel;
import java.sql.*;
import java.util.Scanner;

public class Login extends JFrame implements ActionListener {
        LoginGraphics l = new LoginGraphics();
		JFrame frame = new JFrame();
		JLabel userIDLabel;
		JLabel userPasswordLabel;
		JTextField userIDField;
		JPasswordField userPasswordField;
		JButton loginButton;
		JLabel messageLabel;

        public String myuser="s";
		Connection con = null;//SQL
		PreparedStatement pst1 = null;//SQL
		PreparedStatement pst2 = null;//SQL
		ResultSet rs1 = null;//SQL
		ResultSet rs2 = null;//SQL
		Login(){ //CONSTRACTOR
			System.out.println("just pressed login");
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

					    pst2.setString(2,String.valueOf(userPasswordField.getPassword()));
					    rs2 = pst2.executeQuery();
						if (rs2.next()) {//PASSWORD IS CORRECT

						    System.out.println("checking password");
							messageLabel.setText("Login successful");




							  System.out.println("1 to start a new conversation or 2 to check messages");
							  Scanner scanner = new Scanner(System.in);

							   String answer=scanner.nextLine();

							  if (answer=="1") {
							  Chatdemo newchat = new Chatdemo();
						   }else {

								   Receivemessage view = new Receivemessage();
								   view.receive();




						   }

							  if(con != null)
									con.close();

								  pst2.close();

						}else
							messageLabel.setText("Wrong password");


				} else {
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

		}
	}
