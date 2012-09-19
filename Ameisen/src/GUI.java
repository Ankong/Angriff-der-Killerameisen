import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JButton;


public class GUI extends JFrame {

	public static GUI frame;
	public JPanel contentPane;
	public static JLabel l_Slidewert;
	public JTextField t_Ameisen;
	public JTextField t_Stadte;
	public JTextField t_Iteration;
	public JTextField t_Pheromon;
	public JTextField t_heuristisch;
	public JTextField t_init_Pheromon;
	public JTextField t_heur_Pheromon;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GUI();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.pack();
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
		sfl_offnen.addActionListener(new Datei_oeffnen());

		JMenuItem sfl_speichern = new JMenuItem("Daten speichern");
		sfl_speichern.setEnabled(false);
		mnDatei.add(sfl_speichern);
		
		JMenuItem sfl_Doku = new JMenuItem("Dokumentation");
		mnDatei.add(sfl_Doku);
		
		JMenuItem sfl_Info = new JMenuItem("Info");
		mnDatei.add(sfl_Info);
		
		JMenuItem sfl_Ende = new JMenuItem("Beenden");
		mnDatei.add(sfl_Ende);
		sfl_Ende.addActionListener(new BeendenListener());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel l_Ameise = new JLabel("");
		l_Ameise.setIcon(new ImageIcon("../Ameisen/ameise.gif"));
		contentPane.add(l_Ameise, BorderLayout.EAST);
		
		JPanel p_Para = new JPanel();
		contentPane.add(p_Para, BorderLayout.WEST);
		p_Para.setPreferredSize(new Dimension (250, p_Para.getPreferredSize().height));
		p_Para.setLayout(new GridLayout(23, 2, 0, 0));
	
		JLabel l_Leer01 = new JLabel("");
		p_Para.add(l_Leer01);
		
		JLabel l_Leer02 = new JLabel("");
		p_Para.add(l_Leer02);
		
