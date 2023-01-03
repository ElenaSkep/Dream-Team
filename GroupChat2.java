package d2d2;

import java.util.Scanner;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import java.awt.TextField;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class GroupChat2 implements ActionListener {
	

	    JFrame frame = new JFrame();
		JLabel sendMessage;
		JTextField messageField;
		JButton messageButton;
		JLabel messageLabel;
		String message;
		Connection connection = null ;
		PreparedStatement pst3 = null;
		public String myuser;

    public GroupChat2(String myuser) {
    	
    	this.myuser=myuser;
    	try {
			Class.forName("org.sqlite.JDBC");
	        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
		 Statement statement2 = connection.createStatement();
		 ResultSet resultset = statement2.executeQuery("SELECT * FROM groupmess  WHERE message<>'null'");
		 while (resultset.next()) {

			 System.out.println(resultset.getString("message")+ ":" + resultset.getString("fromid")) ;

			 }

		}catch(Exception s) {
		}finally {
			try {
				if(connection != null) 
					connection.close();
				
		
			}catch ( SQLException e12) {
				e12.printStackTrace();
				
			}
			
		}
    
		JFrame frame = new JFrame();
		frame.setTitle("Send a message to Door2Door");

		sendMessage = new JLabel ("message:");
		sendMessage.setBounds(50,100,75,25);
		frame.add(sendMessage);

		messageButton = new JButton("Message");
		messageButton.setBounds(125,200,100,25);
		messageButton.addActionListener(this);
		frame.add(messageButton);

		messageLabel = new JLabel("The text about the access will appear here");
		messageLabel.setBounds(115,240,240,120);
		frame.add(messageLabel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
		frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
		frame.setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(0,102,0));

		messageField = new JTextField();
	    messageField.setBounds(125,100,200,25);
	   	frame.add(messageField);


	}

	public void actionPerformed(ActionEvent e){
	
     //    Login l = new Login();
     //  System.out.println(  l.getmyuser());
		
		
		if(e.getSource()==messageButton){

				message = messageField.getText();
				
				messageLabel.setText("Message sent!");
				try {
					Class.forName("org.sqlite.JDBC");
			        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
			        Statement statement = connection.createStatement();
			        
			       
					String sql="INSERT INTO groupmess VALUES (?,?,?,?);";
					
					pst3 = connection.prepareStatement(sql);
					
					
					pst3.setString(1,message);
					pst3.setString(2,myuser);
					pst3.setString(3,"2022-12-12 7:20:01");
					pst3.setString(4,"11527");
                   statement.executeUpdate(sql);
				   pst3.execute();
                   System.out.println("success");
					
				}catch(Exception e5){
					System.out.println("man you cant do this because of" + e5);
					
				}finally {
					
					try {
						if(connection != null) 
							connection.close();
						  pst3.close();
				
					}catch ( SQLException e12) {
						e12.printStackTrace();
						
					}
				}
				
		}

		
	}

   
}

