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
	public static double v_Pheromon;
	public static double v_heuristisch;
	public static double v_Verdunst;
	public static double v_init_Pheromon;
	public static double v_heur_Pheromon;
	static boolean posible;
	/**
	 * Einlesen der Parameter aus den Textfeldern
	 */
	
	public static void parameter_einlesen() {
		v_Ameisen = Integer.parseInt(GUI.t_Ameisen.getText());
		v_Stadte = Integer.parseInt(GUI.t_Stadte.getText());
		v_Iteration = Integer.parseInt(GUI.t_Iteration.getText());
		v_Pheromon = Double.parseDouble(GUI.t_Pheromon.getText());
		v_heuristisch = Double.parseDouble(GUI.t_heuristisch.getText());
		v_Verdunst = (double)(GUI.s_Verdunst.getValue())/100;
		v_init_Pheromon = Double.parseDouble(GUI.t_init_Pheromon.getText());
		v_heur_Pheromon = Double.parseDouble(GUI.t_heur_Pheromon.getText());
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
		double qparam = v_heur_Pheromon;
		double update;
		if (antList.get(index).tabuList.contains(strecke)) {
			update = qparam / antList.get(index).getGesamtlaenge();
		}
		else {
			update = 0;
		}
		return update;
	}
	public TSP_Strecke Stadtauswahl(int ameisenid, double startx, double starty) {
		TSP_Strecke strecke = null;
		double auswahl = Integer.MAX_VALUE;
		
		for (int k= 0; k < streckenList.size(); k++) {
			if ( (startx == streckenList.get(k).getStartxPos() ) && ( starty == streckenList.get(k).getStartyPos() ) ) {
				for (int i = k; k <= v_Stadte + k; i++) {
					posible = ( TSP_Ameisen.check_posibility(ameisenid, streckenList.get(i).getEndxPos(), streckenList.get(i).getEndyPos()) ) ;
					if ( ( berechne(i, ameisenid, startx, starty) < auswahl ) && (posible) ) {
						auswahl = berechne(i, ameisenid, startx, starty);
						strecke = streckenList.get(k);
					}
				}
			break;
			}
		}
		return strecke;
	}
	public double berechne (int index, int amid, double beginnx, double beginny) {
		double wert1, wert2, gesamtwert;
		wert2 = 0;
		boolean moeglich;
		
		wert1 = (Math.pow(streckenList.get(index).getPheromon(), v_Pheromon)) * (Math.pow(streckenList.get(index).getLaenge(), (-v_heuristisch)));
		for (int j = index; j<= v_Stadte + index; j++) {
			moeglich = ( TSP_Ameisen.check_posibility(amid, streckenList.get(j).getEndxPos(), streckenList.get(j).getEndyPos()) ) ;
			if (moeglich = true) {
				wert2 += (Math.pow(streckenList.get(index).getPheromon(), v_Pheromon)) * (Math.pow(streckenList.get(index).getLaenge(), (-v_heuristisch)));
			}
		}
		gesamtwert = wert1/wert2;
		return gesamtwert;
	}
}
