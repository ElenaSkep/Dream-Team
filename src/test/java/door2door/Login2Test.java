package door2door;

import static org.junit.Assert.*;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.Assert;
import org.junit.Test;

public class Login2Test {

	@Test
	public void test() {
		LoginGui l=new LoginGui();
		JTextField userID=new JTextField("false");
		JPasswordField code=new JPasswordField("false");
		JLabel message= new JLabel("false");
		JTextField areacode=new JTextField("false");
		
		Login l2 = new Login(l,userID,code,message,areacode);
		
		Assert.assertNotNull(l.userIdfield.getText());
		Assert.assertNotNull(l.userPasswordField.getPassword());
		Assert.assertNotNull(l.postalCodeField.getText());
	}

}

