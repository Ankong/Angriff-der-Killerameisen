import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener_Stop implements ActionListener {

	/**
	 * Actionlistener zum Beenden des Algorythmus �ber den Stopbutton
	 */
	
	
	public void actionPerformed(ActionEvent e) {
		TSP_Algorithmus.stop_btn = true;
		GUI.progressBar.setForeground(Color.RED);
	}	
}
