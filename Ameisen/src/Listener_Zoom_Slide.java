import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Listener_Zoom_Slide implements ChangeListener {
	
	/**
	 * Actionlistener zur Veränderung der dargestelleten Größe des TSP
	 */
	
	public static double slidezahl = 50;
	
	public void stateChanged(ChangeEvent slide_event) {
		JSlider quelle = (JSlider) slide_event.getSource();
		slidezahl =  quelle.getValue();
		GUI.l_Zoomwert.setText(Double.toString((slidezahl - 50)/10));

		GUI.frame_refresh();
	}
	public static void reset(JSlider s_Zoom) {
		s_Zoom.setValue(50);
	}

}
