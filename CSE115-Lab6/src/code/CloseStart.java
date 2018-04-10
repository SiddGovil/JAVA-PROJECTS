package code;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.border.Border;

public class CloseStart implements ActionListener {
	private JFrame _jf2;
		
	
	public CloseStart(JFrame jf) {
		_jf2 = jf;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// TODO Auto-generated method stub
		_jf2.dispose();
		JFrame jf3;
		jf3 = new JFrame("Sequence Game");
		FlowLayout fl2;
		fl2 = new FlowLayout();
		jf3.setLayout(fl2);
		jf3.setVisible(true);
		jf3.setSize(450,200);
		JButton jb2;
		jb2 = new JButton("A");
		JButton jb3;
		jb3 = new JButton("B");
		JButton jb4;
		jb4 = new JButton("C");
		jf3.add(jb2);
		jf3.add(jb3);
		jf3.add(jb4);
		Font myFont2;
		myFont2 = new Font("Novelgot", Font.ROMAN_BASELINE,48);
		jb2.setFont(myFont2);
		jb3.setFont(myFont2);
		jb4.setFont(myFont2);
		Random r;
		r = new Random();
		int x = r.nextInt(3);
		if (x == 0) {jb2.setBackground(Color.BLUE);jb3.setEnabled(false);jb4.setEnabled(false);}
		else if (x == 1) {jb3.setBackground(Color.BLUE);jb2.setEnabled(false);jb4.setEnabled(false);}
		else if (x == 2) {jb4.setBackground(Color.BLUE);jb2.setEnabled(false);jb3.setEnabled(false);}
		RandomButton rb;
		rb = new RandomButton(jb2, jb3, jb4, 0);
		jb2.addActionListener(rb);
		jb3.addActionListener(rb);
		jb4.addActionListener(rb);
		Timer t;
		t = new Timer(10*1000, null);
		t.start();
		t.addActionListener(new CloseGame(rb));
		
		}
		
	

	}