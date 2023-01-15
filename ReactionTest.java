package application;
//import required classes and packages
import org.junit.*;
import javax.swing.*;
import java.awt.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReactionTest {

	private Reaction reaction;
	private JButton react = new JButton("React");;
	private JButton comment = new JButton("Comment");
	private JButton goback = new JButton("Back to Posts");
	private JButton a = new JButton("Back to Posts");
	private WatchPost p;
	private WatchPost object;

	@Test
	public void setUp()  {

		reaction = new Reaction();

	}
	
	@Test
	public void testReaction () {

		if (a != goback) {

				if (a == react) { //user to react

					    React react = new React();
						React object = new React();
						object =  react;

				} else if (a == comment) { //user to comment

						Comm comment = new Comm();
						Comm  object = new Comm();
						object = comment;

				} else if (a == goback) { //go back to watching posts

					    WatchPost wp = new WatchPost();
						WatchPost object = new WatchPost();
						object = wp;

				}

		} else if (a == goback) {

				p = new WatchPost();
				object = new WatchPost();
				object = p;
				
		}

		Assert.assertTrue("failure", object == p);
	
	}

}
