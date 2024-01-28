package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu, Jordan Clark
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
		/* Reference to the local singleton instance of Game Service and
		 * checks if there is an instance of Game Service in the memory.
		 * if not, creates one 
		 */
		GameService service = GameService.getInstance();
		
		// A simple for loop to print the games
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		}

	}
	
}
