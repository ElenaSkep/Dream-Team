package JavaAssingnment;
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

public class Dm implements ActionListener {
    JButton SendButton;
JFrame frame = new JFrame();
JLabel userIDLabel;
JTextField userIDField;
JTextField messageField;
JButton SearchButton;
JLabel messageLabel;
    String username1;
public Connection con= null;
PreparedStatement pst3=null;
PreparedStatement pst32=null;
boolean result = false;
ResultSet rs=null;
String sql=null;
Statement statement =null;
    String finalresult="";
    boolean flag=false;
    String message;
    public String myuser;
Dm(String myuser){
this.myuser=myuser;
   JFrame frame = new JFrame();
frame.setTitle("Send a DM ");
userIDLabel = new JLabel ("To:");
  userIDLabel.setBounds(50,100,75,25);//x,y,w,height
  frame.add(userIDLabel);

  messageLabel = new JLabel ("Message:");
  messageLabel.setBounds(50,150,75,25);
  frame.add(messageLabel);

  userIDField = new JTextField();
  userIDField.setBounds(125,100,200,25);
  frame.add(userIDField);

  messageField = new JTextField();
  messageField.setBounds(125,150,200,25);
  frame.add(messageField);
 
  SendButton = new JButton("Send");
  SendButton.setBounds(125,200,100,25);
  SendButton.setFocusable(false);
  SendButton.addActionListener(this);
  frame.add(SendButton);

messageLabel = new JLabel("The text about the access will appear here");//message that show if login was successful
  messageLabel.setBounds(125,250,250,35);
  frame.add(messageLabel);
 
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from application
  frame.setSize(420,420);//sets the x-dimension, and y-dimension of application
  frame.setLayout(null);
  frame.setVisible(true);
  frame.getContentPane().setBackground(new Color(50,180,0)); //change color of background



}
public void actionPerformed(ActionEvent e) {

  if(e.getSource()==SendButton) {
  username1 = userIDField.getText();
  message=messageField.getText();
String sql = "SELECT username FROM users WHERE username = '"+username1+"' ";
         
try {
try {
Class.forName("org.sqlite.JDBC");
} catch (ClassNotFoundException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
pst3 = con.prepareStatement(sql);
pst3.execute();
Statement statement = con.createStatement();
ResultSet rs = statement.executeQuery(sql);
   String finalresult=null;
finalresult = rs.getString(1) ;

boolean comp =username1.equals(finalresult);

 if(comp==true || username1=="surevalue" && username1 !="testing" ) {

messageLabel.setText("User found");


flag=true;

String sql121 = "INSERT INTO messagesonetoone VALUES (?,?,?,?)";
Statement statement2 = con.createStatement();
      // System.out.println( con != null && !con.isClosed());
       pst32=con.prepareStatement(sql121);
       
       pst32.setString(1,myuser); //log.myuser
   pst32.setString(2,username1);
   pst32.setString(3,message);
 
//  String dates=Calendar.getInstance().toString();

  //pst32.setString(4,"now");
 
  //pst32.setString(5,"delivered");
 
  pst32.execute();

 
 
  messageLabel.setText("User found & Message Sent");
// getflag();
  //Goes to chat
}else {
 messageLabel.setText("User not found");}

  } catch (SQLException e1) {
  e1.printStackTrace();
  }finally{
  try {
     
 
      if(con != null)
   
    con.close();
 
//checking if its turned off;
System.out.println( "great job buddy");

 


     }catch ( SQLException e3) {
  e3.printStackTrace();

}

  }


  }
 
}

public void setflag( boolean flag) {
this.flag=flag;
}
public String getuser() {
return username1;
}
public boolean getflag() {
System.out.println("get flag");
return flag;
}
}