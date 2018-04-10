package code;

import java.util.ArrayList;

/*
 * @author Siddhant Govil
 * 
 * Provides the implementation of the I-shaped tile.
 * 
 * @param _paths: Boolean array which indicates whether corresponding direction
 * 				is a viable movement option.[0] is upward, [1] is right, [2], is 
 * 				downward, [3] is left. True indicates a valid movement, false
 * 				indicates a non-valid movement
 * @param _players: ArrayList of the "Player" objects on the current tile.
 * @param temp0: temporary variable that holds _paths[0] during rotateCW or 
 * 				rotateCCW method calls.
 * @param temp1: temporary variable that holds _paths[1] during rotateCW or 
 * 				rotateCCW method calls.
 * @param temp2: temporary variable that holds _paths[2] during rotateCW or 
 * 				rotateCCW method calls.
 * @param temp3: temporary variable that holds _paths[3] during rotateCW or 
 * 				rotateCCW method calls.
 * @param p: Player object that is passed in through setPlayer or removePlayer
 * 			method call.
 */

public class ITile implements Tile {

	private boolean[] _paths;
	private ArrayList<Player> _players;
	
	public ITile(){
		_paths = new boolean[] {true, false, true, false};
		_players = new ArrayList<Player>();
	}
	
	@Override
	public boolean[] getDirs() { return _paths; }

	@Override
	public void rotateCW() {
		boolean temp0 = _paths[0];
		boolean temp1 = _paths[1];
		boolean temp2 = _paths[2];
		boolean temp3 = _paths[3];
		_paths[0] = temp3;
		_paths[1] = temp0;
		_paths[2] = temp1;
		_paths[3] = temp2;
	}

	@Override
	public void rotateCCW() {
		boolean temp0 = _paths[0];
		boolean temp1 = _paths[1];
		boolean temp2 = _paths[2];
		boolean temp3 = _paths[3];
		_paths[0] = temp1;
		_paths[1] = temp2;
		_paths[2] = temp3;
		_paths[3] = temp0;
	}

	@Override
	public ArrayList<Player> getPlayers() { return _players; }

	@Override
	public ArrayList<Player> addPlayer(ArrayList<Player> p) {
		if (p != null) {
			for (int i = 0; i < p.size(); i++) {
				_players.add(p.get(i));
			}
		}
		return p;
	}
	
	@Override
	public Player addPlayer(Player p) {
		_players.add(p);
		return p;
	}

	@Override
	public ArrayList<Player> removePlayer(ArrayList<Player> p) {
		if (p != null) {
			for (int i = 0; i < p.size(); i++) {
				_players.remove(p.get(i));
			}
		}
		return p;
	}

	@Override
	public ArrayList<Player> removePlayer() {
		ArrayList<Player> p = new ArrayList<Player>();
		for (int i = 0; i < _players.size(); i++) {
			p.add(_players.get(i));
			_players.remove(i);
		}
		return p;
	}
}