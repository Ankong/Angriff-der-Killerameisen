import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Listener_Slide implements ChangeListener {
	
	/**
	 * Actionlistener zum Erfassen und Darstellen der Werte des Verdunstundsfaktors
	 */
	
	public float slidezahl;

	public void stateChanged(ChangeEvent slide_event) {
		JSlider quelle = (JSlider) slide_event.getSource();
		slidezahl = quelle.getValue();
		GUI.l_Slidewert.setText(Float.toString(slidezahl / 100));
	}

}