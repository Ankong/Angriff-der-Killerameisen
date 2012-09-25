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
		g.translate((int)(0 - (ChangeParameter.getMinimum_X_Wert())/ChangeParameter.grossterParam((Zoom_SlideListener.slidezahl - 50)*5)), (int)(0 - (ChangeParameter.getMinimum_Y_Wert()/ChangeParameter.grossterParam((Zoom_SlideListener.slidezahl - 50)*5))));
		/*for (int i = 0; i < OeffnenListener.list.size(); i++) { 
			try { 
				for (int j = 0; j < OeffnenListener.list.size(); j++) {
					g.setColor(Color.lightGray);
					g.drawLine((int)(((OeffnenListener.list.get(i).getxPos()/ ChangeParameter.grossterParam()))+4),((int)((OeffnenListener.list.get(i).getyPos()/ ChangeParameter.grossterParam()))+4),((int)((OeffnenListener.list.get(j).getxPos()/ ChangeParameter.grossterParam()))+4),((int)((OeffnenListener.list.get(j).getyPos()/ ChangeParameter.grossterParam()))+4)); } 
			} catch (IndexOutOfBoundsException e){ 
				//System.out.println("geht nicht"); }
			}
		} */
		for (int i = 0; i < OeffnenListener.list.size(); i++) {
			g.setColor(Color.red);
			g.fillOval((int)((OeffnenListener.list.get(i).getxPos() / ChangeParameter.grossterParam((Zoom_SlideListener.slidezahl - 50)*5))),(int)((OeffnenListener.list.get(i).getyPos() / ChangeParameter.grossterParam((Zoom_SlideListener.slidezahl - 50)*5))), width, high);
		}	
	}
}
