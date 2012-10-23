import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class TSP_Point_Canvas extends Component {

	/**
	 * ClassID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Klasse zum Zeichnen aller Elemente
	 */
	
	 public void drawThickLine(Graphics g, int x1, int y1, int x2, int y2, int thickness, Color c) {
			  // The thick line is in fact a filled polygon
			  g.setColor(c);
			  int dX = x2 - x1;
			  int dY = y2 - y1;
			  // line length
			  double lineLength = Math.sqrt(dX * dX + dY * dY);

			  double scale = (double)(thickness) / (2 * lineLength);

			  // The x,y increments from an endpoint needed to create a rectangle...
			  double ddx = -scale * (double)dY;
			  double ddy = scale * (double)dX;
			  ddx += (ddx > 0) ? 0.5 : -0.5;
			  ddy += (ddy > 0) ? 0.5 : -0.5;
			  int dx = (int)ddx;
			  int dy = (int)ddy;

			  // Now we can compute the corner points...
			  int xPoints[] = new int[4];
			  int yPoints[] = new int[4];

			  xPoints[0] = x1 + dx; yPoints[0] = y1 + dy;
			  xPoints[1] = x1 - dx; yPoints[1] = y1 - dy;
			  xPoints[2] = x2 - dx; yPoints[2] = y2 - dy;
			  xPoints[3] = x2 + dx; yPoints[3] = y2 + dy;

			  g.fillPolygon(xPoints, yPoints, 4);
	}
	
	public TSP_Point_Canvas() {

	}

	public void paint(Graphics g) {
		int width = 8;
		int high = 8;
		
		g.translate((int)(0 - (TSP_ChangeParameter.getMinimum_X_Wert())/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)), (int)(0 - (TSP_ChangeParameter.getMinimum_Y_Wert()/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5))));
		
		/**
		 * Zeichnen der Ameisenstrecke
		 */
		
		try { 
			for (int l = 0; l < TSP_Algorithmus.antList.size(); l++) {
				for (int k = 0; k < TSP_Algorithmus.antList.get(l).getTabuList().size() ; k++) {
					g.setColor(Color.lightGray);
					g.drawLine((int)(TSP_Algorithmus.antList.get(l).getTabuList().get(k).getStartxPos()/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)+4),(int)(TSP_Algorithmus.antList.get(l).getTabuList().get(k).getStartyPos()/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)+4),(int)(TSP_Algorithmus.antList.get(l).getTabuList().get(k).getEndxPos()/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)+4),(int)(TSP_Algorithmus.antList.get(l).getTabuList().get(k).getEndyPos()/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)+4));
				} 
			}
		} catch (IndexOutOfBoundsException e){ 
			System.out.println("Streckenzeichnenfail");
		}
		
		/**
		 * Zeichnen der optimalen Ameisenstrecke
		 */
		
		try {
			for (int o = 0; o < TSP_Algorithmus.optStreckeList.size() ; o++) {
				drawThickLine(g,(int)(TSP_Algorithmus.optStreckeList.get(o).getStartxPos()/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)+4),(int)(TSP_Algorithmus.optStreckeList.get(o).getStartyPos()/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)+4),(int)(TSP_Algorithmus.optStreckeList.get(o).getEndxPos()/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)+4),(int)(TSP_Algorithmus.optStreckeList.get(o).getEndyPos()/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)+4), 4, Color.BLUE);
			}
		} catch (IndexOutOfBoundsException e){ 
			System.out.println("Streckenfail");
		}
		
		/**
		 * Zeichnen der Städte
		 */
		
		for (int i = 0; i < Listener_Oeffnen.cityList.size(); i++) {
			g.setColor(Color.RED);
			g.fillOval((int)((Listener_Oeffnen.cityList.get(i).getxPos() / TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5))),(int)((Listener_Oeffnen.cityList.get(i).getyPos() / TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5))), width, high);
		}
		
		// Anzahl der Städte im Textfeld ausgeben
		
		GUI.t_Stadte.setText(String.valueOf(Listener_Oeffnen.cityList.size()));
		//GUI.l_local_opt.setText(String.valueOf(Math.round((100 *TSP_Algorithmus.opt_strecke()))/100.0));
		//GUI.l_local_aver.setText(String.valueOf(Math.round((100 *TSP_Algorithmus.aver_strecke()))/100.0));
	}
	
}

