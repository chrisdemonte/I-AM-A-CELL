package Models;

import java.util.HashMap;

public class Cytoskeleton extends Organelle{
	public Cytoskeleton(int id, int[] coords) {
		super(id, 
				"Cytoskeleton", 
				"Connects the different parts of the cell. Aids in active transport of cell resources.", 
				coords, 
				new HashMap<Integer, Integer>());
		this.setRequiredResources();
		
	}

	private void setRequiredResources() {
		
		
	}

	@Override
	public void doCellActivity() {
		// TODO Auto-generated method stub
		
	}

}
