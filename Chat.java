import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Chat extends JFrame{

	private Container c;
	private JTextArea textArea_send;
	private JTextArea textArea_mes;
	private JButton button;
	private JButton button_back;
	private String str;
	private JLabel title;

	public Chat(String name) {

        //set the frame
		setVisible(true);
		setTitle("Chat");
		setBounds(320, 120, 1000, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);

		c = getContentPane();
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

		//set the dutton to send the message
		button = new JButton("send");
				button.setFont(new Font("Arial", Font.PLAIN, 15));
				button.setBackground(new java.awt.Color(27, 38, 67));
		        button.setForeground(Color.WHITE);
				button.setSize(100, 30);
				button.setLocation(530, 300);
				button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e)
						{
						str = textArea_send.getText();
						textArea_send.setText("");
						textArea_mes.append(str + "\n");
						textArea_mes.setEditable(false);

						}
					});
        c.add(button);

		//set the dutton to go back to the message page
        button_back = new JButton("back");
				button_back.setFont(new Font("Arial", Font.PLAIN, 15));
				button_back.setBackground(new java.awt.Color(27, 38, 67));
		        button_back.setForeground(Color.WHITE);
				button_back.setSize(100, 30);
				button_back.setLocation(200, 350);
				button_back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					 new Messages();
					 dispose();
					}
				});
        c.add(button_back);

	}
}