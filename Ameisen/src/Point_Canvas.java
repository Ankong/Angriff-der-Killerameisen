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
		g.translate(250, 213);
		//g.fillOval(500, 425, width, high);
		/*for (int i = 0; i < OeffnenListener.list.size(); i++) { 
			try { 
				for (int j = 0; j < OeffnenListener.list.size(); j++) {
					g.setColor(Color.lightGray);
					g.drawLine(((OeffnenListener.list.get(i).getxPos()/4)+4),((OeffnenListener.list.get(i).getyPos()/4)+4),((OeffnenListener.list.get(j).getxPos()/4)+4),((OeffnenListener.list.get(j).getyPos()/4)+4)); } 
			} catch (IndexOutOfBoundsException e){ 
				//System.out.println("geht nicht"); }
			}
		} */
		for (int i = 0; i < OeffnenListener.list.size(); i++) {
			g.setColor(Color.red);
			if (ChangeParameter.getMaximum_X_Wert() > 500) {
				g.fillOval((OeffnenListener.list.get(i).getxPos() / ChangeParameter.grossterParam()),(OeffnenListener.list.get(i).getyPos() / ChangeParameter.grossterParam()), width, high);
			}
			else {
				g.fillOval((OeffnenListener.list.get(i).getxPos() * ChangeParameter.kleinsterParam()),(OeffnenListener.list.get(i).getyPos() * ChangeParameter.kleinsterParam()), width, high);
			}
		}	
	}
}
