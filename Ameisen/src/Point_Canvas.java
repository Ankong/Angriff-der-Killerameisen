import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class Point_Canvas extends Component {

	/**
	 * ClassID
	 */
	private static final long serialVersionUID = 1L;

	public Point_Canvas() {

	}

	public void paint(Graphics g) {
		int width = 8;
		int high = 8;
		for (int i = 0; i < Datei_oeffnen.list.size(); i++) { 
			try { 
				for (int j = 0; j < Datei_oeffnen.list.size(); j++) {
					g.setColor(Color.lightGray);
					g.drawLine(((Datei_oeffnen.list.get(i).getxPos()/4)+4),((Datei_oeffnen.list.get(i).getyPos()/4)+4),((Datei_oeffnen.list.get(j).getxPos()/4)+4),((Datei_oeffnen.list.get(j).getyPos()/4)+4)); } 
			} catch (IndexOutOfBoundsException e){ 
				//System.out.println("geht nicht"); }
			}
		} 
		for (int i = 0; i < Datei_oeffnen.list.size(); i++) {
			g.setColor(Color.red);
			g.fillOval((Datei_oeffnen.list.get(i).getxPos() / 4),(Datei_oeffnen.list.get(i).getyPos() / 4), width, high);
		}
	}
}
