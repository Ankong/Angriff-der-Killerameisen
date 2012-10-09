import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JFileChooser;

@SuppressWarnings("rawtypes")
public class OeffnenListener implements ActionListener {

	/**
	 * Actionlistener zum Öffnen einer TSP über den Menüpunkt: Datei öffnen
	 */
	
	public static List<Stadt> list = new ArrayList<Stadt>();
	public static Vector vector = new Vector<>();
	public static String sxPos;
	public static double xPos;
	public static String syPos;
	public static double yPos;

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent event) {
		String line;
		File file = new File("");
		
		//Liste leeren
		if (!list.isEmpty()) {
			list.clear();
		}
		//Vetor leeren
		if (!vector.isEmpty()) {
			vector.clear();
		}
		
		//Zoom-Slider reseten
		Zoom_SlideListener.reset(GUI.s_Zoom);
		
		//File-Explorer zum Datei-Öffnen auswählen
		JFileChooser chooser = new JFileChooser("c:/Users/Boris/workspace/Angriff-der-Killerameisen/Ameisen");
		int wert = chooser.showOpenDialog(null);
		if (wert == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			try {
				//Erste Zeilen werden eingelesen und zum schreiben weitergegeben
				int count = 1;
				while (!(line = reader.readLine()).equals("NODE_COORD_SECTION")) {
					if (count < 5) {
						StringTokenizer tokens = new StringTokenizer(line);
						String begin = tokens.nextToken();
						vector.add(begin);
						count++;
					}
					else {
						vector.add(line);
					}
				}
				vector.add("NODE_COORD_SECTION");
				try {
					//String-Tokenizer zum Aufteilen der Zeile
					while (!(line = reader.readLine()).equals("EOF")) {
						StringTokenizer tokenizer = new StringTokenizer(line);
						while (tokenizer.hasMoreTokens()) {
							String sid = tokenizer.nextToken();
							int id = Integer.parseInt(sid);
							sxPos = tokenizer.nextToken();
							xPos = Double.parseDouble(sxPos);
							syPos = tokenizer.nextToken();
							yPos = Double.parseDouble(syPos);
							Stadt daten = new Stadt(id, xPos,
									yPos);
							list.add(daten);
						}
					}
					//Punkte automatisch zeichnen
					
					GUI.frame_refresh();
					
				} catch (IOException e) {
					System.out.println("Exception");
				}
			} catch (NullPointerException | NumberFormatException | IOException e) {
				System.out.println("bla");
			}
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println("Datei nicht gefunden");
		}
		
		// Speichern-Button aktivieren
		GUI.sfl_speichern.setEnabled(true);

	}

}
