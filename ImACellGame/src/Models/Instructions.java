package Models;

import java.util.ArrayList;

public class Instructions {
	
	private int resourceCode;
	private ArrayList<String> destinations;
	private ArrayList<Integer> fabricationTimes;
	
	public Instructions(int resourceCode, ArrayList<String> destinations, ArrayList<Integer> fabricationTimes ) {
		super();
		this.resourceCode = resourceCode;
		this.destinations = destinations;
		this.fabricationTimes = fabricationTimes;
	}

	public int getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(int resourceCode) {
		this.resourceCode = resourceCode;
	}

	public ArrayList<String> getDestinations() {
		return destinations;
	}

	public void setDestinations(ArrayList<String> destinations) {
		this.destinations = destinations;
	}

	public ArrayList<Integer> getFabricationTimes() {
		return fabricationTimes;
	}

	public void setFabricationTimes(ArrayList<Integer> fabricationTimes) {
		this.fabricationTimes = fabricationTimes;
	}


}
