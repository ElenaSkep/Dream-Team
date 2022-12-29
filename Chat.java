package connection2;
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

public class Chat extends Login implements ActionListener{
	String myuser;
	String message;
	Connection con = null;//SQL VARIABLES
	PreparedStatement pst3 = null;//SQL VARIABLES
	ResultSet rs3 = null;//SQL VARIABLES
	ArrayList<String> users = new ArrayList<>();
	
	
	public   Chat() {
		
	
		
		try{
			
			String sql3 = "SELECT distinct username FROM users ;";
			String sql32 = "SELECT distinct COUNT( username ) FROM users ;";
			Class.forName("org.sqlite.JDBC");
			
	         
	        Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
	        Statement statement = con.createStatement();
		
				ResultSet r = statement.executeQuery(sql32);

				//int count=0;
				// while (r.next()) {
					
   
	                //count=count+1;				
                    //}
				
				
		
				ResultSet rs = statement.executeQuery(sql3);
				while (rs.next()) {
				
					users.add(rs.getString("username"));
					//System.out.println(rs.getString("username"));
					
				}
				   
					JFrame frame= new JFrame("users");
				    frame.setSize(400,400);
				    frame.setLayout(null);
				    for(int i3=0;i3<users.size();i3++) {
				    	//System.out.println(users.get(i3));
				    	JLabel label = new JLabel(users.get(i3));
				    	frame.add(label);
						label.setBounds(0,i3*25,500,50);
			
						JButton b=new JButton("Add" + " "+users.get(i3));
						frame.add(b);
			        	b.setBounds(50,i3*35,100,20);
						frame.setSize(400,400);
				    	b.addActionListener(this);

				    	
				    }
					
			
					   
					    
					    
						frame.setVisible(true); 
	

	
		}catch(Exception e4){
			System.out.println("into catch");
			
		}finally{
			try {
				if(con != null) 
					con.close();
				
		
			}catch ( SQLException e) {
	
			e.printStackTrace();
				
			}
		}
			
		}
	   
	
	
	public void actionPerformed(ActionEvent e){
		

	  	String str = e.getActionCommand();
	  	JFrame frame1=new JFrame("Chat");
	  	frame1.setSize(400,400);
	  	frame1.setLayout(null);
	  	 for(int i=0 ; i<users.size() ; i++){
	  	if (str.equals("Add"+" "+users.get(i))){
	  		//got to work with the database now :))//
	  		try{
			
				String sql121 = "INSERT INTO one2one VALUES (?,?,?,?,?)";
				Class.forName("org.sqlite.JDBC");
		         
		        Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
		        Statement statement = con.createStatement();
		        
		        pst3=con.prepareStatement(sql121);
		        System.out.println(getmyuser());
		        pst3.setString(1,"justme"); //log.myuser
			    pst3.setString(2,users.get(i));
				   System.out.println("you can now send a message to the user"+" "+users.get(i));
				   JLabel label1 = new JLabel("user:"+" "+message);
				   Scanner scanner = new Scanner(System.in);
				   
				    message=scanner.nextLine();
				
			
				   pst3.setString(3,message);
				  
				   String dates=Calendar.getInstance().toString();
					 
				   pst3.setString(4,dates);
				   System.out.println("hi");
				   pst3.setString(5,"delivered");
				   statement.executeUpdate(sql121);
				  
				   pst3.execute();
				    
				   ResultSet res2 = statement.executeQuery("SELECT * FROM one2one WHERE toID = '"+users.get(i)+"'");

					 while (res2.next()) {
						

					 System.out.println(res2.getString("message")) ;


					 }
			   
			 //   ResultSet resultset = statement.executeQuery(sql121);
			    
			    frame1.add(label1);
				label1.setBounds(0,0,700,50);
				Receivemessage obj1=new Receivemessage();
				int c=obj1.receive();
				while(c==1){
				JLabel label2 = new JLabel(users.get(i)+":"+" "+scanner.nextLine());
				frame1.add(label2);
				label2.setBounds(0,20,700,50);
				
				String sql1212 = "INSERT INTO one2one VALUES (?,?,?,?,?)";
				Class.forName("org.sqlite.JDBC");
		         
		        Connection con2 = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
		        Statement statement2 = con.createStatement();
		        
		        pst3=con.prepareStatement(sql121);
		        
		        pst3.setString(1,"justme"); //log.myuser
			    pst3.setString(2,users.get(i));
				   System.out.println("you can now send a message to the user"+" "+users.get(i));
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

				}

		}
	
	
	
	
	
	
	
	


