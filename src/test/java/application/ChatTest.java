package application;
//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class ChatTest {

	private Chat chat;
	private String a = "sample";
	private JButton send = new JButton("send");
	private JButton back = new JButton("back");
	private JButton test = new JButton("back");
	private Messages msg;

@Test
	public void setUp()  {

		chat = new Chat(a);

	}
@Test
	public void testChat () {
		if (test != back) {
			if (test == send) { //user to send msg
				Chat chat = new Chat(a);
            }
        } else {
            msg = new Messages();
        }
    }
}
