import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Edit_TSPpoint implements MouseListener {

	/**
	 * Klasse zum manuellen Erstellen von Städten per Mausklick
	 */
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mousePressed(MouseEvent e) {
		int posx = e.getX();
		int posy = e.getY();
		int id = OeffnenListener.list.size();
		OeffnenListener.list.add(new Stadt(id + 1,
				Math.round(ChangeParameter.grossterParam((Zoom_SlideListener.slidezahl - 50)*5)*posx), 
				Math.round(ChangeParameter.grossterParam((Zoom_SlideListener.slidezahl - 50)*5)*posy)));
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


