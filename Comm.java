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
	private JFrame frame;
	private JButton goback;

    // constructor, to structure Comment window
    public Comm() {

        frame = new JFrame();
		frame.setTitle("InTune");
		frame.getContentPane().setBackground(new java.awt.Color(232, 237, 244));
	    frame.setBounds(320, 120, 1000, 750);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(true);
		cc = frame.getContentPane();
		cc.setLayout(null);

		comment = new JLabel("Comment");
		comment.setFont(new Font("Arial", Font.BOLD, 30));
		comment.setForeground(new java.awt.Color(27, 38, 67));
		comment.setSize(300, 50);
	    comment.setLocation(110, 40);
		cc.add(comment);

		text = new JTextField(30);
		text.setFont(new Font("Arial",Font.BOLD,20));
	    text.setSize(400, 40);
		text.setLocation(110, 110);
		cc.add(text);

		post = new JButton("Send");
		post.setBackground(new java.awt.Color(27, 38, 67));
		post.setForeground(Color.WHITE);
		post.setFont(new Font("Arial", Font.BOLD, 15));
	    post.setSize(240, 35);
		post.setLocation(110, 190);
		post.addActionListener(this);
		cc.add(post);

		goback = new JButton("Go Back");
		goback.setBackground(new java.awt.Color(27, 38, 67));
		goback.setForeground(Color.WHITE);
		goback.setFont(new Font("Arial", Font.BOLD, 15));
		goback.setSize(240, 35);
		goback.setLocation(110, 240);
		goback.addActionListener(this);
        cc.add(goback);

		frame.setVisible(true);

	}

    //Confirms that comment was posted
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == post) {

			JOptionPane.showMessageDialog(null,"Your comment is online!");
			WatchPost wp = new WatchPost();
            frame.setVisible(false);

		}else if (ae.getSource() == goback) { // redirects to homepage

			Reaction mainpage = new Reaction();
			frame.setVisible(false);
		}

	}
	public static void main(String[] args) {
		Comm com = new Comm();
   }
}