//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

class WatchPost extends JFrame implements ActionListener {

    // Components of the WatchPost window
	private Container cw;
	private JTextArea space;
	private JButton choose;
	private JButton goback;
	private JTextField tfshowchoice;
	private JButton play;

    // constructor, to structure WatchPost window
    public WatchPost() {

        setVisible(true);

	    setTitle("InTune");

	    setBounds(320, 120, 1000, 750);

	    setDefaultCloseOperation(EXIT_ON_CLOSE);

	    setResizable(true);

	    cw = getContentPane();

		cw.setLayout(new FlowLayout());


		space = new JTextArea();
		space.setText("");
		space.setFont(new Font("Arial", Font.PLAIN, 15));
		space.setSize(500, 800);
		space.setLocation(100, 500);
		space.setLineWrap(true);
		space.setEditable(false);
        cw.add(space);

        choose = new JButton("Choose a post to react to!");
        choose.setFont(new Font("Arial", Font.PLAIN, 15));
		choose.setSize(200, 20);
		choose.setLocation(150, 500);
        choose.addActionListener(this);
        cw.add(choose);

        goback = new JButton("Homepage");
        goback.setFont(new Font("Arial", Font.PLAIN, 15));
		goback.setSize(200, 20);
		goback.setLocation(150, 600);
        goback.addActionListener(this);
        cw.add(goback);

		tfshowchoice = new JTextField(30);
		tfshowchoice.setFont(new Font("Arial", Font.PLAIN, 15));
		tfshowchoice.setSize(190, 20);
		tfshowchoice.setLocation(200,100);
		cw.add(tfshowchoice);

		play = new JButton("Play a post");
		play.setFont(new Font("Arial", Font.PLAIN, 15));
		play.setSize(200, 20);
		play.setLocation(150, 700);
		play.addActionListener(this);
        cw.add(play);

        //Show all Posts
		Connection conn = null;
		String r = "";
		try {
								        Class.forName("org.sqlite.JDBC");
										conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
										String sqlinsert = "SELECT * FROM Post";
										PreparedStatement statement = conn.prepareStatement(sqlinsert);
										ResultSet rs = statement.executeQuery();
										    while (rs.next()) {
												String s = rs.getString("postno") + "\t" + rs.getString("postext") + "\t" + " from " + "\t" + rs.getString("username") + "\n";
												r = r + s;
												space.setText(r);
												space.setEditable(false);

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

    //Choose a post to react or comment on
    public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == choose) {


			Connection conn = null;
					try {
											        Class.forName("org.sqlite.JDBC");
													conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
													String sqlinsert = "SELECT * FROM Post WHERE postno LIKE ?";
													PreparedStatement statement = conn.prepareStatement(sqlinsert);
													statement.setString(1,tfshowchoice.getText());
													ResultSet rs = statement.executeQuery();
													    if (rs.next()) {

															Reaction reaction = new Reaction();
															setVisible(false);
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


		} else if (ae.getSource() == goback) { // redirects to homepage

			Homepage mainpage = new Homepage();
			setVisible(false);

		} else if (ae.getSource() == play) {

            String url = "";
			Connection conn = null;
				try {
					Class.forName("org.sqlite.JDBC");
					conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
					String sqlinsert = "SELECT postext FROM Post WHERE postno LIKE ?";
					PreparedStatement statement = conn.prepareStatement(sqlinsert);
					statement.setString(1,tfshowchoice.getText());
					ResultSet rs = statement.executeQuery();
					if (rs.next()) {

			            url = rs.getString(1);
				    }
			 try {
			     URI uri = new URI(url);
			     Desktop desktop = null;
			     if (Desktop.isDesktopSupported()) {
			         desktop = Desktop.getDesktop();
			     }
			     if (desktop != null)
			        desktop.browse(uri);
			 } catch (IOException ioe) {
			     ioe.printStackTrace();
			 } catch (URISyntaxException use) {
			      use.printStackTrace();
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

	}

}

