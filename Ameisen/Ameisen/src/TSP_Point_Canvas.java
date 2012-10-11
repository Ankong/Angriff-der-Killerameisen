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
	
	public TSP_Point_Canvas() {

	}

	public void paint(Graphics g) {
		int width = 8;
		int high = 8;
		double[] start = new double[2];
		double[] ende = new double[2];
		
		g.translate((int)(0 - (TSP_ChangeParameter.getMinimum_X_Wert())/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)), (int)(0 - (TSP_ChangeParameter.getMinimum_Y_Wert()/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5))));
		
		/**
		 * Zeichnen der Ameisenstrecke
		 */
		
		try { 
			for (int l = 0; l < TSP_Algorithmus.antList.size(); l++) {
				//TSP_Ameisen.printListDouble(TSP_Algorithmus.antList.get(l).getTabuList());
				for (int k = 0; k < TSP_Algorithmus.antList.get(l).getTabuList().size() - 1; k++) {
					g.setColor(Color.lightGray);
					start = TSP_Algorithmus.antList.get(l).getTabuList().get(k);
					ende = TSP_Algorithmus.antList.get(l).getTabuList().get(k + 1);
					g.drawLine((int)(start[0]/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)+4),(int)(start[1]/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)+4),(int)(ende[0]/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)+4),(int)(ende[1]/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)+4));
				} 
			}
		} catch (IndexOutOfBoundsException e){ 
			System.out.println("Streckenzeichnenfail");
		}
		
		/**
		 * Zeichnen der Städte
		 */
		
		for (int i = 0; i < Listener_Oeffnen.cityList.size(); i++) {
			g.setColor(Color.RED);
			g.fillOval((int)((Listener_Oeffnen.cityList.get(i).getxPos() / TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5))),(int)((Listener_Oeffnen.cityList.get(i).getyPos() / TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5))), width, high);
		}
		
		/**
		 * Zeichnen der Ameisen
		 */
		
		for (int j = 0; j < TSP_Algorithmus.antList.size(); j++) {
			g.setColor(Color.GREEN);
			g.fillOval((int)((TSP_Algorithmus.antList.get(j).getxPos() / TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5))),(int)((TSP_Algorithmus.antList.get(j).getyPos() / TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5))), 6, 6);
		}
		
		// Anzahl der Städte im Textfeld ausgeben
		
		GUI.t_Stadte.setText(String.valueOf(Listener_Oeffnen.cityList.size()));
	}
	
}
