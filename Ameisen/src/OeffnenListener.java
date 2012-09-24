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

import javax.swing.JFileChooser;

public class OeffnenListener implements ActionListener {

	public static List<TSP_Formatierung> list = new ArrayList<TSP_Formatierung>();
	public static String sxPos;
	public static double xPos;
	public static String syPos;
	public static double yPos;

	@Override
	public void actionPerformed(ActionEvent event) {
		String line;
		File file = new File("");
		
		//Liste leeren
		if (!list.isEmpty()) {
			list.clear();
		}
		
		//File-Explorer zum Datei-Öffnen auswählen
		JFileChooser chooser = new JFileChooser();
		int wert = chooser.showOpenDialog(null);
		if (wert == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			try {
				//Erste Zeilen ignorieren
				while (!reader.readLine().equals("NODE_COORD_SECTION")) {
				}
				try {
					//String-Tokenizer zum Aufteilen der Zeile
					while (!(line = reader.readLine()).equals("EOF")) {
						StringTokenizer tokenizer = new StringTokenizer(line);
						while (tokenizer.hasMoreTokens()) {
							String sid = tokenizer.nextToken();
							int id = Integer.parseInt(sid);
							sxPos = tokenizer.nextToken();
							//xPos = new Double(sxPos).intValue();
							xPos = Double.parseDouble(sxPos);
							syPos = tokenizer.nextToken();
							//yPos = new Double(syPos).intValue();
							yPos = Double.parseDouble(syPos);
							TSP_Formatierung daten = new TSP_Formatierung(id, xPos,
									yPos);
							list.add(daten);
						}
					}
					//Punkte automatisch zeichnen
					
					GUI.frame_refresh();
					
					/*
					for (int i = 0; i < list.size();i++) {
						System.out.println(list.get(i));
					}*/
					
				} catch (IOException e) {
					System.out.println("Exception");
				}
			} catch (NullPointerException | NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
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
