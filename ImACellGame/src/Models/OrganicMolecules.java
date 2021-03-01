package Models;

public class OrganicMolecules {
	private int glucose;
	private int starch;
	private int aminoacid;
	private int fattyAcid;
	private int phosphorus;
	private int sodium;
	private int water;
	private int oxygen;
	private int carbonDioxide;
	private int waste;
	
	public OrganicMolecules(int cellWidth, int cellHeight) {
		int starting = cellWidth * cellHeight;
		this.glucose = starting;
		this.starch = starting;
		this.aminoacid = starting;
		this.fattyAcid = starting;
		this.phosphorus = starting;
		this.sodium = starting;
		this.water = starting;
		this.oxygen = starting;
		this.carbonDioxide = 0;
		this.waste = 0;
	}

	public int getGlucose() {
		return glucose;
	}

	public void setGlucose(int glucose) {
		this.glucose = glucose;
	}
	public void changeGlucose(int glucose) {
		this.glucose += glucose;
		if (this.glucose < 0) {
			this.glucose = 0;
		}
	}

	public int getStarch() {
		return starch;
	}

	public void setStarch(int starch) {
		this.starch = starch;
	}
	public void changeStarch(int starch) {
		this.starch += starch;
		if (this.starch < 0) {
			this.starch = 0;
		}
	}

	public int getAminoacid() {
		return aminoacid;
	}

	public void setAminoacid(int aminoacid) {
		this.aminoacid = aminoacid;
	}
	public void changeAminoacid(int aminoacid) {
		this.aminoacid += aminoacid;
		if (this.aminoacid < 0) {
			this.aminoacid = 0;
		}
	}

	public int getFattyAcid() {
		return fattyAcid;
	}

	public void setFattyAcid(int fattyAcid) {
		this.fattyAcid = fattyAcid;
	}
	public void changeFattyAcid(int fattyAcid) {
		this.fattyAcid += fattyAcid;
		if (this.fattyAcid < 0) {
			this.fattyAcid = 0;
		}
	}

	public int getPhosphorus() {
		return phosphorus;
	}

	public void setPhosphorus(int phosphorus) {
		this.phosphorus = phosphorus;
	}
	public void changePhosphorus(int phosphorus) {
		this.phosphorus += phosphorus;
		if (this.phosphorus < 0) {
			this.phosphorus = 0;
		}
	}

	public int getSodium() {
		return sodium;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}
	public void changeSodium(int sodium) {
		this.sodium += sodium;
		if (this.sodium < 0) {
			this.sodium = 0;
		}
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}
	public void changeWater(int water) {
		this.water += water;
		if (this.water < 0) {
			this.water = 0;
		}
	}
	public int getOxygen() {
		return oxygen;
	}

	public void setOxygen(int oxygen) {
		this.oxygen = oxygen;
	}
	public void changeOxygen(int oxygen) {
		this.oxygen += oxygen;
		if (this.oxygen < 0) {
			this.oxygen = 0;
		}
	}

	public int getCarbonDioxide() {
		return carbonDioxide;
	}

	public void setCarbonDioxide(int carbonDioxide) {
		this.carbonDioxide = carbonDioxide;
	}
	public void changeCarbonDioxide(int carbonDioxide) {
		this.carbonDioxide += carbonDioxide;
		if (this.carbonDioxide < 0) {
			this.carbonDioxide = 0;
		}
	}

	public int getWaste() {
		return waste;
	}

	public void setWaste(int waste) {
		this.waste = waste;
	}
	
	public void changeWaste(int waste) {
		this.waste += waste;
		if (this.waste < 0) {
			this.waste = 0;
		}
	}

	@Override
	public String toString() {
		return "OrganicMolecules \nGlucose =" + glucose + "\nStarch =" + starch + "\nAminoacids =" + aminoacid
				+ "\nFattyAcids =" + fattyAcid + "\nPhosphorus =" + phosphorus + "\nSodium=" + sodium + "\nWater =" + water
				+ "\nOxygen =" + oxygen + "\nCarbonDioxide =" + carbonDioxide + "\nWaste =" + waste;
	}

}
