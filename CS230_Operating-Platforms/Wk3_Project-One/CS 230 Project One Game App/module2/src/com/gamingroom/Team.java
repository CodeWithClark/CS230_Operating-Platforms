package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * 
 * <p>
 * Inherits from @link Entity, a base class for creating 
 * a sole instance of a Team with iterative behaviors to 
 * access and search through the players list.
 * </p>
 * 
 * @author coce@snhu.edu, Jordan Clark
 *
 */
public class Team extends Entity {
	
	private static List<Player> players = new ArrayList<Player>();
	
	/* 
	 *  Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 *  Implements iterator pattern to return an existing player
	 *  with the same name or create a new player with the users
	 *  unique name.
	 */
    public Player addPlayer(String name) {
    	
    	// Create the team list iterator
    	Player player = null;
    	
    	// Search through the entire players list
    	for (int i = 0; i < players.size() -1; i++) {
    		// If an existing player has the same name
    		if (players.get(i).getName() == name) {
    			// Update the users player name to the existing player
    			player = players.get(i);
    		}
    	}
    	
    	// If the player does not exist
    	if (player == null) {
    		// Reference the GameService's sole instance
    		GameService service = GameService.getInstance();
    		
    		// Create a new player
    		player = new Player(service.getNextPlayerId(), name);
    		// Add player to Player list
    		players.add(player);
    	}
    	
    	// Return either the new or existing instance
    	return player;
    }

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
