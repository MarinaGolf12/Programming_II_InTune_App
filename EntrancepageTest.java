//import required classes and packages
import org.junit.*;
import javax.swing.*;
import java.awt.*;

class EntrancepageTest extends JFrame implements ActionListener {

	private Entrancepage entrancepage;

	protected static JTextField tfusername;

	private JPasswordField tfpassword;

	private Container cp;

    private JFrame frame;

		@Before
		public void setUp()  {

			entrancepage = new Entrancepage();
		}

		@Test
		public void testEntrancepage() {


			frame = new JFrame();
			frame.setTitle("InTune");
			frame.setBounds(320, 120, 1000, 750);
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			frame.setResizable(true);

			frame.getContentPane().setBackground(new java.awt.Color(232, 237, 244));
			cp = frame.getContentPane();
			cp.setLayout(null);

			tfusername = new JTextField();
			tfusername.setFont(new Font("Arial", Font.PLAIN, 15));
			tfusername.setSize(550, 30);
			tfusername.setLocation(200, 190);
			cp.add(tfusername);

			tfpassword = new JPasswordField(25);
			tfpassword.setFont(new Font("Arial", Font.PLAIN, 15));
			tfpassword.setSize(550, 30);
			tfpassword.setLocation(200, 290);
			cp.add(tfpassword);

			String usernameValue = tfusername.getText();

			String passwordValue = tfpassword.getText();

			Assert.assertNotNull("The username you enter return null", usernameValue);

			Assert.assertNotNull("The password you enter return null", passwordValue);



		}







}