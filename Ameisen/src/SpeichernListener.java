import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SpeichernListener implements ActionListener {

	/**
	 * Actionlistener zum Speichern einer TSP über den Menüpunkt: Datei speichern
	 */
	
	public static String line;
	
	public void actionPerformed(ActionEvent e) {
		File file = null;
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION){
			String path = fileChooser.getSelectedFile().getPath();
			if (!path.toLowerCase().endsWith(".txt")) {
			  path = path + ".txt";
			} 
			file = new File(path);
			try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (int k = 0; k < OeffnenListener.vector.size(); k++) {
				if (k == 0) {
					line = OeffnenListener.vector.get(0).toString();
					writer.write(line);
					writer.write(" ");
					String input = JOptionPane.showInputDialog("Stadtname:");
					writer.write(input + OeffnenListener.list.size());
					writer.newLine();
				}
				else if (k == 1) {
					line = OeffnenListener.vector.get(1).toString();
					writer.write(line+" TSP");
					writer.newLine();
				}
				else if (k == 2) {
					line = OeffnenListener.vector.get(2).toString();
					writer.write(line);
					writer.write(" ");
					String input = JOptionPane.showInputDialog(line);
					writer.write(input);
					writer.newLine();
				}
				else if (k == 3) {
					line = OeffnenListener.vector.get(3).toString();
					writer.write(line);
					writer.write(" "+ OeffnenListener.list.size());
					writer.newLine();
				}
				else {
					line = OeffnenListener.vector.get(k).toString();
					writer.write(line);
					writer.newLine();
				}
			}
			for (int i = 0; i < OeffnenListener.list.size();i++) {
					line = OeffnenListener.list.get(i).toString();
					writer.write(line);
					writer.newLine();
			}
			writer.write("EOF");
			writer.close();
			JOptionPane.showMessageDialog(null, "Die Datei wurde gespeichert");
			} catch (IOException e1) {
				
			}
		}
	}
}
