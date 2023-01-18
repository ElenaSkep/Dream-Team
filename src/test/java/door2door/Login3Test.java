package door2door;


import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.Assert;
import org.junit.Test;

public class Login3Test {

	@Test
	public void test() {
		LoginGui l=new LoginGui();
		JTextField userID=new JTextField("true");
		JPasswordField code=new JPasswordField("true");
		JLabel message= new JLabel("The text about the access will appear here");
		JTextField areacode=new JTextField("test");
		
		Login l2 = new Login(l,userID,code,message,areacode);
		
		Assert.assertEquals(true,l2.loginmethod());
	}

}
