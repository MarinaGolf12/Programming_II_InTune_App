//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Comm extends JFrame implements ActionListener {

    // Components of the Comment window
	private Container cc;
	private JLabel comment;
	private JTextField text;
	private JButton post;

    // constructor, to structure Comment window
    public Comm() {

		setVisible(true);
		setTitle("InTune");
	    setBounds(320, 120, 1000, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		cc = getContentPane();
		cc.setLayout(new FlowLayout());

		comment = new JLabel("Comment");
		cc.add(comment);

		text = new JTextField(30);
		cc.add(text);

		post = new JButton("Post your comment");
		post.addActionListener(this);
		cc.add(post);

	}

    //Confirms that comment was posted
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == post) {

			JOptionPane.showMessageDialog(null,"Your comment is online!");
			WatchPost wp = new WatchPost();
            setVisible(false);

		}

	}

}
