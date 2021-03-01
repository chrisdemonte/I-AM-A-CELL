package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.image.Image;

public class IMGUtil {
	public static final String CELLMEMBRANE_CURVE = "assets/CellMembrane_Curve.png";
	public static final String CELLMEMBRANE_STRAIT = "assets/CellMembrane_Strait.png";
	public static final String CYTOPLASM = "assets/Cytoplasm.png";
	public static final String ENVIRONMENT= "assets/Enviornment.png";
	public static final String GOLGI_APPARATUS= "assets/GolgiApparatus.png";
	public static final String LIPID= "assets/Lipid.png";
	public static final String MITOCHONDRIAN_LEFT= "assets/Mitochondrian_LCorner.png";
	public static final String MITOCHONRIAN_RIGHT= "assets/Mitochondrian_RCorner.png";
	public static final String NUCLEUS_CENTER= "assets/Nucleus_Center.png";
	public static final String NUCLEUS_EDGE= "assets/Nucleus_Edge.png";
	public static final String NUCLEUS_CORNER = "assets/Nucleus_Corner.png";
	public static final String PROTIEN = "assets/Protien.png";
	public static final String RIBOSOME= "assets/Ribosome.png";
	public static final String ROUGH_ER= "assets/RoughER.png";
	public static final String SMOOTH_ER = "assets/SmoothER.png";
	
	
	public static Image loadImg(String url) {
		FileInputStream fis = null;
		Image image = null;
		try {
			fis = new FileInputStream( new File(url));
			image = new Image(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return image;
	}
	public static void saveTest() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("assets/testfile.dat"));
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}