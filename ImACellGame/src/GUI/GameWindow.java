package GUI;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import Models.Cell;
import Models.CellMembrane;
import Models.Cytoplasm;
import Models.GolgiApparatus;
import Models.Instructions;
import Models.Mitochondrion;
import Models.Nucleus;
import Models.Ribosome;
import Models.RoughER;
import Models.SmoothER;
import Utilities.EnviornmentUtil;
import Utilities.IMGUtil;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class GameWindow extends HBox{
	
	private ScrollPane scrollPane;
	private static Pane enviornment;
	private static VBox controls;
	private static HashMap<Integer, Image> images;
	private int tileWidth = 60;
	private Cell cell;

	public GameWindow () {
		super();
		cell = new Cell(15,10);
		this.generateLayout();
		this.loadImages();	
		this.generateEnviornment();
		GameControls gc = new GameControls();
		
		System.out.print(cell.getOrganelles().size());
		this.debugTest();	
	}
	
	private void debugTest() {
		/*
		Random rand = new Random();
		int num = rand.nextInt(EnviornmentUtil.roughERCounter - 1) + 1;
		Nucleus nucleus = (Nucleus)Cell.getOrganelles().get("Nucleus_1");
		ImageView iv = new ImageView(images.get(30));
		iv.setTranslateX(nucleus.getCoords()[0] + rand.nextInt(60));
		iv.setTranslateY(nucleus.getCoords()[1] + rand.nextInt(60));
		Ribosome ribosome = new Ribosome(300, nucleus.getCoords(),new Instructions(2019, "Rough_ER_" + num, "",""), iv);
		enviornment.getChildren().add(iv);
		ribosome.doCellActivity();
		
		Nucleus nucleus = (Nucleus)Cell.getOrganelles().get("Nucleus_1");
		Random rand = new Random();
		ArrayList<String> dest = new ArrayList<String>();
		dest.add("RoughER_" + (rand.nextInt(EnviornmentUtil.roughERCounter - 1) + 1));
		ArrayList<Integer> times = new ArrayList<Integer>();
		times.add(1);
		nucleus.getQueue().add(new Instructions(300, dest, times));
		ArrayList<String> dest2 = new ArrayList<String>();
		dest2.add("Ribosomes_1");
		dest2.add("GolgiBody_0");
		ArrayList<Integer> times2 = new ArrayList<Integer>();
		times2.add(3);
		times2.add(1);
		nucleus.getQueue().add(new Instructions(200, dest2, times2));
		
		ArrayList<String> dest3 = new ArrayList<String>();
		dest3.add("RoughER_" + (rand.nextInt(EnviornmentUtil.roughERCounter - 1) + 1));
		ArrayList<Integer> times3 = new ArrayList<Integer>();
		times3.add(1);
		nucleus.getQueue().add(new Instructions(300, dest3, times3));
		ArrayList<String> dest4 = new ArrayList<String>();
		dest4.add("Ribosomes_2");
		dest4.add("GolgiBody_0");
		ArrayList<Integer> times4 = new ArrayList<Integer>();
		times4.add(3);
		times4.add(1);
		nucleus.getQueue().add(new Instructions(200, dest4, times4));
		
		ArrayList<String> dest5 = new ArrayList<String>();
		dest5.add("RoughER_" + (rand.nextInt(EnviornmentUtil.roughERCounter - 1) + 1));
		ArrayList<Integer> times5 = new ArrayList<Integer>();
		times5.add(1);
		nucleus.getQueue().add(new Instructions(300, dest5, times5));
		ArrayList<String> dest6 = new ArrayList<String>();
		dest6.add("Ribosomes_3");
		dest6.add("GolgiBody_0");
		ArrayList<Integer> times6 = new ArrayList<Integer>();
		times6.add(3);
		times6.add(1);
		nucleus.getQueue().add(new Instructions(200, dest6, times6));
		 hjbfgynvnvtuv*/
		this.doAnimation();
	}
	private void doAnimation() {
		
		Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		
		EventHandler<ActionEvent> finalHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Cell.doAllActivity();
				GameControls.setStatsDisplay();
			}	
		};
		
		timeline.getKeyFrames().addAll(
				new KeyFrame(Duration.seconds(1), finalHandler));
		timeline.play();
		
	}

	private void generateEnviornment() {
		ArrayList<Integer> defaultList = EnviornmentUtil.getDefaultEnviornment();
		int xCoord = 0;
		int yCoord = 0;
		int counter = 0;
		for (int i = 0; i < 14; i++) {
			xCoord = 0;
			for (int j = 0; j < 19; j++) {
				int index = defaultList.get(counter);
				if (images.containsKey((index/10))) {
					ImageView iv = new ImageView(images.get((index/10)));
					iv.setRotate(90 * (index%10));
					iv.setTranslateX(xCoord);
					iv.setTranslateY(yCoord);
					this.addOrganelle(index, xCoord, yCoord, iv);
					enviornment.getChildren().add(iv);
				}
				counter++;
				xCoord += this.tileWidth;
			}
			yCoord += this.tileWidth;
		}
	}

	private void addOrganelle(int index, int xCoord, int yCoord, ImageView iv) {
		int[] arr = {xCoord, yCoord};
		int remainder = index%10;
		switch (index/10) {
		case 2:
			EnviornmentUtil.nucleusCounter++;
			this.cell.getOrganelles().put("Nucleus_" + EnviornmentUtil.nucleusCounter, new Nucleus(index, arr));
			break;
		case 10:
			EnviornmentUtil.cytoplasmCounter++;
			this.cell.getOrganelles().put("Cytoplasm_" + EnviornmentUtil.cytoplasmCounter, new Cytoplasm(index, arr));
			break;
		case 20:
			EnviornmentUtil.cellMembraneCounter++;
			this.cell.getOrganelles().put("CellMembrane_" + EnviornmentUtil.cellMembraneCounter, new CellMembrane(index, arr));
			break;
		case 21:
			EnviornmentUtil.cellMembraneCounter++;
			this.cell.getOrganelles().put("CellMembrane_" + EnviornmentUtil.cellMembraneCounter, new CellMembrane(index, arr));
			break;
		case 40:
			EnviornmentUtil.roughERCounter++;
			this.cell.getOrganelles().put("RoughER_" + EnviornmentUtil.roughERCounter, new RoughER(index, arr));
			break;
		case 50:
			EnviornmentUtil.smoothERCounter++;
			this.cell.getOrganelles().put("SmoothER_" + EnviornmentUtil.smoothERCounter, new SmoothER(index, arr));
			break;
		case 60:
			EnviornmentUtil.golgiApparatusCounter++;
			this.cell.getOrganelles().put("GolgiBody_" + EnviornmentUtil.golgiApparatusCounter, new GolgiApparatus(index, arr));
			break;
		case 70:
			if (remainder == 0) {
				EnviornmentUtil.mitochonriaCounter++;
				this.cell.getOrganelles().put("Mitochondrion_" + EnviornmentUtil.mitochonriaCounter, new Mitochondrion(index, arr));
			}
			break;
		default :
			break;
		}
		
	}

	private void generateLayout() {
		setMinSize(1400, 800);
		setMaxSize(1400, 800);
		scrollPane = new ScrollPane();
		scrollPane.setMinSize(1100, 800);
		scrollPane.setMaxSize(1100, 800);
		enviornment = new Pane();
		enviornment.setMinSize(this.tileWidth * 19, this.tileWidth * 14);
		enviornment.setMaxSize(this.tileWidth * 19, this.tileWidth * 14);
		controls = new VBox();
		controls.setMinSize(300, 800);
		controls.setMaxSize(300, 800);
		
		scrollPane.setContent(enviornment);
		this.getChildren().addAll(scrollPane, controls);
		
	}
	private void loadImages() {
		images = new HashMap<Integer, Image>(25);
		images.put(-10, IMGUtil.loadImg(IMGUtil.ENVIRONMENT));
		images.put(0, IMGUtil.loadImg(IMGUtil.NUCLEUS_CORNER));
		images.put(1, IMGUtil.loadImg(IMGUtil.NUCLEUS_EDGE));
		images.put(2, IMGUtil.loadImg(IMGUtil.NUCLEUS_CENTER));
		images.put(10, IMGUtil.loadImg(IMGUtil.CYTOPLASM));
		images.put(21, IMGUtil.loadImg(IMGUtil.CELLMEMBRANE_STRAIT));
		images.put(20, IMGUtil.loadImg(IMGUtil.CELLMEMBRANE_CURVE));
		images.put(30, IMGUtil.loadImg(IMGUtil.RIBOSOME));
		images.put(40, IMGUtil.loadImg(IMGUtil.ROUGH_ER));
		images.put(50, IMGUtil.loadImg(IMGUtil.SMOOTH_ER));
		images.put(60, IMGUtil.loadImg(IMGUtil.GOLGI_APPARATUS));
		images.put(70, IMGUtil.loadImg(IMGUtil.MITOCHONDRIAN_LEFT));
		images.put(71, IMGUtil.loadImg(IMGUtil.MITOCHONRIAN_RIGHT));
		images.put(200, IMGUtil.loadImg(IMGUtil.PROTIEN));
		images.put(201, IMGUtil.loadImg(IMGUtil.LIPID));
		
	}
	public static Pane getEnviornment() {
		return enviornment;
	}

	public ScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(ScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public static VBox getControls() {
		return controls;
	}

	public static void setControls(VBox controls) {
		GameWindow.controls = controls;
	}

	public static HashMap<Integer, Image> getImages() {
		return images;
	}

	public static void setImages(HashMap<Integer, Image> images) {
		GameWindow.images = images;
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}

	public static void setEnviornment(Pane enviornment) {
		GameWindow.enviornment = enviornment;
	}

}
