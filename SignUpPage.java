package connection2;

import java.lang.System;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;//javax.swing.JFrame + javax.swing.JButton + javax.swing.JTextField + javax.swing.JLabel;
import java.sql.*;



public class SignUpPage1 implements ActionListener {
	    SignUpPage1Graphics b = new SignUpPage1Graphics();
	    JFrame frame = new JFrame();
		JLabel userIDLabel;
		JLabel userPasswordLabel;
		JTextField userIDField;
		JPasswordField userPasswordField;
		JButton SignUpButton;
		JButton ResetButton;
		JLabel messageLabel;

		Connection con = null;//SQL VARIABLES
		PreparedStatement pst3 = null;//SQL VARIABLES
		ResultSet rs3 = null;//SQL VARIABLES
		SignUpPage1() {
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

					pst3.setString(1,userIDField.getText());

					pst3.setString(2,String.valueOf(userPasswordField.getPassword()));

                    statement.executeUpdate(sql);



					pst3.execute();



					messageLabel.setText("Sign up successful");
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

			if(e.getSource()==ResetButton){
				userIDField.setText("");
				userPasswordField.setText("");
				System.out.println("works");
				messageLabel.setText("Reset successful");
				//will transfer to my welcome page
			}

	   		}
	}
}
