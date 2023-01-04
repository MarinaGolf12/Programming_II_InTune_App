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
	private JFrame frame;
	private JLabel postlabel;
	protected static JTextField text;
	private JButton submitbutton;
	private Container cp;
	private JButton goback;

    // constructor, to structure Post window
	public  Post () {

		 frame = new JFrame();
		 frame.setTitle("InTune");
		 frame.getContentPane().setBackground(new java.awt.Color(232, 237, 244));
		 frame.setBounds(320, 120, 1000, 750);
		 frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
         frame.setResizable(true);
		 cp = frame.getContentPane();
		 cp.setLayout(null);

		 postlabel = new JLabel("Post");
		 postlabel.setFont(new Font("Arial", Font.BOLD, 30));
		 postlabel.setForeground(new java.awt.Color(27, 38, 67));
		 postlabel.setSize(300, 50);
         postlabel.setLocation(130, 40);
 		 cp.add(postlabel);

		 text = new JTextField (50);
		 text.setFont(new Font("Arial",Font.BOLD,20));
		 text.setSize(400, 40);
		 text.setLocation(130, 110);
		 cp.add(text);

		 submitbutton = new JButton("Share");
		 submitbutton.setBackground(new java.awt.Color(27, 38, 67));
		 submitbutton.setForeground(Color.WHITE);
		 submitbutton.setFont(new Font("Arial", Font.BOLD, 15));
		 submitbutton.setSize(240, 35);
		 submitbutton.setLocation(130, 190);
		 submitbutton.addActionListener(this);
         cp.add(submitbutton);

         goback = new JButton("Go Back");
		 goback.setFont(new Font("Arial", Font.BOLD, 15));
		 goback.setBackground(new java.awt.Color(27, 38, 67));
		 goback.setForeground(Color.WHITE);
		 goback.setSize(240, 35);
		 goback.setLocation(130, 245);
		 goback.addActionListener(this);
         cp.add(goback);

		 frame.setVisible(true);

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

                   JOptionPane.showMessageDialog(null,"Post is online!");
                   Homepage mainpage = new Homepage();
                   frame.setVisible(false);

	         } else if (ae.getSource() == goback) {
			 	frame.setVisible(false);
			 	Homepage p = new Homepage();
		     }
  }

}