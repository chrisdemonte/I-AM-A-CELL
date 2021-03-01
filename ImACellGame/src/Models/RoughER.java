package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class RoughER extends ProductContainer{


	public RoughER(int id, int[] coords) {
		
		super(id, "Rough Endoplasmic Reticulum", "Has a lot of ribosomes. Makes cell protein", coords, new HashMap<Integer, Integer>(), 5);
	}

	private void setRequiredResources() {
		
		
	}

	@Override
	public void doCellActivity() {
		/**
		for (int i = 0; i < this.plantedRibosomes.size(); i++) {
			this.plantedRibosomes.get(i).doCellActivity();
		}
		**/
		
		
	}
	
	

}
