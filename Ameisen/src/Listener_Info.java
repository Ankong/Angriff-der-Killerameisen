import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener_Info implements ActionListener {

	/**
	 * Actionlistener zum �ffnen der Info �ber den Men�punkt: Info
	 */
	
	public static GUI_Info infoframe;
	
	public void actionPerformed(ActionEvent e) {
		infoframe = new GUI_Info();
		infoframe.setVisible(true);
		infoframe.setResizable(false);
		infoframe.pack();
	}

}
