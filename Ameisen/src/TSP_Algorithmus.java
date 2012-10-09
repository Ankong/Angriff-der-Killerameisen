
import java.util.ArrayList;
import java.util.List;

public class TSP_Algorithmus {
	
	/**
	 * Klasse zur Berechnung des Ameisen-Algorithmus
	 */

	/**
	 * Klassenrelevante Variablen
	 */
	
	public static List<Ameisen> antList = new ArrayList<Ameisen>();
	
	/**
	 * Parametervariablen
	 */
	
	public static int v_Ameisen;
	public static int v_Stadte;
	public static int v_Iteration;
	public static int v_Pheromon;
	public static int v_heuristisch;
	public static double v_Verdunst;
	public static int v_init_Pheromon;
	public static int v_heur_Pheromon;
	
	/**
	 * Einlesen der Parameter aus den Textfeldern
	 */
	
	public static void parameter_einlesen() {
		v_Ameisen = Integer.parseInt(GUI.t_Ameisen.getText());
		v_Stadte = Integer.parseInt(GUI.t_Stadte.getText());
		v_Iteration = Integer.parseInt(GUI.t_Iteration.getText());
		v_Pheromon = Integer.parseInt(GUI.t_Pheromon.getText());
		v_heuristisch = Integer.parseInt(GUI.t_heuristisch.getText());
		v_Verdunst = (double)(GUI.s_Verdunst.getValue())/100;
		v_init_Pheromon = Integer.parseInt(GUI.t_init_Pheromon.getText());
		v_heur_Pheromon = Integer.parseInt(GUI.t_heur_Pheromon.getText());
	}
	
	/**
	 * Erstellen der Ameisen
	 */
	
	public static void ameisen_generieren() {
		int zufall;
		
		for (int i = 0; i < v_Ameisen; i++) {
			zufall = (int)(Math.random() * v_Stadte);
			Ameisen ameisen = new Ameisen(i, OeffnenListener.list.get(zufall).getId(), OeffnenListener.list.get(zufall).getxPos(), OeffnenListener.list.get(zufall).getyPos());
			antList.add(ameisen);	
		}
	}
	
}
