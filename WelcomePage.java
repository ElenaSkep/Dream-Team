 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.System;
import java.util.HashMap;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;//javax.swing.JFrame + javax.swing.JButton + javax.swing.JTextField + javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;



class WelcomePage extends JFrame
{
JButton b1;
//JLabel l1;//
JFrame frame = new JFrame();//creates the frame of my application
	public WelcomePage()
	{
	//JFrame frame = new JFrame();//creates the frame of my application//
	setTitle("Welcome to Door2Door");
	setSize(420,420);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
    frame.getContentPane().setBackground(new Color(0,102,0)); //change color of background
	setLayout(new BorderLayout());
	setContentPane(new JLabel(new ImageIcon("C:\\Users\\evely\\Documents\\door2doorlogo.jpg")));
	setLayout(new FlowLayout());
	//l1=new JLabel("Join now");//
	b1=new JButton("Search bar");
	//add(l1);//
	add(b1);
	setSize(399,399);
	setSize(400,400);
	ImageIcon logoImage = new ImageIcon("C:\\Users\\evely\\Documents\\door2doorlogo.jpg");
	frame.setIconImage(logoImage.getImage());
	//frame.getContentPane().setBackground(new Color(0,102,0)); //change color of background//

	}

    public void actionPerformed(ActionEvent e) {
			 if(e.getSource() == b1){
			   //l1.setText("Welcome to Door2Door");//
			SearchBar k = new SearchBar();
				}
			}
	}


