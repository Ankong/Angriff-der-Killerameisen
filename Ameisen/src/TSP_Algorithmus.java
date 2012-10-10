
import java.util.ArrayList;
import java.util.List;

public class TSP_Algorithmus {
	
	/**
	 * Klasse zur Berechnung des Ameisen-Algorithmus
	 */

	/**
	 * Klassenrelevante Variablen
	 */
	
	public static List<TSP_Ameisen> antList = new ArrayList<TSP_Ameisen>();
	public static List<TSP_Strecke> streckenList = new ArrayList<TSP_Strecke>();
	
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
			zufall = (int)( Math.random() * v_Stadte );
			TSP_Ameisen ameisen = new TSP_Ameisen(i, Listener_Oeffnen.list.get(zufall).getId(), Listener_Oeffnen.list.get(zufall).getxPos(), Listener_Oeffnen.list.get(zufall).getyPos());
			antList.add(ameisen);	
		}
	}
	
	public static void strecken_generieren() {
		for (int j = 0; j < Listener_Oeffnen.list.size(); j++) { 
		try { 
			for (int k = 0; k < Listener_Oeffnen.list.size(); k++) {
				TSP_Strecke element = new TSP_Strecke(Listener_Oeffnen.list.get(j).getxPos(), Listener_Oeffnen.list.get(j).getyPos(), Listener_Oeffnen.list.get(k).getxPos(), Listener_Oeffnen.list.get(k).getyPos(), Math.sqrt( Math.pow( ( Listener_Oeffnen.list.get(k).getxPos() - Listener_Oeffnen.list.get(j).getxPos() ), 2) + Math.pow( ( Listener_Oeffnen.list.get(k).getyPos() - Listener_Oeffnen.list.get(j).getyPos() ), 2) ), v_init_Pheromon);
				streckenList.add(element);
			}	
		} catch (IndexOutOfBoundsException e){ 
			System.out.println("Streckenfail");
			}
		}
	}
	
}
