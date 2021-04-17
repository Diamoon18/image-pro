package model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class questionFormPowModel{
	
	private static double valueOfPow;
	static JFrame f;
	
	public static void frame() {
		f = new JFrame();
		String input = "1";
		input = JOptionPane.showInputDialog( "Value of pow [0,10]:");
		if(input == null || input.isEmpty() || !input.matches("([0-9]*[.])?[0-9]+")) {
			input = "1";
			JOptionPane.showMessageDialog(f,"Error input, default input 1");
		}
		valueOfPow = Double.parseDouble(input);
		if(valueOfPow < 0 || valueOfPow > 10) {
			valueOfPow = 1;
			JOptionPane.showMessageDialog(f,"Error input, default input 1");
		}
		powModel.potega(valueOfPow);
	}
	
	public static void frame_op() {
		f = new JFrame();
		String input = "1";
		input = JOptionPane.showInputDialog( "Value of pow [0,1]:");
		if(input == null || input.isEmpty() || !input.matches("([0-9]*[.])?[0-9]+")) {
			input = "1";
			JOptionPane.showMessageDialog(f,"Error input, default input 1");
		}
		valueOfPow = Double.parseDouble(input);
		if(valueOfPow < 0 || valueOfPow > 1) {
			valueOfPow = 1;
			JOptionPane.showMessageDialog(f,"Error input, default input 1");
		}
	}
	
	public static double getValueOfPow() {
		return valueOfPow;
	}
}
