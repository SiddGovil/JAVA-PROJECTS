/**
 * 
 * 
 * 
 * 
 * 
 */

package tests;

import code.Board;
import code.ITile;
import code.LTile;
import code.Player;
import code.TTile;
import code.Tile;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

public class BoardTests {
	// _b was made so that methods can be called without having the board as an
	// argument every time
	Board _b;

	/**
	 * 
	 * @author Andrew Test the constructor, making sure that everything is set
	 *         up correctly at the start of the game
	 * 
	 * 
	 */
	// Testing that a board is constructed correctly
	/**
	 * 
	 */
	@Test
	public void constructTest() {
		_b = new Board();
		// create an ArrayList of all the movable tiles on the board to test
		// later
		ArrayList<Tile> tmp_AL_tiles = new ArrayList<Tile>();
		// boolean test = true; //Not sure why this line is here--> keeping it
		// just in case
		for (int y = 0; y < 7; y++) {
			for (int x = 0; x < 7; x++) {
				// Only get the non positions where both tiles are not even
				// this way you get only the mobile tiles
				if (x % 2 == 1 || y % 2 == 1) {
					tmp_AL_tiles.add(_b.getTile(x, y));
				}
			}
		}
		// add in the extra tile to the ArrayList in the last position
		tmp_AL_tiles.add(_b.getExtraTile());

		// Count each kind of tile on the board in order to see that the
		// distribution of tile types is correct
		int _L_tile_count = 0;
		int _T_tile_count = 0;
		int _I_tile_count = 0;
		for (Tile t : tmp_AL_tiles) {
			if (!(t instanceof Tile)) {
				// test = false; //Not sure why this line is here--> keeping it
				// just in case
				fail("The positions were not all instances of tiles");
			} else if (t instanceof LTile) {
				_L_tile_count++;
			} else if (t instanceof TTile) {
				_T_tile_count++;
			} else if (t instanceof ITile) {
				_I_tile_count++;
			}
		}
		if (_L_tile_count != 14) {
			fail("LTiles should be: " + 14 + ", but was actually: " + _L_tile_count);
		} else if (_T_tile_count != 7) {
			fail("T tiles should be: " + 7 + ", but was actually: " + _T_tile_count);
		} else if (_I_tile_count != 13) {
			fail("L tiles should be: " + 13 + ", but was actually: " + _L_tile_count);
		}

		// Check that each of the immobile squares are set up correctly
		final boolean F = false;
		final boolean T = true;
		immobileTest(0, 0, new boolean[] { F, T, T, F });
		immobileTest(2, 0, new boolean[] { F, T, T, T });
		immobileTest(4, 0, new boolean[] { F, T, T, T });
		immobileTest(6, 0, new boolean[] { F, F, T, T });

		immobileTest(0, 2, new boolean[] { T, T, T, F });
		immobileTest(2, 2, new boolean[] { T, T, T, F });
		immobileTest(4, 2, new boolean[] { F, T, T, T });
		immobileTest(6, 2, new boolean[] { T, F, T, T });

		immobileTest(0, 4, new boolean[] { T, T, T, F });
		immobileTest(2, 4, new boolean[] { T, T, F, T });
		immobileTest(4, 4, new boolean[] { T, F, T, T });
		immobileTest(6, 4, new boolean[] { T, F, T, T });

		immobileTest(0, 6, new boolean[] { T, T, F, F });
		immobileTest(2, 6, new boolean[] { T, T, F, T });
		immobileTest(4, 6, new boolean[] { T, T, F, T });
		immobileTest(6, 6, new boolean[] { T, F, F, T });
		// no pass method exists, so if it reaches the end of a method, the test
		// is assumed to have passed
	}

