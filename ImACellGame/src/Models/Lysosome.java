package Models;

import java.util.HashMap;

public class Lysosome extends Organelle{

	public Lysosome(int id, int[] coords) {
		super(id, 
				"Lysosome", 
				"A storage sack containing digestive enzymes.", 
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
