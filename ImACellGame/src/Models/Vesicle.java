package Models;

import java.util.HashMap;

public class Vesicle extends Organelle{

	public Vesicle(int id, int[] coords) {
		super(id, 
				"Vesicle", 
				"A storage container, made from cell membrane", 
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
