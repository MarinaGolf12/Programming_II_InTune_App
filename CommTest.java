package application;
//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CommTest {

	private Comm comm;
	private JButton post = new JButton("send");
	private JButton goback = new JButton("Go Back");
	private JButton test = new JButton("Go Back");
	private Homepage back;

@Test
	public void setUp()  {

		comm = new Comm();

	}
@Test
	public void TestComm () {
		
          if (test != goback) {
        	  
              if (test == post) {
//user to send msg

                  Comm comm = new Comm();
              }
          } else {
              back = new Homepage();
          }
    }

}
