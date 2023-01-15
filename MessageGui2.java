package Door2Door;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MessageGui2 {
	JFrame frame;
	String areacode;
	String areacode1;
	JLabel messageLabel;
	JButton b;
	Connection connection = null ;
	JLabel likemessageLabel;
	String myuser;
	Statement statement1;
	boolean flag;
	JLabel countoflikes;
	Messages11 m;
	String fromid;
	int likes;
	int  numbermes;
	
	public MessageGui2(String areacode,String myuser) {
		  this.areacode=areacode;
		  this.myuser=myuser;
	
		  m = new Messages11(this, areacode, myuser);
		  m.showMessages();
		  
		  b=new JButton("Like");
	}
	
	public void method1() {
		 frame = new JFrame();
		 frame.setTitle("GroupChatMessages in " + areacode);
		 
	}
	public void method2(int i, int likes, String fromid, String date, String mes) {
		 messageLabel= new JLabel(fromid
	   			+ ": " + mes +  " " + date )  ;
		 messageLabel.setBounds(170,i*35,500,20);
		 frame.add(messageLabel);
		 //frame.setSize(420,420);
		 System.out.println("method 2 works ");
	}
	
	public void setCountoflikes(int i, int likes) {
		countoflikes= new JLabel(String.valueOf(likes) + " " + "Likes ");
	   	countoflikes.setBounds(105,i*35,50,20);
	   	frame.add(countoflikes);
	    System.out.println("setcountoflikes works");
	   	//return countoflikes;
	}
	public void createButton(int i) {
		b=new JButton("Like");
        b.setBounds(0,i*35,100,20);
        b.addActionListener(new ActionListener() {
            public  void actionPerformed(ActionEvent e){
            	m.body();
        	    System.out.println("button works");
            }
        });
        frame.add(b);
	}
	
	public void createFrame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
	    frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
	    frame.setLayout(null);
	    frame.setVisible(true);
	    frame.getContentPane().setBackground(new Color(50,180,0)); 
	    System.out.println("create Frame works");
	}
	public void updateScreen(String myuser,String fromid, int likes) {
		System.out.println(myuser + " " + "Just Liked " + fromid +"'s Message");
        countoflikes.setText(String.valueOf(likes +1 ) + " " + "Likes ");
        System.out.println("update screen works");
        System.out.println(likes);
	}
	
}
