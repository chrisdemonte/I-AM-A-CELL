package Models;

import java.util.HashMap;

public class CellMembrane extends Organelle{

	public CellMembrane(int id, int[] coords) {
		super(id, 
				"Cell Membrane", 
				"Separates the cell from the enviornment", 
				coords, 
				new HashMap<Integer, Integer>());
		this.setRequiredResources();
	}

	private void setRequiredResources() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doCellActivity() {
		if (Cell.getCellArea() > Cell.getMolecules().getOxygen()) {
			Cell.getMolecules().changeOxygen(1);
		}
		else {
			Cell.getMolecules().changeOxygen(-1);
		}
		if (Cell.getCellArea() > Cell.getMolecules().getCarbonDioxide()) {
			Cell.getMolecules().changeCarbonDioxide(1);
		}
		else {
			Cell.getMolecules().changeCarbonDioxide(-1);
		}
		
	}

}
