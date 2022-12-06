import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Homepage extends JFrame {


	public static void main(String[] args) {

		 Post newpostbutton = new Post();

		 JFrame frame = new JFrame("Home Page");

		 frame.setVisible(true);

		 frame.setSize(1000,1000);

		 frame.setLayout(new FlowLayout());

		 JLabel label = new JLabel("Menu");

 		 frame.add(label);


		 ButtonGroup menugroup = new ButtonGroup();

		 JButton postbutton = new JButton("New Post");

		 menugroup.add(postbutton);

		 frame.add(postbutton);

		 JButton chatbutton = new JButton("Chat");

		 menugroup.add(chatbutton);

		 frame.add(chatbutton);

		 JButton profilebutton = new JButton("Profile");

		 menugroup.add(profilebutton);

		 frame.add(profilebutton);

		 JButton logoffbutton = new JButton("Logoff");

		 menugroup.add(logoffbutton);

		 frame.add(logoffbutton);


		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 frame.setLocationRelativeTo(null);

		 postbutton.addActionListener(e -> newpostbutton.newPost());


	 }



}