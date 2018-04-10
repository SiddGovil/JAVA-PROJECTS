package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopChicken implements ActionListener {
	private example1.Chicken _chick;
	public StopChicken(example1.Chicken chick){
		_chick = chick;
	}
	
	public void actionPerformed(ActionEvent e) {
		_chick.stop();
		
	}
	

}
