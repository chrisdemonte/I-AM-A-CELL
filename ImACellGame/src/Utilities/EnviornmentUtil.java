package Utilities;

import java.util.ArrayList;

public class EnviornmentUtil {
	
	public static int nucleusCounter = 0;
	public static int mitochonriaCounter = 0;
	public static int smoothERCounter = 0;
	public static int roughERCounter = 0;
	public static int golgiApparatusCounter = 0;
	public static int lyosomeCounter = 0;
	public static int ribosomeCounter = 0;
	public static int cellMembraneCounter = 0;
	public static int cytoplasmCounter = 0;
	public static int vesicleCounter = 0;
	public static int enzymeCounter = 0;
	
	public static ArrayList<Integer> getDefaultEnviornment (){
		ArrayList<Integer> list = new ArrayList<Integer>();
		/* Rows 1-2
		 * enviorment spaces added
		 */
		addSpace(list, 38, -100);
		
		/*
		 * row 6
		 * top slice of cell
		 */
		addSpace(list,  2, -100);
		list.add(203);
		addSpace(list, 13, 213);
		list.add(200);
		addSpace(list, 2, -100);
		
		/*
		 * row 7
		 * Mitochondrion start
		 */
		addSpace(list,  2, -100);
		list.add(212);
		list.add(100);
		list.add(712);
		list.add(702);
		addSpace(list, 10, 100);
		list.add(210);
		addSpace(list, 2, -100);
		/*
		 * row 8
		 * Mitochondrion end
		 */
		addSpace(list,  2, -100);
		list.add(212);
		list.add(100);
		list.add(700);
		list.add(710);
		addSpace(list, 10, 100);
		list.add(210);
		addSpace(list, 2, -100);
		
		/*
		 * row 9
		 */
		addSpace(list,  2, -100);
		list.add(212);
		addSpace(list, 10, 100);
		list.add(601);
		list.add(601);
		list.add(601);
		list.add(210);
		addSpace(list, 2, -100);
		
		/*
		 * row 10
		 */
		addSpace(list,  2, -100);
		list.add(212);
		addSpace(list, 2, 100);
		list.add(3);
		list.add(13);
		list.add(0);
		list.add(401);
		list.add(401);
		list.add(501);
		list.add(501);
		list.add(501);
		list.add(601);
		list.add(601);
		list.add(601);
		list.add(210);
		addSpace(list, 2, -100);
		
		/*
		 * row 11
		 */
		addSpace(list,  2, -100);
		list.add(212);
		addSpace(list, 2, 100);
		list.add(12);
		list.add(20);
		list.add(10);
		list.add(401);
		list.add(401);
		list.add(501);
		list.add(501);
		list.add(501);
		list.add(601);
		list.add(601);
		list.add(601);
		list.add(210);
		addSpace(list, 2, -100);
		
		/*
		 * row 12
		 */
		addSpace(list,  2, -100);
		list.add(212);
		addSpace(list, 2, 100);
		list.add(2);
		list.add(11);
		list.add(1);
		list.add(401);
		list.add(401);
		list.add(501);
		list.add(501);
		list.add(501);
		list.add(601);
		list.add(601);
		list.add(601);
		list.add(210);
		addSpace(list, 2, -100);
		
		/*
		 * row 13
		 */
		addSpace(list,  2, -100);
		list.add(212);
		addSpace(list, 4, 100);
		list.add(401);
		list.add(401);
		list.add(501);
		list.add(501);
		list.add(501);
		list.add(501);
		list.add(601);
		list.add(601);
		list.add(601);
		list.add(210);
		addSpace(list, 2, -100);
		
		/*
		 * row 14
		 */
		addSpace(list,  2, -100);
		list.add(212);
		addSpace(list, 6, 100);
		list.add(601);
		list.add(601);
		list.add(601);
		list.add(601);
		list.add(601);
		list.add(601);
		list.add(601);
		list.add(210);
		addSpace(list, 2, -100);
		
		/*
		 * row 15
		 */
		addSpace(list,  2, -100);
		list.add(202);
		addSpace(list, 13, 211);
		list.add(201);
		addSpace(list, 2, -100);
		
		
		/*Rows 16- 20
		 * enviornment spaces added
		 */
		addSpace(list, 38, -100);
		
		return list;
	}
	private static void addSpace(ArrayList<Integer> list, int spaces, int id){
		for (int i = 0; i < spaces; i++) {
			list.add(id);
		}
		
	}
	public static int getOrganelleBounds (String str) {
		if (str.contentEquals("SmoothER")) {
			return smoothERCounter;
		}
		else if (str.contentEquals("RoughER")) {
			return roughERCounter;
		}
		else if (str.contentEquals("Cytoplasm")) {
			return cytoplasmCounter;
		}
		else if (str.contentEquals("CellMembrane")) {
			return cellMembraneCounter;
		}
		else if (str.contentEquals("Mitochondria")) {
			return mitochonriaCounter;
		}
		else if (str.contentEquals("Enzyme")) {
			return enzymeCounter;
		}
		else  {
			return golgiApparatusCounter;
		}
	}

}
