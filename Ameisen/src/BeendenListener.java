import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BeendenListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		GUI.frame.dispose();

	}

}
