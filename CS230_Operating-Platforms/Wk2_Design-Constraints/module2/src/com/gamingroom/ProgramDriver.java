package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu, Jordan Clark
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		/* 
		 * Create a new instance of GameService to start
		 * the initial service to the program. There are no
		 * other instances of GameService, this is the first.
		 */
		GameService service = GameService.getInstance();
		
		System.out.println("\nAbout to test initializing game data...");
		
		// Initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Game #2");
		System.out.println(game2);
		
		// Use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
