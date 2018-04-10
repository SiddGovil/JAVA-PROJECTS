package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AddChicken implements ActionListener {
	private example1.BarnYard _by;
	public AddChicken(example1.BarnYard by) {
		_by = by;
	
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		example1.Chicken chick;
		chick = new example1.Chicken();
		_by.addChicken(chick);
		JButton button2;
		button2 = new JButton("Start");
		_by.addButton(button2);
		button2.addActionListener(new MoveChicken(chick));
		JButton button3;
		button3 = new JButton("Stop");
		_by.addButton(button3);
		button3.addActionListener(new StopChicken(chick));
		
		
		
	}

}
