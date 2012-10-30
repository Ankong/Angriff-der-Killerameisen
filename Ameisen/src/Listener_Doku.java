import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Listener_Doku implements ActionListener {

	/**
	 * Actionlistener zum Öffnen der Doku über den Menüpunkt: Dokumentation
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Desktop.getDesktop().open(new File("Dokumentation TSP.pdf"));
		} catch (IOException e1) {
			System.out.println("Filefail");
			e1.printStackTrace();
		}
		
	}

}
