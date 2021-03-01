package App;

import GUI.GameWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Runner extends Application {

	@Override
	public void start(Stage mainStage) throws Exception {
		
		GameWindow gameWindow = new GameWindow();
		
		Scene scene = new Scene(gameWindow,1400, 800);
		mainStage.setScene(scene);
		mainStage.setTitle("I am a Cell : Game");
		mainStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
