package test.java.concepts;

import javax.swing.*;

public class Dialog {
	
	public static void displayInputDialog() {
		String s = (String)JOptionPane.showInputDialog("message");
		System.out.println(s);
	}
	
	public static String displayOptionDialog() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Please enter your Irctc password:");
		JPasswordField pass = new JPasswordField(20);
		
		panel.add(label);
		panel.add(pass);
		
		String password = null;
		
		int s = JOptionPane.showOptionDialog(null, panel, "Prompt", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
		System.out.println(s);
		
		if (s == 0) {
			password = pass.getPassword().toString();			
		}
		return password;
	}
	
	public static void main (String[] args) {
		Dialog.displayInputDialog();
		Dialog.displayOptionDialog();
	}
}
