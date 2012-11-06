import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Listener_Check3 implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		GUI.chb_It_erreicht.setSelected(false);
		GUI.chb_Schwelle.setSelected(false);
		GUI.t_Schwellenwert.setVisible(false);

	}

}
