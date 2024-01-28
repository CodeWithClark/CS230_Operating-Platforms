package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * <p>
 * Inherits from @link Entity, which provides a base
 * class for creating a sole instance of an object 
 * with iterative behaviors to search through the 
 * teams list.
 * </p>
 * 
 * @author coce@snhu.edu, Jordan Clark
 *
 */
public class Game extends Entity {
	
	/**
	 * Private list to store active teams
	 */
	private static List<Team> teams = new ArrayList<Team>();

	/**
	 * Public default constructor with an identifier and name
	 */
	public Game(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Iterator pattern: We use the pattern here to access and search
	 * the Team list, then return an existing team with the same name 
	 * or create a new team with the users unique name.
	 */
    public Team addTeam(String name) {
    	
    	// A local team instance
    	Team team = null;
    	
    	// Search through the entire list of teams
    	for (int i = 0; i < teams.size() -1; i++) {
    		// If an existing team has the same name
    		if (teams.get(i).getName() == name) {
    			// Update the users team to the existing team
    			team = teams.get(i);
    		}
    	}
    	
    	// If the team does not exist
    	if (team == null) {
    		// Reference the GameService's sole instance
    		GameService service = GameService.getInstance();
    		
    		// Create a new team containing players within that reference
    		team = new Team(service.getNextPlayerId(), name);
    		// Add this team to the list
    		teams.add(team);
    	}
    	
    	// Return either the new or existing instance
    	return team;
    }

	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
