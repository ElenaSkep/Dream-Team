package door2door;


import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.Assert;
import org.junit.Test;

public class DmTest {
	JTextField userID;
	JPasswordField code;
	JTextField message;
	JLabel m;
	@Test
	public void testdm() {
		String myuser="surevalue";
		Dmgraphics parentgui=new Dmgraphics(myuser);
		userID=new JTextField("fays");
		message=new JTextField("for the test");
		m=new JLabel("");
		Dm dm = new Dm(parentgui,userID,message,m,myuser);
		Assert.assertTrue( dm.try1());
		

	}
}