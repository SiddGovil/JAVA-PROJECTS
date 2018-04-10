/**
 * 
 */
package tests;
import code.Tile;
import code.Board;
import code.ITile;
import code.LTile;
import code.TTile;
import code.Player;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/**
 * @author Josh
 *
 */
public class TileTests {
	@Test public void tTileConstructorTest() {
		TTile tt = new TTile();
		boolean expected[] = { false, true, true, true };
		boolean actual[] = tt.getDirs();
		assertTrue("The expected value is " + expected + ", but the actual value is " + actual, Arrays.equals(actual, expected));
	}
	
	@Test public void lTileConstructorTest() {
		LTile lt = new LTile();
		boolean expected[] = { true, true, false, false };
		boolean actual[] = lt.getDirs();
		assertTrue("The expected value is " + expected + ", but the actual value is " + actual, Arrays.equals(actual, expected));
	}
	
	@Test public void iTileConstructor() {
		ITile it = new ITile();
		boolean expected[] = { true, false, true, false };
		boolean actual[] = it.getDirs();
		assertTrue("The expected value is " + expected + ", but the actual value is " + actual, Arrays.equals(actual, expected));
	}
	
	@Test public void tTilerotateCWTest() {
		TTile tt = new TTile();
		boolean expected[] = { true, false, true, true };
		tt.rotateCW();
		boolean actual[] = tt.getDirs();
		assertTrue("The expected value is " + expected + ", but the actual value is " + actual, Arrays.equals(actual, expected));
	}
	
	@Test public void lTilerotateCWTest() {
		LTile lt = new LTile();
		boolean expected[] = { false, true, true, false };
		lt.rotateCW();
		boolean actual[] = lt.getDirs();
		assertTrue("The expected value is " + expected + ", but the actual value is " + actual, Arrays.equals(actual, expected));
	}
	
	@Test public void iTilerotateCWTest() {
		ITile it = new ITile();
		boolean expected[] = { false, true, false, true };
		it.rotateCW();
		boolean actual[] = it.getDirs();
		assertTrue("The expected value is " + expected + ", but the actual value is " + actual, Arrays.equals(actual, expected));
	}
	
	@Test public void tTilerotateCCWTest() {
		TTile tt = new TTile();
		boolean expected[] = { true, true, true, false };
		tt.rotateCCW();
		boolean actual[] = tt.getDirs();
		assertTrue("The expected value is " + expected + ", but the actual value is " + actual, Arrays.equals(actual, expected));
	}
	
	@Test public void lTilerotateCCWTest() {
		LTile lt = new LTile();
		boolean expected[] = { true, false, false, true };
		lt.rotateCCW();
		boolean actual[] = lt.getDirs();
		assertTrue("The expected value is " + expected + ", but the actual value is " + actual, Arrays.equals(actual, expected));
	}
	
	@Test public void iTilerotateCCWTest() {
		ITile it = new ITile();
		boolean expected[] = { false, true, false, true };
		it.rotateCCW();
		boolean actual[] = it.getDirs();
		assertTrue("The expected value is " + expected + ", but the actual value is " + actual, Arrays.equals(actual, expected));
	}
	
	@Test public void tTilegetPlayerTest() {
		TTile tt = new TTile();
		Board _b = new Board();
		Player p1 = new Player(_b,"RED");
		Player p2 = new Player(_b,"GOLD");
		ArrayList<Player> expected = new ArrayList<Player>();
		expected.add(p1);
		expected.add(p2);
		tt.addPlayer(expected);
		ArrayList<Player> actual = tt.getPlayers();
		assertTrue("The expected value is " + expected + ", but the actual value is " + actual, expected.equals(actual));
	}
	
	@Test public void lTilegetPlayerTest() {
		LTile lt = new LTile();
		Board _b = new Board();
		Player p1 = new Player(_b,"RED");
		Player p2 = new Player(_b,"GOLD");
		ArrayList<Player> expected = new ArrayList<Player>();
		expected.add(p1);
		expected.add(p2);
		lt.addPlayer(expected);
		ArrayList<Player> actual = lt.getPlayers();
		assertTrue("The expected value is " + expected + ", but the actual value is " + actual, expected.equals(actual));
	}
	
	@Test public void iTilegetPlayerTest() {
		ITile it = new ITile();
		Board _b = new Board();
		Player p1 = new Player(_b,"RED");
		Player p2 = new Player(_b,"GOLD");
		ArrayList<Player> expected = new ArrayList<Player>();
		expected.add(p1);
		expected.add(p2);
		it.addPlayer(expected);
		ArrayList<Player> actual = it.getPlayers();
		assertTrue("The expected value is " + expected + ", but the actual value is " + actual, expected.equals(actual));
	}
	
	@Test public void tTileremovePlayerTest() {
		TTile tt = new TTile();
		Board _b = new Board();
		Player p1 = new Player(_b,"RED");
		ArrayList<Player> expected = new ArrayList<Player>();
		expected.add(p1);
		tt.addPlayer(expected);
		tt.removePlayer(expected);
		expected.remove(p1);
		ArrayList<Player> actual = tt.getPlayers();
		assertTrue("The expected value is " + expected + ", but the actual value is " + actual, expected.equals(actual));
	}
	
	@Test public void lTileremovePlayerTest() {
		LTile lt = new LTile();
		Board _b = new Board();
		Player p1 = new Player(_b,"RED");
		ArrayList<Player> expected = new ArrayList<Player>();
		expected.add(p1);
		lt.addPlayer(expected);
		lt.removePlayer(expected);
		expected.remove(p1);
		ArrayList<Player> actual = lt.getPlayers();
		assertTrue("The expected value is " + expected + ", but the actual value is " + actual, expected.equals(actual));
	}
	
	@Test public void iTileremovePlayerTest() {
		ITile it = new ITile();
		Board _b = new Board();
		Player p1 = new Player(_b,"RED");
		ArrayList<Player> expected = new ArrayList<Player>();
		expected.add(p1);
		it.addPlayer(expected);
		it.removePlayer(expected);
		expected.remove(p1);
		ArrayList<Player> actual = it.getPlayers();
		assertTrue("The expected value is " + expected + ", but the actual value is " + actual, expected.equals(actual));
	}
}