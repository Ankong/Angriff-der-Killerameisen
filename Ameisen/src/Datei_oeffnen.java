import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;

import sun.awt.DesktopBrowse;


public class Datei_oeffnen implements ActionListener {

	public static List<Daten_einlesen> list = new ArrayList<Daten_einlesen>();
	/*public static String sxPos;
	public static double xPos = Double.parseDouble(sxPos);
	public static String syPos;
	public static double yPos = Double.parseDouble(syPos);*/
	@Override
	public void actionPerformed(ActionEvent event) {
		//List<Daten_einlesen> list = new ArrayList<Daten_einlesen>();
		String line;
		File file = new File("");
		JFileChooser chooser = new JFileChooser();
		int wert = chooser.showOpenDialog(null);
		if (wert == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			for (int i=0;i<6;i++) {
				try {
					reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				while (!(line = reader.readLine()).equals("EOF") ) {
					StringTokenizer tokenizer = new StringTokenizer(line);
					while (tokenizer.hasMoreTokens()) {
						String sid = tokenizer.nextToken();
						int id = Integer.parseInt(sid);
						String sxPos = tokenizer.nextToken();
						double xPos = Double.parseDouble(sxPos);
						String syPos = tokenizer.nextToken();
						double yPos = Double.parseDouble(syPos);
						Daten_einlesen einlesen = new Daten_einlesen(id, xPos, yPos);
						list.add(einlesen); 
					}
				}
				//Liste Probeweise ausgeben...
				//for (int j = 0; j < list.size();j++){
					//System.out.println(list.get(j));
					//System.out.println(list.get(j));
				//}	
			} catch (IOException e) {
				System.out.println("Exception");
			}
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Datei nicht gefunden");
		}

	}

}
