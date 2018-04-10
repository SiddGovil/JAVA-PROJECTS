/**
 * 
 */
package code;

import code.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.awt.Point;

/**
 * @author Siddhant Govil
 *
 */
public class Board {

	private HashMap<Point, Tile> _model;
	private Tile _extraTile;
	private static final int NUM_I = 13;
	private static final int NUM_T = 7;
	private static final int NUM_L = 14;
	int _numPlayers;

	/**
	 * @author Siddhant Govil	 * 	Constructor, for now defaults to a 0 player game with no
	 *  treasures
	 */
	public Board() {
		_numPlayers = 0;
		createDynamicTiles();
		// Tedious TEDIOUS process of putting in all of the static tiles
		createStaticTiles();

	}

	/**
	 * @author Siddhant Govil 
	 * 	Accessor for the tile at the coordinates x, y which is numbered from the top left (0,0) to the bottom right (6,6)
	 * <p> returns null when the position DNE or the tile is not assigned yet
	 * @param d horizontal component of location of tile accessing
	 * @param e vertical component of location of tile accessing.
	 */
	public Tile getTile(int d, int e) {
		return _model.get(new Point(d, e));
	}

	/**
	 * @author Siddhant Govil 
	 * 	Accessor for the extra tile 
	 * <p> returns null when the tile DNE 
	 */
	public Tile getExtraTile(){
		return _extraTile;
	}

	/**
	 * @author Siddhant Govil 
	 * 	Creates the tiles that can not move, assigns them to the board
	 */
	private void createStaticTiles() {
		Tile temp_tile = new LTile();
		temp_tile.rotateCW();
		_model.put(new Point(0, 0), temp_tile);

		temp_tile = new TTile();
		_model.put(new Point(2, 0), temp_tile);

		temp_tile = new TTile();
		_model.put(new Point(4, 0), temp_tile);

		temp_tile = new LTile();
		temp_tile.rotateCCW();
		temp_tile.rotateCCW();
		_model.put(new Point(6, 0), temp_tile);

		temp_tile = new TTile();
		temp_tile.rotateCCW();
		_model.put(new Point(0, 2), temp_tile);

		temp_tile = new TTile();
		temp_tile.rotateCCW();
		_model.put(new Point(2, 2), temp_tile);

		temp_tile = new TTile();
		_model.put(new Point(4, 2), temp_tile);

		temp_tile = new TTile();
		temp_tile.rotateCW();
		_model.put(new Point(6, 2), temp_tile);

		temp_tile = new TTile();
		temp_tile.rotateCCW();
		_model.put(new Point(0, 4), temp_tile);

		temp_tile = new TTile();
		temp_tile.rotateCW();
		temp_tile.rotateCW();
		_model.put(new Point(2, 4), temp_tile);

		temp_tile = new TTile();
		temp_tile.rotateCW();
		_model.put(new Point(4, 4), temp_tile);

		temp_tile = new TTile();
		temp_tile.rotateCW();
		_model.put(new Point(6, 4), temp_tile);

		temp_tile = new LTile();
		_model.put(new Point(0, 6), temp_tile);

		temp_tile = new TTile();
		temp_tile.rotateCW();
		temp_tile.rotateCW();
		_model.put(new Point(2, 6), temp_tile);

		temp_tile = new TTile();
		temp_tile.rotateCW();
		temp_tile.rotateCW();
		_model.put(new Point(4, 6), temp_tile);

		temp_tile = new LTile();
		temp_tile.rotateCCW();
		_model.put(new Point(6, 6), temp_tile);
	}

