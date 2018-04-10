package gamecode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Press implements KeyListener {
	private Bricks _brick;
public Press(Bricks b){
	_brick = b;
}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		_brick.remove(e.getKeyChar());

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
