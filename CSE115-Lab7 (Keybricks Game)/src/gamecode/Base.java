package gamecode;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Base implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		JFrame jf;
		jf = new JFrame("TypingGame");
		JPanel jp;
		jp = new JPanel();
		jf.setSize(400, 400);
		jp.setLayout(new GridLayout(4,1));
		jf.add(jp);
		jp.addKeyListener(new Press(new Bricks(jp)));
		jp.setFocusable(true);
		jf.setVisible(true);
		
	}
	
		
	}
	