	/**
	 * immobileTest determines if the immobile tiles are all set up correctly,
	 * with openings in the right places, and not in the wrong places.
	 * <p>
	 * 
	 * @author Andrew
	 * @param x
	 *            x coordinate of tile testing
	 * @param y
	 *            y coordinate of tile testing
	 * @param correct_dirs
	 *            the directions that should be in that location
	 */
	private void immobileTest(int x, int y, boolean[] correct_dirs) {
		Tile tmp_Tile = _b.getTile(x, y);
		if (tmp_Tile == null) {
			fail("Tile at position (" + x + "," + y + ") is null.");
		}
		boolean[] actual_dirs = tmp_Tile.getDirs();
		if (!(actual_dirs[0] == correct_dirs[0] && actual_dirs[1] == correct_dirs[1]
				&& actual_dirs[2] == correct_dirs[2] && actual_dirs[3] == correct_dirs[3])) {
			fail("static tile at position (" + x + "," + y + ") is incorrect, with directions: " + actual_dirs[0] + ", "
					+ actual_dirs[1] + ", " + actual_dirs[2] + ", " + actual_dirs[3] + " " + ", which should be: "
					+ correct_dirs[0] + ", " + correct_dirs[1] + ", " + correct_dirs[2] + ", " + correct_dirs[3]);
		}

	}

	
	/**
	 * insertTest Ensures that all 12 possible insertion spots are working, and that invalid ones do not work
	 * 
	 * <p>
	 * the spots are numbered from the top row's left most, clockwise.
	 * 
	 * @author Andrew
	 * 
	 * */
	@Test
	public void insertTests() {
		_b = new Board();

		if (_b.insertExtra(-1)) {
			fail("insert -1 should return false");
		}
		if (_b.insertExtra(12)) {
			fail("insert 12 should return false");
		}

		ArrayList<Tile> shiftingList;
		ArrayList<Tile> shiftedList;
		int _cur_const = 0;
		int _mode_testing = 0;

		// The next 6 blocks check that inserting vertically up or down works
		_cur_const = 1;
		_mode_testing = 0;
		shiftingList = new ArrayList<Tile>();
		shiftedList = new ArrayList<Tile>();
		for (int i = 0; i < 7; i++) {
			shiftingList.add(_b.getTile(_cur_const, i));
		}
		shiftingList.add(_b.getExtraTile());
		_b.insertExtra(_mode_testing);
		shiftedList.add(_b.getExtraTile());
		for (int i = 0; i < 7; i++) {
			shiftedList.add(_b.getTile(_cur_const, i));
		}
		for (int i = 0; i < 7; i++) {
			if ((shiftingList.get(i).equals(shiftedList.get(i)))) {
				fail("insertExtra(" + _mode_testing + ") does not work");
			}
		}
		if (shiftedList.get(0).getPlayers().equals( shiftingList.get(6).getPlayers())) {
			fail("The newly inserted tile does not have the same players on it as the tile that left in insertExtra mode: "
					+ _mode_testing );
		}

		_cur_const = 3;
		_mode_testing = 1;
		shiftingList = new ArrayList<Tile>();
		shiftedList = new ArrayList<Tile>();
		for (int i = 0; i < 7; i++) {
			shiftingList.add(_b.getTile(_cur_const, i));
		}
		shiftingList.add(_b.getExtraTile());
		_b.insertExtra(_mode_testing);
		shiftedList.add(_b.getExtraTile());
		for (int i = 0; i < 7; i++) {
			shiftedList.add(_b.getTile(_cur_const, i));
		}
		for (int i = 0; i < 7; i++) {
			if (!(shiftingList.get(i).equals(shiftedList.get(i)))) {
				fail("insertExtra(" + _mode_testing + ") does not work");
			}
		}

		_cur_const = 5;
		_mode_testing = 2;
		shiftingList = new ArrayList<Tile>();
		shiftedList = new ArrayList<Tile>();
		for (int i = 0; i < 7; i++) {
			shiftingList.add(_b.getTile(_cur_const, i));
		}
		shiftingList.add(_b.getExtraTile());
		_b.insertExtra(_mode_testing);
		shiftedList.add(_b.getExtraTile());
		for (int i = 0; i < 7; i++) {
			shiftedList.add(_b.getTile(_cur_const, i));
		}
		for (int i = 0; i < 7; i++) {
			if (!(shiftingList.get(i).equals(shiftedList.get(i)))) {
				fail("insertExtra(" + _mode_testing + ") does not work");
			}
		}
		if (shiftedList.get(6).getPlayers() != shiftingList.get(0).getPlayers()) {
			fail("The newly inserted tile does not have the same players on it as the tile that left in insertExtra mode: "
					+ _mode_testing);
		}

		_cur_const = 5;
		_mode_testing = 6;
		shiftingList = new ArrayList<Tile>();
		shiftedList = new ArrayList<Tile>();
		for (int i = 6; i >= 0; i--) {
			shiftingList.add(_b.getTile(_cur_const, i));
		}
		shiftingList.add(_b.getExtraTile());
		_b.insertExtra(_mode_testing);
		shiftedList.add(_b.getExtraTile());
		for (int i = 6; i >= 0; i--) {
			shiftedList.add(_b.getTile(_cur_const, i));
		}
		for (int i = 0; i < 7; i++) {
			if (!(shiftingList.get(i).equals(shiftedList.get(i)))) {
				fail("insertExtra(" + _mode_testing + ") does not work");
			}
		}
		if (shiftedList.get(6).getPlayers() != shiftingList.get(0).getPlayers()) {
			fail("The newly inserted tile does not have the same players on it as the tile that left in insertExtra mode: "
					+ _mode_testing);
		}

		_cur_const = 3;
		_mode_testing = 7;
		shiftingList = new ArrayList<Tile>();
		shiftedList = new ArrayList<Tile>();
		for (int i = 6; i >= 0; i--) {
			shiftingList.add(_b.getTile(_cur_const, i));
		}
		shiftingList.add(_b.getExtraTile());
		_b.insertExtra(_mode_testing);
		shiftedList.add(_b.getExtraTile());
		for (int i = 6; i >= 0; i--) {
			shiftedList.add(_b.getTile(_cur_const, i));
		}
		for (int i = 0; i < 7; i++) {
			if (!(shiftingList.get(i).equals(shiftedList.get(i)))) {
				fail("insertExtra(" + _mode_testing + ") does not work");
			}
		}
		if (shiftedList.get(6).getPlayers() != shiftingList.get(0).getPlayers()) {
			fail("The newly inserted tile does not have the same players on it as the tile that left in insertExtra mode: "
					+ _mode_testing);
		}

		_cur_const = 1;
		_mode_testing = 8;
		shiftingList = new ArrayList<Tile>();
		shiftedList = new ArrayList<Tile>();
		for (int i = 6; i >= 0; i--) {
			shiftingList.add(_b.getTile(_cur_const, i));
		}
		shiftingList.add(_b.getExtraTile());
		_b.insertExtra(_mode_testing);
		shiftedList.add(_b.getExtraTile());
		for (int i = 6; i >= 0; i--) {
			shiftedList.add(_b.getTile(_cur_const, i));
		}
		for (int i = 0; i < 7; i++) {
			if (!(shiftingList.get(i).equals(shiftedList.get(i)))) {
				fail("insertExtra(" + _mode_testing + ") does not work");
			}
		}
		if (shiftedList.get(6).getPlayers() != shiftingList.get(0).getPlayers()) {
			fail("The newly inserted tile does not have the same players on it as the tile that left in insertExtra mode: "
					+ _mode_testing);
		}

		// The next 6 blocks check that inserting horizontally left or right
		// works
		_cur_const = 5;
		_mode_testing = 9;
		shiftingList = new ArrayList<Tile>();
		shiftedList = new ArrayList<Tile>();
		for (int i = 0; i < 7; i++) {
			shiftingList.add(_b.getTile(i, _cur_const));
		}
		shiftingList.add(_b.getExtraTile());
		_b.insertExtra(_mode_testing);
		shiftedList.add(_b.getExtraTile());
		for (int i = 0; i < 7; i++) {
			shiftedList.add(_b.getTile(i, _cur_const));
		}
		for (int i = 0; i < 7; i++) {
			if (!(shiftingList.get(i).equals(shiftedList.get(i)))) {
				fail("insertExtra(" + _mode_testing + ") does not work");
			}
		}
		if (shiftedList.get(6).getPlayers() != shiftingList.get(0).getPlayers()) {
			fail("The newly inserted tile does not have the same players on it as the tile that left in insertExtra mode: "
					+ _mode_testing);
		}

		_cur_const = 3;
		_mode_testing = 10;
		shiftingList = new ArrayList<Tile>();
		shiftedList = new ArrayList<Tile>();
		for (int i = 0; i < 7; i++) {
			shiftingList.add(_b.getTile(i, _cur_const));
		}
		shiftingList.add(_b.getExtraTile());
		_b.insertExtra(_mode_testing);
		shiftedList.add(_b.getExtraTile());
		for (int i = 0; i < 7; i++) {
			shiftedList.add(_b.getTile(i, _cur_const));
		}
		for (int i = 0; i < 7; i++) {
			if (!(shiftingList.get(i).equals(shiftedList.get(i)))) {
				fail("insertExtra(" + _mode_testing + ") does not work");
			}
		}
		if (shiftedList.get(6).getPlayers() != shiftingList.get(0).getPlayers()) {
			fail("The newly inserted tile does not have the same players on it as the tile that left in insertExtra mode: "
					+ _mode_testing);
		}

		_cur_const = 1;
		_mode_testing = 11;
		shiftingList = new ArrayList<Tile>();
		shiftedList = new ArrayList<Tile>();
		for (int i = 0; i < 7; i++) {
			shiftingList.add(_b.getTile(i, _cur_const));
		}
		shiftingList.add(_b.getExtraTile());
		_b.insertExtra(_mode_testing);
		shiftedList.add(_b.getExtraTile());
		for (int i = 0; i < 7; i++) {
			shiftedList.add(_b.getTile(i, _cur_const));
		}
		for (int i = 0; i < 7; i++) {
			if (!(shiftingList.get(i).equals(shiftedList.get(i)))) {
				fail("insertExtra(" + _mode_testing + ") does not work");
			}
		}

		if (shiftedList.get(6).getPlayers() != shiftingList.get(0).getPlayers()) {
			fail("The newly inserted tile does not have the same players on it as the tile that left in insertExtra mode: "
					+ _mode_testing);
		}

		_cur_const = 1;
		_mode_testing = 3;
		shiftingList = new ArrayList<Tile>();
		shiftedList = new ArrayList<Tile>();
		for (int i = 6; i >= 0; i--) {
			shiftingList.add(_b.getTile(i, _cur_const));
		}
		shiftingList.add(_b.getExtraTile());
		_b.insertExtra(_mode_testing);
		shiftedList.add(_b.getExtraTile());
		for (int i = 6; i >= 0; i--) {
			shiftedList.add(_b.getTile(i, _cur_const));
		}
		for (int i = 0; i < 7; i++) {
			if (!(shiftingList.get(i).equals(shiftedList.get(i)))) {
				fail("insertExtra(" + _mode_testing + ") does not work");
			}
		}
		if (shiftedList.get(6).getPlayers() != shiftingList.get(0).getPlayers()) {
			fail("The newly inserted tile does not have the same players on it as the tile that left in insertExtra mode: "
					+ _mode_testing);
		}

		_cur_const = 3;
		_mode_testing = 4;
		shiftingList = new ArrayList<Tile>();
		shiftedList = new ArrayList<Tile>();
		for (int i = 6; i >= 0; i--) {
			shiftingList.add(_b.getTile(i, _cur_const));
		}
		shiftingList.add(_b.getExtraTile());
		_b.insertExtra(_mode_testing);
		shiftedList.add(_b.getExtraTile());
		for (int i = 6; i >= 0; i--) {
			shiftedList.add(_b.getTile(i, _cur_const));
		}
		for (int i = 0; i < 7; i++) {
			if (!(shiftingList.get(i).equals(shiftedList.get(i)))) {
				fail("insertExtra(" + _mode_testing + ") does not work");
			}
		}
		if (shiftedList.get(6).getPlayers() != shiftingList.get(0).getPlayers()) {
			fail("The newly inserted tile does not have the same players on it as the tile that left in insertExtra mode: "
					+ _mode_testing);
		}

		_cur_const = 5;
		_mode_testing = 5;
		shiftingList = new ArrayList<Tile>();
		shiftedList = new ArrayList<Tile>();
		for (int i = 6; i >= 0; i--) {
			shiftedList.add(_b.getTile(i, _cur_const));
		}
		shiftingList.add(_b.getExtraTile());
		_b.insertExtra(_mode_testing);
		shiftedList.add(_b.getExtraTile());
		for (int i = 6; i >= 0; i--) {
			shiftedList.add(_b.getTile(i, _cur_const));
		}
		for (int i = 0; i < 7; i++) {
			if (!(shiftingList.get(i).equals(shiftedList.get(i)))) {
				fail("insertExtra(" + _mode_testing + ") does not work");
			}
		}
		if (shiftedList.get(6).getPlayers() != shiftingList.get(0).getPlayers()) {
			fail("The newly inserted tile does not have the same players on it as the tile that left in insertExtra mode: "
					+ _mode_testing);
		}

	}
	
