//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

    // constructor, to structure React window
    public React() {

		setVisible(true);
		setTitle("InTune");
		setBounds(320, 120, 1000, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		crr = getContentPane();
		crr.setLayout(new FlowLayout());

		react = new JLabel("React to this post!");
		crr.add(react);

		bg = new ButtonGroup();

		r1 = new JRadioButton("My favourite");
		r1.setFont(new Font("Arial", Font.PLAIN, 15));
		r1.setSelected(true);
		r1.setSize(75, 20);
        r1.setLocation(200, 300);
		crr.add(r1);
		bg.add(r1);

		r2 = new JRadioButton("Like");
		r2.setFont(new Font("Arial", Font.PLAIN, 15));
		r2.setSelected(true);
		r2.setSize(75, 20);
        r2.setLocation(210, 300);
		crr.add(r2);
		bg.add(r2);

		r3 = new JRadioButton("Catchy");
		r3.setFont(new Font("Arial", Font.PLAIN, 15));
		r3.setSelected(true);
		r3.setSize(75, 20);
        r3.setLocation(220, 300);
		crr.add(r3);
		bg.add(r3);

		r4 = new JRadioButton("Sound Off");
		r4.setFont(new Font("Arial", Font.PLAIN, 15));
		r4.setSelected(true);
		r4.setSize(75, 20);
        r4.setLocation(230, 300);
		crr.add(r4);
		bg.add(r4);

		r5 = new JRadioButton("Earache");
		r5.setFont(new Font("Arial", Font.PLAIN, 15));
		r5.setSelected(true);
		r5.setSize(75, 20);
        r5.setLocation(240, 300);
		crr.add(r5);
		bg.add(r5);

        goback = new JButton("Back to reacting!!");
        goback.setFont(new Font("Arial", Font.PLAIN, 15));
		goback.setSelected(true);
		goback.setSize(75, 20);
        goback.setLocation(250, 300);
        goback.addActionListener(this);
        crr.add(goback);

        sub = new JButton("Submit Reaction");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
		sub.setSelected(true);
		sub.setSize(75, 20);
        sub.setLocation(260, 300);
		sub.addActionListener(this);
        crr.add(sub);

        ta = new JTextArea();
		ta.setFont(new Font("Arial", Font.PLAIN, 15));
		ta.setSize(300, 400);
		ta.setLocation(500, 500);
		ta.setLineWrap(true);
		ta.setEditable(false);
        crr.add(ta);

    }

    //show reactions to a post
    public void actionPerformed(ActionEvent ae) {

		if(ae.getSource() == sub) {

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



		}
		if (ae.getSource() == goback) {

			Reaction reaction = new Reaction();
			setVisible(false);

		}

	}

	int x1 = 0;
	int x2 = 0;
	int x3 = 0;
	int x4 = 0;
	int x5 = 0;

    //count reactions to a post
	public void newPost( int a) {


	        if (a == 1){

		        x1 = x1 + 1;

			} else if (a == 2) {

				x2= x2 + 1;

		    }else if (a == 3) {

				x3= x3 + 1;

			}else if (a == 4) {

				x4= x4 + 1;

			}else if (a == 5) {

				x5= x5 + 1;

			}

			ta.setText(x1 +" My favourite" + "\n" + x2 + " Like" + "\n" + x3 + " Catchy" + "\n" + x4 + " Sound Off" + "\n" + x5 + " Earache");

	    }


}

