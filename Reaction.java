/**
 * @author Elena_Fouka
 * @author Antigoni_Vlassa
 */
package application;
//import required classes and packages
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**Declare the class Reaction.*/
class Reaction extends JFrame implements ActionListener {

//Components of the Homepage

	private Container cr;
	private JLabel label1;
	private JTextField text;
	private Font font;
	private JButton button;
	private JButton react;
	private JButton comment1;
	private JButton goback;
	private JFrame frame;
	private JLabel img;
	private static final long serialVersionUID = 7526472295622776147L;

/**constructor, to structure Reaction window.*/

	public Reaction() {

		frame = new JFrame();
		frame.setTitle("InTune");
		frame.getContentPane().
		setBackground(new java.awt.Color(232, 237, 244));
		frame.setBounds(320, 120, 1000, 750);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(true);
		cr = frame.getContentPane();
		cr.setLayout(null);

        react = new JButton("React");
        react.setFont(new Font("Arial", Font.BOLD, 15));
        react.setBackground(new java.awt.Color(27, 38, 67));
		react.setForeground(Color.WHITE);
		react.setFont(new Font("Arial", Font.BOLD, 15));
		react.setSize(280, 35);
		react.setLocation(330, 190);
        react.addActionListener(this);
        cr.add(react);

        comment1 = new JButton("Comment");
        comment1.setFont(new Font("Arial", Font.BOLD, 15));
        comment1.setBackground(new java.awt.Color(27, 38, 67));
		comment1.setForeground(Color.WHITE);
		comment1.setFont(new Font("Arial", Font.BOLD, 15));
		comment1.setSize(280, 35);
		comment1.setLocation(330, 250);
        comment1.addActionListener(this);
        cr.add(comment1);

        goback = new JButton("Back to Posts");
		goback.setFont(new Font("Arial", Font.BOLD, 15));
		goback.setBackground(new java.awt.Color(27, 38, 67));
		goback.setForeground(Color.WHITE);
		goback.setSize(280, 35);
		goback.setLocation(330, 310);
		goback.addActionListener(this);
        cr.add(goback);

        img = new JLabel();
		img.setIcon(new ImageIcon("logo.png"));
		Dimension size = img.getPreferredSize();
//Gets the size of the image
		img.setBounds(380, 20, size.width, size.height);
//Sets the location of the image
		cr.add(img);
		frame.setVisible(true);
	}

	/**Choose whether to react or comment.*/

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() != goback) {

			if (ae.getSource() == react) {

//user to react

			    React react = new React();
			    frame.setVisible(false);

		    } else if (ae.getSource() == comment1) {

//user to comment

			    Comm comment = new Comm();
			    frame.setVisible(false);

		    } else if (ae.getSource() == goback) {

//go back to watching posts

			    WatchPost wp = new WatchPost();
			    frame.setVisible(false);

		    }

		} else if (ae.getSource() == goback) {
			 	frame.setVisible(false);
			 	WatchPost p = new WatchPost();
		}

	}


}
