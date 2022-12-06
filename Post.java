import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.io.FileWriter;

public class Post extends JFrame {


	public void newPost ( ) {

		 LoadImageApp picture = new LoadImageApp();

		 Reaction reaction = new Reaction();

		 JFrame postframe = new JFrame("New post");

		 postframe.setVisible(true);

		 postframe.setSize(1000,1000);

		 postframe.setLayout(new FlowLayout());

		 JLabel postlabel = new JLabel("Post");

 		 postframe.add(postlabel);

		 JFrame newpostframe = new JFrame("New post");

		  newpostframe.setSize(1000,1000);

		  newpostframe.setLayout(new FlowLayout());

		  JLabel newpostlabel = new JLabel("Don't go yet! Camila Cabello :)");

		  newpostframe.add(newpostlabel);

		  ButtonGroup reactgroup = new ButtonGroup();

		  JButton react = new JButton("React");

		  reactgroup.add(react);

		  newpostframe.add(react);

		  JButton comment = new JButton("Comment");

		 newpostframe.add(comment);

		  reactgroup.add(comment);



		 JTextField text = new JTextField (50);

		 postframe.add(text);

		 Font font = new Font("Calibri",Font.BOLD,20);

		 text.setFont(font);

		  JButton addphotobutton = new JButton("Add photo");

		 postframe.add(addphotobutton);

		 JButton submitbutton = new JButton("Submit");

		 postframe.add(submitbutton);

		 submitbutton.addActionListener(e -> newpostframe.setVisible(true));

		 react.addActionListener(e -> reaction.react());

		 comment.addActionListener(e -> reaction.comment());

		 addphotobutton.addActionListener(e -> picture.image());

		 }

}