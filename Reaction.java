//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Reaction extends JFrame implements ActionListener {

    // Components of the Homepage
	private Container cr;
	private JFrame frame;
	private JLabel label1;
	private JTextField text;
	private Font font;
	private JButton button;
	private JButton react;
	private JButton comment;
	private JButton goback;

    // constructor, to structure Reaction window
	public Reaction() {

		 setVisible(true);
		 setTitle("InTune");
		 setBounds(320, 120, 1000, 750);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setResizable(true);
		 cr = getContentPane();
		 cr.setLayout(new FlowLayout());

         react = new JButton("React");
         react.setFont(new Font("Arial", Font.PLAIN, 15));
		 react.setSize(200, 20);
		 react.setLocation(150, 500);
         react.addActionListener(this);
         cr.add(react);

         comment = new JButton("Comment");
         comment.setFont(new Font("Arial", Font.PLAIN, 15));
		 comment.setSize(200, 20);
		 comment.setLocation(150, 600);
         comment.addActionListener(this);
         cr.add(comment);

         goback = new JButton("Back to Posts");
		 goback.setFont(new Font("Arial", Font.PLAIN, 15));
		 goback.setSize(200, 20);
		 goback.setLocation(150, 700);
		 goback.addActionListener(this);
         cr.add(goback);

	}

    //Choose whether to react or comment
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() != goback) {

			if (ae.getSource() == react) { //user to react

			    React react = new React();
			    setVisible(false);

		    } else if (ae.getSource() == comment) { //user to comment

			    Comm comment = new Comm();
			    setVisible(false);

		    } else if (ae.getSource() == goback) { //go back to watching posts

			    WatchPost wp = new WatchPost();
			    setVisible(false);

		    }

		}

	}

}
