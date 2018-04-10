package code;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;


public class RandomButton implements ActionListener {
	private JButton _jb2;
	private JButton _jb3;
	private JButton _jb4;
	private int _c;
	
	
		

	public RandomButton(JButton jb2, JButton jb3, JButton jb4, int c) {
		_jb2 = jb2;
		_jb3 = jb3;
		_jb4 = jb4;
		_c = c;
	// TODO Auto-generated constructor stub
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Random r;
		r = new Random();
		int x = r.nextInt(3);
		if (x == 0) {_jb2.setBackground(Color.BLUE);_jb3.setBackground(null);_jb4.setBackground(null);_jb3.setEnabled(false);_jb4.setEnabled(false);_jb2.setEnabled(true);}
		else if (x == 1) {_jb3.setBackground(Color.BLUE);_jb2.setBackground(null);_jb4.setBackground(null);_jb2.setEnabled(false);_jb4.setEnabled(false);_jb3.setEnabled(true);}
		else if (x == 2) {_jb4.setBackground(Color.BLUE);_jb2.setBackground(null);_jb3.setBackground(null);_jb2.setEnabled(false);_jb3.setEnabled(false);_jb4.setEnabled(true);}
		_c = _c+1;
		
		
	
	
	
	}
	public void myMethod() {
		System.out.println("You've managed "+_c+" clicks");
		System.exit(0);
		
		// TODO Auto-generated method stub
		
	}
	
	
	

}
