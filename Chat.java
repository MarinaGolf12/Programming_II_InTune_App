//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Chat extends JFrame implements ActionListener {

	// Components of the Chat window
	private Container c;
	private JTextArea textArea_send;
	private JTextArea textArea_mes;
	private JButton send;
	private JButton button_back;
	private String str;
	private JLabel title;
	private String textto = "";
	private JFrame frame;

	// constructor, to structure Messages window, with an argument that specifies whom the user is messaging
	public Chat(String name) {

        //set the frame
        frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(new java.awt.Color(232, 237, 244));
		frame.setTitle("InTune");
		frame.setBounds(320, 120, 1000, 750);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(true);

		c = frame.getContentPane();
        c.setLayout(null);

		//set as a title the name of the person we want to chat with
        title = new JLabel(name);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setSize(500, 50);
		title.setLocation(200, 30);
		c.add(title);

		//set the area to write a message
        textArea_send = new JTextArea();
		textArea_send.setFont(new Font("Arial", Font.PLAIN, 15));
		textArea_send.setSize(300, 30);
		textArea_send.setLocation(200, 300);
		c.add(textArea_send);

		//set the area the chat is shown
		textArea_mes = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea_mes);
		textArea_mes.setEditable(false);
		textArea_mes.setFont(new Font("Arial", Font.PLAIN, 15));
		textArea_mes.setSize(550, 150);
		textArea_mes.setLocation(200, 100);
		c.add(textArea_mes);

		//set the button to send the message
		send = new JButton("send");
		send.setFont(new Font("Arial", Font.PLAIN, 15));
		send.setBackground(new java.awt.Color(27, 38, 67));
	    send.setForeground(Color.WHITE);
		send.setSize(100, 30);
		send.setLocation(530, 300);
		send.addActionListener(this);
		c.add(send);

		//set the button to go back to the message page
        button_back = new JButton("back");
		button_back.setFont(new Font("Arial", Font.PLAIN, 15));
		button_back.setBackground(new java.awt.Color(27, 38, 67));
		button_back.setForeground(Color.WHITE);
		button_back.setSize(100, 30);
		button_back.setLocation(200, 350);
		button_back.addActionListener(this);
		c.add(button_back);

		textto = name;

	}


	public void actionPerformed(ActionEvent e) {

	    if (e.getSource() == send) { //sends message

			Connection conn = null;

			    try {

			        Class.forName("org.sqlite.JDBC");
				    conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Marina//Desktop//DMST//sophomore year//1st semester//Progr II//CODE//Original Code//INTUNE.db");
					String sqlinsert = "INSERT INTO MESSAGES(textmessage, textfrom, texto, status) VALUES(?,?,?,?)";
					PreparedStatement statement = conn.prepareStatement(sqlinsert);
					statement.setString(1, textArea_send.getText());
					statement.setString(2, Entrancepage.tfusername.getText());
					statement.setString(3, textto);
					statement.setInt(4, 0);

                    statement.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Message sent!");

                    textArea_mes.setText(textArea_send.getText());

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



		} else if (e.getSource() == button_back) { //goes back to messages

            Messages msg = new Messages();
            frame.setVisible(false);

		}

	}

}