	/**
	 * @author Siddhant Govi 
	 * 	Creates the tiles that can move, assigns them to the board or the extra
	 */
	private void createDynamicTiles() {


		ArrayList<Tile> fillerUpper = new ArrayList<Tile>();

		Random r = new Random();
		for (int i = 0; i < NUM_I; i++) {
			ITile adding_tile = new ITile();
			switch (r.nextInt(4)) {
			case 3:
				adding_tile.rotateCW();
			case 2:
				adding_tile.rotateCW();
			case 1:
				adding_tile.rotateCW();
			case 0:
			}
			fillerUpper.add(adding_tile);
		}
		for (int i = 0; i < NUM_T; i++) {
			TTile adding_tile = new TTile();
			switch (r.nextInt(4)) {
			case 3:
				adding_tile.rotateCW();
			case 2:
				adding_tile.rotateCW();
			case 1:
				adding_tile.rotateCW();
			case 0:
			}
			fillerUpper.add(adding_tile);
		}
		for (int i = 0; i < NUM_L; i++) {
			LTile adding_tile = new LTile();
			switch (r.nextInt(4)) {
			case 3:
				adding_tile.rotateCW();
			case 2:
				adding_tile.rotateCW();
			case 1:
				adding_tile.rotateCW();
			case 0:
			}
			fillerUpper.add(adding_tile);
		}
		Collections.shuffle(fillerUpper);

		_model = new HashMap<Point, Tile>();
		for (int y = 0; y < 7; y++) {
			for (int x = 0; x < 7; x++) {
				if (y % 2 != 0 || x % 2 != 0) {
					_model.put(new Point(x, y), fillerUpper.remove(0));
				}
			}
		}
		_extraTile = fillerUpper.remove(0);
	}
	/**
	 * @author Siddhant Govil 
	 * 	 inserts the extra tile into one of the 12 slots, while shifting the other tiles
	 */
	public boolean insertExtra(int mode_select) {
		if ( mode_select<0 || mode_select>11) return false;

		int _const_num = -1; //the number that is the same for the row or column
		char _axis_shift; //Which axis is being shifted along (vertical (Y) or horizontal (X))
		int _shift_dir; //whether the shift is in the positive direction of the axis or the negative, represented by +/- 1
		if(mode_select == 0 || mode_select == 3 || mode_select == 8 || mode_select == 11){
			_const_num = 1;
		}
		else if(mode_select == 1 || mode_select == 4 || mode_select == 7 || mode_select == 10){
			_const_num = 3;
		}
		else if(mode_select == 2 || mode_select == 5 || mode_select == 6 || mode_select == 9){
			_const_num = 5;
		}


		if(mode_select<3 && mode_select>=0){
			_axis_shift='y';
			_shift_dir= 1;
		}
		else if(mode_select<6){
			_axis_shift='x';
			_shift_dir=-1;
		}
		else if(mode_select<9){
			_axis_shift='y';
			_shift_dir= -1;
		}
		else if (mode_select<12){
			_axis_shift='x';
			_shift_dir= 1;
		}
		else return false;


		Tile temp_tile;
		Point _cur_Point;
		if(_axis_shift == 'y'){
			if(_shift_dir == 1){
				_extraTile.addPlayer(getTile(_const_num,6).removePlayer());
				for (int i = 0; i<7;i++){
					_cur_Point = new Point(_const_num,i);
					temp_tile = _model.get(_cur_Point);
					_model.put(_cur_Point, _extraTile);
					_extraTile = temp_tile;
				}
				return true;
			}
			else if(_shift_dir == -1){
				_extraTile.addPlayer(getTile(_const_num,6).removePlayer());
				for (int i = 6; i>=0;i--){
					_cur_Point = new Point(_const_num,i);
					temp_tile = _model.get(_cur_Point);
					_model.put(_cur_Point, _extraTile);
					_extraTile = temp_tile;
				}
				return true;
			}
		}
		
		else if(_axis_shift == 'y'){
			if(_shift_dir == 1){
				_extraTile.addPlayer(getTile(_const_num,6).removePlayer());
				for (int i = 0; i<7;i++){
					_cur_Point = new Point(i,_const_num);
					temp_tile = _model.get(_cur_Point);
					_model.put(_cur_Point, _extraTile);
					_extraTile = temp_tile;
				}
				return true;
			}
			else if(_shift_dir == -1){
				_extraTile.addPlayer(getTile(_const_num,6).removePlayer());
				for (int i = 6; i>=0;i--){
					_cur_Point = new Point(i,_const_num);
					temp_tile = _model.get(_cur_Point);
					_model.put(_cur_Point, _extraTile);
					_extraTile = temp_tile;
				}
				return true;
			}
		}


		return false;

	}

