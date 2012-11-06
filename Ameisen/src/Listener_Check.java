import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Listener_Check implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		GUI.chb_Erg_gefunden.setSelected(false);
		GUI.chb_It_erreicht.setSelected(false);
		GUI.t_Schwellenwert.setVisible(true);
	}

}
