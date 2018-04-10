package gamecode;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Bricks {
	private JPanel _jp;
	private ArrayList<Color> _colors;
	private ArrayList<String> _letters;
	private ArrayList<Tile> _tilelist;
	private int counter = 0;
	
	public Bricks(JPanel jp){
		_colors = new ArrayList<Color>();
		_tilelist = new ArrayList<Tile>();
		_jp = jp;
		_letters = new ArrayList<String>();
		for (char c = 97; c <= 122; c++){
		_letters.add("" + c);
		
		}
			
		_colors.add(Color.RED);
		_colors.add(Color.CYAN);
		_colors.add(Color.GREEN);
		_colors.add(Color.YELLOW);
		
		int i;
		for (i = 0; i < 16; i++) {
			Random s = new Random();
			int z = s.nextInt(4);
			
			JButton B;
			B = new JButton("");
			B.setBackground(_colors.get(z));
			Tile T;
			T = new Tile(B, "", _colors.get(z));
			_tilelist.add(T);
			_jp.add(B);	
		
		}
		for (i = 0; i < 4; i++) {
			Random r = new Random();
		int x = r.nextInt(_letters.size());
		int y = r.nextInt(_tilelist.size());
		
		if (_tilelist.get(y).getString().equals("")) {
			_tilelist.get(y).changeString(_letters.get(x));
		_letters.remove(x);
		}
		else {i = i - 1;}
		}
		
	}
	
	public void remove(char c){
		for (int x = 0; x < 16; x = x +1){
			if (_tilelist.get(x).getString().equals("" + c)){
				_tilelist.get(x).changeString("");
				_tilelist.get(x).changeColor(Color.BLACK);
			for ( int i = 0; i < 1; i++){
				Random r = new Random();
				int w = r.nextInt(_letters.size());
				int y = r.nextInt(_tilelist.size());
				
				if (_tilelist.get(y).getString().equals("") && _tilelist.get(y).getColor() != Color.BLACK) {
					_tilelist.get(y).changeString(_letters.get(w));
					counter++;
				_letters.remove(w);
				}
				else {i = i - 1;}
				}
			
				swap(x);
				
				
			}
		}
		
	}
	
	public void swap(int x){
		for (int y = x; y > x % 4; y = y - 4){
			String temp;
			temp = _tilelist.get(y).getString();
			_tilelist.get(y).changeString(_tilelist.get(y-4).getString());
			_tilelist.get(y).changeColor(_tilelist.get(y-4).getColor());
			_tilelist.get(y-4).changeColor(Color.BLACK);
			_tilelist.get(y-4).changeString(temp);
		}
		closegame();
	}
	
	public void closegame(){
		if (_tilelist.get(12).getColor() == Color.BLACK && _tilelist.get(13).getColor() 
				== Color.BLACK && _tilelist.get(14).getColor() 
				== Color.BLACK && _tilelist.get(15).getColor() 
				== Color.BLACK){System.exit(0);}
	}
}


