package d2d2;

import java.util.ArrayList;
import java.util.Calendar;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class Chat2 implements ActionListener  {
	
	String message;
	Connection con = null;//SQL VARIABLES
	PreparedStatement pst3 = null;//SQL VARIABLES
	ResultSet rs3 = null;//SQL VARIABLES
	public String myuser;
	public String touser;
	JTextField messageField;
	JButton messageButton;
	JLabel Message;
	JLabel messageLabel;
	
	
	public   Chat2(String myuser,String touser) {
		
	this.myuser=myuser;
	this.touser=touser;
	
	
	JFrame frame = new JFrame();
	frame.setTitle("Send a message to Door2Door");

	 Message = new JLabel ("Message:");
	Message.setBounds(50,100,75,25);
	frame.add(Message);

	 messageButton = new JButton("Send");
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
		

		if(e.getSource()==messageButton){
             message = messageField.getText();
	  		//got to work with the database now :))//
	  		try{
			  
				String sql121 = "INSERT INTO one2one VALUES (?,?,?,?,?)";
				Class.forName("org.sqlite.JDBC");
		         
		        Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
		        Statement statement = con.createStatement();
		       // System.out.println( con != null && !con.isClosed());
		        pst3=con.prepareStatement(sql121);
		        System.out.println(myuser);
		        System.out.println(touser);
		        pst3.setString(1,myuser); //log.myuser
			    pst3.setString(2,touser);
				 
				  
				
					
				  
				 
			
			
				   pst3.setString(3,message);
				   
				 //  String dates=Calendar.getInstance().toString();
					 
				   pst3.setString(4,"now");
				   
				   pst3.setString(5,"delivered");
				 //statement.executeUpdate(sql121);
				 
				   //System.out.println( con != null && !con.isClosed());
				   pst3.execute();
				   System.out.println("after query");
				    
				 //  ResultSet res2 = statement.executeQuery("SELECT * FROM one2one ");
				  
					// while (res2.next()) {
						

					//System.out.println(res2.getString("message")) ;


					// }
			   
			 //   ResultSet resultset = statement.executeQuery(sql121);
			    
			    //frame1.add(label1);
				//label1.setBounds(0,0,700,50);
				//ReceiveMessage2 obj1=new ReceiveMessage2();
				//int c=obj1.receive();
				//while(c==1){
				//JLabel label2 = new JLabel(touser)+":"+" "+scanner.nextLine());
				//frame1.add(label2);
				//label2.setBounds(0,20,700,50);
				
				//String sql1212 = "INSERT INTO one2one VALUES (?,?,?,?,?)";
				//Class.forName("org.sqlite.JDBC");
		         
		       // Connection con2 = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
		       // Statement statement2 = con.createStatement();
		        
		      //  pst3=con.prepareStatement(sql121);
		        
		       // pst3.setString(1,myuser); 
			   // pst3.setString(2,touser);
				//   System.out.println("you can now send a message to the user"+" "+touser);
				  // JLabel label12 = new JLabel("user:"+" "+message);
				  // Scanner scanner2 = new Scanner(System.in);
				   
				  //  message=scanner.nextLine();
				
			
				  // pst3.setString(3,message);
				  // String dates2=Calendar.getInstance().toString();
					 
				  // pst3.setString(4,dates2);
				   //pst3.setString(5,"delivered");
				 //  statement.executeUpdate(sql1212);
				   
				//	pst3.execute();
				
				
				
				
				
				
					//int c1=obj1.receive();
					//c=c1;
				
				
				
			 //  }
				}catch(Exception e121) {
				
				System.out.println(e121);
			}finally {
				
				try {
					if(con != null) 
						con.close();
					   
			
				}catch ( SQLException e12) {
					e12.printStackTrace();
					
				}
			}
				

		//frame1.setVisible(true);

		}
		 // System.out.println(a);

		

				}


}	
	
	
	
	
