package tests;

import static org.junit.Assert.*;


import org.junit.Test;

import code.Board;
import code.Player;

public class PlayerTests {

	@Test
	public void testred() {
		Board b = new Board();
		Player p = new Player(b,"RED");
		b.addPlayer(p);
		int expected = 0;
		int actual = p.getC();
		assertTrue("I expected "+expected+" but I actually got "+actual, expected == actual);
		
	}
	
	@Test
	public void testblue() {
		Board b = new Board();
		Player p = new Player(b,"BLUE");
		b.addPlayer(p);
		int expected = 1;
		int actual = p.getC();
		assertTrue("I expected "+expected+" but I actually got "+actual, expected == actual);
		
	}
	@Test
	public void testgold() {
		Board b = new Board();
		Player p = new Player(b,"GOLD");
		b.addPlayer(p);
		int expected = 2;
		int actual = p.getC();
		assertTrue("I expected "+expected+" but I actually got "+actual, expected == actual);
		
	}
	@Test
	public void testwhite() {
		Board b = new Board();
		Player p = new Player(b,"WHITE");
		b.addPlayer(p);
		int expected = 3;
		int actual = p.getC();
		assertTrue("I expected "+expected+" but I actually got "+actual, expected == actual);
		
	}
	
	
}