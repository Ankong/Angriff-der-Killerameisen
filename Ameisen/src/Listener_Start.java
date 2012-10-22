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
		
		
		/**
		 * Liste leeren
		 */
		
		if (!TSP_Algorithmus.antList.isEmpty()) {
			TSP_Algorithmus.antList.clear();
		}
		
		
		TSP_Algorithmus.parameter_einlesen();
		TSP_Algorithmus.ameisen_generieren();
		TSP_Algorithmus.strecken_generieren();
		TSP_Algorithmus.iterationen_durchlaufen();
	}

}
