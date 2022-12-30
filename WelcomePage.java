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



public class WelcomePage extends JFrame implements ActionListener
{
JButton b1;
JFrame frame = new JFrame();//creates the frame of my application
	public WelcomePage()
	{
	setTitle("Welcome to Door2Door");
	setSize(420,420);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
        frame.getContentPane().setBackground(new Color(204,204,204)); //change color of background
	setLayout(new BorderLayout());
	setContentPane(new JLabel(new ImageIcon("door2doorlogo.jpg")));
	setLayout(new FlowLayout());
	b1=new JButton("Search bar");
	b1.addActionListener(this);
	add(b1);
	ImageIcon logoImage = new ImageIcon("door2doorlogo.jpg");
	frame.setIconImage(logoImage.getImage());
	setVisible(true);

	}

    public void actionPerformed(ActionEvent e) {
			 if(e.getSource() == b1){
			 System.out.println(e);  
			 SearchBar k = new SearchBar();
				}
			}
	}


