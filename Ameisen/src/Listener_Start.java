import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener_Start implements ActionListener {

	/**
	 * Actionlistener zum Starten des Algorythmus über den Startbutton
	 */
	
	public void actionPerformed(ActionEvent e) {
		
		/**
		 * Klassenrelevante Variablen
		 */
		
		
		TSP_Strecke strecke = null;
		
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
		
		
		
		for (int l = 0; l < TSP_Algorithmus.antList.size(); l++) {
			
			if (!TSP_Algorithmus.antList.get(l).tabuList.isEmpty()) {
				TSP_Algorithmus.antList.get(l).tabuList.clear();
			} 
						
			for (int t = 0; t < Listener_Oeffnen.cityList.size() + 1  ; t++) {	
				strecke = TSP_Algorithmus.kuerzeste_Dist(l, TSP_Algorithmus.antList.get(l).getxPos(), TSP_Algorithmus.antList.get(l).getyPos());
				TSP_Ameisen.add_city(l, strecke);
				TSP_Ameisen.next_city(l, strecke);
				System.out.println(TSP_Algorithmus.antList.get(l));
				if (TSP_Algorithmus.antList.get(l).getTabuList().size() == Listener_Oeffnen.cityList.size()-1 ) {
					strecke = TSP_Algorithmus.findeStrecke(strecke.getEndxPos(), strecke.getEndyPos(), TSP_Algorithmus.antList.get(l).getTabuList().get(0).getStartxPos(), TSP_Algorithmus.antList.get(l).getTabuList().get(0).getStartyPos());
					TSP_Algorithmus.antList.get(l).getTabuList().add(strecke);
					TSP_Ameisen.next_city(l, strecke);
					break;
				}	
			}
		}
		
		// Aktualisierung der Zeichnung
		
		GUI.draw_TSP();
		GUI.frame_refresh(); 
	}

}
