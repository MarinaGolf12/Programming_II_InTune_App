//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class EditProfile extends JFrame implements ActionListener {

    // Components of the profile editing window
    private Container cep;
    private JFrame frame;
    private String cname = "";
    private String cusername = "";
    private String cpassword = "";
    private String cpasscheck = "";
    private String cgender = "";
    private int cage = 0;
    private JTextField changeno;
    private JTextField changevalue;
    private JTextArea profile;
    private JButton subchange;
    private JButton goback;
    private JLabel tchangeno;
    private JLabel tchangevalue;
    private JLabel title;

    // constructor, to structure profile editing window
    public EditProfile() {

    frame = new JFrame();
	frame.setTitle("InTune");
	frame.setBounds(320, 120, 1000, 750);
	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	frame.setResizable(true);

	frame.getContentPane().setBackground(new java.awt.Color(232, 237, 244));
	cep = frame.getContentPane();
	cep.setLayout(null);

	title = new JLabel("Edit your Profile");
	title.setFont(new Font("Arial", Font.BOLD, 30));
	title.setForeground(new java.awt.Color(27, 38, 67));
	title.setSize(300, 50);
	title.setLocation(130, 30);
    cep.add(title);

	profile = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(profile);
	profile.setEditable(false);
	profile.setFont(new Font("Arial", Font.PLAIN, 15));
	profile.setSize(550, 190);
	profile.setLocation(200, 100);
	cep.add(profile);

	tchangeno = new JLabel("Select number to edit");
    tchangeno.setFont(new Font("Arial", Font.PLAIN, 17));
   	tchangeno.setSize(300, 30);
	tchangeno.setLocation(200, 320);
    cep.add(tchangeno);

    changeno = new JTextField(30);
	changeno.setFont(new Font("Arial", Font.PLAIN, 15));
	changeno.setSize(550, 25);
	changeno.setLocation(200, 350);
	cep.add(changeno);

	tchangevalue = new JLabel("Write new info");
	tchangevalue.setFont(new Font("Arial", Font.PLAIN, 17));
   	tchangevalue.setSize(300, 30);
	tchangevalue.setLocation(200, 377);
	cep.add(tchangevalue);

	changevalue = new JTextField(30);
	changevalue.setFont(new Font("Arial", Font.PLAIN, 15));
	changevalue.setSize(550, 25);
	changevalue.setLocation(200, 405);
	cep.add(changevalue);

	subchange = new JButton("Submit Change");
	subchange.setBackground(new java.awt.Color(27, 38, 67));
	subchange.setForeground(Color.WHITE);
	subchange.setFont(new Font("Arial", Font.BOLD, 15));
	subchange.setSize(240, 35);
	subchange.setLocation(350, 480);
	subchange.addActionListener(this);
	cep.add(subchange);

	goback = new JButton("Profile");
	goback.setBackground(new java.awt.Color(27, 38, 67));
	goback.setForeground(Color.WHITE);
	goback.setFont(new Font("Arial", Font.BOLD, 15));
	goback.setSize(240, 35);
	goback.setLocation(350, 530);
	goback.addActionListener(this);
	cep.add(goback);

    frame.setVisible(true);

	//Show User's info
	Connection conn = null;
	    try {

	        Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
		String sqlinsert = "SELECT * FROM User WHERE username LIKE ?";
		PreparedStatement statement = conn.prepareStatement(sqlinsert);
		statement.setString(1, Entrancepage.tfusername.getText());
		ResultSet rs = statement.executeQuery();

		if (rs.next()) {
		    String s = "1.Name: " + rs.getString("name") + "\n" + "2.Username: " + rs.getString("username") + "\n" + "3.Password: " + rs.getString("password") + "\n" + "4.Gender: " + rs.getString("gender") + "\n" + "5.Age: " + rs.getInt("age");
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

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == subchange) { //submits change to profile

			if (changeno.getText().equals("1")) { //changes name

				Connection conn = null;
			    try {

			        Class.forName("org.sqlite.JDBC");
					conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
                    String sqlinsert = "UPDATE User SET name = ? WHERE username LIKE ?";
					PreparedStatement statement = conn.prepareStatement(sqlinsert);
					statement.setString(1, changevalue.getText());
					statement.setString(2, Entrancepage.tfusername.getText());
					statement.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Profile updated!");
                    Profile prof = new Profile();
                    frame.setVisible(false);

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

			}else if (changeno.getText().equals("2")) { //changes username

				Connection conn = null;
			    try {

			        Class.forName("org.sqlite.JDBC");
					conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
                    String sqlinsert = "UPDATE User SET username = ? WHERE username LIKE ?";
					PreparedStatement statement = conn.prepareStatement(sqlinsert);
					statement.setString(1, changevalue.getText());
					statement.setString(2, Entrancepage.tfusername.getText());
					statement.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Profile updated!");
                    Profile prof = new Profile();
                    frame.setVisible(false);

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

			}else if (changeno.getText().equals("3")) { //changes password

				Connection conn = null;
			    try {

			        Class.forName("org.sqlite.JDBC");
					conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
                    String sqlinsert = "UPDATE User SET password = ?, passcheck = ? WHERE username LIKE ?";
					PreparedStatement statement = conn.prepareStatement(sqlinsert);
					statement.setString(1, changevalue.getText());
					statement.setString(2, changevalue.getText());
					statement.setString(3, Entrancepage.tfusername.getText());
					statement.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Profile updated!");
                    Profile prof = new Profile();
                    frame.setVisible(false);

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

			}else if (changeno.getText().equals("4")) { //changes gender

				Connection conn = null;
			    try {

			        Class.forName("org.sqlite.JDBC");
					conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
                    String sqlinsert = "UPDATE User SET gender = ? WHERE username LIKE ?";
					PreparedStatement statement = conn.prepareStatement(sqlinsert);
					statement.setString(1, changevalue.getText());
					statement.setString(2, Entrancepage.tfusername.getText());
					statement.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Profile updated!");
                    Profile prof = new Profile();
                    frame.setVisible(false);

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

			}else if (changeno.getText().equals("5")) { //changes age

				Connection conn = null;
			    try {

			        Class.forName("org.sqlite.JDBC");
					conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
                    String sqlinsert = "UPDATE User SET age = ? WHERE username LIKE ?";
					PreparedStatement statement = conn.prepareStatement(sqlinsert);
					statement.setString(1, changevalue.getText());
					statement.setString(2, Entrancepage.tfusername.getText());
					statement.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Profile updated!");
                    Profile prof = new Profile();
                    frame.setVisible(false);

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

        } else if (e.getSource() == goback) { //go back to user's profile

            Profile prof = new Profile();
            frame.setVisible(false);

        }

    }
}