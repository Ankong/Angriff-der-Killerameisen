import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener_Start implements ActionListener {

	/**
	 * Actionlistener zum Starten des Algorythmus über den Startbutton
	 */
	
	public void actionPerformed(ActionEvent e) {
		
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
		
		// Aktualisierung der Zeichnung
		
		GUI.draw_TSP();
		GUI.frame_refresh();
	}

}
