import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener_Start implements ActionListener {

	/**
	 * Actionlistener zum Starten des Algorythmus �ber den Startbutton
	 */
	
	/**
	 * Klassenrelevante Variablen
	 */
	

	
	public void actionPerformed(ActionEvent e) {
		
		/**
		 * Liste leeren
		 */
		
		if (!TSP_Algorithmus.antList.isEmpty()) {
			TSP_Algorithmus.antList.clear();
		}
		
		GUI.p_Erg.setVisible(true);
		TSP_Algorithmus.parameter_einlesen();
		TSP_Algorithmus.ameisen_generieren();
		TSP_Algorithmus.strecken_generieren();
		//TSP_Algorithmus.iterationen_durchlaufen();
		TSP_Algorithmus tsp_Algorithmus = new TSP_Algorithmus();
		tsp_Algorithmus.start();
	}
}
