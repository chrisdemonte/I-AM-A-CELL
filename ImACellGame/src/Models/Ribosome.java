package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import GUI.GameWindow;
import Utilities.EnviornmentUtil;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Ribosome extends Producer{

	public Ribosome(int id, int[] coords, Instructions instructions, boolean planted, ImageView iv) {
		
		super(id,"Ribosome","Made by the nucleus. Makes protein from amino acids",  coords, new HashMap<Integer, Integer>() , instructions, planted, iv);
		
	}

	private void setRequiredResources() {
		
		
	}
	@Override
	public void doCellActivity() {
		if (!planted) {
			ProductContainer destination = (ProductContainer)Cell.getOrganelles().get(this.instructions.getDestinations().get(this.currentStep));
			destination.getInTransit().add(this);
			this.doAnimation();
		}
		else if (this.instructions != null) {
			if (currentBuild == null 
					&&Cell.getATP() >= 10
					&&Cell.getMolecules().getAminoacid() > 0
					&&Cell.getMolecules().getWater()>0) {
				Random rand = new Random();
				ImageView iv = new ImageView(GameWindow.getImages().get(200));
				int[] newCoords = {this.getCoords()[0], this.getCoords()[1]};
				iv.setTranslateX(newCoords[0]);
				iv.setTranslateY(newCoords[1]);
				if (this.getInstructions().getResourceCode() == 2080) {
					currentBuild = new Enzyme(this.getInstructions().getResourceCode(), newCoords, this.instructions, false, iv);
					currentBuild.setCurrentStep(this.currentStep);
				}
				else {
					currentBuild = new Macromolecule(this.getId(), newCoords, this.instructions, false, iv);
					currentBuild.setCurrentStep(this.currentStep);
				}
				Cell.getMolecules().changeWaste(1);
				Cell.getMolecules().changeAminoacid(-1);
				Cell.getMolecules().changeWater(-1);
				Cell.changeATP(-10);
				GameWindow.getEnviornment().getChildren().add(iv);
			}
			else if (this.instructions.getFabricationTimes().get(this.currentStep) > this.currentProgress
					&&Cell.getATP() >= 10
					&&Cell.getMolecules().getAminoacid() > 0
					&&Cell.getMolecules().getWater()>0){
				this.currentProgress++;	
				Cell.getMolecules().changeWaste(1);
				Cell.getMolecules().changeAminoacid(-1);
				Cell.getMolecules().changeWater(-1);
				Cell.changeATP(-10);
			}
			else {
				if (Cell.getATP() >= 10) {
					currentBuild.doCellActivity();
					currentBuild = null;	
					Cell.changeATP(-10);
					Cell.getMolecules().changeWaste(1);
					currentProgress = 0;
					if (instructions.getResourceCode()% 100 > 10) {
						this.instructions = null;
					}
				}
			}
		}
		else {
			
		}
		
	}
	private void doAnimation() {
		Timeline timeline = new Timeline();
		Random rand = new Random();
		Organelle destination = Cell.getOrganelles().get(this.instructions.getDestinations().get(this.currentStep));
		
		int[] dCoords = destination.getCoords();
		double duration = Math.sqrt((Math.pow((double)(dCoords[0] - this.getCoords()[0]), 2.0) + Math.pow((double)(dCoords[1] - this.getCoords()[1]), 2.0)));
		duration /= 60;
		
		final String dest = this.instructions.getDestinations().get(this.currentStep);
		final Ribosome ref = this;	
		EventHandler<ActionEvent> finalHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				ProductContainer finalDestination = (ProductContainer)Cell.getOrganelles().get(dest);
				finalDestination.recieveProduct(ref);
				ref.getCoords()[0] = (int)ref.getIv().getTranslateX();
				ref.getCoords()[1] = (int)ref.getIv().getTranslateY();
				EnviornmentUtil.ribosomeCounter++;
				Cell.getOrganelles().put("Ribosomes_" + EnviornmentUtil.ribosomeCounter, ref);
				ref.setInstructions(null);
				ref.planted = true;
				timeline.stop();
			}	
		};
		timeline.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, 
						new KeyValue(iv.translateXProperty(), this.getCoords()[0]),
						new KeyValue(iv.translateYProperty(), this.getCoords()[1])),
				new KeyFrame(Duration.seconds(duration), finalHandler,
						new KeyValue(iv.translateXProperty(), dCoords[0] + rand.nextInt(55)),
						new KeyValue(iv.translateYProperty(), dCoords[1] + rand.nextInt(55))));
		timeline.play();
	}

}
