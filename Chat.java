package d2d;

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

public class Chat  implements ActionListener{
	
	String message;
	Connection con = null;//SQL VARIABLES
	PreparedStatement pst3 = null;//SQL VARIABLES
	ResultSet rs3 = null;//SQL VARIABLES
	public String myuser;
	public String touser;
	
	
	
	public   Chat(String myuser,String touser) {
		
	this.myuser=myuser;
	this.touser=touser;
	
	System.out.print(myuser+" " +"You can now send a message to user"+ "  "+  touser);
		
	}
					
			
				
			
		
	  
	
	
	public void actionPerformed(ActionEvent e){
		

	  	String str = e.getActionCommand();
	  	JFrame frame1=new JFrame("Chat");
	  	frame1.setSize(400,400);
	  	frame1.setLayout(null);
	  
	  		//got to work with the database now :))//
	  		try{
			
				String sql121 = "INSERT INTO one2one VALUES (?,?,?,?,?)";
				Class.forName("org.sqlite.JDBC");
		         
		        Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
		        Statement statement = con.createStatement();
		        
		        pst3=con.prepareStatement(sql121);
		       // System.out.println(getmyuser());
		        pst3.setString(1,myuser); //log.myuser
			    pst3.setString(2,touser);
				   System.out.println("you can now send a message to the user"+" ");
				   JLabel label1 = new JLabel("user:"+" "+message);
				   Scanner scanner = new Scanner(System.in);
				   
				    message=scanner.nextLine();
				
			
				   pst3.setString(3,message);
				  
				   String dates=Calendar.getInstance().toString();
					 
				   pst3.setString(4,dates);
				   
				   pst3.setString(5,"delivered");
				   statement.executeUpdate(sql121);
				  
				   pst3.execute();
				    
				   ResultSet res2 = statement.executeQuery("SELECT * FROM one2one WHERE toID = '+touser)+'");

					 while (res2.next()) {
						

					 System.out.println(res2.getString("message")) ;


					 }
			   
			 //   ResultSet resultset = statement.executeQuery(sql121);
			    
			    frame1.add(label1);
				label1.setBounds(0,0,700,50);
				ReceiveMessage obj1=new ReceiveMessage();
				int c=obj1.receive();
				while(c==1){
				//JLabel label2 = new JLabel(touser)+":"+" "+scanner.nextLine());
				//frame1.add(label2);
				//label2.setBounds(0,20,700,50);
				
				String sql1212 = "INSERT INTO one2one VALUES (?,?,?,?,?)";
				Class.forName("org.sqlite.JDBC");
		         
		        Connection con2 = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
		        Statement statement2 = con.createStatement();
		        
		        pst3=con.prepareStatement(sql121);
		        
		        pst3.setString(1,myuser); //log.myuser
			    pst3.setString(2,touser);
				   System.out.println("you can now send a message to the user"+" "+touser);
				   JLabel label12 = new JLabel("user:"+" "+message);
				   Scanner scanner2 = new Scanner(System.in);
				   
				    message=scanner.nextLine();
				
			
				   pst3.setString(3,message);
				   String dates2=Calendar.getInstance().toString();
					 
				   pst3.setString(4,dates2);
				   pst3.setString(5,"delivered");
				   statement.executeUpdate(sql1212);
				   
					pst3.execute();
				
				
				
				
				
				
					int c1=obj1.receive();
					c=c1;
				
				
				
			   }
				}catch(Exception e121) {
				
				System.out.println(e121);
			}finally {
				
				try {
					if(con != null) 
						con.close();
					    pst3.close();
			
				}catch ( SQLException e12) {
					e12.printStackTrace();
					
				}
			}
				

		frame1.setVisible(true);

		}
		 // System.out.println(a);

		

				}

		
	
	
	
	
	
	
	
	


