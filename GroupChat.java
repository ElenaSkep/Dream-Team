import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import java.awt.TextField;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class GroupChat implements ActionListener {
	

	    JFrame frame = new JFrame();
		JLabel sendMessage;
		JTextField messageField;
		JButton messageButton;
		JLabel messageLabel;
		String message;
		Connection connection = null ;
		PreparedStatement pst3 = null;
		String datetime;

    public GroupChat() {
    	Sqlite3.connectiontrial3();
		JFrame frame = new JFrame();
		frame.setTitle("GroupChat of Door2Door");

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
		
		 System.out.println("about to connect for the groupchat");


		if(e.getSource()==messageButton){

				message = messageField.getText();
				System.out.println("Success");
				messageLabel.setText("Message sent!");
				try {
					Class.forName("org.sqlite.JDBC");
			        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
			        Statement statement = connection.createStatement();
			        System.out.println("before writing the query");
					String sql=("INSERT INTO groupmessages VALUES (?,?,?);");
					System.out.println("after writing the query");
					pst3 = connection.prepareStatement(sql);
					System.out.println("after prep statement");
					
					SimpleDateFormat formatter = new SimpleDateFormat(" HH:mm"+ " " +"(dd-MM-YYYY)");
				    Date date = new Date(System.currentTimeMillis());
				  //  System.out.println(formatter.format(date));
					datetime= date.toString();
				    
					pst3.setString(1,"its me");
					pst3.setString(2,message);
					pst3.setString(3,datetime);
					System.out.println("before executing the query");
                   statement.executeUpdate(sql);
				   pst3.execute();
					
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

