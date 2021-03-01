package Models;

import java.util.HashMap;

import javafx.scene.image.ImageView;

public abstract class Producer extends Organelle{
	
	protected Instructions instructions;
	protected boolean planted;
	protected Producer currentBuild;
	protected int currentStep;
	protected int currentProgress;
	protected ImageView iv;
	
	public Producer(int id, String name, String description, int[] coords, HashMap<Integer, Integer> storedResources,
			Instructions instructions, boolean planted, ImageView iv) {
		super(id, name, description, coords, storedResources);
		this.instructions = instructions;
		this.planted = planted;
		this.currentBuild = null;
		this.currentProgress = 0;
		this.iv = iv;
		this.currentStep = 0;
	}

	public Instructions getInstructions() {
		return instructions;
	}

	public void setInstructions(Instructions instructions) {
		this.instructions = instructions;
	}

	public boolean isPlanted() {
		return planted;
	}

	public void setPlanted(boolean planted) {
		this.planted = planted;
	}

	public ImageView getIv() {
		return iv;
	}

	public void setIv(ImageView iv) {
		this.iv = iv;
	}

	public Producer getCurrentBuild() {
		return currentBuild;
	}

	public void setCurrentBuild(Producer currentBuild) {
		this.currentBuild = currentBuild;
	}

	public int getCurrentStep() {
		return currentStep;
	}

	public void setCurrentStep(int currentStep) {
		this.currentStep = currentStep;
	}

	public int getCurrentProgress() {
		return currentProgress;
	}

	public void setCurrentProgress(int currentProgress) {
		this.currentProgress = currentProgress;
	}

}
