import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Entrancepage extends JFrame implements ActionListener {

    private Container cp;
    private JButton signup;
    private JLabel username;
	private JTextField tfusername;
	private JLabel password;
    private JTextField tfpassword;
    private JButton login;
    private JLabel newuser;

    public Entrancepage() {

		setVisible(true);

        setTitle("InTune");
        setBounds(320, 120, 1000, 750);
        setResizable(false);
        setDefaultCloseOperation(javax.swing.
		WindowConstants.DISPOSE_ON_CLOSE);
        //setSize(400, 200);

        cp = getContentPane();
        cp.setLayout(null);

        username = new JLabel("Username");
	    username.setFont(new Font("Arial", Font.PLAIN, 20));
		username.setSize(300, 60);
		username.setLocation(300, 150);
		cp.add(username);

		tfusername = new JTextField();
		tfusername.setFont(new Font("Arial", Font.PLAIN, 15));
		tfusername.setSize(1050, 60);
		tfusername.setLocation(600, 150);
		cp.add(tfusername);

		password = new JLabel("Password");
		password.setFont(new Font("Arial", Font.PLAIN, 20));
		password.setSize(300, 60);
		password.setLocation(300, 300);
		cp.add(password);

		tfpassword = new JTextField();
		tfpassword.setFont(new Font("Arial", Font.PLAIN, 15));
		tfpassword.setSize(1050, 60);
		tfpassword.setLocation(600, 300);
		cp.add(tfpassword);

		login = new JButton("Login");
		login.setFont(new Font("Arial", Font.PLAIN, 15));
		login.setSize(600, 60);
		login.setLocation(750, 450);
		login.addActionListener(this);
        cp.add(login);

        newuser = new JLabel("Are you new?");
		newuser.setFont(new Font("Arial", Font.PLAIN, 16));
		newuser.setSize(600, 60);
		newuser.setLocation(1000, 650);
		cp.add(newuser);

		signup = new JButton("Sign Up");
		signup.setFont(new Font("Arial", Font.PLAIN, 15));
		signup.setSize(600, 60);
		signup.setLocation(750, 750);
		signup.addActionListener(this);
        cp.add(signup);

    }

    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == login) {

	                String usernameValue = tfusername.getText();
					String passwordValue = tfpassword.getText();

					if (usernameValue.equals("marina") && passwordValue.equals("pass")) {  //this part should be connected with db

					    NewPage mainpage = new NewPage();
					    setVisible(false);
					    mainpage.setVisible(true);
					    JLabel mainlabel = new JLabel("Welcome: "+usernameValue);
					    mainpage.getContentPane().add(mainlabel);

					} else{

					    System.out.println("Wrong username or password");

                    }



	        } else if (e.getSource() == signup) {

				    Signuppage signuppage = new Signuppage();
				    setVisible(false);

		    }

    }


}

