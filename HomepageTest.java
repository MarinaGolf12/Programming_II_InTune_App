//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HomepageTest {

    private Homepage homepage;
    private JButton postbutton = new JButton("New Post");
    private JButton newpostbutton = new JButton("Watch posts");
    private JButton chatbutton = new JButton("Chat");
    private JButton profilebutton = new JButton("Profile");
    private JButton logoffbutton = new JButton("Logoff");
    private JButton test = new JButton("test");
    private Post post;
    private WatchPost wp;
    private Messages msg;
    private Profile profile;
    private Logoff logoff;


		public void setUp()  {
			homepage = new Homepage();
		}

		public void testHomepage () {
            if (test ==  postbutton) {
                post = new Post();
            } else if (test == newpostbutton) {
                wp = new WatchPost();
            } else if (test == chatbutton) {
                msg = new Messages();
            } else if (test == profilebutton) {
                profile = new Profile();
            } else if (test == logoffbutton) {
                logoff = new Logoff();
            }
        }
}
