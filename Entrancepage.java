//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//Set up graphics for Login Page
class Entrancepage extends JFrame implements ActionListener {

    // Components of the Entrancepage Form
    private Container cp;
    private JFrame frame;
    private JButton signup;
    private JLabel username;
	protected static JTextField tfusername;
	private JLabel password;
    private JPasswordField tfpassword;
    private JButton login;
    private JLabel newuser;
    private JTextArea twrong;
    private JLabel res;
    private JTextArea resadd;
    private JLabel img;

    // constructor, to structure Entrancepage window
    public Entrancepage() {

	frame = new JFrame();
        frame.setTitle("InTune");
        frame.setBounds(320, 120, 1000, 750);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(true);

	frame.getContentPane().setBackground(new java.awt.Color(232, 237, 244));
        cp = frame.getContentPane();
        cp.setLayout(null);


        username = new JLabel("Username");
	username.setFont(new Font("Arial", Font.PLAIN, 15));
	username.setSize(280, 35);
	username.setLocation(340, 170);
	cp.add(username);

	tfusername = new JTextField();
	tfusername.setFont(new Font("Arial", Font.PLAIN, 15));
	tfusername.setSize(280, 35);
	tfusername.setLocation(340, 200);
	cp.add(tfusername);

	password = new JLabel("Password");
	password.setFont(new Font("Arial", Font.PLAIN, 15));
	password.setSize(280, 35);
	password.setLocation(340, 250);
	cp.add(password);

	tfpassword = new JPasswordField(25);
	tfpassword.setFont(new Font("Arial", Font.PLAIN, 15));
	tfpassword.setSize(280, 35);
	tfpassword.setLocation(340, 280);
	cp.add(tfpassword);

	login = new JButton("Log in");
	login.setBackground(new java.awt.Color(27, 38, 67));
	login.setForeground(Color.WHITE);
	login.setFont(new Font("Arial", Font.BOLD, 15));
	login.setSize(280, 35);
	login.setLocation(340, 390);
	login.addActionListener(this);
        cp.add(login);

        newuser = new JLabel("Don't have an account?");
	newuser.setFont(new Font("Arial", Font.PLAIN, 16));
	newuser.setSize(500, 60);
	newuser.setLocation(400, 450);
	cp.add(newuser);

	signup = new JButton("Sign Up");
	signup.setFont(new Font("Arial",Font.BOLD, 15));
	signup.setBackground(new java.awt.Color(232, 237, 244));
	signup.setForeground(new java.awt.Color(27, 38, 67));
	signup.setSize(150, 30);
	signup.setLocation(400, 500);
	signup.addActionListener(this);
        cp.add(signup);

        res = new JLabel("");
	res.setFont(new Font("Arial", Font.PLAIN, 20));
	res.setSize(500, 25);
	res.setLocation(350, 650);
	cp.add(res);

	img = new JLabel();
	img.setIcon(new ImageIcon("logo.png"));
	Dimension size = img.getPreferredSize(); //Gets the size of the image
	img.setBounds(380, 20, size.width, size.height); //Sets the location of the image
	cp.add(img);

	frame.setVisible(true);

    }

    //Checks with DB before connecting a user to app
    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == login) {

	                String usernameValue = tfusername.getText();
					String passwordValue = tfpassword.getText();

                    Connection conn = null;
					try {

                        Class.forName("org.sqlite.JDBC");
						conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
						String sqlinsert = "SELECT * FROM User WHERE username LIKE ? AND password LIKE ?";
						PreparedStatement pstmt = conn.prepareStatement(sqlinsert);
						pstmt.setString(1,usernameValue);
						pstmt.setString(2,passwordValue);
						ResultSet rs = pstmt.executeQuery();

						if (rs.next()) {
							JOptionPane.showMessageDialog(null,"Login Successful");
						    Homepage mainpage = new Homepage();
							frame.setVisible(false);

						} else {

							JOptionPane.showMessageDialog(null,"Wrong username or password");
							Entrancepage ent = new Entrancepage();
							frame.setVisible(false);
						}



					}catch (Exception ex) {

                    }finally {
                        if (conn != null) {
                            try {
                                conn.close();
                            } catch (SQLException exc) {
                            }
                        }

				   }


            //Redirect to Signup Page
	        } else if (e.getSource() == signup) {

				    Signuppage signuppage = new Signuppage();
				    frame.setVisible(false);

		    }

    }


}
