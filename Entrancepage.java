//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Set up graphics for Login Page
class Entrancepage extends JFrame implements ActionListener {

    private Container cp;
    private JButton signup;
    private JLabel title;
    private JLabel username;
	private JTextField tfusername;
	private JLabel password;
    private JTextField tfpassword;
    private JButton login;
    private JLabel newuser;
    private JTextArea twrong;
    private JLabel res;
    private JTextArea resadd;

    public Entrancepage() {

		setVisible(true);

        setTitle("InTune");
        setBounds(320, 120, 1000, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        //setSize(400, 200);

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

		tfpassword = new JTextField();
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

        /*twrong = new JTextArea();
		twrong.setFont(new Font("Arial", Font.PLAIN, 15));
		twrong.setSize(300, 400);
		twrong.setLocation(200, 600);
		twrong.setLineWrap(true);
		twrong.setEditable(false);
        cp.add(twrong);*/

        res = new JLabel("");
		res.setFont(new Font("Arial", Font.PLAIN, 20));
		res.setSize(500, 25);
		res.setLocation(350, 650);
		cp.add(res);

		/*resadd = new JTextArea();
		resadd.setFont(new Font("Arial", Font.PLAIN, 15));
		resadd.setSize(200, 75);
		resadd.setLocation(580, 175);
		resadd.setLineWrap(true);
		cp.add(resadd);*/


    }

    //Check with DB before connecting a user to app
    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == login) {

	                String usernameValue = tfusername.getText();
					String passwordValue = tfpassword.getText();

					if (usernameValue.equals("marina") && passwordValue.equals("pass")) {  //this part should be connected with db

					    NewPage mainpage = new NewPage(); //will use other code instead of that in NewPage.java
					    setVisible(false);
					    mainpage.setVisible(true);
					    JLabel mainlabel = new JLabel("Welcome: "+usernameValue);
					    mainpage.getContentPane().add(mainlabel);

					} else{

					    String def = " ";
						res.setText("Wrong Username or Password");
                        tfusername.setText(def);
                        tfpassword.setText(def);

                    }


            //Redirect to Signup Page
	        } else if (e.getSource() == signup) {

				    Signuppage signuppage = new Signuppage();
				    setVisible(false);

		    }

    }


}

