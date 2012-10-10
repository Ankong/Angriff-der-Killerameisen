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
		
		g.translate((int)(0 - (TSP_ChangeParameter.getMinimum_X_Wert())/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)), (int)(0 - (TSP_ChangeParameter.getMinimum_Y_Wert()/TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5))));
		
		/**
		 * Zeichnen der Strecken
		 */
		
		try { 
			for (int k = 0; k < TSP_Algorithmus.streckenList.size(); k++) {
				g.setColor(Color.lightGray);
				g.drawLine((int)(((TSP_Algorithmus.streckenList.get(k).getStartxPos()/ TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)))+4),((int)((TSP_Algorithmus.streckenList.get(k).getStartyPos()/ TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)))+4),((int)((TSP_Algorithmus.streckenList.get(k).getEndxPos()/ TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)))+4),((int)((TSP_Algorithmus.streckenList.get(k).getEndxPos()/ TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)))+4));
				System.out.println(TSP_Algorithmus.streckenList.get(k));
			} 
		} catch (IndexOutOfBoundsException e){ 
			System.out.println("Streckenzeichnenfail");
		}
		
		/**
		 * Zeichnen der Städte
		 */
		
		for (int i = 0; i < Listener_Oeffnen.list.size(); i++) {
			g.setColor(Color.RED);
			g.fillOval((int)((Listener_Oeffnen.list.get(i).getxPos() / TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5))),(int)((Listener_Oeffnen.list.get(i).getyPos() / TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5))), width, high);
		}
		
		/**
		 * Zeichnen der Ameisen
		 */
		
		for (int j = 0; j < TSP_Algorithmus.antList.size(); j++) {
			g.setColor(Color.GREEN);
			g.fillOval((int)((TSP_Algorithmus.antList.get(j).getxPos() / TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5))),(int)((TSP_Algorithmus.antList.get(j).getyPos() / TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5))), 6, 6);
		}
		
		// Anzahl der Städte im Textfeld ausgeben
		
		GUI.t_Stadte.setText(String.valueOf(Listener_Oeffnen.list.size()));
	}
	
}
