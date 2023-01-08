package d2d2;
import java.lang.System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dm {
	JButton SendButton;
	JFrame frame = new JFrame();
	JLabel userIDLabel;
	JTextField userIDField;
	JTextField messageField;
	String message;
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

	    public String myuser;
	    DMGraphics gui;


	    public Dm(DMGraphics parentGui, JTextField userID,JTextField message ,JLabel m,String myuser){ //CONSTRACTOR
					gui = parentGui;
					messageField = message;
					userIDField =userID ;
					messageLabel=m;
					this.myuser=myuser;
			}





		public boolean try1() {
			System.out.println(messageField.getText());

	  username1 = userIDField.getText();
	  message=messageField.getText();
	String sql = "SELECT username FROM users WHERE username = '"+username1+"' ";

	try {
	try {
	Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e1) {
	
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

	String sql121 = "INSERT INTO one2one VALUES (?,?,?,?)";
	Statement statement2 = con.createStatement();
	      // System.out.println( con != null && !con.isClosed());
	       pst32=con.prepareStatement(sql121);

	       pst32.setString(1,myuser); 
	   pst32.setString(2,username1);
	   pst32.setString(3,message);


	   String pattern = ("HH:mm" + " " + "(dd-MM-YYYY)");
       SimpleDateFormat simpleDateFormat= new SimpleDateFormat(pattern);
       String date= simpleDateFormat.format(new Date());
       String datetime= date.toString();

		 //  String dates=Calendar.getInstance().toString();




	  pst32.setString(4,datetime);



	  pst32.execute();



	  messageLabel.setText("User found & Message Sent");
	  //proc was done successfully
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

   return flag;
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


