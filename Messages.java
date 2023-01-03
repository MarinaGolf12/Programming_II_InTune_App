//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Messages extends JFrame implements ActionListener {

	// Components of the Messages window
	private Container c;
	private JLabel title;
	private JButton button;
	private JLabel label;
	private JTextField textField;
	private String str;
	private JButton goback;
	private JButton unread;

    // constructor, to structure Messages window
	public Messages() {

		//set the frame
		setVisible(true);
		setTitle("InTune");
		setBounds(320, 120, 1000, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);

		c = getContentPane();
        c.setLayout(null);

		//set a title
        title = new JLabel("Messages");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setSize(500, 50);
		title.setLocation(180, 30);
		c.add(title);

		//set a label
		label = new JLabel("Message to :");
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		label.setSize(500, 30);
		label.setLocation(180, 100);
		c.add(label);

		//set the text field to write the name of the person we want to chat with
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setSize(550, 30);
		textField.setLocation(280, 100);
		c.add(textField);

		//set button go to chat
		button = new JButton("GO");
		c.add(button);
		button.setBackground(new java.awt.Color(27, 38, 67));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.PLAIN, 15));
		button.setSize(550, 30);
		button.setLocation(280, 170);
		button.addActionListener(this);

		//set button to go back to homepage
		goback = new JButton("Homepage");
		c.add(goback);
		goback.setBackground(new java.awt.Color(27, 38, 67));
		goback.setForeground(Color.WHITE);
		goback.setFont(new Font("Arial", Font.PLAIN, 15));
		goback.setSize(550, 30);
		goback.setLocation(280, 220);
		goback.addActionListener(this);

		//set button to see new messages
		unread = new JButton("See unread messages");
		c.add(unread);
		unread.setBackground(new java.awt.Color(27, 38, 67));
		unread.setForeground(Color.WHITE);
		unread.setFont(new Font("Arial", Font.PLAIN, 15));
		unread.setSize(550, 30);
		unread.setLocation(280, 270);
		unread.addActionListener(this);

	}


		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == button) { //choose a user to message

		        str = textField.getText();
		        Connection conn = null;

                if (str.equals(Entrancepage.tfusername.getText()) != true) {
				    try {

				        Class.forName("org.sqlite.JDBC");
						conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
						String sqlinsert = "SELECT username FROM User WHERE username LIKE ?";
						PreparedStatement pstmt = conn.prepareStatement(sqlinsert);
						pstmt.setString(1,str);
						ResultSet rs = pstmt.executeQuery();

						if (rs.next()) {

							new Chat(str);
		                    setVisible(false);

						} else {

							JOptionPane.showMessageDialog(null,"Please enter an existing user");

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

					JOptionPane.showMessageDialog(null,"Can not send message to yourself!");

				}

			} else if (e.getSource() == goback) { //redirects to homepage

				Homepage hp = new Homepage();
				setVisible(false);

			} else if (e.getSource() == unread) {

			    Connection conn = null;

				    try {

				        Class.forName("org.sqlite.JDBC");
						conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
						String sqlinsert = "SELECT textmessage FROM Messages WHERE status LIKE ?";
						PreparedStatement pstmt = conn.prepareStatement(sqlinsert);
						pstmt.setInt(1,0);
						ResultSet rs = pstmt.executeQuery();

						if (rs.next()) {

							Unread unread = new Unread();
							setVisible(false);

						} else {

							JOptionPane.showMessageDialog(null,"No new messages!");

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
