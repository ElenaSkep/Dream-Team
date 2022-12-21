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

public class SearchBar implements ActionListener {

JLabel userIDLabel;
JTextField userIDField;
JButton SearchButton;
JLabel messageLabel;
String finalresult="";

SearchBar(){
	//SearchBarGraphics n = new SearchBarGraphics();//


try {
Class.forName("org.sqlite.JDBC");
} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

boolean flag = false;
}
@Override
public void actionPerformed(ActionEvent e) {
  if(e.getSource()==SearchButton) {
  	String username1 = userIDField.getText();
	String sql = "SELECT username FROM users WHERE username = '"+username1+"' ";
	try {
		Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
	} catch (SQLException e1) {
// TODO Auto-generated catch block
	e1.printStackTrace();
	}

	try {
		Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
		Statement statement = con.createStatement();
		Statement pst3 = con.prepareStatement(sql);
	} catch (SQLException e1) {
// TODO Auto-generated catch block
	e1.printStackTrace();
	}

	try {
		Connection con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
		//pst3.execute();//
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		String finalresult = rs.getString(1) ;
		boolean comp =finalresult.equals(username1);
		System.out.println(comp);
		if(comp) {
			messageLabel.setText("User found");
			//Goes to chat
		}else {
		messageLabel.setText("User not found");
		}

	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
}
}





