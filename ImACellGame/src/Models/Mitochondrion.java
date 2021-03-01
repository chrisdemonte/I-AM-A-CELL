package Models;

import java.util.HashMap;
import java.util.Random;

public class Mitochondrion extends Organelle{

	public Mitochondrion(int id, int[] coords) {
		super(id, 
				"Mitochondrion", 
				"The powerhouse of the cell. Responsible for producing ATP(energy).", 
				coords, 
				new HashMap<Integer, Integer>());
		this.setRequiredResources();
		
	}

	private void setRequiredResources() {
		
		
	}
	@Override
	public void doCellActivity() {
		if (Cell.getMolecules().getGlucose() > 0) {
			Random rand = new Random();
			Cell.changeATP(32 + rand.nextInt(5));
			Cell.getMolecules().changeGlucose(-1);
			Cell.getMolecules().changeOxygen(-1);
			Cell.getMolecules().changeCarbonDioxide(1);
		}
		
	}

}
