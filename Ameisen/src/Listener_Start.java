import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener_Start implements ActionListener {

	/**
	 * Actionlistener zum Starten des Algorythmus über den Startbutton
	 */
	public static double gesamtLaenge;
	
	public void actionPerformed(ActionEvent e) {
		
		/**
		 * Klassenrelevante Variablen
		 */
		
		
		TSP_Strecke strecke = null;
		double update;
		
		/**
		 * Liste leeren
		 */
		
		if (!TSP_Algorithmus.antList.isEmpty()) {
			TSP_Algorithmus.antList.clear();
		}
		
		/**
		 * Ameisen werden generiert
		 */
		
		TSP_Algorithmus.parameter_einlesen();
		TSP_Algorithmus.ameisen_generieren();
		TSP_Algorithmus.strecken_generieren();
		
		
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
					//strecke = TSP_Algorithmus.kuerzeste_Dist(l, TSP_Algorithmus.antList.get(l).getxPos(), TSP_Algorithmus.antList.get(l).getyPos());
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
		
		// Aktualisierung der Zeichnung
		
		//GUI.draw_TSP();
		//GUI.frame_refresh(); 
	}

}
