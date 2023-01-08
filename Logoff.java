//Import classes from Java APIs
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Dimension;

//Declare the class LogOff
public class Logoff {
    //This is the body of the class

    //Declare the exit method
    public Logoff() {
        //Body of the method


        //Display a Dialog Box
        JPanel dialBox = new JPanel();
        dialBox.setSize(new Dimension(300, 100));
        dialBox.setLayout(null);

        //Display a message(text) on the Dialog Box
        JLabel msg1 = new JLabel("Do you want to exit from InTune?");
        msg1.setVerticalAlignment(SwingConstants.BOTTOM);
        msg1.setBounds(20,20,350,50);
        msg1.setHorizontalAlignment(SwingConstants.CENTER);
        dialBox.add(msg1);



        //Title available options of the Dialog Box
	UIManager.put("OptionPane.minimumSize", new Dimension(500, 250));
	int response = JOptionPane.showConfirmDialog(null, dialBox, "Logout From InTune App?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        //Consider the case where the choice is yes
	if (response == JOptionPane.YES_OPTION) {

            //Display a new Panel
            JPanel confBox = new JPanel();
	    confBox.setSize(new Dimension(300,100));
	    confBox.setLayout(null);

            //Display an informational message to the user
	    JLabel msg2 = new JLabel("You are successfully logged off. Press OK to continue!");
	    msg2.setVerticalAlignment(SwingConstants.BOTTOM);
	    msg2.setBounds(20,20,425,50);
	    msg2.setHorizontalAlignment(SwingConstants.CENTER);
	    confBox.add(msg2);

            //Title and available options of the Panel
	    UIManager.put("OptionPane.minimumSize", new Dimension(500, 250));
	    int resp = JOptionPane.showConfirmDialog(null, confBox, "Logout Successful", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

	    System.out.println();

        } else {

			Homepage hp = new Homepage();

		}



    }//End of exit method
   
}//End of class LogOff
