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
    private JFrame frame;
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




    // constructor, to initialize the components with default values.
    public Signuppage()
    {

		frame = new JFrame();
        frame.setTitle("InTune");
        frame.setBounds(320, 120, 1000, 750);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
		frame.getContentPane().setBackground(new java.awt.Color(232, 237, 244));
        c = frame.getContentPane();
        c.setLayout(null);

        title = new JLabel("Sign Up");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(new java.awt.Color(27, 38, 67));
        title.setSize(300, 50);
        title.setLocation(130, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 15));
        name.setSize(100, 20);
        name.setLocation(130, 110);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(130, 135);
        c.add(tname);

        username = new JLabel("Username");
	    username.setFont(new Font("Arial", Font.PLAIN, 15));
	    username.setSize(100, 20);
		username.setLocation(130, 165);
		c.add(username);

		tusername = new JTextField();
		tusername.setFont(new Font("Arial", Font.PLAIN, 15));
		tusername.setSize(190, 20);
		tusername.setLocation(130, 190);
		c.add(tusername);

		password = new JLabel("Password");
		password.setFont(new Font("Arial", Font.PLAIN, 15));
		password.setSize(100, 20);
		password.setLocation(130, 220);
		c.add(password);

		tpassword = new JTextField();
		tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
		tpassword.setSize(190, 20);
		tpassword.setLocation(130, 245);
		c.add(tpassword);

		passcheck = new JLabel("Repeat");
		passcheck.setFont(new Font("Arial", Font.PLAIN, 15));
		passcheck.setSize(100, 20);
		passcheck.setLocation(130, 275);
		c.add(passcheck);

		tpasscheck = new JTextField();
		tpasscheck.setFont(new Font("Arial", Font.PLAIN, 15));
		tpasscheck.setSize(190, 20);
		tpasscheck.setLocation(130, 300);
		c.add(tpasscheck);


        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 15));
        gender.setSize(100, 20);
        gender.setLocation(130, 330);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(130, 355);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(205, 355);
        c.add(female);

        other = new JRadioButton("Other");
		other.setFont(new Font("Arial", Font.PLAIN, 15));
		other.setSelected(false);
		other.setSize(85, 20);
		other.setLocation(280, 355);
        c.add(other);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);
        gengp.add(other);

        age = new JLabel("Age");
		age.setFont(new Font("Arial", Font.PLAIN, 15));
		age.setSize(100, 20);
		age.setLocation(130, 385);
		c.add(age);

		tage = new JTextField();
		tage.setFont(new Font("Arial", Font.PLAIN, 15));
		tage.setSize(190, 20);
		tage.setLocation(130, 410);
		c.add(tage);

        term = new JCheckBox("Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(200, 20);
        term.setLocation(130, 450);
        c.add(term);

        check = new JButton("Check your info");
        check.setFont(new Font("Arial", Font.PLAIN, 15));
        check.setBackground(new java.awt.Color(216, 223, 233));
		check.setForeground(new java.awt.Color(27, 38, 67));
		check.setSize(200, 20);
        check.setLocation(130, 500);
        check.addActionListener(this);
        c.add(check);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setBackground(new java.awt.Color(216, 223, 233));
		reset.setForeground(new java.awt.Color(27, 38, 67));
        reset.setSize(200, 20);
        reset.setLocation(130, 535);
        reset.addActionListener(this);
        c.add(reset);

        goback = new JButton("Go Back");
		goback.setFont(new Font("Arial", Font.PLAIN, 15));
		goback.setBackground(new java.awt.Color(216, 223, 233));
		goback.setForeground(new java.awt.Color(27, 38, 67));
		goback.setSize(200, 20);
		goback.setLocation(130, 570);
		goback.addActionListener(this);
        c.add(goback);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 120);
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
        resadd.setLocation(580, 185);
        resadd.setLineWrap(true);
        c.add(resadd);

        sub = new JButton("Submit");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
		sub.setBackground(new java.awt.Color(27, 38, 67));
		sub.setForeground(Color.WHITE);
		sub.setSize(170, 30);
		sub.setLocation(570, 550);
		sub.addActionListener(this);
        c.add(sub);

	    frame.setVisible(true);

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
			frame.setVisible(false);
			Entrancepage p = new Entrancepage();
		}
		else if (e.getSource() == sub) {
		    if (term.isSelected()) {
                if (tpassword.getText().equals(tpasscheck.getText())) {
	                    String gender;
	                    Connection conn = null;
	                    if (male.isSelected()) {
	                        gender = "male";
		                    try {
		                        Class.forName("org.sqlite.JDBC");
		                    	conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
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
		                	}finally {
                        if (conn != null) {
                            try {
                                conn.close();
                            } catch (SQLException exc) {

                            }
                        }

				   }

	                	} else if (female.isSelected()) {
	                    	gender = "female";
		                	try {
		                    	Class.forName("org.sqlite.JDBC");
		                    	conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
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
							} finally {
                        if (conn != null) {
                            try {
                                conn.close();
                            } catch (SQLException exc) {
                            }
                        }

				   }

	                    } else if (other.isSelected()) {
					        gender = "other";
						    try {
						        Class.forName("org.sqlite.JDBC");
								conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
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
                                } finally {
                        if (conn != null) {
                            try {
                                conn.close();
                            } catch (SQLException exc) {
                            }
                        }

				   }

                    	}
                    	Entrancepage ep = new Entrancepage();
                    	frame.setVisible(false);

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