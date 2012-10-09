import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TSP_Edit_Point implements MouseListener {

	/**
	 * Klasse zum manuellen Erstellen von St�dten per Mausklick
	 */
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mousePressed(MouseEvent e) {
		int posx = e.getX();
		int posy = e.getY();
		int id = Listener_Oeffnen.list.size();
		Listener_Oeffnen.list.add(new TSP_Stadt(id + 1,
				Math.round(TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)*posx), 
				Math.round(TSP_ChangeParameter.grossterParam((Listener_Zoom_Slide.slidezahl - 50)*5)*posy)));
		GUI.frame_refresh();
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}