	/**
	 * @author Siddhant Govil 
	 * 	The method adds players to the board up to a maximum of 4
	 * 
	 * @param p The player that needs to be added to the board
	 */
	public boolean addPlayer(Player p) {
		if (_numPlayers>5){
			return false;
		}
		_numPlayers++;
		ArrayList<Player> addingPlayer;
		if (_numPlayers ==1){
			addingPlayer = new ArrayList<Player>();
			addingPlayer.add(p);
			getTile(2,2).addPlayer(p);
			return true;
		}
		else if (_numPlayers ==2){
			addingPlayer = new ArrayList<Player>();
			addingPlayer.add(p);
			getTile(2,4).addPlayer(p);
			return true;
		}
		else if (_numPlayers ==3){
			addingPlayer = new ArrayList<Player>();
			addingPlayer.add(p);
			getTile(4,2).addPlayer(p);
			return true;
		}
		else if (_numPlayers ==4){
			addingPlayer = new ArrayList<Player>();
			addingPlayer.add(p);
			getTile(4,4).addPlayer(p);
			return true;
		}
		return true;
	}
	
	/**
	 * @author Siddhant Govil	 * 	The method returns the point that the player queried is standing on
	 * 
	 * @param p The player that needs to be added to the board
	 */
	public Point getPlayerPos(Player p){
		Point _testPoint;
		for(int x = 0; x<7;x++){
			for(int y = 0; y<7;y++){
				//_testPoint = new Point(x,y);
				if(getTile(x,y).getPlayers().contains(p)){
					return new Point(x,y);
				}
				
			}
		}
		return null;
	}
	/**
	 * @author Siddhant Govil
	 *  - 1. Get the player's position.
	 * 				   2. Get the current tile the player is on.
	 *                 3. Remove player from current tile.
	 *                 4. Set reference to the final tile.
	 *                 5. Add player to final tile.
	 */
	
	public void moveUp(Player p){
		Point playerpoint = getPlayerPos(p);
		boolean[] validDirection = p.getValidDirections();
				if ( validDirection[0]) {
					getTile((int)playerpoint.getX(), (int)playerpoint.getY());	
					Tile playerCurrentTile = getTile((int)playerpoint.getX(), (int)playerpoint.getY());
					ArrayList<Player> playerList = new ArrayList<Player>();
					playerList.add(p);
					playerCurrentTile.removePlayer(playerList);
					Tile playerFinalTile = getTile((int)playerpoint.getX(), (int)playerpoint.getY()-1);
					playerFinalTile.addPlayer(p);
					
				}
			
		
	}
	
	public void moveRight(Player p){
		Point playerpoint = getPlayerPos(p);
		boolean[] validDirection = p.getValidDirections();
				if ( validDirection[1]) {
					getTile((int)playerpoint.getX(), (int)playerpoint.getY());	
					Tile playerCurrentTile = getTile((int)playerpoint.getX(), (int)playerpoint.getY());
					ArrayList<Player> playerList = new ArrayList<Player>();
					playerList.add(p);
					playerCurrentTile.removePlayer(playerList);
					Tile playerFinalTile = getTile((int)playerpoint.getX()+1, (int)playerpoint.getY());
					playerFinalTile.addPlayer(p);
					
				}
			
		
	}
	
	public void moveDown(Player p){
		Point playerpoint = getPlayerPos(p);
		boolean[] validDirection = p.getValidDirections();
				if ( validDirection[2]) {
					getTile((int)playerpoint.getX(), (int)playerpoint.getY());	
					Tile playerCurrentTile = getTile((int)playerpoint.getX(), (int)playerpoint.getY());
					ArrayList<Player> playerList = new ArrayList<Player>();
					playerList.add(p);
					playerCurrentTile.removePlayer(playerList);
					Tile playerFinalTile = getTile((int)playerpoint.getX(), (int)playerpoint.getY()+1);
					playerFinalTile.addPlayer(p);
					
				}
			
		
	}
	
	public void moveLeft(Player p){
		Point playerpoint = getPlayerPos(p);
		boolean[] validDirection = p.getValidDirections();
				if ( validDirection[3]) {
					//getTile((int)playerpoint.getX(), (int)playerpoint.getY());	
					Tile playerCurrentTile = getTile((int)playerpoint.getX(), (int)playerpoint.getY());
					ArrayList<Player> playerList = new ArrayList<Player>();
					playerList.add(p);
					playerCurrentTile.removePlayer(playerList);
					Tile playerFinalTile = getTile((int)playerpoint.getX()-1, (int)playerpoint.getY());
					playerFinalTile.addPlayer(p);
				}
	}			
}
	

