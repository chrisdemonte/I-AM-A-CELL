package Models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import Utilities.EnviornmentUtil;

public class Cell {
	
	private static OrganicMolecules molecules;
	private static int cellArea;
	private static HashMap <String, Organelle> organelles;
	public static int ATP;
	
	public Cell (int cellWidth, int cellHeight) {
		this.molecules = new OrganicMolecules(cellWidth, cellHeight);
		this.cellArea = cellWidth * cellHeight;
		this.organelles = new HashMap<String, Organelle>();
		this.ATP = 100;
	}
	
	public static void doAllActivity() {
		Iterator<Entry<String, Organelle>> it = organelles.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			Organelle o = (Organelle)entry.getValue();
			if (o.getId() != 20) {
			o.doCellActivity();
			}
		}
		organelles.get("Nucleus_" + EnviornmentUtil.nucleusCounter).doCellActivity();
	}

	public static OrganicMolecules getMolecules() {
		return molecules;
	}

	public static void setMolecules(OrganicMolecules molecules) {
		Cell.molecules = molecules;
	}

	public static int getCellArea() {
		return cellArea;
	}

	public static void setCellArea(int cellArea) {
		Cell.cellArea = cellArea;
	}

	public static HashMap<String, Organelle> getOrganelles() {
		return organelles;
	}

	public static void setOrganelles(HashMap<String, Organelle> organelles) {
		Cell.organelles = organelles;
	}

	public static int getATP() {
		return ATP;
	}

	public static void setATP(int aTP) {
		ATP = aTP;
	}
	public static void changeATP(int atp) {
		ATP += atp;
	}

}
