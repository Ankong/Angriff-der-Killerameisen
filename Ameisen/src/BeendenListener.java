import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeendenListener implements ActionListener {

	/**
	 * Actionlistener zum Beenden des Programms �ber den Men�punkt: Beenden
	 */
	
	@Override
	public void actionPerformed(ActionEvent event) {
		GUI.frame.dispose();

	}

}
