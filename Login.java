//package Door2Door;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.lang.System;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;//javax.swing.JFrame + javax.swing.JButton + javax.swing.JTextField + javax.swing.JLabel;
import java.sql.*;
import java.util.Scanner;

public class Login {

		JFrame frame = new JFrame();
		JLabel userIDLabel;
		JLabel userPasswordLabel;
		JLabel PostalCodeLabel;
		JTextField userIDField;
		JPasswordField userPasswordField;
		JTextField PostalCodeField;
		JButton loginButton;
		JLabel messageLabel;

		LoginGui gui;
        public String myuser="s";
		Connection con = null;//SQL
		PreparedStatement pst1 = null;//SQL
		PreparedStatement pst2 = null;//SQL
		ResultSet rs1 = null;//SQL
		ResultSet rs2 = null;//SQL
		String tk;
		int a;

		public Login (LoginGui parentGui, JTextField userID,JPasswordField code, JLabel m){ //CONSTRACTOR
			gui = parentGui;
			userIDField = userID;
			userPasswordField = code;
			messageLabel = m;
		}

		public void try1() {
			try{
			 System.out.println("works");
			//Sqlite2.connectiontrial2(); // makes the connection WITH MY DB IN SQL
			String sql1 = "SELECT * from users WHERE USERNAME = ? ; ";
			String sql2 = "SELECT * from users WHERE USERNAME = ? AND PASSWORD = ?;";
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
				        GroupChat2 chat = new GroupChat2(myuser);
					}else{
						SearchBar2 s =new SearchBar2(myuser);
				    }

					if (con != null) {
					    con.close();
		                pst2.close();
					}

				} else {
					messageLabel.setText("Wrong password");
				}
		   } else {
		       messageLabel.setText("User not found.Please sign up");
		   }

		   }catch(Exception e1){
		       System.out.println(e1);
		   }finally {
			    try {
					if(con != null) {
					con.close();
					//pst2.close();
					pst1.close();
					}
				}catch ( SQLException e3) {
				    e3.printStackTrace();
				}
			}
		}
	}


