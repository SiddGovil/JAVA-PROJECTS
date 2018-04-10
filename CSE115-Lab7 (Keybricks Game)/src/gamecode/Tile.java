package gamecode;

import java.awt.Color;

import javax.swing.JButton;

public class Tile {
	private JButton _jbutton;
	private String _s;
	private Color _c;
	
	public Tile(JButton button, String s, Color c){
		_jbutton = button;
		_s = s;
		_c = c;
	
		
	}
	
	public String getString(){
		return _s;
		
	}
	
	public void changeString(String s){
		_s = s;
		_jbutton.setText(s);
		
		
	}
	
	public void changeColor(Color c) {
		_c = c;
		_jbutton.setBackground(c);
	}

	public Color getColor(){
		return _c;
	}
}
