package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.imagesLoad;

public class questionFormModel implements ChangeListener {
	static JFrame f;
	static JSlider b;
	static JLabel l;
	static JButton jb;
	
	private static int valueOfB;
	private static String stan;
	
	
	public static void frame(int start, int end, int interval, String mode) {
		
		stan = mode;
		
		f = new JFrame("Frame");
		if(stan.equals("dark")) {
			int st = start;
			start = end;
			end = st*(-1);
		}
		
		b = new JSlider(start, end, interval);
		l = new JLabel();
		jb = new JButton("Enter");
		
		questionFormModel qm = new questionFormModel();
		JPanel p = new JPanel();
		
		if(stan.equals("dark")) {
			b.setInverted(true);
			f.setTitle("Podaj wartosc -b:");
			l.setText("value of -b:" + b.getValue()*(-1));
		}
		else if(stan.equals("light")){
			
			f.setTitle("Podaj wartosc b:");
			l.setText("value of b:" + b.getValue());
		} 
		
		f.setSize(300, 130);
		f.setIconImage(imagesLoad.icon.getImage());
        f.setResizable(false);
        f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		b.setPaintTrack(true);
		b.setPaintTicks(true);
		b.setPaintLabels(true);
		
		b.setMajorTickSpacing(interval);
		b.setMinorTickSpacing(5);
		
		b.addChangeListener(qm);
		
		jb.setBounds(150, 10, 95, 30);
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(stan.equals("dark")) {
					valueOfB = b.getValue()*(-1);
					linearModel.dark(valueOfB);
					f.dispose();
				}
				else if(stan.equals("light")){
					valueOfB = b.getValue();
					linearModel.light(valueOfB);
					f.dispose();
				}
			}
		});
		
		p.add(jb);
		p.add(b);
		p.add(l);
		
		f.add(p);
	}
	
	public static int getValueOfB() {
		return valueOfB;
	}
	

	@Override
	public void stateChanged(ChangeEvent e) {
		if(stan.equals("dark")) {
			l.setText("value of -b:" + b.getValue()*(-1));
		}else if(stan.equals("light")) {
			l.setText("value of b:" + b.getValue());
		}
	}
}
