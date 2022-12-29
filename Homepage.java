import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Homepage extends JFrame implements ActionListener {

	private Container ch;

	private JFrame frame;

	private JLabel label;

	//private ButtonGroup menugroup;

	private JButton postbutton;

	private JButton chatbutton;

	private JButton profilebutton;

	private JButton logoffbutton;


	public  Homepage() {

         setVisible(true);

		 setTitle("Home Page");

		 setBounds(320, 120, 1000, 750);

		 setDefaultCloseOperation(EXIT_ON_CLOSE);

         setResizable(true);

		 //frame.setLayout(new FlowLayout());

		 ch = getContentPane();

		 ch.setLayout(new FlowLayout());

		 label = new JLabel("Menu");

 		 //frame.add(label);
 		 ch.add(label);

		 //menugroup = new ButtonGroup();

		 postbutton = new JButton("New Post");
		 postbutton.addActionListener(this);

		 //menugroup.add(postbutton);

		 //frame.add(postbutton);
		 ch.add(postbutton);

		 chatbutton = new JButton("Chat");
		 chatbutton.addActionListener(this);

		 //menugroup.add(chatbutton);

		 //frame.add(chatbutton);
		 ch.add(chatbutton);

		 profilebutton = new JButton("Profile");
		 profilebutton.addActionListener(this);

		 //menugroup.add(profilebutton);

		 //frame.add(profilebutton);
		 ch.add(profilebutton);

		 logoffbutton = new JButton("Logoff");
		 logoffbutton.addActionListener(this);

		 //menugroup.add(logoffbutton);

		 //frame.add(logoffbutton);
         ch.add(logoffbutton);

		 //frame.setLocationRelativeTo(null);


	}

	public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == postbutton) {

				Post post = new Post();
			    setVisible(false);



        /*} else if (e.getSource() == chatbutton) {

			Chat chat = new Chat();
			setVisible(false);
			chat.setVisible(true);

		} else if (e.getSource() == profilebutton) {

			Profile profile = new Profile();
			setVisible(false);
			profile.setVisible(true);

		} else if (e.getSource() == logoffbutton) {

			Logoff logoff = new Logoff();
			setVisible(false);
			logoff.setVisible(true);
			*/
		}

	}



}