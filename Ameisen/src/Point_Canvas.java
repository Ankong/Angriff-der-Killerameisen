import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;


public class Point_Canvas extends Component {

	public Point_Canvas(){
		
	}
	
	public void paint (Graphics g){
		int width = 7;
		int high = 7;
		int xProbe = 100;
		int yProbe = 100;
		g.setColor(Color.black);
		g.fillOval(xProbe, yProbe, width, high); //ProbePunkt
		for (int i = 0; i < Datei_oeffnen.list.size(); i++) {
			//g.fillOval((int) Datei_oeffnen.xPos, (int) Datei_oeffnen.yPos, width, high);
			System.out.println(Datei_oeffnen.list);
		}
	}
}
