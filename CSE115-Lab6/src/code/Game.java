package code;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game implements Runnable{

	@Override
	public void run() {
		JFrame jf;
		jf = new JFrame("Sequence Game");
		jf.setVisible(true);
		jf.setSize(450, 300);
		JButton jb;
		jb = new JButton("Start");
		jf.add(jb);
		FlowLayout fl;
		fl = new FlowLayout();
		jf.setLayout(fl);
		Font myFont;
		myFont = new Font("Novelgot", Font.ROMAN_BASELINE,56);
		jb.setFont(myFont);
		jb.setForeground(Color.BLACK);
		jb.setBackground(Color.WHITE);
		JLabel jl;
		jl = new JLabel();
		jl.setText("<HTML><body><H1>Instructions</H1><p>Click the 'start' button to start the game" + 
				"<br>Click as many of the red buttons as you can before time runs out!<p></body></HTML>");
		jf.add(jl);
		jb.addActionListener(new CloseStart(jf));
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		
	}

}
