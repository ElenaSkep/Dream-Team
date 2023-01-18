package door2door;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GroupChatMessages extends JFrame implements ActionListener  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
    String areacode;
    String areacode1;
    JLabel messageLabel;
    JButton b1;

    Connection connection = null ;
    JLabel likemessageLabel;
    String myuser;
    Statement statement1;
    boolean flag;

    GroupChatMessages(String myuser,String a) {
      this.areacode=a;
      this.myuser=myuser;   
      
      b1 = new JButton("Back");
      b1.setBounds(270, 330, 100, 30);
      b1.setFocusable(false);
      b1.addActionListener(new ActionListener() {
        public  void actionPerformed(ActionEvent e) {
          dispose();
          System.out.println(e);
          @SuppressWarnings("unused")
          WelcomePageGui k = new WelcomePageGui(myuser, areacode);
          frame.dispose();
        }
      });
      frame.add(b1);
    }
    
    

    public void showMessages() {
   
       frame = new JFrame();
       frame.setTitle("Hood " + areacode);
       frame.setSize(40, 50);
       
       b1 = new JButton("Send new message");
       
 	   b1.addActionListener(this);
 	   frame.add(b1);
 	   b1.setBounds(125,8,150,25);
 	   b1.setFocusable(false);
       
     
	   
       
  
       try {
    	   Class.forName("org.sqlite.JDBC");

           connection = DriverManager.getConnection("jdbc:sqlite:mydb.db");

           Statement statement1 = connection.createStatement();
     
           ResultSet resultset1 = statement1.executeQuery("SELECT * FROM groupmess WHERE message<>'null'   ORDER BY No DESC" );
   
           int i =1;

           while (resultset1.next()  ) {
        	   
        	   int  numbermes = resultset1.getInt("No");
               Statement statement2 = connection.createStatement();
               ResultSet resultset2 = statement2.executeQuery("SELECT * FROM Likes  WHERE No =  '"+ numbermes +"'" );
       
               areacode1= resultset1.getString("area_code");
               String onoma=resultset1.getString("fromid");
               String mes=resultset1.getString("message");
              
                       
               System.out.println(areacode1 + onoma + mes );
               if (areacode1.equals(areacode)) {
            	   System.out.println("if");
                  String fromid= resultset1.getString("fromid");
                 
                  messageLabel= new JLabel(resultset1.getString("fromid")
                      + ": " + resultset1.getString("message") +  " " + resultset1.getString("date") )  ;
         
                  messageLabel.setBounds(170,i*35,500,20);
                  
                  
       
                  frame.add(messageLabel);           
                  JButton b=new JButton("Like" );
                  frame.add(b);
                  b.setBounds(0,i*35,100,20);
                  frame.setSize(150,150);
          
                  int likes = resultset2.getInt("likes");
                  JLabel countoflikes= new JLabel(String.valueOf(likes) + " " + "Likes ");
                  countoflikes.setBounds(105,i*35,50,20);
       
                  frame.add(countoflikes);
           
           
         
                  b.addActionListener(new ActionListener() {
   
                	   public  void actionPerformed(ActionEvent e){
          
                          System.out.println(myuser + " " + "Just Liked " + fromid +"'s Message");
                          countoflikes.setText(String.valueOf(likes +1 ) + " " + "Likes ");
        
                          try {
                              Connection connection = null;       
                              try {
                            	  Class.forName("org.sqlite.JDBC");
                              } catch (ClassNotFoundException e1) {

                                   e1.printStackTrace();
                              }
       
                              connection = DriverManager.getConnection("jdbc:sqlite:mydb.db");

                              int newlike= likes+1;       
       
                              String sql="UPDATE  Likes SET likes = '"+ newlike +"' WHERE No =  '"+ numbermes +"'";
        
                              Statement statement1 = connection.createStatement();    
                              PreparedStatement pst3 = connection.prepareStatement(sql);
                              statement1.executeUpdate(sql);
         
                          } catch (SQLException e1) {
                        	  e1.printStackTrace();

                          }finally {
                        	  try {        
                        		  if(connection != null) {
           
                        			  connection.close();
                        		  }

                        	  }catch ( SQLException e3) {
                                  e3.printStackTrace();
                                 
                        	  }

                          }
                     }
                 });
      
               }
               i++;         
           }
   
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
           frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
           frame.setLayout(null);
           frame.setVisible(true);
           //frame.getContentPane().setBackground(new Color(204,204,204)); //change color of backgrounds
         
       } catch (ClassNotFoundException | SQLException e) {
           System.out.println("exception" + e);

       }finally {
    	   try {
               if(connection != null) {
                  connection.close();
               }

           }catch ( SQLException e) {
               e.printStackTrace();
           }
       }
    }
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == b1){
    	    System.out.println(e);
    	    new GroupChatGraphics(myuser,areacode);
    	    
    	}
    }

	
}