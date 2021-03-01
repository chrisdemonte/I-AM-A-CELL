package Models;

import java.util.Arrays;
import java.util.HashMap;

public abstract class Organelle implements CellActivity{
	
	/**
	 * ID: is a for digit int. All elements that have an id will follow the same rules
	 * divide by 100 gives you the type of organelle. 
	 * -1 = envoirnment
	 * 0 = nucleus
	 * 1 = cytoplasm
	 * 2 = cell membrane
	 * 3 = ribosome
	 * 4 = rough ER
	 * 5 = smooth ER
	 * 6 = golgi apparatus
	 * 7 = mitochondrian
	 * 8 = lysosome
	 * 9 = vesicle
	 * 20 = resource
	 * %100 give you the unique sub-type
	 * 
	 */
	
	private int id; 
	private String name;
	private String description;
	private int[] coords;
	private int health;
	private HashMap <Integer, Integer> storedResources;
	
	public Organelle(int id, String name, String description, int[] coords, HashMap<Integer, Integer> storedResources) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.coords = coords;
		this.storedResources = storedResources;
		this.health = 100;
	}

	@Override
	public String toString() {
		return "Organelle [id=" + id + ", name=" + name + ", description=" + description + ", coords="
				+ Arrays.toString(coords) + ", health=" + health + ", storedResources=" + storedResources.toString() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int[] getCoords() {
		return coords;
	}

	public void setCoords(int[] coords) {
		this.coords = coords;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public HashMap<Integer, Integer> getStoredResources() {
		return storedResources;
	}

	public void setStoredResources(HashMap<Integer, Integer> storedResources) {
		this.storedResources = storedResources;
	}
	
	

}
