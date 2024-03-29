/**
 * @author Marina_Gkolfinopoulou
 * @author Andriana_Lazana
 */package application;
//import required classes and packages
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**Declare the class Messages.*/
public class Messages extends JFrame implements ActionListener {

//Components of the Messages window

	private Container c;
	private JLabel title;
	private JButton button;
	private JLabel label;
	private JTextField textField;
	private String str;
	private JButton goback;
	private JButton unread;
	private JFrame frame;
	private static final long serialVersionUID = 7526472295622776147L;

/**constructor, to structure Messages window.*/

	public Messages() {

//set the frame

		frame = new JFrame();
		frame.getContentPane().
		setBackground(new java.awt.Color(232, 237, 244));
		frame.setTitle("InTune");
		frame.setBounds(320, 120, 1000, 750);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(true);

		c = frame.getContentPane();
        c.setLayout(null);

//set a title

        title = new JLabel("Messages");
        title.setFont(new Font("Arial", Font.BOLD, 30));
		title.setForeground(new java.awt.Color(27, 38, 67));
		title.setSize(300, 50);
		title.setLocation(110, 40);
		c.add(title);

//set a label

		label = new JLabel("Message to :");
		label.setFont(new Font("Arial", Font.BOLD, 15));
		label.setSize(500, 30);
		label.setLocation(110, 100);
		c.add(label);

//set the text field to write the name of the person we want to chat with

		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setSize(550, 30);
		textField.setLocation(220, 105);
		c.add(textField);

//set button go to chat

		button = new JButton("GO");
		button.setBackground(new java.awt.Color(27, 38, 67));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.BOLD, 15));
	   	button.setSize(240, 35);
		button.setLocation(220, 170);
		button.addActionListener(this);
		c.add(button);

//set button to go back to homepage

		goback = new JButton("Go Back");
		goback.setBackground(new java.awt.Color(27, 38, 67));
		goback.setForeground(Color.WHITE);
	    goback.setFont(new Font("Arial", Font.BOLD, 15));
	   	goback.setSize(240, 35);
		goback.setLocation(220, 220);
		goback.addActionListener(this);
		c.add(goback);

//set button to see new messages

		unread = new JButton("See unread messages");
		unread.setBackground(new java.awt.Color(27, 38, 67));
		unread.setForeground(Color.WHITE);
		unread.setFont(new Font("Arial", Font.BOLD, 15));
	   	unread.setSize(240, 35);
		unread.setLocation(220, 270);
		unread.addActionListener(this);
		c.add(unread);

		frame.setVisible(true);

	}

/**Declare the actionPerformed method.*/
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == button) {

//choose a user to message

		      str = textField.getText();
		      Connection conn = null;

              if (str.equals(Entrancepage.tfusername.getText()) != true) {

				    try {
				        Class.forName("org.sqlite.JDBC");
						conn = DriverManager.getConnection("jdbc:sqlite:C:\\SQLITE//InTune.db");
						String sqlinsert =
						"SELECT username "
						+ "FROM User "
						+ "WHERE username LIKE ?";
						PreparedStatement pstmt = conn.
						prepareStatement(sqlinsert);
						pstmt.setString(1, str);
						ResultSet rs = pstmt.
						executeQuery();

						if (rs.next()) {

							Chat ch = new Chat(str);
		                    frame.setVisible(false);

						} else {

							JOptionPane.
							showMessageDialog(null,
							"Please enter "
							+ "an existing user");

						}

					} catch (Exception ex) {
					} finally {
					    if (conn != null) {
						    try {
						        conn.close();
						    } catch (SQLException exc) {
						    }
						 }
				    }

				} else {

					JOptionPane.
					showMessageDialog(null,
					"Can not send message to yourself!");

				}

			} else if (e.getSource() == goback) {

//redirects to homepage

				Homepage hp = new Homepage();
				frame.setVisible(false);

			} else if (e.getSource() == unread) {

				Connection conn = null;

				try {

					Class.forName("org.sqlite.JDBC");
					conn = DriverManager.getConnection("jdbc:sqlite:C:\\\\SQLITE//InTune.db");
					String sqlinsert = "SELECT textmessage"
					+ "FROM Messages "
					+ "WHERE status LIKE ?"
					+ " AND texto LIKE ?";
					PreparedStatement pstmt =
					conn.prepareStatement(sqlinsert);
					pstmt.setInt(1, 0);
					pstmt.setString(2, Entrancepage.
					tfusername.getText());
					ResultSet rs = pstmt.executeQuery();

					if (rs.next()) {

						Unread unread = new Unread();
						frame.setVisible(false);

					} else {

						JOptionPane.
						showMessageDialog(null,
						"No new messages!");
					}

				} catch (Exception ex) {

				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException exc) {
						}
					}
				}

			}

	}
}
