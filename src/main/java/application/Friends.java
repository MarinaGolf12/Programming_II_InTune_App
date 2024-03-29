/**
 * @author Marina_Gkolfinopoulou
 * @author Konstantinos_Diamantoudis
 */
package application;
//import required classes and packages
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**Declare Friends class.*/
class Friends extends JFrame implements ActionListener {

    // Components of the Friends window
    private Container cf;
    private JFrame frame;
    private JTextArea friendslist;
    private JButton add;
    private JButton delete;
    private JButton goback;
    private JTextField friendname;
    private JLabel writefn;
    private JLabel title;

    /**constructor, to structure Friends window.*/
    public Friends() {

    	frame = new JFrame();
        frame.setTitle("InTune");
        frame.setBounds(320, 120, 1000, 750);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(true);

        frame.getContentPane().
        setBackground(new java.awt.Color(232, 237, 244));
        cf = frame.getContentPane();
        cf.setLayout(null);

        title = new JLabel("Friends");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(new java.awt.Color(27, 38, 67));
        title.setSize(300, 50);
        title.setLocation(130, 30);
        cf.add(title);

        friendslist = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(friendslist);
        friendslist.setEditable(false);
        friendslist.setFont(new Font("Arial", Font.PLAIN, 15));
        friendslist.setSize(550, 190);
        friendslist.setLocation(200, 120);
        cf.add(friendslist);

        writefn = new JLabel("Choose friend to add or delete");
        writefn.setFont(new Font("Arial", Font.PLAIN, 17));
        writefn.setSize(300, 30);
        writefn.setLocation(200, 320);
        cf.add(writefn);

        friendname = new JTextField(40);
        friendname.setFont(new Font("Arial", Font.PLAIN, 15));
        friendname.setSize(550, 25);
        friendname.setLocation(200, 350);
        cf.add(friendname);

        add = new JButton("Add new friend");
        add.setBackground(new java.awt.Color(27, 38, 67));
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Arial", Font.BOLD, 15));
        add.setSize(240, 35);
        add.setLocation(350, 400);
        add.addActionListener(this);
        cf.add(add);

        delete = new JButton("Delete friend");
        delete.setBackground(new java.awt.Color(27, 38, 67));
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("Arial", Font.BOLD, 15));
        delete.setSize(240, 35);
        delete.setLocation(350, 450);
        delete.addActionListener(this);
        cf.add(delete);

        goback = new JButton("Profile");
        goback.setBackground(new java.awt.Color(27, 38, 67));
        goback.setForeground(Color.WHITE);
        goback.setFont(new Font("Arial", Font.BOLD, 15));
        goback.setSize(240, 35);
        goback.setLocation(350, 500);
        goback.addActionListener(this);
        cf.add(goback);

        frame.setVisible(true);

        //Show all friends
        Connection conn = null;
        String r = "";
        try {

        	Class.forName("org.sqlite.JDBC");
        	conn = DriverManager.getConnection("jdbc:sqlite:C:\\SQLITE//InTune.db");
        	String sqlinsert =
        	"SELECT friendusername FROM Friends WHERE fusername LIKE ?";
        	PreparedStatement statement =
        	conn.prepareStatement(sqlinsert);
        	statement.
        	setString(1, Entrancepage.tfusername.getText());
        	ResultSet rs = statement.executeQuery();

        	while (rs.next()) {

        		String s = " "
        		+ rs.getString("friendusername") + "\n";
        		r = r + s;
        		friendslist.setText(r);
        		friendslist.setEditable(false);

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

    public void actionPerformed(final ActionEvent ae) {

        if (ae.getSource() == add) { //add a friend

		    Connection conn = null;
            if (CheckFriends.
            friendExists(friendname.getText()) == true) {

			    if (friendname.
			    equals(Entrancepage.tfusername.getText()) != true) {

				    try {

					    Class.forName("org.sqlite.JDBC");
						conn = DriverManager.
						getConnection("jdbc:sqlite:C:\\SQLITE//InTune.db");
						String sqlinsert =
						"INSERT INTO "
						+ "Friends(fusername,"
						+ " friendusername)"
						+ "VALUES(?, ?)";
						PreparedStatement pstmt =
						conn.
						prepareStatement(sqlinsert);
						pstmt.
						setString(1, Entrancepage.
						tfusername.getText());
						pstmt.setString(2,
						friendname.getText());
						pstmt.executeUpdate();

						JOptionPane.
						showMessageDialog(null,
						"Friend was added!");
						Friends fr = new Friends();
						frame.setVisible(false);

					} catch (Exception ex) {
					} finally {
						if (conn != null) {
							try {
								conn.close();
							} catch (
							  SQLException exc) {
							}
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Can not add yourself!");
				}

			} else {

				JOptionPane.
				showMessageDialog(null,
				"Please enter an existing user!");

			}

        } else if (ae.getSource() == delete) {
        //delete a friend

			Connection conn = null;
            if (CheckFriends.
            friendExists(friendname.getText()) == true) {
			    if (friendname.
			    equals(Entrancepage.
			    tfusername.getText()) != true) {

					try {

						Class.
						forName("org.sqlite.JDBC");
						conn = DriverManager.
						getConnection("jdbc:sqlite:C:\\\\SQLITE//InTune.db");
						String sqlinsert =
						"DELETE FROM Friends"
						+ " WHERE fusername = ?"
						+ " AND friendusername = ?";
						PreparedStatement
						pstmt =
						conn.
						prepareStatement(sqlinsert);
						pstmt.
						setString(1, Entrancepage.
						tfusername.getText());
						pstmt.setString(2, friendname.
						getText());
						pstmt.executeUpdate();

						JOptionPane.
						showMessageDialog(null,
						"Friend was deleted");
					    Friends fr = new Friends();
						frame.setVisible(false);

					} catch (Exception ex) {
					} finally {
						if (conn != null) {
							try {
								conn.close();
							} catch (
							  SQLException exc) {
							}
						}
					}
				} else {
					JOptionPane.
					showMessageDialog(null,
					"Can not delete yourself!");
				}

			} else {

				JOptionPane.
				showMessageDialog(null,
				"Please enter an existing user!");

			}

        } else if (ae.getSource() == goback) {
        	//go back to user's profile

            Profile prof = new Profile();
            frame.setVisible(false);

        }

    }
}
