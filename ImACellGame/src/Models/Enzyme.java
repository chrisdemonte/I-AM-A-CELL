package Models;

import java.util.HashMap;
import java.util.Random;

import Utilities.EnviornmentUtil;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Enzyme extends Producer {


	public Enzyme(int id, int[] coords, Instructions instructions, boolean planted, ImageView iv) {
		super(id, "Enzyme", "Does stuff", coords, null , instructions, planted, iv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCellActivity() {
		if (!planted) {
			this.doAnimation();
		}
		else {
			this.enzymeSwitch();
		}
		
	}
	
	private void enzymeSwitch() {
		switch (this.getId()) {
		case 2080:
			if (Cell.getATP()>=5 && Cell.getMolecules().getStarch() > 0) {
				Cell.changeATP(-5);
				Cell.getMolecules().changeGlucose(1);
			}
			break;
		case 2082:
			if (Cell.getATP()>=5 ) {
				Cell.changeATP(-5);
				Cell.getMolecules().changeAminoacid(1);
			}
			break;
		case 2084:
			if (Cell.getATP()>=5) {
				Cell.changeATP(-5);
				Cell.getMolecules().changeFattyAcid(1);
			}
			break;
		case 2086:
			if (Cell.getATP()>=5) {
				Cell.changeATP(-5);
				Cell.getMolecules().changeStarch(1);
			}
			break;
		case 2088:
			if (Cell.getATP()>=5 ) {
			Cell.changeATP(-5);
			Cell.getMolecules().changeWater(1);
			}
			break;
		case 2090:
			if (Cell.getATP()>=5 ) {
			Cell.changeATP(-5);
			Cell.getMolecules().changeWaste(-1);
			}
			break;
		}
		
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
		final Enzyme ref = this;	
		
		EventHandler<ActionEvent> finalHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				ProductContainer finalDestination = (ProductContainer)Cell.getOrganelles().get(dest);
				finalDestination.recieveProduct(ref);
				ref.planted = true;
				EnviornmentUtil.enzymeCounter++;
				Cell.getOrganelles().put("Enzyme_" + EnviornmentUtil.enzymeCounter, ref);
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
