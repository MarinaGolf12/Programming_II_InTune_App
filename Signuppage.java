// Java program to implement
// a Simple Registration Form
// using Java Swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Signuppage
    extends JFrame
    implements ActionListener {

    // Components of the Form
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
    private ButtonGroup gengp;
    private JLabel age;
    private JTextField tage;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;



    // constructor, to initialize the components
    // with default values.
    public Signuppage()
    {
        setTitle("Sign Up");
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

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        age = new JLabel("Age");
		age.setFont(new Font("Arial", Font.PLAIN, 20));
		age.setSize(100, 20);
		age.setLocation(100, 400);
		c.add(age);

		tage = new JTextField();
		tage.setFont(new Font("Arial", Font.PLAIN, 15));
		tage.setSize(190, 20);
		tage.setLocation(200, 400);
		c.add(tage);

        term = new JCheckBox("Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(200, 20);
        term.setLocation(150, 500);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(200, 20);
        sub.setLocation(150, 550);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(200, 20);
        reset.setLocation(150, 650);
        reset.addActionListener(this);
        c.add(reset);

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
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
            if (term.isSelected()) {
                String data2;
                String data3;
                String data1 = "Name : "
                      + tname.getText() + "\n";
                if (male.isSelected()) {
                    data2 = "Gender : Male" + "\n" ;
                    data3 = "Age : "
                      + tage.getText() + "\n";

                } else {

                    data2 = "Gender : Female" + "\n";
                    data3 = "Age : "
                      + tage.getText() + "\n";

			    }

                tout.setText(data1 + data2 + data3);
                tout.setEditable(false);

            }
            else {
                tout.setText("");
                resadd.setText("");
                res.setText("Please accept the"
                            + " terms & conditions..");
            }
        }

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
    }
}
