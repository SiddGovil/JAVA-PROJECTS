package code;

import javax.swing.JButton;

public class Application implements Runnable {

	public Application() {
		// do nothing here
	}
	
	@Override
	public void run() {
		example1.BarnYard by;
		by = new example1.BarnYard();
		JButton button1;
		button1 = new JButton("Add Chicken");
		by.addButton(button1);
		button1.addActionListener(new AddChicken(by));
		
		// do your initialization here
	}


}
