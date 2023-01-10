package Door2Door;

import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp {
	
	JFrame frame = new JFrame();
	JLabel userIDLabel;
	JLabel userPasswordLabel;
	JLabel areacodeLabel;
	JTextField userIDField;
	JTextField areacodeField;
	JPasswordField userPasswordField;
	JButton SignUpButton;
	JButton ResetButton;
	JLabel messageLabel;
	int a;
	Connection con = null;//SQL VARIABLES
	PreparedStatement pst3 = null;//SQL VARIABLES
	ResultSet rs3 = null;//SQL VARIABLES
    public String name;
    boolean flag;
	SignUpGui gui;
	
	 public SignUp(SignUpGui parentGui,JTextField userID,JPasswordField code, JLabel message, JTextField areacode){
		gui = parentGui;
		userIDField = userID;
		userPasswordField = code;
		messageLabel = message;
		areacodeField = areacode;
	}
	 
	 public boolean signUp1() {
		 flag=false;
		 try{
		 String sql = "INSERT INTO users VALUES (?,?,?);";
			
			
			
			Class.forName("org.sqlite.JDBC");
	         
	        
	
				
			Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
			
			//con=Sqlite2.connectiontrial2();
			
			Statement statement = con.createStatement();
			
			pst3 = con.prepareStatement(sql); //remember: [PreparedStatement pst3 = null;] at first lines
			
			//boolean flag=false;
			
			
			
			//while (flag==false) {
			
				
				if (userIDField.getText().isEmpty()==true||userIDField.getText()=="testing" ||String. valueOf(userPasswordField.getPassword()).isEmpty()== true ) {
				
					
					new SignUp(gui ,userIDField ,userPasswordField ,messageLabel,areacodeField);
					
					messageLabel.setText("Please enter username & password");
					userIDField.getText();
					userPasswordField.getPassword();
					//SignUpButton.setText(userIDField.getText());
					//SignUpButton.setText(String.valueOf(userPasswordField.getPassword()));
			        
			     
					
				}else {
					flag = true;
					pst3.setString(1,userIDField.getText());
					pst3.setString(2,String.valueOf(userPasswordField.getPassword()));
					pst3.setString(3,areacodeField.getText());
					statement.executeUpdate(sql);
					pst3.execute();
					a=1;
					messageLabel.setText("Sign up successful");
					new Welcome2(userIDField.getText());
					flag=true;

				}

		}catch (Exception e2){
			System.out.println("registration failed" + e2);
		}finally {
			
			try {
				if(con != null) 
					con.close();
				  pst3.close();
		
			}catch ( SQLException e12) {
				e12.printStackTrace();
				
			}
		}
		 return flag;
}
	 public void reset() {
		System.out.println("works");
		userIDField.setText("");
		userPasswordField.setText("");
		areacodeField.setText("");
		messageLabel.setText("Reset successful");
	 }
}

