package code;

import java.util.ArrayList;

/* @author Siddhant Govil * 
 * Description: General interface for the three types of tile
 * that will be used. Each class that implements this interface
 * will define methods as needed.
 * 
 * @param x: x coordinate of tile where player p is to be moved.
 * @param y: y coordinate of tile where player p is to be moved.
 * @param p: specific player object being referenced in accessor
 * and mutator methods involving player object
 * 
 */

public interface Tile {
	
	public boolean[] getDirs();
	
	public void rotateCW();
	
	public void rotateCCW();
	
	public ArrayList<Player> getPlayers();
	
	public ArrayList<Player> addPlayer(ArrayList<Player> p);
	
	public Player addPlayer(Player p);
	
	public ArrayList<Player> removePlayer(ArrayList<Player> p);
	
	public ArrayList<Player> removePlayer();
}
