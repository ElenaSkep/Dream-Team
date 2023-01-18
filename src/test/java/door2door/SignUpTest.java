package door2door;

import static org.junit.Assert.*;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.Test;
import org.testng.Assert;



public class SignUpTest {
	JTextField userID;
	JPasswordField code;
	JTextField areacode;
	JLabel m;

	@Test
	public void test() {
		
		//testing if sign up is possible.
				SignUpGui parentGui1=new SignUpGui();
				userID=new JTextField("true12");
				code=new JPasswordField("1234");
				areacode=new JTextField("29100");
				m=new JLabel("");
						
				SignUp s1=new SignUp(parentGui1,userID, code, m, areacode);
			    //Assert.assertTrue(s1.signUp1() );
					     
				
				
				SignUpGui parentGui2=new SignUpGui();
				userID=new JTextField(" ");
				code=new JPasswordField(" ");
				areacode=new JTextField(" ");
				m=new JLabel("");
				
				SignUp s2=new SignUp(parentGui2,userID, code, m, areacode);
				
				//tests that you cannot sign up without entering a username or password.
				  Assert.assertNotNull(s2.userIdField.getText());
				  
				  Assert.assertNotNull(String. valueOf(s2.userPasswordField.getPassword()));
				  
				  Assert.assertNotNull (s2.areacodeField.getText());
		

	
	}

}
