//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Unread extends JFrame implements ActionListener {

    // Components of the Unread messages window
    private Container cu;
    private JButton goback;
    private JTextArea urmes;
    private JButton answer;
    private JTextField tanswer;
    private JButton read;

    // constructor, to structure unread messages window
    public Unread() {

        setVisible(true);
	    setTitle("InTune");
	    setBounds(320, 120, 1000, 750);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(true);
	    cu = getContentPane();
	    cu.setLayout(new FlowLayout());

	    goback = new JButton("Go back to messages");
	    goback.setBackground(new java.awt.Color(27, 38, 67));
	    goback.setForeground(Color.WHITE);
	    goback.setFont(new Font("Arial", Font.PLAIN, 15));
	    goback.setSize(550, 30);
	    goback.setLocation(180, 470);
	    goback.addActionListener(this);
	    cu.add(goback);

	    answer = new JButton("Answer");
	    answer.setBackground(new java.awt.Color(27, 38, 67));
		answer.setForeground(Color.WHITE);
		answer.setFont(new Font("Arial", Font.PLAIN, 15));
	    answer.setSize(550, 30);
		answer.setLocation(280, 470);
		answer.addActionListener(this);
	    cu.add(answer);

	    read = new JButton("I read all my messages");
		read.setBackground(new java.awt.Color(27, 38, 67));
		read.setForeground(Color.WHITE);
		read.setFont(new Font("Arial", Font.PLAIN, 15));
		read.setSize(550, 30);
		read.setLocation(380, 470);
		read.addActionListener(this);
	    cu.add(read);

	    tanswer = new JTextField(50);
		tanswer.setFont(new Font("Arial", Font.PLAIN, 15));
		tanswer.setSize(190, 20);
		tanswer.setLocation(380, 470);
		cu.add(tanswer);

		urmes = new JTextArea();
		urmes.setText("");
		JScrollPane scrollPane = new JScrollPane(urmes);
		urmes.setLineWrap(true);
		urmes.setEditable(false);
		urmes.setFont(new Font("Arial", Font.PLAIN, 15));
		urmes.setSize(850, 850);
		urmes.setLocation(800, 800);
		cu.add(urmes);

        Connection conn = null;
        String r = "";

        //show unread messages
        try {

	        Class.forName("org.sqlite.JDBC");
	 	    conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
	        String sqlinsert = "SELECT textmessage, textfrom, textno, status FROM Messages WHERE texto LIKE ? AND status LIKE ?";
	 	    PreparedStatement statement = conn.prepareStatement(sqlinsert);
	 	    statement.setString(1, Entrancepage.tfusername.getText());
	 	    statement.setInt(2, 0);

	        ResultSet rs = statement.executeQuery();

				while (rs.next()) {

			        String s = rs.getString("textno") + "\t" + rs.getString("textmessage") + "\t" + " from " + "\t" + rs.getString("textfrom") + "\n";
				    r = r + s;
				    urmes.setText(r);
				    urmes.setEditable(false);

		        }


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

    }

    public void actionPerformed (ActionEvent e) {

		if (e.getSource() == goback) { //go back to writing a message

			Messages mes = new Messages();
			setVisible(false);

		} else if(e.getSource() == read) { //establish that all current messages were read

			 Connection con = null;

				    try {

					    Class.forName("org.sqlite.JDBC");
						con = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
						String sqlin = "UPDATE Messages SET status = ? WHERE texto LIKE ?";
						PreparedStatement stmt = con.prepareStatement(sqlin);
						stmt.setInt(1, 1);
						stmt.setString(2, Entrancepage.tfusername.getText());

						stmt.executeUpdate();

					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
					} catch (ClassNotFoundException ex) {
						System.out.println(ex.getMessage());
					}finally {
						if (con != null) {
					        try {
							    con.close();
						    } catch (SQLException exc) {
							}
						}

		            }

		      urmes.setText("");

	    } else if (e.getSource() == answer) { // answer to a message

            if (urmes.getText() != "") {
			Connection conn = null;

			    try {
				    Class.forName("org.sqlite.JDBC");
					conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
					String sqlinsert = "SELECT * FROM Messages WHERE textno LIKE ?";
					PreparedStatement statement = conn.prepareStatement(sqlinsert);
					statement.setString(1,tanswer.getText());
					ResultSet rs = statement.executeQuery();

					    if (rs.next()) {

							Chat chat = new Chat(rs.getString("textfrom"));
							setVisible(false);

						}

				} catch (Exception ex) {
				} finally {
					if (conn != null) {
						try {
						    conn.close();
						} catch (SQLException exc) {
						}
					}
			    }

	        } else {

				JOptionPane.showMessageDialog(null,"Nothing new to answer to");

			}


		}

    }

}