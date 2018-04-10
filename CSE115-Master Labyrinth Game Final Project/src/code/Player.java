package code;

import java.awt.Point;
import code.Board;
/**
 * 
 * @author Siddhant Govil
 *
 *         Used to create a new player Creates int variables for each color, as
 *         players are created they will be assigned a color top to bottom Keeps
 *         track of the amount of wands, starts each player off with 3 Keeps
 *         track of current points for each player, starts with 0 Also created
 *         an abitrary string for keeping track of current ingredients
 * 
 *
 */

public class Player {

	public static final int RED = 0;
	public static final int BLUE = 1;
	public static final int GOLD = 2;
	public static final int WHITE = 3;

	private int color;

	int wands;
	int points;
	static int numPlayers = 0;

	Board _b;

	
	public Player(Board b, String c) {
		_b = b;
		wands = 3;
		points = 0;
		setC(c);
		//ArrayList<String> ingredients = new ArrayList<String>(); 
		//ingredients.add("Leaf");
		//ingredients.add("Pine Cone");
		//ingredients.add("WHATEVER");
	}

	/**
	 * SetC = Set color, sets the player color to the number we have assigned to
	 * each, red being 0 and so fourth
	 * 
	 */

	private void setC(String c) {
		if (c.equals("RED")) {
			color = RED;
		}
		if (c.equals("BLUE")) {
			color = BLUE;
		}
		if (c.equals("GOLD")) {
			color = GOLD;
		}
		if (c.equals("WHITE")) {
			color = WHITE;
		}

	}

	/**
	 * 
	 * Simply returns the color of the player
	 * 
	 */

	public int getC() {

		return color;

	}

	/**
	 * 
	 * Gets valid movment directions based on the current position of the player
	 * on the board
	 * 
	 * Tells if based on their current poisition, if up, down, left and right
	 * are currently viable options, used the boolean array to tell with the
	 * order of up, right, down and then left
	 * 
	 * the validDirs variable starts out all false, and goes through each
	 * direction, if the direction is valid it is changed to true, if not it
	 * stays false
	 * @return 
	 * 
	 */

	public boolean[] getValidDirections() {

		Point myPos = _b.getPlayerPos(this);

		boolean[] PosDirs = _b.getTile((int)myPos.getX(), (int)myPos.getY()).getDirs();
		boolean[] validDirs = { false, false, false, false };

		if (PosDirs[0]) {
			if (myPos.getY() > 0) {
				if (_b.getTile((int)myPos.getX(), (int)myPos.getY() - 1).getDirs()[3]) {
					validDirs[0] = true;
				}
			}
		}
		if (PosDirs[1]) {
			if (myPos.getY() < 11) {
				if (_b.getTile((int)myPos.getX()+1, (int)myPos.getY()).getDirs()[2]) {
					validDirs[1] = true;
				}
			}
		}
		if (PosDirs[2]) {
			if (myPos.getY() < 11) {
				if (_b.getTile((int)myPos.getX(), (int)myPos.getY() + 1).getDirs()[0]) {
					validDirs[2] = true;
				}
			}
		}
		if (PosDirs[3]) {
			if (myPos.getY() > 0) {
				if (_b.getTile((int)myPos.getX()-1, (int)myPos.getY()).getDirs()[1]) {
					validDirs[3] = true;
				}
			}
		}
		return validDirs;

	}
	/**
	 * @author Siddhant Govil
	 * determine if two players are the same
	 * @param p
	 * @return
	 */
	@Override
	public boolean equals(Object p){
		if(!(p instanceof Player)){
			return false;
		}
		return this.getC() == ((Player)p).getC();
	}
}