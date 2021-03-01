package Models;

import java.util.HashMap;
import java.util.Random;

import GUI.GameWindow;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class RNA extends Producer{

	public RNA(int id, int[] coords,Instructions instructions, boolean planted, ImageView iv) {
		super(id, "RNA", "The instructions read by Ribosomes to produce protiens", coords, null, instructions, planted, iv);
	}

	@Override
	public void doCellActivity() {
		if (!planted) {
			planted = true;
			this.doAnimation();
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
		final Producer ref = this;	
		EventHandler<ActionEvent> finalHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Ribosome finalDestination = (Ribosome)Cell.getOrganelles().get(dest);
				finalDestination.setInstructions(ref.getInstructions());
				finalDestination.setCurrentStep(1);
				ref.getCoords()[0] = (int)ref.getIv().getTranslateX();
				ref.getCoords()[1] = (int)ref.getIv().getTranslateY();
				GameWindow.getEnviornment().getChildren().remove(ref.getIv());
				timeline.stop();
			}	
		};
		timeline.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, 
						new KeyValue(iv.translateXProperty(), this.getCoords()[0]),
						new KeyValue(iv.translateYProperty(), this.getCoords()[1])),
				new KeyFrame(Duration.seconds(duration), finalHandler,
						new KeyValue(iv.translateXProperty(), dCoords[0]),
						new KeyValue(iv.translateYProperty(), dCoords[1])));
		timeline.play();
	}

}
