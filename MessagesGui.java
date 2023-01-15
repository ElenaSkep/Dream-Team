package Door2Door;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MessagesGui {

	JFrame frame;
	String areacode;
	JLabel messageLabel;
	JButton b;
	Connection connection = null ;
	JLabel likemessageLabel;
	String myuser;
	Statement statement1;
	boolean flag;
	Messages mes;
	JLabel sendMessage;
	JButton messageButton;
	JTextField messageField;
	JLabel  countoflikes;
	
	public MessagesGui(String code,String myuser) {
		
		areacode=code;
		this.myuser=myuser;
		  
		frame = new JFrame();
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
	    frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
		frame.setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(50,180,0)); //change color of backgrounds
		
	    mes = new Messages(this, areacode , myuser, frame);
	    mes.showMessages();
	     

    	b.addActionListener(new ActionListener() {
    	   public  void actionPerformed(ActionEvent e){
    			showmes1(); 		
    			   
   		   }
   	   });
	}
	
	public void showmes1() {
		frame = new JFrame();
		frame.setTitle("GroupChatMessages in " + areacode);
	}
	 public JButton method3(int i,String fromid, String message, String date, int likes) {
	    	
			messageLabel= new JLabel(fromid
	   			   + ": " + message +  " " + date );

	 	   messageLabel.setBounds(170,i*35,500,20);

	 	   frame.add(messageLabel);
	 	   frame.add(b);
	 	   b=new JButton("Like");
	 	   b.setBounds(0,i*35,100,20);
	 	   frame.setSize(420,420);
	 	   countoflikes= new JLabel(String.valueOf(likes) + " " + "Likes ");
	 	   countoflikes.setBounds(105,i*35,50,20);
	 	   frame.add(countoflikes);
	 	   return b;
		}
	

	
}