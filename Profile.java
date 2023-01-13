package application;

//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**Declare the class Profile.*/
class Profile extends JFrame implements ActionListener {

  // Components of the Entrancepage Form
  private Container cp;
  private JFrame frame;
  private JButton changepersonal;
  private JButton friends;
  private JButton goback;
  private JTextArea profile;
  private JLabel img;

  public Profile() {

      frame = new JFrame();
	    frame.setTitle("InTune");
	    frame.setBounds(320, 120, 1000, 750);
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    frame.setResizable(true);

	    frame.getContentPane().setBackground(new java.awt.Color(232, 237, 244));
	    cp = frame.getContentPane();
	    cp.setLayout(null);

		img = new JLabel();
		img.setIcon(new ImageIcon("profile.png"));
		Dimension size = img.getPreferredSize(); //Gets the size of the image
		img.setBounds(390, 40, size.width, size.height); //Sets the location of the image
		cp.add(img);

	    changepersonal = new JButton("Edit Profile");
	    changepersonal.setBackground(new java.awt.Color(27, 38, 67));
		changepersonal.setForeground(Color.WHITE);
		changepersonal.setFont(new Font("Arial", Font.BOLD, 15));
		changepersonal.setSize(240, 35);
	    changepersonal.setLocation(340, 350);
	    changepersonal.addActionListener(this);
      cp.add(changepersonal);

	    friends = new JButton("My Friends");
	    friends.setBackground(new java.awt.Color(27, 38, 67));
		friends.setForeground(Color.WHITE);
		friends.setFont(new Font("Arial", Font.BOLD, 15));
		friends.setSize(240, 35);
	    friends.setLocation(340, 400);
	    friends.addActionListener(this);
      cp.add(friends);

      goback = new JButton("Homepage");
	    goback.setBackground(new java.awt.Color(27, 38, 67));
		goback.setForeground(Color.WHITE);
		goback.setFont(new Font("Arial", Font.BOLD, 15));
		goback.setSize(240, 35);
	    goback.setLocation(340, 450);
	    goback.addActionListener(this);
      cp.add(goback);

      profile = new JTextArea();
	    JScrollPane scrollPane = new JScrollPane(profile);
	    profile.setEditable(false);
	    profile.setFont(new Font("Arial", Font.PLAIN, 15));
	    profile.setSize(550, 150);
	    profile.setLocation(200, 170);
	    cp.add(profile);

	    frame.setVisible(true);

	    //Show User's info
		Connection conn = null;
		try {

		    Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\30698\\OneDrive\\Υπολογιστής\\SQLite\\sqlite-tools-win32-x86-3400100\\sqlite-tools-win32-x86-3400100\\INTUNE1.db");
			String sqlinsert = "SELECT * FROM User WHERE username LIKE ?";
			PreparedStatement statement = conn.prepareStatement(sqlinsert);
			statement.setString(1, Entrancepage.tfusername.getText());
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
			    String s = "1.Name: " + rs.getString("name") + "\n" + "2."+
				    "Username: " + rs.getString("username") + "\n" + "3."+
				    "Password: " + rs.getString("password") + "\n" + "4."+
				    "Gender: " + rs.getString("gender") + "\n" + "5."+
				    "Age: " + rs.getInt("age");
			    profile.setText(s);
			    profile.setEditable(false);

		    }
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (conn != null) {
			    try {
				    conn.close();
				} catch (SQLException exc) {
				}
			}

		}

  }
  /**Declare the actionPerformed method.*/
  public void actionPerformed(ActionEvent ae) {

      if (ae.getSource() == changepersonal) {

			EditProfile ep = new EditProfile();
			frame.setVisible(false);

      } else if (ae.getSource() == friends) {

			Friends fr = new Friends();
			frame.setVisible(false);

      } else if (ae.getSource() == goback) {

			Homepage hp = new Homepage();
			frame.setVisible(false);

      }

  }
}
