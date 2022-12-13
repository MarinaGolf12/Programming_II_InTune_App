import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.io.FileWriter;

public class Post extends JFrame {

	public Post() {

	}


	public void post ( ) {


		 JFrame postframe = new JFrame("New post");

		 postframe.setVisible(true);

		 postframe.setSize(1000,1000);

		 postframe.setLayout(new FlowLayout());

		 JLabel postlabel = new JLabel("Post");

 		 postframe.add(postlabel);

		 JTextField text = new JTextField (50);

		 postframe.add(text);

		 Font font = new Font("Calibri",Font.BOLD,20);

		 text.setFont(font);

		 JButton addphotobutton = new JButton("Add photo");

		 postframe.add(addphotobutton);

		 JButton submitbutton = new JButton("Submit");

		 postframe.add(submitbutton);

		 submitbutton.addActionListener(new ActionListener() {




			public void actionPerformed(ActionEvent e) {

				 newPost(0);


				JOptionPane.showMessageDialog(null,"Your post is online!");
			}
		});



		 }

		 int x1 = 0;

		 int x2 = 0;

		 int x3 = 0;

		 int x4 = 0;

		 int x5 = 0;

		 int x6 = 0;

		 public void newPost( int a) {

			 Reaction reaction = new Reaction();


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

			  newpostframe.setVisible(true);

				newpostframe.add(comment);



				if (a == 1){

					x1 = x1 + 1;

				} else if (a == 2) {

					x2= x2 + 1;

				}else if (a == 3) {

					x3= x3 + 1;

				}else if (a == 4) {

					x4= x4 + 1;

				}else if (a == 5) {

					x5= x5 + 1;

				}else if (a == 6) {

					x6= x6 + 1;

				} else {

				}

			if (x1 > 0) {
			  Label r1 = new Label(x1 +" My favourite");

			  newpostframe.add(r1);

		  	}

 			if (x2 > 0) {
			  Label r2 = new Label(x2 + " Like");

			  newpostframe.add(r2);

		  }

 			if (x3 > 0) {
			  Label r3 = new Label( x3 + " Catchy");

			  newpostframe.add(r3);

		  }

		  if (x4 > 0) {

			 Label r4 = new Label( x4 + " Sound Off");

			  newpostframe.add(r4);

		  }

		  if (x5 > 0) {

			  Label r5 = new Label( x5 + " Earache");

			  newpostframe.add(r5);

		  }

		  if (x6 > 0) {

			  if (x6 == 1) {

			  Label r6 = new Label("1 Comment");

			  newpostframe.add(r6);

		  } else {

			  Label r6 = new Label( x6 + " Comments");

			  newpostframe.add(r6);

		  }

	  }

			 reactgroup.add(comment);

			  react.addActionListener(e -> reaction.react());

			 comment.addActionListener(e -> reaction.comment());

		 }


}