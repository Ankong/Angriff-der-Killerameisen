import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;


public class Point_Canvas extends Component {

	public Point_Canvas(){
		
	}
	
	public void paint (Graphics g){
		int width = 6;
		int high = 6;
		for (int i = 0; i < Datei_oeffnen.list.size(); i++) {
			try {
				for (int j = 0; j < Datei_oeffnen.list.size(); j++) {
					g.setColor(Color.lightGray);
					g.drawLine(((Datei_oeffnen.list.get(i).getxPos()/4)+3),((Datei_oeffnen.list.get(i).getyPos()/4)+3), ((Datei_oeffnen.list.get(j).getxPos()/4)+3), ((Datei_oeffnen.list.get(j).getyPos()/4)+3));
				}
			} catch (IndexOutOfBoundsException e){
				//System.out.println("geht nicht");
			}
		}
		for (int i = 0; i < Datei_oeffnen.list.size(); i++) {
			g.setColor(Color.red);
			g.fillRect((Datei_oeffnen.list.get(i).getxPos()/4), (Datei_oeffnen.list.get(i).getyPos()/4), width, high);
		}
	}
}
