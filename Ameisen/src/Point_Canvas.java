import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;


public class Point_Canvas extends Component {

	public Point_Canvas(){
		
	}
	
	public void paint (Graphics g){
		int width = 7;
		int high = 7;
		g.setColor(Color.red);
		for (int i = 0; i < Datei_oeffnen.list.size(); i++) {
			g.fillOval((Datei_oeffnen.list.get(i).getxPos()/3), (Datei_oeffnen.list.get(i).getyPos()/3), width, high);
		}
	}
}
