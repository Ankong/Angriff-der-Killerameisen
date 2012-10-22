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
	
	public static double gesamtLaenge;
	static double update;
	static TSP_Strecke strecke = null;
	
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
	
	/**
	 * Erstellen der Strecken
	 */
	
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
	
	public static TSP_Strecke findeStrecke (double startx, double starty, double endx, double endy) {
		TSP_Strecke strecke = null;
		for (int a = 0; a < TSP_Algorithmus.streckenList.size(); a++) {
			if ((startx == TSP_Algorithmus.streckenList.get(a).getStartxPos()) && (starty == TSP_Algorithmus.streckenList.get(a).getStartyPos()) && (endx == TSP_Algorithmus.streckenList.get(a).getEndxPos()) && (endy == TSP_Algorithmus.streckenList.get(a).getEndyPos())) {
				strecke = TSP_Algorithmus.streckenList.get(a);
			}
		}
		return strecke;
	}
	
	
	/**public static Double kleinsteLaenge (double gesamtlaenge) {
		double kleinlaenge = 0;
		
		return kleinlaenge;
	}**/
	
	public static Double pheromonUpdate (int index, TSP_Strecke strecke) {
		double update;
		if (antList.get(index).tabuList.contains(strecke)) {
			update = v_heur_Pheromon / antList.get(index).getGesamtlaenge();
		}
		else {
			update = 0;
		}
		return update;
	}
	
	public static TSP_Strecke Stadtauswahl(int ameisenid, double startx, double starty) {
		double auswahl = Double.MIN_VALUE;
		double summe_pos;
		TSP_Strecke strecke = null;
		
		for (int k= 0; k < streckenList.size(); k++) {
			if ( (startx == streckenList.get(k).getStartxPos() ) && ( starty == streckenList.get(k).getStartyPos() ) ) {
				summe_pos = berechne_summe_strecken(k, ameisenid);
				for (int i = k; i < (v_Stadte - 1 + k); i++) {
					posible = ( TSP_Ameisen.check_posibility(ameisenid, streckenList.get(i).getEndxPos(), streckenList.get(i).getEndyPos()) ) ;
					if ( ( berechne(i, ameisenid, summe_pos) > auswahl ) && (posible) ) {
						auswahl = berechne(i, ameisenid, summe_pos);
						strecke = streckenList.get(i);
					}
				}
			break;
			}
		}
		return strecke;
	}
	
	public static double berechne_summe_strecken (int index, int amid) {
		boolean moglich;
		double summe;
		
		summe = 0;
		moglich = false;
		
		for (int j = index; j < (v_Stadte  - 1 + index); j++) {
			moglich = ( TSP_Ameisen.check_posibility(amid, streckenList.get(j).getEndxPos(), streckenList.get(j).getEndyPos()) ) ;
			if (moglich = true) {
				summe += (Math.pow(streckenList.get(index).getPheromon(), v_Pheromon)) * (Math.pow((1 / streckenList.get(index).getLaenge() ), (v_heuristisch)));
			}
		}
		
		return summe;
	}
	
	public static double berechne (int index, int amid, double summe) {
		double posibility;
		double gesamt;
		
		posibility = (Math.pow(streckenList.get(index).getPheromon(), v_Pheromon)) * (Math.pow((1 / streckenList.get(index).getLaenge() ), (v_heuristisch)));
		
		gesamt = posibility / summe;
		
		return gesamt;
	}
	
	public static void iterationen_durchlaufen() {
		for (int b = 0; b < TSP_Algorithmus.v_Iteration; b++) {
			//Liste leeren und neue Ameisen für neue zufällige Städte erstellen und setzen, nach dem ersten Durchlauf
			if (!TSP_Algorithmus.antList.isEmpty() & b!=0) {
				TSP_Algorithmus.antList.clear();
				TSP_Algorithmus.ameisen_generieren();
			}
			for (int l = 0; l < TSP_Algorithmus.antList.size(); l++) {
				gesamtLaenge = 0;
				if (!TSP_Algorithmus.antList.get(l).tabuList.isEmpty()) {
					TSP_Algorithmus.antList.get(l).tabuList.clear();
				} 
							
				for (int t = 0; t < Listener_Oeffnen.cityList.size() + 1  ; t++) {	
					strecke = TSP_Algorithmus.Stadtauswahl(l, TSP_Algorithmus.antList.get(l).getxPos(), TSP_Algorithmus.antList.get(l).getyPos());
					gesamtLaenge = gesamtLaenge + strecke.getLaenge();
					TSP_Ameisen.add_city(l, strecke);
					TSP_Ameisen.next_city(l, strecke);
					if (TSP_Algorithmus.antList.get(l).getTabuList().size() == Listener_Oeffnen.cityList.size()-1 ) {
						strecke = TSP_Algorithmus.findeStrecke(strecke.getEndxPos(), strecke.getEndyPos(), TSP_Algorithmus.antList.get(l).getTabuList().get(0).getStartxPos(), TSP_Algorithmus.antList.get(l).getTabuList().get(0).getStartyPos());
						TSP_Algorithmus.antList.get(l).getTabuList().add(strecke);
						TSP_Ameisen.next_city(l, strecke);
						break;
					}	
				}
				TSP_Algorithmus.antList.get(l).setGesamtlaenge(Math.round((100 *gesamtLaenge))/100.0);
				
				for (int a = 0; a < TSP_Algorithmus.antList.get(l).tabuList.size(); a++) {
					update = TSP_Algorithmus.pheromonUpdate(l, TSP_Algorithmus.antList.get(l).tabuList.get(a));
					TSP_Algorithmus.antList.get(l).tabuList.get(a).setPheromon(TSP_Algorithmus.antList.get(l).tabuList.get(a).getPheromon()+update);
				}					
			}
			TSP_Algorithmus.v_init_Pheromon = (1 - TSP_Algorithmus.v_Verdunst) * TSP_Algorithmus.v_init_Pheromon;
			GUI.draw_TSP();
			GUI.frame_refresh();
		}	
	}
	
	public static double aver_strecke() {
		double laenge = 0;
		
		for (int h = 0; h < antList.size(); h++) {
			laenge += antList.get(h).getGesamtlaenge();
		}
		
		laenge = laenge / antList.size();
		
		return laenge;
	}
	
	public static double opt_strecke() {
		double laenge = Double.MAX_VALUE;
		
		for (int h = 0; h < antList.size(); h++) {
			if (antList.get(h).getGesamtlaenge() < laenge) {
				laenge = antList.get(h).getGesamtlaenge();
			}
		}
		
		return laenge;
	}
	
	public static int opt_ameise() {
		double laenge = Double.MAX_VALUE;
		int opt = 0;
		
		for (int h = 0; h < antList.size(); h++) {
			if (antList.get(h).getGesamtlaenge() < laenge) {
				laenge = antList.get(h).getGesamtlaenge();
				opt = h;
			}
		}
		
		return opt;
	}
}
