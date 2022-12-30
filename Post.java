//import required classes and packages
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.io.FileWriter;
import java.sql.*;

public class Post extends JFrame implements ActionListener{

    // Components of the Post window
	private JFrame postframe;
	private JLabel postlabel;
	protected static JTextField text;
	private Font font;
	private JButton submitbutton;
	private Container cp;

    // constructor, to structure Post window
	public  Post () {

         setVisible(true);

		 setTitle("InTune");

		 setBounds(320, 120, 1000, 750);

		 setDefaultCloseOperation(EXIT_ON_CLOSE);

         setResizable(true);

		 cp = getContentPane();

		 cp.setLayout(new FlowLayout());

		 postlabel = new JLabel("Post");

 		 cp.add(postlabel);

		 text = new JTextField (50);

		 cp.add(text);

		 font = new Font("Calibri",Font.BOLD,20);

		 text.setFont(font);

		 submitbutton = new JButton("Submit");
		 submitbutton.addActionListener(this);

		 cp.add(submitbutton);

		 }

         //submits Post
		 public void actionPerformed(ActionEvent ae) {

             if (ae.getSource() == submitbutton) {

				 Connection conn = null;

				 String posttext = text.getText();
				 try {
				     Class.forName("org.sqlite.JDBC");
				 	 conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
				 	 String sqlinsert = "INSERT INTO Post (postext,username) VALUES(?,?)";
				 	 PreparedStatement statement = conn.prepareStatement(sqlinsert);
				 	 statement.setString(1, posttext);
				 	 statement.setString(2, Entrancepage.tfusername.getText());

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

                   Homepage mainpage = new Homepage();
                   setVisible(false);

	         }
     }

}