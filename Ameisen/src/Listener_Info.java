import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener_Info implements ActionListener {

	/**
	 * Actionlistener zum Öffnen der Info über den Menüpunkt: Info
	 */
	
	public static GUI_Info infoframe;
	
	public void actionPerformed(ActionEvent e) {
		infoframe = new GUI_Info();
		infoframe.setVisible(true);
		infoframe.setResizable(false);
		infoframe.pack();
	}

}
