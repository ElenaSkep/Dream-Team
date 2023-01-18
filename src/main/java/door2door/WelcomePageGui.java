package door2door;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *WelcomePageGui contains graphics.
 *No parameters.
 *It procedes the user to the page he clicks.
 */
public class WelcomePageGui extends JFrame {
  private static final long serialVersionUID = 1L;
  Connection con54 = null;
  PreparedStatement pst19 = null;
  ResultSet rs3 = null;
  Statement stmt = null;
  JButton b1;
  JButton b2;
  JButton b3;
  JButton b4;
  JFrame frame;
  String myuser;
  String tk;
  JLabel messageLabel;
  WelcomePageExt mes;
  boolean flag;

  /**
   *Constructor of WelcomePageGui.
   *Creates button b1 that procedes the user to the One2One page.
   *Creates button b2 that procedes the user to the GroupChat page.
   *Creates button b3 that procedes the user to the page where he can read all his messages.
   *Creates button b4 that procedes the user to the Action page.
   *
   */
   WelcomePageGui(String a, String b) {
    myuser = a;
    tk = b;
    frame = new JFrame(); 
    frame.setTitle("Welcome to Door2Door"); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    frame.setSize(420, 420); 
    frame.setLayout(null);
    frame.setVisible(true);
    frame.getContentPane().setBackground(new Color(204, 204, 204)); 
    frame.setResizable(false);
 
    mes = new WelcomePageExt(myuser, tk);

    messageLabel = new JLabel("Keep your friends close and your neighbors closer!"); 
    messageLabel.setBounds(60, 240, 300, 120);
    frame.add(messageLabel);

    b1 = new JButton("One2One");
    b1.setBounds(150, 100, 100, 30);
    b1.setFocusable(false);
    b1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         new Dmgraphics(myuser);
         //frame.dispose();
      }
    });
    frame.add(b1);
    b2 = new JButton("GroupChat");
    b2.setBounds(150, 150, 100, 30);
    b2.setFocusable(false);
    b2.addActionListener(new ActionListener() {
    	
      public void actionPerformed(ActionEvent e) {
    	 // frame.dispose();
         
    	GroupChatMessages gr= new GroupChatMessages(myuser, tk);
    	 gr.showMessages();
              
      }
    });
    frame.add(b2);

    b3 = new JButton("Messages");
    b3.setBounds(150, 200, 100, 30);
    b3.setFocusable(false);
    b3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        boolean flag = mes.messages1();
        if (flag == true) {          
          frame.dispose();       
        }
      }
    });
    frame.add(b3);
    b4 = new JButton("Log out");
    b4.setBounds(270, 330, 100, 30);
    b4.setFocusable(false);
    b4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new Main();
        frame.dispose();
      }
    });
    frame.add(b4);

   

  }
}