import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Canvas;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;


public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Programm");
		menuBar.add(mnDatei);
		
		JMenuItem sfl_offnen = new JMenuItem("Datei \u00F6ffnen");
		mnDatei.add(sfl_offnen);
		
		JMenuItem sfl_Doku = new JMenuItem("Dokumentation");
		mnDatei.add(sfl_Doku);
		
		JMenuItem sfl_Info = new JMenuItem("Info");
		mnDatei.add(sfl_Info);
		
		JMenuItem sfl_Ende = new JMenuItem("Beenden");
		mnDatei.add(sfl_Ende);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel l_Ameise = new JLabel("");
		l_Ameise.setIcon(new ImageIcon("../Ameisen/ameise.gif"));
		contentPane.add(l_Ameise, BorderLayout.EAST);
		
		JPanel p_Para = new JPanel();
		contentPane.add(p_Para, BorderLayout.WEST);
		p_Para.setLayout(new GridLayout(22, 2, 0, 0));
		
		JLabel l_Leer1 = new JLabel("");
		p_Para.add(l_Leer1);
		
		JLabel l_Ameisen = new JLabel("Anzahl der Ameisen: ");
		l_Ameisen.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Ameisen);
		
		JLabel l_Leer2 = new JLabel("");
		p_Para.add(l_Leer2);
		
		JLabel l_Stadte = new JLabel("Anzahl der St\u00E4dte: ");
		l_Stadte.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Stadte);
		
		JLabel l_Leer3 = new JLabel("");
		p_Para.add(l_Leer3);
		
		JLabel l_Iteration = new JLabel("Anzahl der Iterationen: ");
		l_Iteration.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Iteration);
		
		JLabel l_Leer4 = new JLabel("");
		p_Para.add(l_Leer4);
		
		JLabel l_Pheromon = new JLabel("\u03B1, Pheromon Parameter");
		l_Pheromon.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Pheromon);
		
		JLabel l_Leer5 = new JLabel("");
		p_Para.add(l_Leer5);
		
		JLabel l_heuristisch = new JLabel("\u03B2, heuristischer Parameter f\u00FCr die lokale Information");
		l_heuristisch.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_heuristisch);
		
		JLabel l_Leer6 = new JLabel("");
		p_Para.add(l_Leer6);
		
		JLabel l_Verdunst = new JLabel("\u03C1, Verdunstundsfaktor");
		l_Verdunst.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Verdunst);
		
		JPanel p_Erg = new JPanel();
		contentPane.add(p_Erg, BorderLayout.SOUTH);
		p_Erg.setLayout(new BorderLayout(0, 0));
		
		JLabel l_warten = new JLabel("");
		l_warten.setIcon(new ImageIcon("../Ameisen/ameise-0005.gif"));
		p_Erg.add(l_warten, BorderLayout.WEST);
		
		JPanel p_TSP = new JPanel();
		contentPane.add(p_TSP, BorderLayout.CENTER);
	}

}
