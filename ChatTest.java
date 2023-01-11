//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



class ChatTest {

    private Chat chat;

    private String a = "sample";

    private JButton send = new JButton("send");

    private JButton back = new JButton("back");

    private JButton test = new JButton("back");

    private Messages msg;


		public void setUp()  {

			chat = new Chat(a);

		}

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
