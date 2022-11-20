import javax.swing.JFrame;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Picture implements ActionListener{
	public Picture(){
	JFrame frame;
	frame= new JFrame("Pictures");
		//frame.setSize(600,600);
		//���������� ������ ��� �� ���������� �� frame
	final TextField tf=new TextField();
	tf.setBounds(101,70,170,20);
	//tf.setBounds(50,80,75,20);
	Scanner scanner = new Scanner(System.in);
	Button b=new Button("Like");
	//b.setBounds(50,100,80,30);
	b.setBounds(140,95,65,30);
	tf.setText(scanner.nextLine());
	JPanel pa = new JPanel();
	frame.add(b);

	frame.add(tf);
	frame.setSize(400,400);
	frame.setLayout(null);
	frame.setVisible(true);
	b.addActionListener(this);

}
public int like =0;
public void actionPerformed(ActionEvent e){
	  like=like+1;
	System.out.println(like);
	}
public static void main (String [] args){
	Picture photo=new Picture();

	}
}