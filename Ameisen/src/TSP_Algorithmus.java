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
	public static double v_init_Pheromon;
	public static int v_heur_Pheromon;
	static boolean posible;
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
		v_init_Pheromon = Double.parseDouble(GUI.t_init_Pheromon.getText());
		v_heur_Pheromon = Integer.parseInt(GUI.t_heur_Pheromon.getText());
	}
	
	/**
	 * Erstellen der Ameisen
	 */
	
	public static void ameisen_generieren() {
		int zufall;
		
		for (int i = 0; i < v_Ameisen; i++) {
			zufall = (int)( Math.random() * v_Stadte );
			TSP_Ameisen ameisen = new TSP_Ameisen(Listener_Oeffnen.cityList.get(zufall).getId(), Listener_Oeffnen.cityList.get(zufall).getxPos(), Listener_Oeffnen.cityList.get(zufall).getyPos(), 0);
			antList.add(ameisen);
		}
	}
	
	public static void strecken_generieren() {
		for (int j = 0; j < Listener_Oeffnen.cityList.size(); j++) { 
		try { 
			for (int k = 0; k < Listener_Oeffnen.cityList.size(); k++) {
				TSP_Strecke element = new TSP_Strecke(Listener_Oeffnen.cityList.get(j).getxPos(), Listener_Oeffnen.cityList.get(j).getyPos(), Listener_Oeffnen.cityList.get(k).getxPos(), Listener_Oeffnen.cityList.get(k).getyPos(), Math.sqrt( Math.pow( ( Listener_Oeffnen.cityList.get(k).getxPos() - Listener_Oeffnen.cityList.get(j).getxPos() ), 2) + Math.pow( ( Listener_Oeffnen.cityList.get(k).getyPos() - Listener_Oeffnen.cityList.get(j).getyPos() ), 2) ), v_init_Pheromon);
				if (k != j) {
					streckenList.add(element);
				}
			}	
		} catch (IndexOutOfBoundsException e){ 
			System.out.println("Streckenfail");
			}
		}
	}
	
	public static TSP_Strecke kuerzeste_Dist (int ameisenid, double startx, double starty) {
		TSP_Strecke strecke = null;
		double kurz = Integer.MAX_VALUE;
		
		for (int k= 0; k < streckenList.size(); k++) {
			if ( (startx == streckenList.get(k).getStartxPos() ) && ( starty == streckenList.get(k).getStartyPos() ) ) {
				posible = ( TSP_Ameisen.check_posibility(ameisenid, streckenList.get(k).getEndxPos(), streckenList.get(k).getEndyPos()) ) ;
				if ( ( streckenList.get(k).getLaenge() < kurz ) && (posible) ) {
					kurz = streckenList.get(k).getLaenge();
					strecke = streckenList.get(k);
				}	
			}
		}
		return strecke;
		
	}
	
	public static TSP_Strecke findeStrecke (double startx, double starty, double endx, double endy) {
		TSP_Strecke strecke = null;
		for (int a = 0; a < TSP_Algorithmus.streckenList.size(); a++) {
			if ((startx == TSP_Algorithmus.streckenList.get(a).getStartxPos()) && (starty == TSP_Algorithmus.streckenList.get(a).getStartyPos()) && (endx == TSP_Algorithmus.streckenList.get(a).getEndxPos()) && (endy == TSP_Algorithmus.streckenList.get(a).getEndyPos())) {
				strecke = TSP_Algorithmus.streckenList.get(a);
			}
		}
		return strecke;
	}
	
	
	public static Double kleinsteLaenge (double gesamtlaenge) {
		double kleinlaenge = 0;
		
		return kleinlaenge;
	}
	
	public static Double pheromonUpdate (int index, TSP_Strecke strecke) {
		int qparam = v_heur_Pheromon;
		double update;
		if (antList.get(index).tabuList.contains(strecke)) {
			update = qparam / antList.get(index).getGesamtlaenge();
		}
		else {
			update = 0;
		}
		return update;
	}
	
}
