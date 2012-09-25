import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;


public class SpeichernListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		File file = new File("");
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION){
			file = fileChooser.getSelectedFile();
			try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < OeffnenListener.list.size();i++) {
					String line = OeffnenListener.list.get(i).toString();
					writer.write(line);
					writer.newLine();
			}
			writer.write("EOF");
			writer.close();
			} catch (IOException e1) {
				
			}
		}
	}
}
