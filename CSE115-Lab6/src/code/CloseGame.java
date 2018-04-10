package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CloseGame implements ActionListener {
private JFrame _jf4;
private RandomButton _rb2;
public CloseGame(RandomButton rb){
	_rb2 = rb;
	
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		_rb2.myMethod();
		
		
	}

}
