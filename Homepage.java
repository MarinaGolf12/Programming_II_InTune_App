//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Homepage extends JFrame implements ActionListener {

    // Components of the Homepage
	private Container ch;
	private JFrame frame;
	private JLabel label;
	private JButton postbutton;
	private JButton chatbutton;
	private JButton profilebutton;
	private JButton logoffbutton;
	private JButton newpostbutton;

    // constructor, to structure Homepage window
	public  Homepage() {

         setVisible(true);
		 setTitle("InTune");
		 setBounds(320, 120, 1000, 750);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
         setResizable(true);
		 ch = getContentPane();
		 ch.setLayout(new FlowLayout());
		 label = new JLabel("Menu");
 		 ch.add(label);

		 postbutton = new JButton("New Post");
		 postbutton.addActionListener(this);

		 ch.add(postbutton);

		 newpostbutton = new JButton("Watch posts");
		 newpostbutton.addActionListener(this);

         ch.add(newpostbutton);

		 chatbutton = new JButton("Chat");
		 chatbutton.addActionListener(this);

		 ch.add(chatbutton);

		 profilebutton = new JButton("Profile");
		 profilebutton.addActionListener(this);


		 ch.add(profilebutton);

		 logoffbutton = new JButton("Logoff");
		 logoffbutton.addActionListener(this);

         ch.add(logoffbutton);

	}

    //Redirects to different actions
	public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == postbutton) { //Redirects to posting

			Post post = new Post();
			setVisible(false);



        } else if (ae.getSource() == newpostbutton) { //Redirects to all posts posted

	        WatchPost wp = new WatchPost();
	        setVisible(false);

		/*}else if (e.getSource() == chatbutton) { //Redirects to chat

			Chat chat = new Chat();
			setVisible(false);
			chat.setVisible(true);

		} else if (e.getSource() == profilebutton) { //Redirects to user's profile

			Profile profile = new Profile();
			setVisible(false);
			profile.setVisible(true);

		} else if (e.getSource() == logoffbutton) { //Proceeds to log off

			Logoff logoff = new Logoff();
			setVisible(false);
			logoff.setVisible(true);
			*/
		}

	}



}