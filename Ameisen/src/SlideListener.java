import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SlideListener implements ChangeListener {

	public float slidezahl;
	
	@Override
	public void stateChanged(ChangeEvent slide_event) {
		JSlider quelle = (JSlider)slide_event.getSource();
		slidezahl = quelle.getValue();
		GUI.l_Slidewert.setText(Float.toString(slidezahl/100));
	}

}
