import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Messages extends JFrame {

	private Container c;
	private JLabel title;
	private JButton button;
	private JLabel label;
	private JTextField textField;
	private String str;
	//private JButton button_back;


	public Messages() {

		//set the frame
		setVisible(true);
		setTitle("Messages");
		setBounds(320, 120, 1000, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);

		c = getContentPane();
        c.setLayout(null);

		//set a title
        title = new JLabel("Messages");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setSize(500, 50);
		title.setLocation(180, 30);
		c.add(title);

		//set a label
		label = new JLabel("Message to :");
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		label.setSize(500, 30);
		label.setLocation(180, 100);
		c.add(label);

		//set the text field to write the name of the person we want to chat with
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setSize(550, 30);
		textField.setLocation(280, 100);
		c.add(textField);

		//set button go to chat
		button = new JButton("GO");
		c.add(button);
		button.setBackground(new java.awt.Color(27, 38, 67));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.PLAIN, 15));
		button.setSize(550, 30);
		button.setLocation(280, 170);
		button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					str = textField.getText();
					new Chat(str);
					dispose();
				}
			});

       /* connection with the previous class
       button_back = new JButton("GO");
       button_back.setFont(new Font("Arial", Font.PLAIN, 15));
       button.setBackground(new java.awt.Color(27, 38, 67));
	   button.setForeground(Color.WHITE);
	   button_back.setSize(550, 60);
	   button_back.setLocation(200, 350);
	   button_back.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e)
						{
							new className();
							dispose();
						}
					});
        c.add(button_back); */

	}

	public static void main(String[] args) {

		Messages ms = new Messages();
    }
}