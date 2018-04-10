package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import example1.Chicken;

public class MoveChicken implements ActionListener {
	private example1.Chicken _chick;
	public MoveChicken(example1.Chicken chick) {
		_chick = chick; }
	
	


	public void actionPerformed(ActionEvent e) {
		_chick.start();
		
		
	}

}
