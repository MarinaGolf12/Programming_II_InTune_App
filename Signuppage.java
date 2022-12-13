//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Signuppage
    extends JFrame
    implements ActionListener {

    // Components of the Entrance Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel username;
    private JTextField tusername;
    private JLabel password;
    private JTextField tpassword;
    private JLabel passcheck;
    private JTextField tpasscheck;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private JRadioButton other;
    private ButtonGroup gengp;
    private JLabel age;
    private JTextField tage;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JButton check;
    private JButton goback;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    private boolean usernameExists;



    // constructor, to initialize the components with default values.
    public Signuppage()
    {
        setTitle("InTune");
        setBounds(320, 120, 1000, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Sign Up");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        c.add(tname);

        username = new JLabel("Username");
	    username.setFont(new Font("Arial", Font.PLAIN, 20));
	    username.setSize(100, 20);
		username.setLocation(100, 150);
		c.add(username);

		tusername = new JTextField();
		tusername.setFont(new Font("Arial", Font.PLAIN, 15));
		tusername.setSize(190, 20);
		tusername.setLocation(200, 150);
		c.add(tusername);

		password = new JLabel("Password");
		password.setFont(new Font("Arial", Font.PLAIN, 20));
		password.setSize(100, 20);
		password.setLocation(100, 200);
		c.add(password);

		tpassword = new JTextField();
		tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
		tpassword.setSize(190, 20);
		tpassword.setLocation(200, 200);
		c.add(tpassword);

		passcheck = new JLabel("Repeat");
		passcheck.setFont(new Font("Arial", Font.PLAIN, 20));
		passcheck.setSize(100, 20);
		passcheck.setLocation(100, 250);
		c.add(passcheck);

		tpasscheck = new JTextField();
		tpasscheck.setFont(new Font("Arial", Font.PLAIN, 15));
		tpasscheck.setSize(190, 20);
		tpasscheck.setLocation(200, 250);
		c.add(tpasscheck);


        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 300);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 300);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 300);
        c.add(female);

        other = new JRadioButton("Other");
		other.setFont(new Font("Arial", Font.PLAIN, 15));
		other.setSelected(false);
		other.setSize(85, 20);
		other.setLocation(365, 300);
        c.add(other);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);
        gengp.add(other);

        age = new JLabel("Age");
		age.setFont(new Font("Arial", Font.PLAIN, 20));
		age.setSize(100, 20);
		age.setLocation(100, 350);
		c.add(age);

		tage = new JTextField();
		tage.setFont(new Font("Arial", Font.PLAIN, 15));
		tage.setSize(190, 20);
		tage.setLocation(200, 350);
		c.add(tage);

        term = new JCheckBox("Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(200, 20);
        term.setLocation(150, 400);
        c.add(term);

        check = new JButton("Check your info");
        check.setFont(new Font("Arial", Font.PLAIN, 15));
        check.setSize(200, 20);
        check.setLocation(150, 450);
        check.addActionListener(this);
        c.add(check);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(200, 20);
        reset.setLocation(150, 500);
        reset.addActionListener(this);
        c.add(reset);

        goback = new JButton("Go Back");
		goback.setFont(new Font("Arial", Font.PLAIN, 15));
		goback.setSize(200, 20);
		goback.setLocation(150, 550);
		goback.addActionListener(this);
        c.add(goback);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 600);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        sub = new JButton("Submit");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
		sub.setSize(300, 20);
		sub.setLocation(500, 550);
		sub.addActionListener(this);
        c.add(sub);

        setVisible(true);
    }

    public void checkUsernameExists() {

	     usernameExists = false;
	     try
		 {
		     Class.forName("org.sqlite.JDBC");
	         Connection connection = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//INTUNE.db");
	         PreparedStatement st = connection.prepareStatement("select * from User where username = ?");
		     st.setString(1, tusername.getText());
		     ResultSet r1=st.executeQuery();
		     if(r1.next()) {
		         usernameExists = true;
             }
         }catch (SQLException e) {
	        System.out.println("SQL Exception: "+ e.toString());
	     }catch (ClassNotFoundException cE) {
	        System.out.println("Class Not Found Exception: "+ cE.toString());
	     }

    }

    // Shows data of a new user
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == check) {
                String data2;
                String data3;
                String data1 = "Name : "
                      + tname.getText() + "\n";
                if (male.isSelected()) {
                    data2 = "Gender : Male" + "\n" ;
                    data3 = "Age : "
                      + tage.getText() + "\n";

                } else if (female.isSelected()) {

                    data2 = "Gender : Female" + "\n";
                    data3 = "Age : "
                      + tage.getText() + "\n";

			    } else {

			         data2 = "Gender : Other" + "\n";
					 data3 = "Age : "
                      + tage.getText() + "\n";
			   }
                tout.setText(data1 + data2 + data3);
                tout.setEditable(false);

        }
        //Clears out Form
        else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tusername.setText(def);
            tpassword.setText(def);
            tpasscheck.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            tage.setText(def);
            resadd.setText(def);
        }
        //Goes back to Login Page
        else if (e.getSource() == goback) {
			setVisible(false);
			Entrancepage p = new Entrancepage();
		}
		else if (e.getSource() == sub) {
		    if (term.isSelected()) {
                if (tpassword.getText().equals(tpasscheck.getText())) {
					if (usernameExists == false) {
	                    String gender;
	                    if (male.isSelected()) {
	                        gender = "male";
		                    try {
		                        Class.forName("org.sqlite.JDBC");
		                    	Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//INTUNE.db");
		                    	String sqlinsert = "INSERT INTO User(name, username, password, passcheck, gender, age) VALUES(?,?,?,?,?,?)";
		                    	PreparedStatement statement = conn.prepareStatement(sqlinsert);
		                    	statement.setString(1, tname.getText());
		                    	statement.setString(2, tusername.getText());
		                    	statement.setString(3, tpassword.getText());
		                    	statement.setString(4, tpasscheck.getText());
		                    	statement.setString(5, gender);
		                    	statement.setString(6, tage.getText());

                            	statement.executeUpdate();
		                	} catch (SQLException ex) {
                            	System.out.println(ex.getMessage());
                        	} catch (ClassNotFoundException ex) {
		                    	System.out.println(ex.getMessage());
		                	}
	                	} else if (female.isSelected()) {
	                    	gender = "female";
		                	try {
		                    	Class.forName("org.sqlite.JDBC");
		                    	Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
		                    	String sqlinsert = "INSERT INTO User (name, username, password, passcheck, gender, age) VALUES(?,?,?,?,?,?)";
		                    	PreparedStatement statement = conn.prepareStatement(sqlinsert);
		                    	statement.setString(1, tname.getText());
		                    	statement.setString(2, tusername.getText());
		                    	statement.setString(3, tpassword.getText());
	                        	statement.setString(4, tpasscheck.getText());
		                    	statement.setString(5, gender);
		                    	statement.setString(6, tage.getText());

		                    	statement.executeUpdate();
		                	} catch (SQLException ex) {
		                    	System.out.println(ex.getMessage());
		                	} catch (ClassNotFoundException ex) {
		                        System.out.println(ex.getMessage());
							}
	                    } else if (other.isSelected()) {
					        gender = "other";
						    try {
						        Class.forName("org.sqlite.JDBC");
								Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
								String sqlinsert = "INSERT INTO User (name, username, password, passcheck, gender, age) VALUES(?,?,?,?,?,?)";
								PreparedStatement statement = conn.prepareStatement(sqlinsert);
								statement.setString(1, tname.getText());
								statement.setString(2, tusername.getText());
								statement.setString(3, tpassword.getText());
							    statement.setString(4, tpasscheck.getText());
								statement.setString(5, gender);
								statement.setString(6, tage.getText());

								statement.executeUpdate();
								} catch (SQLException ex) {
								    System.out.println(ex.getMessage());
								} catch (ClassNotFoundException ex) {
								    System.out.println(ex.getMessage());
                                }
                    	}
                    	NewPage main = new NewPage();
                    	setVisible(false);
                    	main.setVisible(true);
                    	JLabel mainlabel = new JLabel("Welcome: "+tusername.getText());
					    main.getContentPane().add(mainlabel);

				    } else {
						res.setText("Username is already used.");
						tusername.setText("");
					}

	            }else {

		            res.setText("Password is not repeated correctly.");
		            tpassword.setText("");
                    tpasscheck.setText("");
                }
            } else {
		        tout.setText("");
		        resadd.setText("");
	            res.setText("Please accept the"
	                + " terms & conditions.");
	        }
	    }

    }
}
