//package Door2Door;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;

public class Action2Gui extends JFrame {

	JFrame frame = new JFrame();
	JButton SendMessageButton;
	JButton ReceiveMessageButton;
	JLabel messageLabel;
	String myuser;
	String touser;

	private static final long serialVersionUID = 1L;

	Action2Gui() {
		JFrame frame = new JFrame();
		frame.setTitle("Send or receive a message at Door2Door");

		SendMessageButton = new JButton("Send Message");
		SendMessageButton.setBounds(125,200,100,25);
		SendMessageButton.setFocusable(false);
		SendMessageButton.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e){
				messageLabel.setText("You will proceed to send messages");
				Chat2 c =new Chat2(myuser,touser);
				}
		});
		frame.add(SendMessageButton);

		ReceiveMessageButton = new JButton("Read messages");
		ReceiveMessageButton.setBounds(225,200,100,25);
		ReceiveMessageButton.setFocusable(false);
		ReceiveMessageButton.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e){
				messageLabel.setText("You will proceed to view messages");
				Receivemessage r = new Receivemessage();;
			}
		});
		frame.add(ReceiveMessageButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(204,204,204));

		Icon bug1 = new ImageIcon(getClass().getResource("door2doorlogo.jpg"));
		messageLabel = new JLabel("Choose to send or read messages", bug1, SwingConstants.CENTER);//message that show if login was successful
		messageLabel.setBounds(115,240,240,120);
		frame.add(messageLabel);

		ImageIcon logoImage = new ImageIcon("door2doorlogo.jpg");
		frame.setIconImage(logoImage.getImage());
    }
}