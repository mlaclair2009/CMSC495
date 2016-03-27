import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/* Team LOG
 * CMSC 495
 * Sample Login
 */

public class Login extends JFrame {
	private static final long serialVersionUID = 12345;
	JTextArea textArea = new JTextArea ();
	HashMap <String, String> hm = new HashMap <String, String>();
	boolean login = false;
    
    
    public Login () throws IOException { 
    	hm.put("admin", "1234");
        
        //Create text scroll pane;
        JScrollPane scrollPaneText = new JScrollPane (textArea);
        scrollPaneText.setMinimumSize(new Dimension(600,300));
        
        //Create buttons
        JButton loginButton = new JButton ("Login");
        JLabel user = new JLabel("Username");
        JTextField username = new JTextField (15);
        JLabel pass = new JLabel("Password");
        JTextField password = new JTextField (15);
        
        //Create panel/add buttons to panels
        JPanel panel1 = new JPanel ();
        panel1.add(user);
        panel1.add (username);
        panel1.add(pass);
        panel1.add (password);
        panel1.add (loginButton);
        add (panel1, BorderLayout.PAGE_START);
        add (textArea, BorderLayout.CENTER);
        
    	//Create GUI
        setTitle ("Welcome to LOG");
        setSize (800, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        validate ();
        
        //Add listeners to buttons
        loginButton.addActionListener ( new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                	verifyLogin (username.getText(), password.getText());
            }
        });
    }//End GUI constructor
    
    //Login verification
    protected void verifyLogin(String user, String pass) {
		if (hm.containsKey(user) && hm.get(user).equals(pass)){;
			login = true;
			textArea.setText("Welcome to LOG! Please select an option.");
			//Add menu option buttons based on credentials of user, etc...
		}
		else {
			textArea.setText("Incorrect username/password combination");
		}
	}
	public static void main(String[] args) throws IOException {
        Login run = new Login ();
        run.textArea.append("Welcome to LOG. \nPlease begin by logging in above.");
    }
}
