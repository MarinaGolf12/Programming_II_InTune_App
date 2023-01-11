/**import required classes and packages*/
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Container;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Homepage extends JFrame implements ActionListener {

   /**Components of the Homepage*/

	private Container ch;
	private JFrame frame;
	private JLabel label;
	private JButton postbutton;
	private JButton chatbutton;
	private JButton profilebutton;
	private JButton logoffbutton;
	private JButton newpostbutton;
	private JLabel img;
	private static final long serialVersionUID = 7526472295622776147L;

    /**constructor, to structure Homepage window*/

	public  Homepage() {

		 frame = new JFrame();
		 frame.getContentPane().setBackground(new java.awt.Color(232, 237, 244));
		 frame.setTitle("InTune");
		 frame.setBounds(320, 120, 1000, 750);
		 frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
         frame.setResizable(true);
		 ch = frame.getContentPane();
		 ch.setLayout(null);

		 postbutton = new JButton("New Post");
		 postbutton.setBackground(new java.awt.Color(27, 38, 67));
		 postbutton.setForeground(Color.WHITE);
		 postbutton.setFont(new Font("Arial", Font.BOLD, 15));
		 postbutton.setSize(280, 35);
		 postbutton.setLocation(330, 190);
		 postbutton.addActionListener(this);
		 ch.add(postbutton);

		 newpostbutton = new JButton("Watch posts");
		 newpostbutton.setBackground(new java.awt.Color(27, 38, 67));
		 newpostbutton.setForeground(Color.WHITE);
		 newpostbutton.setFont(new Font("Arial", Font.BOLD, 15));
		 newpostbutton.setSize(280, 35);
		 newpostbutton.setLocation(330, 250);
		 newpostbutton.addActionListener(this);
         ch.add(newpostbutton);

		 chatbutton = new JButton("Chat");
		 chatbutton.setBackground(new java.awt.Color(27, 38, 67));
		 chatbutton.setForeground(Color.WHITE);
		 chatbutton.setFont(new Font("Arial", Font.BOLD, 15));
		 chatbutton.setSize(280, 35);
		 chatbutton.setLocation(330, 310);
		 chatbutton.addActionListener(this);
		 ch.add(chatbutton);

		 profilebutton = new JButton("Profile");
		 profilebutton.setBackground(new java.awt.Color(27, 38, 67));
		 profilebutton.setFont(new Font("Arial", Font.BOLD, 15));
		 profilebutton.setForeground(Color.WHITE);
		 profilebutton.setSize(280, 35);
		 profilebutton.setLocation(330, 370);
		 profilebutton.addActionListener(this);
		 ch.add(profilebutton);

		 logoffbutton = new JButton("Logoff");
		 logoffbutton.setBackground(new java.awt.Color(27, 38, 67));
		 logoffbutton.setForeground(Color.WHITE);
		 logoffbutton.setFont(new Font("Arial", Font.BOLD, 15));
		 logoffbutton.setSize(280, 35);
		 logoffbutton.setLocation(330, 430);
		 logoffbutton.addActionListener(this);
		 ch.add(logoffbutton);

		 img = new JLabel();
		 img.setIcon(new ImageIcon("logo.png"));
		 Dimension size = img.getPreferredSize();

		 /**Gets the size of the image*/

		 img.setBounds(380, 20, size.width, size.height);

		 /**Sets the location of the image*/

		 ch.add(img);

         frame.setVisible(true);

	}

    /**Redirects to different actions*/

	public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == postbutton) {

			/**Redirects to posting*/

			Post post = new Post();
			frame.setVisible(false);

        } else if (ae.getSource() == newpostbutton) {

			/**Redirects to all posts posted*/

	        WatchPost wp = new WatchPost();
	        frame.setVisible(false);

		}else if (ae.getSource() == chatbutton) {

			/**Redirects to chat*/

			Messages chat = new Messages();
			frame.setVisible(false);

		} else if (ae.getSource() == profilebutton) {

			/**Redirects to user's profile*/

			Profile profile = new Profile();
			frame.setVisible(false);

		} else if (ae.getSource() == logoffbutton) {

			/**Proceeds to log off*/

			Logoff logoff = new Logoff();
			frame.setVisible(false);
		}

	}

}


