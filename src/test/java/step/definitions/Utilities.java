package test.java.step.definitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.Assert;


public class Utilities {
	
	public static String displayOptionDialog(String prompt_message, boolean isPassword) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel(prompt_message);
		JPasswordField pass = new JPasswordField(20);
		JTextField field = new JTextField(20);
		
		panel.add(label);
		if (isPassword == true) {
			panel.add(pass);
		} else {
			panel.add(field);
		}
				
		String user_input = null;
		
		// Returns 0 if user clicks OK. Returns 2 if user clicks CANCEL in the Option Dialog.
		int user_option = JOptionPane.showOptionDialog(null, panel, "Prompt from Automation Script", 
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
		
		if (user_option == 0) {
			if (isPassword == true) {			
				user_input = String.valueOf(pass.getPassword());
			} else {
				user_input = field.getText();
			}			
		} else if (user_option == 2) {
			Assert.fail("User not provided the required input(User Name/Password/Captcha) in the Dialog box. Script Execution Terminated.");
		}
		return user_input;
	}
	
	public static String getPropertyFromConfigFile (String file_name, String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream file_stream = new FileInputStream(file_name);
		prop.load(file_stream);
		return(prop.getProperty(key));
		
	}
	
	public static void main (String[] args) {
		Utilities.displayOptionDialog("Hello", false);
	}
}
