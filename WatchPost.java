package application;

//import required classes and packages
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**Declare the class WatchPost.*/
class WatchPost extends JFrame implements ActionListener {

    //Components of the WatchPost window
	private Container cw;
	private JTextArea space;
	private JButton choose;
	private JButton goback;
	private JTextField tfshowchoice;
	private JButton play;
	private JFrame frame;
	private JLabel watchpost;
	private static final long serialVersionUID = 7526472295622776147L;

    /**constructor, to structure WatchPost window.*/
    public WatchPost() {

		frame = new JFrame();
	    frame.setTitle("InTune");
	    frame.getContentPane().setBackground(new java.awt.
	    		Color(232, 237, 244));
	    frame.setBounds(320, 120, 1000, 750);
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    frame.setResizable(true);

	    cw = frame.getContentPane();
		cw.setLayout(null);

		watchpost = new JLabel("Watch Post");
		watchpost.setFont(new Font("Arial", Font.BOLD, 30));
		watchpost.setForeground(new java.awt.Color(27, 38, 67));
		watchpost.setSize(300, 50);
	    watchpost.setLocation(110, 40);
 		cw.add(watchpost);

		space = new JTextArea();
		space.setText("");
		space.setFont(new Font("Arial", Font.PLAIN, 15));
		space.setSize(500, 400);
		space.setLocation(410, 130);
		space.setLineWrap(true);
		space.setEditable(false);
        cw.add(space);

        choose = new JButton("Choose a post to react to!");
        choose.setFont(new Font("Arial", Font.BOLD, 15));
        choose.setBackground(new java.awt.Color(27, 38, 67));
		choose.setForeground(Color.WHITE);
		choose.setSize(240, 35);
		choose.setLocation(110, 190);
        choose.addActionListener(this);
        cw.add(choose);

        goback = new JButton("Go Back");
        goback.setBackground(new java.awt.Color(27, 38, 67));
		goback.setForeground(Color.WHITE);
		goback.setFont(new Font("Arial", Font.BOLD, 15));
		goback.setSize(240, 35);
		goback.setLocation(110, 300);
        goback.addActionListener(this);
        cw.add(goback);

		tfshowchoice = new JTextField(30);
		tfshowchoice.setFont(new Font("Arial", Font.PLAIN, 15));
		tfshowchoice.setSize(240, 35);
		tfshowchoice.setLocation(110, 130);
		cw.add(tfshowchoice);

		play = new JButton("Play a post");
		play.setFont(new Font("Arial", Font.BOLD, 15));
		play.setBackground(new java.awt.Color(27, 38, 67));
		play.setForeground(Color.WHITE);
		play.setSize(240, 35);
		play.setLocation(110, 245);
		play.addActionListener(this);
        cw.add(play);

        frame.setVisible(true);

        //Show all Posts
		Connection conn = null;
		String r = "";
		try {
			
		    Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:"
					+ "C:\\Users\\30698\\OneDrive"
					+ "\\Υπολογιστής\\SQLite"
					+ "\\sqlite-tools-"
					+ "win32-x86-3400100"
					+ "\\sqlite-tools"
					+ "-win32-x86-"
					+ "3400100\\INTUNE1.db");
			String sqlinsert = "SELECT * FROM Post";
			PreparedStatement statement = conn.
					prepareStatement(sqlinsert);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
			    String s = rs.getString("postno") 
			    		+ "\t" + rs.getString("postext") 
			    		+ "\t" + " from " + "\t" 
			    		+ rs.getString("username") + "\n";
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

    /**Choose a post to react or comment on.*/
    public void actionPerformed(ActionEvent ae) {

	    if (ae.getSource() == choose) {


		    Connection conn = null;
			try {
			    Class.forName("org.sqlite.JDBC");
			    conn = DriverManager.getConnection("jdbc:sqlite:C:"
			    		+ "\\Users\\30698\\OneDrive"
			    		+ "\\Υπολογιστής"
			    		+ "\\SQLite"
			    		+ "\\sqlite-tools-win32-x86-3400100"
			    		+ "\\sqlite-tools-win32-x86-3400100"
			    		+ "\\INTUNE1.db");
			    String sqlinsert = "SELECT * "
			    		+ "FROM Post "
			    		+ "WHERE postno LIKE ?";
			    PreparedStatement statement = conn.
			    		prepareStatement(sqlinsert);
			    statement.setString(1, tfshowchoice.getText());
			    ResultSet rs = statement.executeQuery();
			    if (rs.next()) {

			        Reaction reaction = new Reaction();
				    frame.setVisible(false);
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


		} else if (ae.getSource() == goback) {

			//redirects to homepage

			Homepage mainpage = new Homepage();
			frame.setVisible(false);

		} else if (ae.getSource() == play) {

            String url = "";
			Connection conn = null;
			try {
			    Class.forName("org.sqlite.JDBC");
				conn = DriverManager.
						getConnection("jdbc:sqlite:C:"
						+ "\\Users\\30698\\OneDrive"
						+ "\\Υπολογιστής"
						+ "\\SQLite"
						+ "\\sqlite-tools-"
						+ "win32-x86-3400100"
						+ "\\sqlite-"
						+ "tools-win32-x86-3400100"
						+ "\\INTUNE1.db");
				String sqlinsert = "SELECT postext "
						+ "FROM Post "
						+ "WHERE postno LIKE ?";
				PreparedStatement statement = conn.
						prepareStatement(sqlinsert);
				statement.setString(1, tfshowchoice.getText());
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
			         if (desktop != null) {
			             desktop.browse(uri);
			         }
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
		