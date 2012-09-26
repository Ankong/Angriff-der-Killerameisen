import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JToolTip;


@SuppressWarnings("serial")
public class TextTool extends JPanel {

	 public JToolTip createToolTip() {
	        
			JToolTip tip = new JToolTip() {

	            @Override
	            protected void paintComponent(Graphics g) {
	                //zeichne tooltip wie auch immer
	            }

	        };
	        tip.setPreferredSize(new Dimension(200, 30));
	        tip.setComponent(this);
	        return tip;
	    }
}
