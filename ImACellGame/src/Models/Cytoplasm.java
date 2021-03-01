package Models;

import java.util.HashMap;

public class Cytoplasm extends ProductContainer{
	
	public Cytoplasm(int id, int[] coords) {
		super(id, "Cytoplasm", "The jelly like inside of the cell", coords, new HashMap<Integer, Integer>(), 2);
		// TODO Auto-generated constructor stub
	}


	private void setRequiredResources() {
		
		
	}

	@Override
	public void doCellActivity() {
		// TODO Auto-generated method stub
		
	}

}
