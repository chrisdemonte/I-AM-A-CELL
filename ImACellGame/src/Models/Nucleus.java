package Models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import GUI.GameWindow;
import Utilities.EnviornmentUtil;
import javafx.scene.image.ImageView;

public class Nucleus extends Organelle{
	
	private LinkedList<Instructions> queue;
	private Producer currentBuild;

	public Nucleus(int id, int[] coords) {
		super(id, 
				"Nucleus" , 
				"Called the brain of the cell. It is holds DNA, RNA, and is responsible for making robosomes.",
				coords, 
				new HashMap<Integer, Integer>());
		this.setRequiredResources();
		this.queue = new LinkedList<Instructions>();
		this.currentBuild = null;
	
	}

	private void setRequiredResources() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doCellActivity() {
		if (currentBuild == null) {
			if (queue.peek() != null
					&& Cell.getMolecules().getAminoacid() > 0 
					&& Cell.getMolecules().getWater() > 0
					&& Cell.getATP() >= 10 ) {
				Random rand = new Random();
				Nucleus nucleus = (Nucleus)Cell.getOrganelles().get("Nucleus_1");
				int[] newCoords = {nucleus.getCoords()[0] + rand.nextInt(55), nucleus.getCoords()[1] + rand.nextInt(55)};
				ImageView iv;
				Instructions inst = queue.remove();
				if (inst.getResourceCode() == 300) {
					iv = new ImageView(GameWindow.getImages().get(30));
					currentBuild = new Ribosome(300, newCoords,inst, false, iv);
					Cell.getMolecules().changeAminoacid(-1);
					Cell.getMolecules().changeWater(-1);

				}
				else {
					iv = new ImageView(GameWindow.getImages().get(200));
					currentBuild = new RNA(this.getId(), newCoords, inst, false, iv);
					Cell.getMolecules().changeAminoacid(-1);
					Cell.getMolecules().changeWater(-1);
				}
				iv.setTranslateX(newCoords[0]);
				iv.setTranslateY(newCoords[1]);
				Cell.getMolecules().changeWaste(1);
				Cell.changeATP(-10);
				GameWindow.getEnviornment().getChildren().add(iv);
			}
		}
		else {
			if (Cell.getOrganelles().containsKey(currentBuild.instructions.getDestinations().get(currentBuild.currentStep)) &&
					Cell.getATP()>= 10){
				currentBuild.doCellActivity();
				currentBuild = null;
				Cell.changeATP(-10);
			}
			
		}
	}

	public LinkedList<Instructions> getQueue() {
		return queue;
	}

	public void setQueue(LinkedList<Instructions> queue) {
		this.queue = queue;
	}

	public Producer getCurrentBuild() {
		return currentBuild;
	}

	public void setCurrentBuild(Producer currentBuild) {
		this.currentBuild = currentBuild;
	}
	

}
