package Models;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import GUI.GameWindow;
import Utilities.EnviornmentUtil;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Macromolecule extends Producer{
	
	public Macromolecule(int id, int[] coords, Instructions instructions, boolean planted, ImageView iv) {
		super(id, "MacroMolecule", "Vital component for cell activity", coords, null, instructions, planted, iv);
		// TODO Auto-generated constructor stub
	}
	/*
	 * ID uniquely identifies the resource.
	 * All resources start with 20**
	 * 00 - RNA (unfinished)
	 * 01 - RNA
	 * 02 - Nucleic Acid
	 * 20 - Membrane Phospholipid (unfinished)
	 * 21 - Membrane Phospholipid
	 * 22 - Membrane Cholesterol (Unfinished)
	 * 23 - Membrane Cholesterol
	 * 24 - Membrane Protien (unfinished)
	 * 25 - Membrane Protien 
	 * 40 - Rough ER Phospholipid (unfinished)
	 * 41 - Rough ER Phospholipid
	 * 42 - Rough ER Cholesterol (Unfinished)
	 * 43 - Rough ER Cholesterol
	 * 44 - Rough ER Protien (unfinished)
	 * 45 - Rough ER Protien 
	 * 50 - Smooth ER Phospholipid (unfinished)
	 * 51 - Smooth ER Phospholipid
	 * 52 - Smooth ER Cholesterol (Unfinished)
	 * 53 - Smooth ER Cholesterol
	 * 54 - Smooth ER Protien (unfinished)
	 * 55 - Smooth ER Protien 
	 * 60 - GolgiBody Phospholipid (unfinished)
	 * 61 - GolgiBody Phospholipid
	 * 62 - GolgiBody Cholesterol (Unfinished)
	 * 63 - GolgiBody Cholesterol
	 * 64 - GolgiBody Protien (unfinished)
	 * 65 - GolgiBody Protien
	 * 70 - Mitochondrial Phospholipid (unfinished)
	 * 71 - Mitochondrial Phospholipid
	 * 72 - Mitochondrial Cholesterol (Unfinished)
	 * 73 - Mitochondrial Cholesterol
	 * 74 - Mitochondrial Protien (unfinished)
	 * 75 - Mitochondrial Protien 
	 * 80 - Protien Digestion Enzyme (unfinished)
	 * 81 - Protien Digestion Enzyme
	 * 82 - Lipid Digestion Enzyme (unfinished)
	 * 83 - Lipid Digestion Enzyme
	 * 90 - Food
	 * 
	 * 
	 */
	
	@Override
	public void doCellActivity() {
		if (!planted) {
			this.doAnimation();
		}
		/*
		else {
			if (this.instructions.getDestinations().size() > this.currentStep + 1 && currentBuild == null) {
				Random rand = new Random();
				ImageView iv = new ImageView(GameWindow.getImages().get(200));
				int[] newCoords = {this.getCoords()[0], this.getCoords()[1]};
				iv.setTranslateX(newCoords[0]);
				iv.setTranslateY(newCoords[1]);
				currentBuild = new Macromolecule(this.getId(), newCoords, this.instructions, false, iv);
				currentBuild.setCurrentStep(this.currentStep);
				GameWindow.getEnviornment().getChildren().add(iv);
			}
			else if (this.instructions.getFabricationTimes().get(this.currentStep) > this.currentProgress){
				this.currentProgress++;	
			}
			else {
				currentBuild.doCellActivity();
				currentBuild = null;	
				currentProgress = 0;
			}
		}
		*/
		
	}
	private void doAnimation() {
		Timeline timeline = new Timeline();
		Random rand = new Random();
		ProductContainer destination;
		String[] arr = this.instructions.getDestinations().get(this.currentStep).split("_");
		String key = null;
		if (arr[1].contentEquals("0")) {
			key = arr[0] + "_" + (rand.nextInt((EnviornmentUtil.getOrganelleBounds(arr[0])-1)+1));
			destination = (ProductContainer)Cell.getOrganelles().get(key);
		}
		else {
			key = this.instructions.getDestinations().get(this.currentStep);
			destination = (ProductContainer)Cell.getOrganelles().get(this.instructions.getDestinations().get(this.currentStep));
		}
		
		destination.getInTransit().add(this);
		int[] dCoords = destination.getCoords();
		double duration = Math.sqrt((Math.pow((double)(dCoords[0] - this.getCoords()[0]), 2.0) + Math.pow((double)(dCoords[1] - this.getCoords()[1]), 2.0)));
		duration /= 60;
		
		final String dest = key;
		final Macromolecule ref = this;	
		
		EventHandler<ActionEvent> finalHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				ProductContainer finalDestination = (ProductContainer)Cell.getOrganelles().get(dest);
				finalDestination.recieveProduct(ref);
				ref.planted = true;
				ref.getCoords()[0] = (int)ref.getIv().getTranslateX();
				ref.getCoords()[1] = (int)ref.getIv().getTranslateY();
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
	
