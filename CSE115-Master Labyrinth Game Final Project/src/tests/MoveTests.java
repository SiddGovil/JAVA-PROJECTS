package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import code.Board;
import code.Player;
import code.Tile;

public class MoveTests {

	/**
	 * @author Sidd
	 * This tests if the up movement removes the Players from its original tile to a new valid tile.
	 */
	@Test
	public void test00() {
		Board Playerboard = new Board();
		Player p = new Player(Playerboard, "GOLD");
		Playerboard.addPlayer(p);
		Tile eTile = Playerboard.getExtraTile();
		boolean[] extraTileDirection = eTile.getDirs();
		if (!extraTileDirection[2]) {//
			eTile.rotateCW();
		}
		if (!extraTileDirection[2]) {//
			eTile.rotateCW();
		}
		Playerboard.insertExtra(11);//
		Playerboard.insertExtra(11);//
		Playerboard.insertExtra(11);//
		Playerboard.moveUp(p);//
		boolean expected = true;
		boolean actual; 
		Tile expectedTile = Playerboard.getTile(2,1); //
		ArrayList<Player> ePlayers = expectedTile.getPlayers();
		actual = ePlayers.contains(p);
		ArrayList<Player> origSpot = Playerboard.getTile(2,2).getPlayers();
		if (origSpot.contains(p)==true) {fail("The Player did not get removed from the original position.");}
		assertTrue("I believed we were going to get "+expected+", but we really got "+actual+".", actual==expected);
	}
	/**
	 * @author Sidd
	 * This tests if the down movement removes the Players from its original tile to a new valid tile.
	 */
	@Test
	public void test01() {
		Board Playerboard = new Board();
		Player p = new Player(Playerboard, "GOLD");
		Playerboard.addPlayer(p);
		Tile eTile = Playerboard.getExtraTile();
		boolean[] extraTileDirection = eTile.getDirs();
		if (!extraTileDirection[0]) {//
			eTile.rotateCW();
		}
		if (!extraTileDirection[0]) {//
			eTile.rotateCW();
		}
		Playerboard.insertExtra(10);//
		Playerboard.insertExtra(10);//
		Playerboard.insertExtra(10);//
		Playerboard.moveDown(p);//
		boolean expected = true;
		boolean actual; 
		Tile expectedTile = Playerboard.getTile(2,3); //
		ArrayList<Player> ePlayers = expectedTile.getPlayers();
		actual = ePlayers.contains(p);
		ArrayList<Player> origSpot = Playerboard.getTile(2,2).getPlayers();
		if (origSpot.contains(p)==true) {fail("The Player did not get removed from the original position.");}
		assertTrue("I believed we were going to get "+expected+", but we really got "+actual+".", actual==expected);
	}
	/**
	 * @author Sidd
	 * This tests if the right movement removes the Players from its original tile to a new valid tile.
	 */
		@Test
	public void test02() {
		Board Playerboard = new Board();
		Player p = new Player(Playerboard, "GOLD");
		Playerboard.addPlayer(p);
		Tile eTile = Playerboard.getExtraTile();
		boolean[] extraTileDirection = eTile.getDirs();
		if (!extraTileDirection[3]) {//
			eTile.rotateCW();
		}
		if (!extraTileDirection[3]) {//
			eTile.rotateCW();
		}
		Playerboard.insertExtra(1);//
		Playerboard.insertExtra(1);//
		Playerboard.insertExtra(1);//
		Playerboard.moveRight(p);//
		boolean expected = true;
		boolean actual; 
		Tile expectedTile = Playerboard.getTile(3,2); //
		ArrayList<Player> ePlayers = expectedTile.getPlayers();
		actual = ePlayers.contains(p);
		ArrayList<Player> origSpot = Playerboard.getTile(2,2).getPlayers();
		if (origSpot.contains(p)==true) {fail("The Player did not get removed from the original position.");}
		assertTrue("I believed we were going to get "+expected+", but we really got "+actual+".", actual==expected);
	}	
		/**
		 * @author Sidd
		 * This tests if the left movement removes the Players from its original tile to a new valid tile.
		 */	
	@Test
	public void test03() {
		Board Playerboard = new Board();
		Player p = new Player(Playerboard, "GOLD");
		Playerboard.addPlayer(p);
		Tile eTile = Playerboard.getExtraTile();
		boolean[] extraTileDirection = eTile.getDirs();
		if (!extraTileDirection[1]) {//
			eTile.rotateCW();
		}
		if (!extraTileDirection[1]) {//
			eTile.rotateCW();
		}
		Playerboard.insertExtra(0);//
		Playerboard.insertExtra(0);//
		Playerboard.insertExtra(0);//
		Playerboard.moveLeft(p);//
		boolean expected = true;
		boolean actual; 
		Tile expectedTile = Playerboard.getTile(1,2); //
		ArrayList<Player> ePlayers = expectedTile.getPlayers();
		actual = ePlayers.contains(p);
		ArrayList<Player> origSpot = Playerboard.getTile(2,2).getPlayers();
		if (origSpot.contains(p)==true) {fail("The Player did not get removed from the original position.");}
		assertTrue("I believed we were going to get "+expected+", but we really got "+actual+".", actual==expected);
	}
	/**
	 * @author Sidd
	 * This tests if the up movement does not remove the Players from its original tile to a new invalid tile.
	 */
	@Test
	public void test04() {
		Board Playerboard = new Board();
		Player p = new Player(Playerboard, "GOLD");
		Playerboard.addPlayer(p);
		Tile eTile = Playerboard.getExtraTile();
		boolean[] extraTileDirection = eTile.getDirs();
		if (extraTileDirection[2]) {//
			eTile.rotateCW();
		}
		if (extraTileDirection[2]) {//
			eTile.rotateCW();
		}
		if (extraTileDirection[2]) {//
			eTile.rotateCW();
		}
		Playerboard.insertExtra(1);//
		Playerboard.insertExtra(1);//
		Playerboard.insertExtra(1);//
		Playerboard.moveUp(p);//
		boolean expected = false;
		boolean actual; 
		Tile expectedTile = Playerboard.getTile(2,1); //
		ArrayList<Player> ePlayers = expectedTile.getPlayers();
		actual = ePlayers.contains(p);
		ArrayList<Player> origSpot = Playerboard.getTile(2,2).getPlayers();
		if (origSpot.contains(p)==false) {fail("The Player got removed from the original position.");}
		assertTrue("I believed we were going to get "+expected+", but we really got "+actual+".", actual==expected);
	}
	/**
	 * @author Sidd
	 * This tests if the down movement does not remove the Players from its original tile to a new invalid tile.
	 */
	@Test
	public void test05() {
		Board Playerboard = new Board();
		Player p = new Player(Playerboard, "GOLD");
		Playerboard.addPlayer(p);
		Tile eTile = Playerboard.getExtraTile();
		boolean[] extraTileDirection = eTile.getDirs();
		if (extraTileDirection[0]) {//
			eTile.rotateCW();
		}
		if (extraTileDirection[0]) {//
			eTile.rotateCW();
		}
		if (extraTileDirection[0]) {//
			eTile.rotateCW();
		}
		Playerboard.insertExtra(10);//
		Playerboard.insertExtra(10);//
		Playerboard.insertExtra(10);//
		Playerboard.moveDown(p);//
		boolean expected = false;
		boolean actual; 
		Tile expectedTile = Playerboard.getTile(2,3); //
		ArrayList<Player> ePlayers = expectedTile.getPlayers();
		actual = ePlayers.contains(p);
		ArrayList<Player> origSpot = Playerboard.getTile(2,2).getPlayers();
		if (origSpot.contains(p)==false) {fail("The Player got removed from the original position.");}
		assertTrue("I believed we were going to get "+expected+", but we really got "+actual+".", actual==expected);
	}
	/**
	 * @author Sidd
	 * This tests if the right movement does not remove the Players from its original tile to a new invalid tile.
	 */
	@Test
	public void test06() {
		Board Playerboard = new Board();
		Player p = new Player(Playerboard, "GOLD");
		Playerboard.addPlayer(p);
		Tile eTile = Playerboard.getExtraTile();
		boolean[] extraTileDirection = eTile.getDirs();
		if (extraTileDirection[3]) {//
			eTile.rotateCW();
		}
		if (extraTileDirection[3]) {//
			eTile.rotateCW();
		}
		if (extraTileDirection[3]) {//
			eTile.rotateCW();
		}
		Playerboard.insertExtra(1);//
		Playerboard.insertExtra(1);//
		Playerboard.insertExtra(1);//
		Playerboard.moveRight(p);//
		boolean expected = false;
		boolean actual; 
		Tile expectedTile = Playerboard.getTile(3,2); //
		ArrayList<Player> ePlayers = expectedTile.getPlayers();
		actual = ePlayers.contains(p);
		ArrayList<Player> origSpot = Playerboard.getTile(2,2).getPlayers();
		if (origSpot.contains(p)==false) {fail("The Player got removed from the original position.");}
		assertTrue("I believed we were going to get "+expected+", but we really got "+actual+".", actual==expected);
	}
	/**
	 * @author Sidd
	 * This tests if the left movement does not remove the Players from its original tile to a new invalid tile.
	 */
	@Test
	public void test07() {
		Board Playerboard = new Board();
		Player p = new Player(Playerboard, "GOLD");
		Playerboard.addPlayer(p);
		Tile eTile = Playerboard.getExtraTile();
		boolean[] extraTileDirection = eTile.getDirs();
		if (extraTileDirection[1]) {//
			eTile.rotateCW();
		}
		if (extraTileDirection[1]) {//
			eTile.rotateCW();
		}
		if (extraTileDirection[1]) {//
			eTile.rotateCW();
		}
		Playerboard.insertExtra(0);//
		Playerboard.insertExtra(0);//
		Playerboard.insertExtra(0);//
		Playerboard.moveLeft(p);//
		boolean expected = false;
		boolean actual; 
		Tile expectedTile = Playerboard.getTile(1,2); //
		ArrayList<Player> ePlayers = expectedTile.getPlayers();
		actual = ePlayers.contains(p);
		ArrayList<Player> origSpot = Playerboard.getTile(2,2).getPlayers();
		if (origSpot.contains(p)==false) {fail("The Player got removed from the original position.");}
		assertTrue("I believed we were going to get "+expected+", but we really got "+actual+".", actual==expected);
	}

}
