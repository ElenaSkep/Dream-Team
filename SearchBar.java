package connection2;


import java.lang.System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SearchBar implements ActionListener {//Maybe a WlcomePage is needed

	JFrame frame = new JFrame();
	JLabel userIDLabel;
	JTextField userIDField;
	JButton SearchButton;
	JLabel messageLabel;
    String username1;
	public Connection con= null;
	PreparedStatement pst3=null;
	boolean result = false;
	ResultSet rs=null;
	String sql=null;
	Statement statement =null;
    String finalresult="";

	 SearchBar(){
		 try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         JFrame frame = new JFrame();//creates the frame of my application
		 frame.setTitle("Sing up to Door2Door"); //sets title of my frame
         userIDLabel = new JLabel ("Search Bar");
		 userIDLabel.setBounds(50,100,75,25);//x,y,w,height
		 frame.add(userIDLabel);
         userIDField = new JTextField();
		 userIDField.setBounds(125,100,200,25);
		 frame.add(userIDField);
		SearchButton = new JButton("Search");
		SearchButton.setBounds(125,200,100,25);
		SearchButton.setFocusable(false);
		SearchButton.addActionListener(this);//I wanted a subject of type Actionlistener
		frame.add(SearchButton);
        messageLabel = new JLabel("The text about the search will appear here");//message that show if login was successful
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
		boolean flag = false;
		@Override
			public void actionPerformed(ActionEvent e) {
	   		if(e.getSource()==SearchButton) {
	   			username1 = userIDField.getText();
				String sql = "SELECT username FROM users WHERE username = '"+username1+"' ";
	            try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
		        } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				;
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
					 Statement statement = con.createStatement();
					 pst3 = con.prepareStatement(sql);
				 } catch (SQLException e1) {
				     e1.printStackTrace();}
				try {
				Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
		         pst3.execute();
				 Statement statement = con.createStatement();
				 ResultSet rs = statement.executeQuery(sql);
			    String finalresult=null;
					finalresult = rs.getString(1) ;
					System.out.println(finalresult);
					System.out.println(username1);
					 boolean comp =username1.equals(finalresult);
					 System.out.println(comp);
					  if(comp) {
						messageLabel.setText("User found");
							//Goes to chat
						}else {
					  messageLabel.setText("User not found");}
				   } catch (SQLException e1) {
				   e1.printStackTrace();
			}try {
				if(con != null)
					con.close();


			}catch ( SQLException e24) {
				e24.printStackTrace();

			}
		}
	}
}

