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
		
		double[] startp = new double[2];
		double[] endp = new double[2];
		
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
			startp[0] = TSP_Algorithmus.antList.get(l).getxPos();
			startp[1] = TSP_Algorithmus.antList.get(l).getyPos();
			TSP_Algorithmus.antList.get(l).getTabuList().add(startp);
			
			for (int t = 0; t < Listener_Oeffnen.cityList.size() + 1; t++) {	
				endp = TSP_Algorithmus.kuerzeste_Dist(l, TSP_Algorithmus.antList.get(l).getxPos(), TSP_Algorithmus.antList.get(l).getyPos());
				TSP_Ameisen.add_city(l, endp);
				TSP_Ameisen.next_city(l, endp);
				TSP_Ameisen.printListDouble(TSP_Algorithmus.antList.get(l).getTabuList());
			} //while (TSP_Algorithmus.antList.get(l).getTabuList().size() == (Listener_Oeffnen.cityList.size() + 1));
		}

		
		// Aktualisierung der Zeichnung
		
		GUI.draw_TSP();
		GUI.frame_refresh();
	}

}
