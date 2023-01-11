package JavaAssingnment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
import javax.swing.*;//javax.swing.JFrame + javax.swing.JButton + javax.swing.JTextField + javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;



public class WelcomePagewith3button extends JFrame implements ActionListener {
Connection con54=null;
PreparedStatement pst19=null;
ResultSet rs3=null;
Statement stmt=null;
JButton b1;
JButton b2;
JButton b3;
JButton b4;
JFrame frame = new JFrame();//creates the frame of my application
String myuser;
String areacode;

public WelcomePagewith3button(String myuser)
{
this.myuser=myuser;
setTitle("Welcome to Door2Door");
setSize(420,420);
setLocationRelativeTo(null);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
    frame.getContentPane().setBackground(new Color(204,204,204)); //change color of background
setLayout(new BorderLayout());
setContentPane(new JLabel(new ImageIcon("door2doorlogo.jpg")));

setLayout(new FlowLayout());
b1=new JButton("One2One");
b1.addActionListener(this);
b2 = new JButton("GroupChat");
b2.addActionListener(this);
b3 = new JButton("messages");
b3.addActionListener(this);
add(b1);
add(b2);
add(b3);


b4 = new JButton("LogOut");
b4.addActionListener(this);
add(b4);

ImageIcon logoImage = new ImageIcon("door2doorlogo.jpg");
frame.setIconImage(logoImage.getImage());
setVisible(true);

}


public void actionPerformed(ActionEvent e) {
if (e.getSource() == b4) {
	dispose();
	System.out.println(e);
	Action k = new Action();
} else if (e.getSource() == b1){
	dispose();
    System.out.println(e);
   //Login obj=new Login();
    DMGraphics obj=new DMGraphics(myuser);
} else if(e.getSource() == b2) {
dispose();
System.out.println(e);
GroupChatGraphics k = new GroupChatGraphics(myuser,areacode);
}else  if(e.getSource() == b3){
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
}
}
}
