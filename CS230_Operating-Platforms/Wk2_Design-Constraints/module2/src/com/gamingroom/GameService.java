package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu, Jordan Clark
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();
	
	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	
	/*
	 * Holds the next player identifier
	 */
	private static long nextPlayerId = 1;

	/*
	 * Holds the next team identifier
	 */
	private static long nextTeamId = 1;
	
	/*
	 * Private static variable that creates the sole instance
	 * of the game.
	 */
	private static GameService service = null;
	
	/** 
	 * Singleton Implementation: Ensure sole instance
	 * We call a private instance of GameService to prevent
	 * another instance from being created by another 
	 * object using the 'new' operator.
	 */
	private GameService() {}

	/**
	 * Singleton Implementation: Provide global access
	 * Check for an existing instance of the GameService to
	 * ensure only one instance of a service can exist in
	 * memory at any given time. If none exist, create a new one.
	 * 
	 * @return service
	 */
	public static GameService getInstance() {
		// Check to see if an instance of GameService already exists
		if (service == null) {
			// If it doesn't, create a new one
			service = new GameService();
			// Let the user know it's new
			System.out.println("New Service created.");
		} else {
			// Let the user know it already exists
			System.out.println("Game Service already exists.");
		}
		
		// Return the new or existing GameService
		return service;
	}

	/**
	 * Construct a new game instance with unique name parameter
	 * 
	 * @param name, the unique name of the game
	 * @return game, the sole instance (new or existing)
	 */
	public Game addGame(String name) {

		// A local game instance
		Game game = null;

		// Search through Games list for existing game with matching name
		if (getGame(name) != null) {
			// Update the users game to the existing game
			game = getGame(name);
		}

		// If not found
		if (game == null) {
			// Make a new game instance 
			game = new Game(nextGameId++, name);
			// Add the new game to the list of games
			games.add(game);
		}

		// Return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * 
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * 
	 * @param current index position in list
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Iterator Implementation: Retrieves element from collection
	 * 
	 * <p>
	 * The @code getGame method accesses and searches a classes private list.
	 * This behavior is implemented to provide a modifiable operation and 
	 * reduce code duplication.
	 * 
	 */
	
	/*
	 * Returns the game instance with the specified id.
	 */
	public Game getGame(long id) {

		// A local game instance
		Game game = null;

		/**
		 * Iterator Implementation: Single collection link
		 * The getGame iterator traverses over the games list,
		 * which is a private list. This prevents the list from
		 * being accessed or modified outside of the class. The
		 * iterator pattern self contains a way to search and find
		 * elements within its own class and return the item to the
		 * public.
		 */
		
		// Iterates through games to look for existing game with same id
		for (int i = 0; i < getGameCount(); i++) {
			// If found
			if (games.get(i).getId() == id) {
				// Update the users game to the existing game
				game = games.get(i);
			}
		}
		
		// Return existing game with matching ID, if found
		return game;
	}

	/*
	 * Returns the game instance with the specified name.
	 */
	public Game getGame(String name) {

		// A local game instance
		Game game = null;

		// Iterates through games to look for existing game with the same name
		for (int i = 0; i < getGameCount(); i++) {
			// If an existing game has the same name
			if (games.get(i).getName() == name) {
				// Update the users game to the existing game
				game = games.get(i);
			}
		}
		
		// Return existing game with matching name, if found
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return active game count
	 */
	public int getGameCount() {
		return games.size();
	}
	
	/**
	 * Returns the id of the current index in Player list and
	 * adds "1" to the value.
	 * 
	 * @returns the next player ID.
	 */
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
	
	/**
	 * Returns the id of the current index in Team list and
	 * adds "1" to the value.
	 * 
	 * @returns the next team ID
	 */
	public long getNextTeamId() {
		return nextTeamId++;
	}

}
