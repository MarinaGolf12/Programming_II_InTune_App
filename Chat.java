import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
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

public class Chat extends JFrame implements ActionListener {

	/**Components of the Chat window*/
	private Container c;
	private JTextArea textAreaSend;
	private JTextArea textAreaMes;
	private JButton send;
	private JButton buttonBack;
	private String str;
	private JLabel title;
	private String textto = "";
	private JFrame frame;
	private static final long serialVersionUID = 7526472295622776147L;

	/**constructor, to structure Messages window,
	*with an argument that specifies whom the user is messaging*/
	public Chat(String name) {

        /**set the frame*/
        frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(new java.awt.Color(232, 237, 244));
		frame.setTitle("InTune");
		frame.setBounds(320, 120, 1000, 750);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(true);

		c = frame.getContentPane();
        c.setLayout(null);

		/**set as a title the name of the person we want to chat with*/
        title = new JLabel(name);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setSize(500, 50);
		title.setLocation(200, 30);
		c.add(title);

		/**set the area to write a message*/
        textAreaSend = new JTextArea();
		textAreaSend.setFont(new Font("Arial", Font.PLAIN, 15));
		textAreaSend.setSize(300, 30);
		textAreaSend.setLocation(200, 300);
		c.add(textAreaSend);

		/**set the area the chat is shown*/
		textAreaMes = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textAreaMes);
		textAreaMes.setEditable(false);
		textAreaMes.setFont(new Font("Arial", Font.PLAIN, 15));
		textAreaMes.setSize(550, 150);
		textAreaMes.setLocation(200, 100);
		c.add(textAreaMes);

		/**set the button to send the message*/
		send = new JButton("send");
		send.setFont(new Font("Arial", Font.PLAIN, 15));
		send.setBackground(new java.awt.Color(27, 38, 67));
	    send.setForeground(Color.WHITE);
		send.setSize(100, 30);
		send.setLocation(530, 300);
		send.addActionListener(this);
		c.add(send);

		/**set the button to go back to the message page*/
        buttonBack = new JButton("back");
		buttonBack.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonBack.setBackground(new java.awt.Color(27, 38, 67));
		buttonBack.setForeground(Color.WHITE);
		buttonBack.setSize(100, 30);
		buttonBack.setLocation(200, 350);
		buttonBack.addActionListener(this);
		c.add(buttonBack);

		textto = name;

	}


	public void actionPerformed(ActionEvent e) {

	    if (e.getSource() == send) {

			/**sends message*/

			Connection conn = null;

			    try {

			        Class.forName("org.sqlite.JDBC");
				    conn = DriverManager.getConnection("jdbc:sqlite:C://Users//30697//Documents//INTUNE FINAL//INTUNE.db");
					String sqlinsert = "INSERT INTO MESSAGES(textmessage, textfrom, texto, status) VALUES(?,?,?,?)";
					PreparedStatement statement = conn.prepareStatement(sqlinsert);
					statement.setString(1, textAreaSend.getText());
					statement.setString(2, Entrancepage.tfusername.getText());
					statement.setString(3, textto);
					statement.setInt(4, 0);

                    statement.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Message sent!");

                    textAreaMes.setText(textAreaSend.getText());

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



		} else if (e.getSource() == buttonBack) {

			/**goes back to messages*/

            Messages msg = new Messages();
            frame.setVisible(false);

		}

	}

}

