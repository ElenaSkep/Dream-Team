package Door2Door;

import javax.swing.*;
import java.lang.System;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class WelcomePageGui extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con54=null;
	PreparedStatement pst19=null;
	ResultSet rs3=null;
	Statement stmt=null;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JFrame frame;
	String myuser;
	String tk;
	JLabel messageLabel;
	WelcomePageExt w;
	boolean flag;

	public WelcomePageGui(String a, String b) {
		myuser=a;
		tk=b;
		
		frame = new JFrame();//creates the frame of my application
		frame.setTitle("Welcome to Door2Door"); //sets title of my frame
		
		ImageIcon image = new ImageIcon(getClass().getResource("/door2doorlogo2.png"));
	    frame.setIconImage(image.getImage());
		
   		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
   		frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
   		frame.setLayout(null);
   		frame.setVisible(true);
   		frame.getContentPane().setBackground(new Color(204,204,204)); //change color of background
 
   		w = new WelcomePageExt(myuser, tk);
		
		messageLabel = new JLabel("Keep your enemies close and your neighbors closer!"); //message that show if login was successful
		messageLabel.setBounds(60,240,300,120);
		frame.add(messageLabel);
   		
		b1=new JButton("One2One");
		b1.setBounds(150,100,100,30);
		b1.setFocusable(false);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//System.out.println(flag);
			    //System.out.println(e);
			   //Login obj=new Login();
			   //Dm obj=new Dm(myuser);	
				System.out.println("YES");
					frame.dispose();
				}
			});
   		frame.add(b1);
   		
		b2 = new JButton("GroupChat");
		b2.setBounds(150, 150, 100, 30);
		b2.setFocusable(false);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println(flag);
				 //System.out.println(e);
				//Login obj=new Login();
				//Dm obj=new Dm(myuser);
				System.out.println("YES");
				frame.dispose();
				System.out.println(flag);
			}
			});
   		frame.add(b2);
		
   		b3 = new JButton("Messages");
		b3.setBounds(150, 200, 100, 30);
		b3.setFocusable(false);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				boolean flag = w.messages1();
				if (flag==true) {
				System.out.println("YES");
					frame.dispose();
					System.out.println(flag);
				}
				}
			});
   		frame.add(b3);
   		
   		b4 = new JButton("Log out");
		b4.setBounds(270, 330, 100, 30);
		b4.setFocusable(false);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				boolean flag = w.messages1();
				if (flag==true) {
				System.out.println("YES");
					frame.dispose();
					System.out.println(flag);
				}
				}
			});
   		frame.add(b4);

		//ImageIcon logoImage = new ImageIcon("door2doorlogo.jpg");
		//frame.setIconImage(logoImage.getImage());
		//setVisible(true);

	}	

}
