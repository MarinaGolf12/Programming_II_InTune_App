package application;

//import required classes and packages

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**Declare the class React.*/
class React extends JFrame implements ActionListener {

    // Components of the React window

	private Container crr;
	private JLabel react;
	private ButtonGroup bg;
	private JRadioButton r1;
    private JRadioButton r2;
    private JRadioButton r3;
    private JRadioButton r4;
    private JRadioButton r5;
    private JButton goback;
    private JButton sub;
    private JTextArea ta;
    private JFrame frame;
    private static final long serialVersionUID = 7526472295622776147L;

    /**constructor, to structure React window.*/

    public React() {

		frame = new JFrame();
		frame.setTitle("InTune");
		frame.getContentPane().setBackground(new java.awt.Color(232, 237, 244));
		frame.setBounds(320, 120, 1000, 750);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(true);
		crr = frame.getContentPane();
		crr.setLayout(null);

		react = new JLabel("React");
		react.setFont(new Font("Arial", Font.BOLD, 30));
		react.setForeground(new java.awt.Color(27, 38, 67));
		react.setSize(300, 50);
        react.setLocation(130, 30);
		crr.add(react);

		bg = new ButtonGroup();

		r1 = new JRadioButton("My favourite");
		r1.setFont(new Font("Arial", Font.PLAIN, 15));
		r1.setSelected(true);
		r1.setSize(105, 20);
        r1.setLocation(130, 130);
		crr.add(r1);
		bg.add(r1);

		r2 = new JRadioButton("Like");
		r2.setFont(new Font("Arial", Font.PLAIN, 15));
		r2.setSelected(true);
		r2.setSize(75, 20);
        r2.setLocation(130, 190);
		crr.add(r2);
		bg.add(r2);

		r3 = new JRadioButton("Catchy");
		r3.setFont(new Font("Arial", Font.PLAIN, 15));
		r3.setSelected(true);
		r3.setSize(100, 20);
        r3.setLocation(130, 250);
		crr.add(r3);
		bg.add(r3);

		r4 = new JRadioButton("Sound Off");
		r4.setFont(new Font("Arial", Font.PLAIN, 15));
		r4.setSelected(true);
		r4.setSize(100, 20);
        r4.setLocation(130, 310);
		crr.add(r4);
		bg.add(r4);

		r5 = new JRadioButton("Earache");
		r5.setFont(new Font("Arial", Font.PLAIN, 15));
		r5.setSelected(true);
		r5.setSize(100, 20);
        r5.setLocation(130, 370);
		crr.add(r5);
		bg.add(r5);

        goback = new JButton("Go Back");
        goback.setBackground(new java.awt.Color(27, 38, 67));
        goback.setForeground(Color.WHITE);
		goback.setFont(new Font("Arial", Font.BOLD, 15));
		goback.setSize(240, 35);
		goback.setLocation(500, 150);
        goback.addActionListener(this);
        crr.add(goback);

        sub = new JButton("Submit Reaction");
        sub.setBackground(new java.awt.Color(27, 38, 67));
		sub.setForeground(Color.WHITE);
		sub.addActionListener(this);
		sub.setFont(new Font("Arial", Font.BOLD, 15));
		sub.setSize(240, 35);
		sub.setLocation(500, 100);
        crr.add(sub);

        ta = new JTextArea();
		ta.setFont(new Font("Arial", Font.PLAIN, 15));
		ta.setSize(240, 200);
		ta.setLocation(500, 200);
		ta.setLineWrap(true);
		ta.setEditable(false);
        crr.add(ta);

        frame.setVisible(true);

    }

    /**show reactions to a post.*/

    public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == sub) {

			if (r1.isSelected()) {

			    newPost(1);
		    } else if (r2.isSelected()) {

			    newPost(2);

		    } else if (r3.isSelected()) {

			    newPost(3);

		    } else if (r4.isSelected()) {

			    newPost(4);

		    } else if (r5.isSelected()) {

			    newPost(5);

			}


            JOptionPane.showMessageDialog(null, "Reaction sent!");
		}
		if (ae.getSource() == goback) {

			Reaction reaction = new Reaction();
			frame.setVisible(false);

		}

	}

	int x1 = 0;
	int x2 = 0;
	int x3 = 0;
	int x4 = 0;
	int x5 = 0;

    /**count reactions to a post.*/

	public void newPost(int a) {


	        if (a == 1) {

		        x1 = x1 + 1;

			} else if (a == 2) {

				x2 = x2 + 1;

		    } else if (a == 3) {

				x3 = x3 + 1;

			} else if (a == 4) {

				x4 = x4 + 1;

			} else if (a == 5) {

				x5 = x5 + 1;

			}

			ta.setText(x1 + " My favourite" + "\n" + x2 + " Like" + "\n" + x3 + " Catchy" + "\n" + x4 + " Sound Off" + "\n" + x5 + " Earache");

	    }


}
