package GUI;

import java.util.ArrayList;

import Models.Cell;
import Models.Instructions;
import Models.Nucleus;
import Utilities.EnviornmentUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class GameControls {
	
	public static Label statsDisplay;
	private VBox instructionList;
	private ComboBox<String> choices;
	private ArrayList<ComboBox<String>> destinations;
	private ArrayList<TextField> times;
	private Button addButton;
	private Button submitButton;
	
	ArrayList<String> firstSelections;
	ArrayList<String> secondSelections;
	ArrayList<String> thirdSelections;
	
	Instructions inst;
	
	public GameControls() {
		this.generateLayout();
		this.setButtonActions();
	}

	private void setButtonActions() {
		choices.setOnAction(e->{
			this.resetLayout();
			String selection = choices.getValue();
			if (selection.contentEquals("Ribosome")) {
				this.fillWithRoughER(firstSelections);
				this.times.get(0).setText("300");
			}
			else if (selection.contentEquals("RNA")) {
				this.fillWithRibsomes(firstSelections);
				this.fillWithGolgi(secondSelections);
				this.fillWithCytoplasm(secondSelections);
				this.times.get(0).setText("2000");
			}
			
			ObservableList<String> firstDest = 
				    FXCollections.observableArrayList(firstSelections);
			destinations.add(new ComboBox<String>(firstDest));
			times.add(new TextField("1"));
			this.instructionList.getChildren().addAll( destinations.get(0), times.get(1));
			
			if (secondSelections.size() > 0) {
				ObservableList<String> secondDest = 
					    FXCollections.observableArrayList(secondSelections);
				destinations.add(new ComboBox<String>(secondDest));
				this.times.add(new TextField("1"));
				this.instructionList.getChildren().addAll( destinations.get(1), times.get(2));
			}
		});
		submitButton.setOnAction(e->{
			ArrayList<String> dests = new ArrayList<String>();
			for (int i = 0; i < destinations.size(); i++) {
				dests.add(destinations.get(i).getValue());
			}
			ArrayList<Integer> theTimes = new ArrayList<Integer>();
			for (int i = 1; i < times.size(); i++) {
				theTimes.add(Integer.parseInt(times.get(i).getText()));
			}
			Instructions instruction = new Instructions(Integer.parseInt(times.get(0).getText()), dests, theTimes);
			Nucleus nucleus = (Nucleus)Cell.getOrganelles().get("Nucleus_1");
			nucleus.getQueue().add(instruction);
			
		});
		
	}

	private void generateLayout() {
		
		this.instructionList = new VBox(5);
		this.instructionList.setMinSize(300, 500);
		this.instructionList.setMaxSize(300, 500);
		
		this.statsDisplay = new Label();
		this.statsDisplay.setMinSize(300, 250);
		this.statsDisplay.setMaxSize(300, 250);
		this.setStatsDisplay();
		
		ObservableList<String> ribosomeOrRNA = 
			    FXCollections.observableArrayList(
			        "Ribosome",
			        "RNA"
			    );
		choices = new ComboBox<String>(ribosomeOrRNA);
		
		destinations = new ArrayList<ComboBox<String>>();
		times = new ArrayList<TextField>();
		times.add(new TextField());
		firstSelections = new ArrayList<String>();
		secondSelections= new ArrayList<String>();
		thirdSelections= new ArrayList<String>();
		
		addButton = new Button("Add Instruction");
		submitButton = new Button("Send to Nucleus");
		
		this.instructionList.getChildren().addAll(choices, times.get(0));
		GameWindow.getControls().getChildren().addAll(statsDisplay, instructionList, submitButton);
		
	}
	public static void setStatsDisplay() {
		statsDisplay.setText(Cell.getMolecules().toString() + "\nATP = " + Cell.getATP());
	}
	private void resetLayout() {
		for (int i = instructionList.getChildren().size() - 1; i > 1; i--) {
			instructionList.getChildren().remove(i);
		}
		for (int i = times.size() - 1; i > 0; i--) {
			times.remove(i);
		}
		destinations.clear();
		firstSelections.clear();
		secondSelections.clear();
		thirdSelections.clear();
		
	}
	private void fillWithRoughER (ArrayList<String> array){
		for (int i = 0; i <= EnviornmentUtil.roughERCounter; i++) {
			array.add("RoughER_" + i);
		}
	}
	private void fillWithRibsomes (ArrayList<String> array){
		for (int i = 0; i <= EnviornmentUtil.ribosomeCounter; i++) {
			array.add("Ribosomes_" + i);
		}
	}
	private void fillWithGolgi (ArrayList<String> array){
		for (int i = 0; i <= EnviornmentUtil.golgiApparatusCounter; i++) {
			array.add("GolgiBody_" + i);
		}
	}
	private void fillWithCytoplasm (ArrayList<String> array){
		for (int i = 0; i <= EnviornmentUtil.cytoplasmCounter; i++) {
			array.add("Cytoplasm_" + i);
		}
	}
	private void fillWithMembrane (ArrayList<String> array){
		for (int i = 0; i <= EnviornmentUtil.cellMembraneCounter; i++) {
			array.add("CellMembrane_" + i);
		}
	}

}
