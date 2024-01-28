package com.gamingroom;

/**
 *  A class to hold information about an entity
 *  
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p> 
 * 
 * @author Jordan Clark
 *
 */

public class Entity {
	
	/**
	 * The unmodifiable attributes of an entity,
	 */
	protected long id; // uses the 'protected' modifier for inheritance
	protected String name;
	
	/**
	 * Hidden default constructor to store the singleton instance
	 */
	protected Entity() {}

    /**
     * Public constructor to access the singleton instance.
     *  
     * @param id
     * @param name
     */
	public Entity(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}
}