		JLabel l_Ameisen = new JLabel("<HTML><BODY>Anzahl der Ameisen:</BODY></HTML>");
		l_Ameisen.setFont(new Font("Tahoma", Font.BOLD, 11));
		l_Ameisen.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Ameisen);
		
		t_Ameisen = new JTextField();
		p_Para.add(t_Ameisen);
		t_Ameisen.setColumns(10);
		
		JLabel l_Leer03 = new JLabel("");
		p_Para.add(l_Leer03);	
		
		JLabel l_Leer04 = new JLabel("");
		p_Para.add(l_Leer04);
		
		JLabel l_Stadte = new JLabel("<HTML><BODY>Anzahl der St\u00E4dte:</BODY></HTML>");
		l_Stadte.setFont(new Font("Tahoma", Font.BOLD, 11));
		l_Stadte.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Stadte);
		
		t_Stadte = new JTextField();
		p_Para.add(t_Stadte);
		t_Stadte.setColumns(10);
		
		JLabel l_Leer05 = new JLabel("");
		p_Para.add(l_Leer05);	
		
		JLabel l_Leer06 = new JLabel("");
		p_Para.add(l_Leer06);
		
		JLabel l_Iteration = new JLabel("<HTML><BODY>Anzahl der Iterationen:</BODY></HTML>");
		l_Iteration.setFont(new Font("Tahoma", Font.BOLD, 11));
		l_Iteration.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Iteration);
		
		t_Iteration = new JTextField();
		p_Para.add(t_Iteration);
		t_Iteration.setColumns(10);
		
		JLabel l_Leer07 = new JLabel("");
		p_Para.add(l_Leer07);	
		
		JLabel l_Leer08 = new JLabel("");
		p_Para.add(l_Leer08);
		
		JLabel l_Pheromon = new JLabel("<HTML><BODY>\u03B1, Pheromon Parameter:</BODY></HTML>");
		l_Pheromon.setFont(new Font("Tahoma", Font.BOLD, 11));
		l_Pheromon.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Pheromon);
		
		t_Pheromon = new JTextField();
		p_Para.add(t_Pheromon);
		t_Pheromon.setColumns(10);
		
		JLabel l_Leer09 = new JLabel("");
		p_Para.add(l_Leer09);	
		
		JLabel l_Leer10 = new JLabel("");
		p_Para.add(l_Leer10);
		
		JLabel l_heuristisch = new JLabel("<HTML><BODY>\u03B2, heuristischer Parameter:</BODY></HTML>");
		l_heuristisch.setFont(new Font("Tahoma", Font.BOLD, 11));
		l_heuristisch.setToolTipText("");
		l_heuristisch.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_heuristisch);
		
		t_heuristisch = new JTextField();
		p_Para.add(t_heuristisch);
		t_heuristisch.setColumns(10);
		
		JLabel l_Leer11 = new JLabel("");
		p_Para.add(l_Leer11);	
		
		JLabel l_Leer12 = new JLabel("");
		p_Para.add(l_Leer12);
		
		JLabel l_Verdunst = new JLabel("<HTML><BODY>\u03C1, Verdunstungsfaktor:</BODY></HTML>");
		l_Verdunst.setFont(new Font("Tahoma", Font.BOLD, 11));
		l_Verdunst.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Verdunst);
		
		JSlider s_Verdunst = new JSlider();
		s_Verdunst.setPaintTicks(true);
		s_Verdunst.setMinorTickSpacing(10);
		p_Para.add(s_Verdunst);
		s_Verdunst.addChangeListener(new SlideListener());
		
		JLabel l_Leer13 = new JLabel("");
		p_Para.add(l_Leer13);	
		
		l_Slidewert = new JLabel("0,5");
		l_Slidewert.setHorizontalAlignment(SwingConstants.CENTER);
		p_Para.add(l_Slidewert);
		
		JLabel l_init_Pheromon = new JLabel("<HTML><BODY>\u03C40, initiale Pheromon-Werte:</BODY></HTML>");
		l_init_Pheromon.setFont(new Font("Tahoma", Font.BOLD, 11));
		l_init_Pheromon.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_init_Pheromon);
		
		t_init_Pheromon = new JTextField();
		p_Para.add(t_init_Pheromon);
		t_init_Pheromon.setColumns(10);
		
		JLabel l_Leer15 = new JLabel("");
		p_Para.add(l_Leer15);	
		
		JLabel l_Leer16 = new JLabel("");
		p_Para.add(l_Leer16);
		
		JLabel l_heur_Pheromon = new JLabel("<HTML><BODY>Q, heuristischer Parameter:</BODY></HTML>");
		l_heur_Pheromon.setFont(new Font("Tahoma", Font.BOLD, 11));
		l_heur_Pheromon.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_heur_Pheromon);
		
		t_heur_Pheromon = new JTextField();
		p_Para.add(t_heur_Pheromon);
		t_heur_Pheromon.setColumns(10);
		
		JLabel l_Leer17 = new JLabel("");
		p_Para.add(l_Leer17);	
		
		JLabel l_Leer18 = new JLabel("");
		p_Para.add(l_Leer18);
		
		JLabel l_Stoppkrit = new JLabel("<HTML><BODY>Stoppkriterien:</BODY></HTML>");
		l_Stoppkrit.setFont(new Font("Tahoma", Font.BOLD, 11));
		l_Stoppkrit.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Stoppkrit);
		
		JCheckBox chb_It_erreicht = new JCheckBox("<HTML><BODY>Anzahl von Iterationen erreicht</BODY></HTML>");
		chb_It_erreicht.setFont(new Font("Tahoma", Font.PLAIN, 11));
		p_Para.add(chb_It_erreicht);
		
		JLabel l_Leer19 = new JLabel("");
		p_Para.add(l_Leer19);
		
		JLabel l_Leer20 = new JLabel("");
		p_Para.add(l_Leer20);
		
		JLabel l_Leer21 = new JLabel("");
		p_Para.add(l_Leer21);
		
		JCheckBox chb_Erg_gefunden = new JCheckBox("<HTML><BODY>L\u00F6sung gefunden</BODY></HTML>");
		chb_Erg_gefunden.setFont(new Font("Tahoma", Font.PLAIN, 11));
		p_Para.add(chb_Erg_gefunden);
		
		JLabel l_Leer22 = new JLabel("");
		p_Para.add(l_Leer22);
		
		JLabel l_Leer23 = new JLabel("");
		p_Para.add(l_Leer23);
		
		JPanel p_Control = new JPanel();
		p_Para.add(p_Control);
		p_Control.setLayout(new GridLayout(1, 3, 0, 0));
		
		JButton b_Start = new JButton("");
		b_Start.setIcon(new ImageIcon("../Ameisen/pfeil_gruen_r.gif"));
		p_Control.add(b_Start);
		
		JButton b_Stop = new JButton("");
		b_Stop.setIcon(new ImageIcon("../Ameisen/quadrat-rot-hi.png"));
		p_Control.add(b_Stop);
		
		JCheckBox chb_Schwelle = new JCheckBox("<HTML><BODY>Schwellenwert f\u00FCr Tourl\u00E4nge</BODY></HTML>");
		chb_Schwelle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		p_Para.add(chb_Schwelle);
			
		JPanel p_Erg = new JPanel();
		contentPane.add(p_Erg, BorderLayout.SOUTH);
		p_Erg.setLayout(new BorderLayout(0, 0));
		
		JLabel l_warten = new JLabel("");
		l_warten.setIcon(new ImageIcon("../Ameisen/ameise-0005.gif"));
		l_warten.setVisible(true);
		p_Erg.add(l_warten, BorderLayout.WEST);
		
		JPanel p_Ergebnisse = new JPanel();
		p_Erg.add(p_Ergebnisse, BorderLayout.EAST);
		p_Ergebnisse.setLayout(new GridLayout(3, 5, 0, 0));
		p_Ergebnisse.setVisible(true);
		
		JLabel l_opt_Strecke = new JLabel("Optimale Strecke:");
		p_Ergebnisse.add(l_opt_Strecke);
		
		JLabel l_Leer24 = new JLabel("lokal");
		l_Leer24.setHorizontalAlignment(SwingConstants.RIGHT);
		p_Ergebnisse.add(l_Leer24);
		
		JLabel l_local_opt = new JLabel("100");
		l_local_opt.setHorizontalAlignment(SwingConstants.CENTER);
		p_Ergebnisse.add(l_local_opt);
		
		JLabel l_Leer25 = new JLabel("global");
		l_Leer25.setHorizontalAlignment(SwingConstants.RIGHT);
		p_Ergebnisse.add(l_Leer25);
		
		JLabel l_global_opt = new JLabel("100");
		l_global_opt.setHorizontalAlignment(SwingConstants.CENTER);
		p_Ergebnisse.add(l_global_opt);
		
		JLabel l_durch_Strecke = new JLabel("Durchschnittliche Strecke:");
		p_Ergebnisse.add(l_durch_Strecke);
		
		JLabel l_Leer26 = new JLabel("lokal");
		l_Leer26.setHorizontalAlignment(SwingConstants.RIGHT);
		p_Ergebnisse.add(l_Leer26);
		
		JLabel l_local_aver = new JLabel("100");
		l_local_aver.setHorizontalAlignment(SwingConstants.CENTER);
		p_Ergebnisse.add(l_local_aver);
		
		JLabel l_Leer27 = new JLabel("global");
		l_Leer27.setHorizontalAlignment(SwingConstants.RIGHT);
		p_Ergebnisse.add(l_Leer27);
		
		JLabel l_global_aver = new JLabel("100");
		l_global_aver.setHorizontalAlignment(SwingConstants.CENTER);
		p_Ergebnisse.add(l_global_aver);
		
		JLabel l_Zeit = new JLabel("Vergangene Zeit:");
		p_Ergebnisse.add(l_Zeit);
		
		JLabel l_Time = new JLabel("100");
		l_Time.setHorizontalAlignment(SwingConstants.CENTER);
		p_Ergebnisse.add(l_Time);
		
		JLabel l_Leer29 = new JLabel("");
		p_Ergebnisse.add(l_Leer29);
		
		JLabel l_Leer30 = new JLabel("");
		p_Ergebnisse.add(l_Leer30);
		
		JLabel l_Leer31 = new JLabel("");
		p_Ergebnisse.add(l_Leer31);
		
		JPanel p_TSP = new JPanel();
		p_TSP.setBackground(Color.WHITE);
		contentPane.add(p_TSP, BorderLayout.CENTER);
		p_TSP.setLayout(new BorderLayout(0, 0));
		/*
		JLabel l_TSP = new JLabel("");
		l_TSP.setIcon(new ImageIcon("../Ameisen/tsp_LK.png"));
		l_TSP.setBounds(MAXIMIZED_HORIZ, MAXIMIZED_VERT, 700, 500);
		p_TSP.add(l_TSP);*/
		
		//JFrame jFrame = new JFrame("TSP");
		//jFrame.add(new Point_Canvas());
		try {
			if (Datei_oeffnen.list != null ) //Versuch Canvas erst aufzurufen,
											//wenn die Liste gefüllt ist
				{
					p_TSP.add(new Point_Canvas());
			}	
		} catch (Exception e) {
			System.out.println("geht nicht");
		}
		
		JPanel p_north = new JPanel();
		p_TSP.add(p_north, BorderLayout.NORTH);
		
		JPanel p_south = new JPanel();
		p_TSP.add(p_south, BorderLayout.SOUTH);
		
		JPanel p_west = new JPanel();
		p_TSP.add(p_west, BorderLayout.WEST);
		
		JPanel p_east = new JPanel();
		p_TSP.add(p_east, BorderLayout.EAST);
	}
	
}
