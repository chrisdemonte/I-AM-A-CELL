package Models;

import java.util.HashMap;

public class GolgiApparatus extends ProductContainer{

	public GolgiApparatus(int id, int[] coords) {
		super(id, "Golgi Apparatus", "Connects to the ER. Completes protiens and lipids, and sends them to other parts of the cell", coords, new HashMap<Integer, Integer>(), 2);
		// TODO Auto-generated constructor stub
	}


	private void setRequiredResources() {
		
		
	}
	public void doCellActivity() {
		// TODO Auto-generated method stub
		
	}

}
