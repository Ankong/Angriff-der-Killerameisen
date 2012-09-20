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
	public static int xPos;
	public static String syPos;
	public static int yPos;

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
			for (int i = 0; i < 6; i++) {
				try {
					reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				while (!(line = reader.readLine()).equals("EOF")) {
					StringTokenizer tokenizer = new StringTokenizer(line);
					while (tokenizer.hasMoreTokens()) {
						String sid = tokenizer.nextToken();
						int id = Integer.parseInt(sid);
						sxPos = tokenizer.nextToken();
						xPos = new Double(sxPos).intValue();
						syPos = tokenizer.nextToken();
						yPos = new Double(syPos).intValue();
						TSP_Formatierung daten = new TSP_Formatierung(id, xPos,
								yPos);
						list.add(daten);
					}
				}
			} catch (IOException e) {
				System.out.println("Exception");
			}
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println("Datei nicht gefunden");
		}

		GUI.sfl_speichern.setEnabled(true);

	}

}
