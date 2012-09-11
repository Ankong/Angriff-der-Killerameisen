import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;

import javax.swing.JFileChooser;

import sun.awt.DesktopBrowse;


public class Datei_oeffnen implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		String line;
		File file = new File("");
		JFileChooser chooser = new JFileChooser();
		int wert = chooser.showOpenDialog(null);
		if (wert == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			try {
				while ((line = reader.readLine()) != null ) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Datei nicht gnlanden");
		}

	}

}
