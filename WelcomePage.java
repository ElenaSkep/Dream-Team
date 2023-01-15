package Door2Door;

import javax.swing.*;
import java.awt.*;
import java.lang.System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WelcomePage extends JFrame {
/**
*
*/
	private static final long serialVersionUID = 1L;
	JButton b1;
	JButton b2;
	//JFrame frame = new JFrame();//creates the frame of my application
	String myuser;
	String tk;
	boolean flag;
	Connection con54=null;
	PreparedStatement pst19=null;
	ResultSet rs3=null;
	Statement stmt=null;

	public WelcomePage(String myuser, String tk) {
		this.myuser=myuser;
		this.tk=tk;
		/*setTitle("Welcome to Door2Door");
		setSize(420,420);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		frame.getContentPane().setBackground(new Color(204,204,204)); //change color of background
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("door2doorlogo.jpg")));
		setLayout(new FlowLayout());*/

	}
	public boolean one2onechat() {
		System.out.println(flag);
	    //System.out.println(e);
	   //Login obj=new Login();
	  //  Dm obj=new Dm(myuser);
		flag=true;
		return flag;
	}
	

	public boolean groupchat1() {
		System.out.println(flag);
	   // System.out.println(e);
	   //Login obj=new Login();
	  //  Dm obj=new Dm(myuser);
		flag=true;
		return flag;
		
	}
	public boolean messages1() {
		System.out.println(flag);
	   //System.out.println(e);
	  //Login obj=new Login();
	  //Dm obj=new Dm(myuser);
		try{
			//String sql12 = "SELECT fromuser,save from messagesonetoone WHERE touser =  "+myuser;
			con54 = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
			//pst19 = con54.prepareStatement(sql12);
			//rs3=pst19.executeQuery();
			stmt=con54.createStatement();
			//String sql12 = "SELECT fromuser,save from messagesonetoone WHERE touser ='"+myuser+"'";
			rs3=stmt.executeQuery("SELECT save,fromuser FROM messagesonetoone WHERE touser='" + myuser + "';");
			System.out.println("hello"+myuser);
			while (rs3.next()) {
				System.out.println( rs3.getString("fromuser")
	           		 + ": "+ rs3.getString("save") ) ;
				
			}
			stmt.close();
			con54.close();
		}catch(Exception e1){
			System.out.println(e1);
		}finally {
			try {
				
				if(con54!= null) 
					con54.close();
				  //pst2.close();
				  //pst19.close();
				 
		
			}catch ( SQLException e3) {
				e3.printStackTrace();
				
			}
	}
		flag=true;
		return flag;	
	}
}
	

   