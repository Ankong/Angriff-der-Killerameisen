import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;


public class GUI_Info extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GUI_Info() {
		setTitle("Info");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("<HTML><BODY><div align = center><b>Angriff der Killerameisen</b><br><br>Version 1.0<br><br>Copyright by<br>Boris Goldstein, Patric Hausmann,<br>Sebastian Purath, Anton Wolf</BODY></HTML>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	}

}
