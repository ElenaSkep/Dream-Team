//package Door2Door;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Action2 extends JFrame {

	JFrame frame = new JFrame();

	JButton SendMessageButton;
	JButton ReceiveMessageButton;
	JLabel messageLabel;
	String myuser;
	String touser;
	Action2Gui gui = new Action2Gui();


	//constructor
	public Action2() {
		SendMessageButton = new JButton("Send Message");
		SendMessageButton.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e){
				messageLabel.setText("You will proceed to send messages");
				Chat2 c =new Chat2(myuser,touser);
				}
		});


		ReceiveMessageButton = new JButton("Read messages");
		ReceiveMessageButton.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e){
				messageLabel.setText("You will proceed to view messages");
				Receivemessage r = new Receivemessage();
			}
		});
	}
}



