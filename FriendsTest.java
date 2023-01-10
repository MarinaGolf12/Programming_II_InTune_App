//import required classes and packages
import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import org.junit.*;

public class FriendsTest {

    private Friends friends;
    private JButton add = new JButton("Add new friend");
    private JButton delete = new JButton("Delete friend");
    private JButton goback = new JButton("Profile");
    private JButton test = new JButton("test");
    private Profile prof;

    @Before
		public void setUp()  {
			friends = new Friends();
        }

		public void testFriends() {
            if (test != goback) {
                if (test == add) {
                    Friends friends = new Friends();
                } else if (test == delete) {
                    Friends friends = new Friends();
                }
        } else {
            prof = new Profile();
        }
    }
}