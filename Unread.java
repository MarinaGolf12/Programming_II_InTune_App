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
    private JFrame frame;
    private JLabel unread;

    // constructor, to structure unread messages window
    public Unread() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new java.awt.Color(232, 237, 244));
	    frame.setTitle("InTune");
	    frame.setBounds(320, 120, 1000, 750);
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    frame.setResizable(true);
	    cu = frame.getContentPane();
	    cu.setLayout(null);

	    unread = new JLabel("New Messages");
		unread.setFont(new Font("Arial", Font.BOLD, 30));
		unread.setForeground(new java.awt.Color(27, 38, 67));
		unread.setSize(300, 50);
		unread.setLocation(110, 40);
 		cu.add(unread);

	    goback = new JButton("Go back to messages");
	    goback.setBackground(new java.awt.Color(27, 38, 67));
	    goback.setForeground(Color.WHITE);
	   	goback.setFont(new Font("Arial", Font.BOLD, 15));
	   	goback.setSize(240, 35);
		goback.setLocation(110, 300);
	    goback.addActionListener(this);
	    cu.add(goback);

	    answer = new JButton("Answer");
	    answer.setBackground(new java.awt.Color(27, 38, 67));
		answer.setForeground(Color.WHITE);
		answer.setFont(new Font("Arial", Font.BOLD, 15));
		answer.setSize(240, 35);
		answer.setLocation(110, 190);
		answer.addActionListener(this);
	    cu.add(answer);

	    read = new JButton("I read all my messages");
		read.setBackground(new java.awt.Color(27, 38, 67));
		read.setForeground(Color.WHITE);
		read.setFont(new Font("Arial", Font.BOLD, 15));
		read.setSize(240, 35);
		read.setLocation(110, 245);
		read.addActionListener(this);
	    cu.add(read);

	    tanswer = new JTextField(50);
		tanswer.setFont(new Font("Arial", Font.PLAIN, 15));
		tanswer.setSize(240,35);
		tanswer.setLocation(110,130);
		cu.add(tanswer);

		urmes = new JTextArea();
		urmes.setText("");
		JScrollPane scrollPane = new JScrollPane(urmes);
		urmes.setLineWrap(true);
		urmes.setEditable(false);
		urmes.setFont(new Font("Arial", Font.PLAIN, 15));
		urmes.setSize(500, 400);
		urmes.setLocation(410, 130);
		cu.add(urmes);

        Connection conn = null;
        String r = "";

        frame.setVisible(true);

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
			frame.setVisible(false);

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

            if (urmes.getText().equals("") == false) {
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
							frame.setVisible(false);

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
    public static void main(String[] args) {
		new Unread();
    }

}