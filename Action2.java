import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Action2 implements ActionListener {   

	JFrame frame = new JFrame();

	JButton SendMessageButton;
	JButton ReceiveMessageButton;
	JLabel messageLabel;


	//constructor
	Action2(){
		JFrame frame = new JFrame();
   		frame.setTitle("Send or receivemessagge to the groupchat Door2Door"); 

   		SendMessageButton = new JButton("Send Message");
   		SendMessageButton.setBounds(125,200,100,25);
   		SendMessageButton.addActionListener(this);
		frame.add(SendMessageButton);

		ReceiveMessageButton = new JButton("Read messages");
		ReceiveMessageButton.setBounds(225,200,100,25);
		ReceiveMessageButton.addActionListener(this);
		frame.add(ReceiveMessageButton);
		
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
   		frame.getContentPane().setBackground(new Color(50,180,0)); 

   		messageLabel = new JLabel("Choose to send or read messages");
		messageLabel.setBounds(125,250,250,35);
    	frame.add(messageLabel);
}
   		@Override
			public void actionPerformed(ActionEvent e) {
		   		if(e.getSource()==SendMessageButton){
					messageLabel.setText("You will proceed to send a message");
					GroupChat g1= new GroupChat();
				}
				if (e.getSource() == ReceiveMessageButton) {
					messageLabel.setText("You will proceed to read the message of the groupchat`");
			       Sqlite3 rec= new Sqlite3();
			      //  rec.actionPerformed(e);
			        System.out.println("you will read the recieved messages");
			        
			    }
				
       	}

	}


