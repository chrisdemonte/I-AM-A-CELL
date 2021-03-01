package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public abstract class ProductContainer extends Organelle{
	
	protected ArrayList<Producer> plantedRibosomes;
	protected ArrayList<Producer> inTransit;
	protected int capacity;
	
	public ProductContainer(int id, String name, String description, int[] coords,
			HashMap<Integer, Integer> storedResources, int capacity) {
		super(id, name, description, coords, storedResources);
		this.plantedRibosomes = new ArrayList<Producer>();
		this.inTransit = new ArrayList<Producer>();
		this.capacity = capacity;
		
	}
	
	public void recieveProduct(Producer p) {
		if (inTransit.contains(p)) {
			if (!this.isFull()) {
				plantedRibosomes.add(p);
				p.setPlanted(true);
				inTransit.remove(p);
				this.addToResources(p);
			}
		}
	}
	private void addToResources(Producer p) {
		if (!this.getStoredResources().containsKey(p.getId())) {
			this.getStoredResources().put(p.getId(), 1);
		}
		else {
			int temp = this.getStoredResources().get(p.getId());
			temp++;
			this.getStoredResources().put(p.getId(), temp);
		}
		
	}

	public boolean isFull() {
		return plantedRibosomes.size() >= capacity;
	}

	public ArrayList<Producer> getPlantedRibosomes() {
		return plantedRibosomes;
	}

	public void setPlantedRibosomes(ArrayList<Producer> plantedRibosomes) {
		this.plantedRibosomes = plantedRibosomes;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public ArrayList<Producer> getInTransit() {
		return inTransit;
	}

	public void setInTransit(ArrayList<Producer> inTransit) {
		this.inTransit = inTransit;
	}
	
	
}
