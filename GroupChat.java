import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class GroupChat {

	    JFrame frame = new JFrame();
		JLabel sendMessage;
		JTextField messageField;
		JButton messageButton;
		JLabel messageLabel;
		GroupChatGraphics gui;
		String message;
		Connection connection = null ;
		PreparedStatement pst3 = null;
		public String myuser;
		public String areacode;

	 public GroupChat(GroupChatGraphics parentGui,JTextField userID,JLabel m,String myuser,String areacode){
				gui = parentGui;
				messageField = userID;
				messageLabel = m;

    	this.myuser=myuser;
    	this.areacode=areacode;
    
    	try {
    		GroupChatMessages rec = new GroupChatMessages(areacode);
	        rec.showMessages();

		}catch(Exception s) {
			System.out.println("exception"+ s);
		}finally {
			try {
				if(connection != null)
					connection.close();


			}catch ( SQLException e12) {
				e12.printStackTrace();

			}

		}
}


	public void groupchatmethod() {

				message = messageField.getText();

				messageLabel.setText("Message sent!");
				try {
					Class.forName("org.sqlite.JDBC");
			        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/mydb.db");
			        Statement statement = connection.createStatement();


			        String pattern = ("HH:mm" + " " + "(dd-MM-YYYY)");
			        SimpleDateFormat simpleDateFormat= new SimpleDateFormat(pattern);
			        String date= simpleDateFormat.format(new Date());
			        String datetime= date.toString();

                    String sql="INSERT INTO groupmess VALUES (?,?,?,?);";

					pst3 = connection.prepareStatement(sql);


					pst3.setString(1,myuser);
					pst3.setString(2,message);
					pst3.setString(3,datetime);
					pst3.setString(4,areacode);
                   statement.executeUpdate(sql);
				   pst3.execute();
                   System.out.println("success");

				}catch(Exception e5){
					System.out.println("man you cant do this because of" + e5);

				}finally {

					try {
						if(connection != null)
							connection.close();
						  pst3.close();

					}catch ( SQLException e12) {
						e12.printStackTrace();

					}
				}

		}

	}

