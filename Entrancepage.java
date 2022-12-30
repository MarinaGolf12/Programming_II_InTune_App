//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//Set up graphics for Login Page
class Entrancepage extends JFrame implements ActionListener {

    // Components of the Entrancepage Form
    private Container cp;
    private JButton signup;
    private JLabel title;
    private JLabel username;
	protected static JTextField tfusername;
	private JLabel password;
    private JPasswordField tfpassword;
    private JButton login;
    private JLabel newuser;
    private JTextArea twrong;
    private JLabel res;
    private JTextArea resadd;

    // constructor, to structure Entrancepage window
    public Entrancepage() {

		setVisible(true);

        setTitle("InTune");
        setBounds(320, 120, 1000, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);


        cp = getContentPane();
        cp.setLayout(null);

        title = new JLabel("Welcome to InTune!");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(500, 30);
		title.setLocation(300, 30);
		cp.add(title);


        username = new JLabel("Username");
	    username.setFont(new Font("Arial", Font.PLAIN, 20));
		username.setSize(300, 30);
		username.setLocation(100, 150);
		cp.add(username);

		tfusername = new JTextField();
		tfusername.setFont(new Font("Arial", Font.PLAIN, 15));
		tfusername.setSize(550, 30);
		tfusername.setLocation(200, 150);
		cp.add(tfusername);

		password = new JLabel("Password");

		password.setFont(new Font("Arial", Font.PLAIN, 20));
		password.setSize(300, 30);
		password.setLocation(100, 250);
		cp.add(password);

		tfpassword = new JPasswordField(25);
		tfpassword.setFont(new Font("Arial", Font.PLAIN, 15));
		tfpassword.setSize(550, 30);
		tfpassword.setLocation(200, 250);
		cp.add(tfpassword);

		login = new JButton("Login");
		login.setFont(new Font("Arial", Font.PLAIN, 15));
		login.setSize(550, 60);
		login.setLocation(200, 350);
		login.addActionListener(this);
        cp.add(login);

        newuser = new JLabel("Are you new?");
		newuser.setFont(new Font("Arial", Font.PLAIN, 16));
		newuser.setSize(500, 60);
		newuser.setLocation(430, 450);
		cp.add(newuser);

		signup = new JButton("Sign Up");
		signup.setFont(new Font("Arial", Font.PLAIN, 15));
		signup.setSize(550, 60);
		signup.setLocation(200, 550);
		signup.addActionListener(this);
        cp.add(signup);

        res = new JLabel("");
		res.setFont(new Font("Arial", Font.PLAIN, 20));
		res.setSize(500, 25);
		res.setLocation(350, 650);
		cp.add(res);

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
							setVisible(false);



						} else {
							String def = " ";
							res.setText("Wrong Username or Password");
							tfusername.setText(def);
							tfpassword.setText(def);
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
				    setVisible(false);

		    }

    }


}