	@Test
	public void playerPosTest(){
		Board _b = new Board();
		
		Player P1 = new Player(_b,"RED");
		Player P2 = new Player(_b,"BLUE");
		Player P3 = new Player(_b,"WHITE");
		Player P4 = new Player(_b,"GREEN");
		
		_b.addPlayer(P1);
		_b.addPlayer(P2);
		_b.addPlayer(P3);
		_b.addPlayer(P4);
		System.out.println("Player 1 should be added in position (2,2) initially, but was in (" +(int)_b.getPlayerPos(P1).getX()+","+(int)_b.getPlayerPos(P1).getY()+")");
		System.out.println("Player 2 should be added in position (2,4) initially, but was in (" +(int)_b.getPlayerPos(P2).getX()+","+(int)_b.getPlayerPos(P2).getY()+")");
		System.out.println("Player 3 should be added in position (4,2) initially, but was in (" +(int)_b.getPlayerPos(P3).getX()+","+(int)_b.getPlayerPos(P3).getY()+")");
		System.out.println("Player 3 should be added in position (4,4) initially, but was in (" +(int)_b.getPlayerPos(P3).getX()+","+(int)_b.getPlayerPos(P3).getY()+")");
		System.out.println((int)_b.getPlayerPos(P2).getX() != 2 );
		System.out.println((int)_b.getPlayerPos(P2).getY() != 4 );
		if (( (int)_b.getPlayerPos(P1).getX() != 2 || (int)_b.getPlayerPos(P1).getX() != 2)){
			fail("Player 1 should be added in position (2,2) initially, but was in (" +(int)_b.getPlayerPos(P1).getX()+","+(int)_b.getPlayerPos(P1).getY()+")");
		}
		if (( (int)_b.getPlayerPos(P2).getX() != 2 || (int)_b.getPlayerPos(P2).getX() != 4)){
			fail("Player 2 should be added in position (2,4) initially, but was in (" +(int)_b.getPlayerPos(P2).getX()+","+(int)_b.getPlayerPos(P2).getY()+")");
		}
		if (( (int)_b.getPlayerPos(P3).getX() != 4 || (int)_b.getPlayerPos(P3).getX() != 2)){
			fail("Player 3 should be added in position (4,2) initially, but was in (" +(int)_b.getPlayerPos(P3).getX()+","+(int)_b.getPlayerPos(P3).getY()+")");
		}
		if (( (int)_b.getPlayerPos(P4).getX() != 4 || (int)_b.getPlayerPos(P4).getX() != 4)){
			fail("Player 4 should be added in position (4,4) initially, but was in (" +(int)_b.getPlayerPos(P3).getX()+","+(int)_b.getPlayerPos(P3).getY()+")");
		} 
	}
}
