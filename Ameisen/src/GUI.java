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
import javax.swing.JProgressBar;

public class GUI extends JFrame {

	/**
	 * ClassID
	 */
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Diese Klasse hat die Aufgabe die GUI zu initialisieren.
	 * Außerdem ist eine Methode enthalten, die den Frame aktualisiert.
	 */

	/**
	 * Klassenrelevante Variablen
	 */
	
	public static GUI frame;
	public static JPanel contentPane;
	public static JMenuItem sfl_speichern;
	public static JPanel p_TSP;
	public static JLabel l_Slidewert;
	public static JLabel l_Zoomwert;
	public static JSlider s_Zoom;
	public static JProgressBar progressBar;

	/**
	 * Parametervariablen
	 */
	
	public static JTextField t_Ameisen;
	public static JTextField t_Stadte;
	public static JTextField t_Iteration;
	public static JTextField t_Pheromon;
	public static JTextField t_heuristisch;
	public static JSlider s_Verdunst;
	public static JTextField t_init_Pheromon;
	public static JTextField t_heur_Pheromon;

	/**
	 * Ergebnisvariablen
	 */
	
	public static JLabel l_local_opt;
	public static JLabel l_global_opt;
	public static JLabel l_local_aver;
	public static JLabel l_global_aver;
	public static JLabel l_Time;

	/**
	 * Programm starten
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GUI();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Frame refreshen
	 */
	
	public static void frame_refresh() {
		p_TSP.repaint();
	}
	
	public static void neue_Stadt() {
		try {
			p_TSP.addMouseListener(new TSP_Edit_Point());
		} catch (Exception e)	{
			System.out.println("hola");
		}
	}
	
	/**
	 * TSP zeichnen
	 */
	
	public static void draw_TSP() {
		try {
			p_TSP.add(new TSP_Point_Canvas());
			//p_TSP.addMouseListener(new TSP_Edit_Point());
			
		} catch (Exception e) {
			System.out.println("geht nicht");
		}
	}

	/**
	 * Fenster definieren
	 */
	
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ameisen-Algorithmus");
		setBounds(100, 100, 1100, 650);

		/**
		 * Tableiste
		 */
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnDatei = new JMenu("Programm");
		menuBar.add(mnDatei);

		// Öffnen

		JMenuItem sfl_offnen = new JMenuItem("Datei \u00F6ffnen");
		mnDatei.add(sfl_offnen);
		sfl_offnen.addActionListener(new Listener_Oeffnen());
		
		

		// Speichern

		sfl_speichern = new JMenuItem("Daten speichern");
		sfl_speichern.setEnabled(true);
		mnDatei.add(sfl_speichern);
		sfl_speichern.addActionListener(new Listener_Speichern());

		// Doku

		JMenuItem sfl_Doku = new JMenuItem("Dokumentation");
		mnDatei.add(sfl_Doku);
		sfl_Doku.addActionListener(new Listener_Doku());

		// Info

		JMenuItem sfl_Info = new JMenuItem("Info");
		mnDatei.add(sfl_Info);
		sfl_Info.addActionListener(new Listener_Info());

		// Beenden

		JMenuItem sfl_Ende = new JMenuItem("Beenden");
		mnDatei.add(sfl_Ende);
		sfl_Ende.addActionListener(new Listener_Beenden());

		/**
		 * Hauptpanel
		 */

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		/**
		 * Ameise
		 */

		JLabel l_Ameise = new JLabel("");
		l_Ameise.setIcon(new ImageIcon("ameise.gif"));
		contentPane.add(l_Ameise, BorderLayout.EAST);

		/**
		 * Parameterpanel
		 */

		JPanel p_Para = new JPanel();
		contentPane.add(p_Para, BorderLayout.WEST);
		p_Para.setPreferredSize(new Dimension(250,
				p_Para.getPreferredSize().height));
		p_Para.setLayout(new GridLayout(23, 2, 0, 0));

		// Anzahl der Ameisen

		JLabel l_Ameisen = new JLabel("<HTML><BODY>Anzahl der Ameisen:</BODY></HTML>");
		l_Ameisen.setFont(new Font("Tahoma", Font.BOLD, 9));
		l_Ameisen.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Ameisen);

		t_Ameisen = new JTextField();
		t_Ameisen.setColumns(10);
		t_Ameisen.setText("0");
		p_Para.add(t_Ameisen);

		// Leerzeile
		
		JLabel l_Leer03 = new JLabel("");
		p_Para.add(l_Leer03);

		JLabel l_Leer04 = new JLabel("");
		p_Para.add(l_Leer04);

		// Anzahl der Städte

		JLabel l_Stadte = new JLabel("<HTML><BODY>Anzahl der St\u00E4dte:</BODY></HTML>");
		l_Stadte.setFont(new Font("Tahoma", Font.BOLD, 9));
		l_Stadte.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Stadte);

		t_Stadte = new JTextField();
		t_Stadte.setColumns(10);
		t_Stadte.setEditable(false);
		t_Stadte.setBackground(Color.WHITE);
		p_Para.add(t_Stadte);

		// Leerzeile
		
		JLabel l_Leer05 = new JLabel("");
		p_Para.add(l_Leer05);

		JLabel l_Leer06 = new JLabel("");
		p_Para.add(l_Leer06);

		// Anzahl der Iterationen

		JLabel l_Iteration = new JLabel("<HTML><BODY>Anzahl der Iterationen:</BODY></HTML>");
		l_Iteration.setFont(new Font("Tahoma", Font.BOLD, 9));
		l_Iteration.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Iteration);

		t_Iteration = new JTextField();
		t_Iteration.setColumns(10);
		t_Iteration.setText("0");
		p_Para.add(t_Iteration);

		// Leerzeile
		
		JLabel l_Leer07 = new JLabel("");
		p_Para.add(l_Leer07);

		JLabel l_Leer08 = new JLabel("");
		p_Para.add(l_Leer08);

		// Pheromon Parameter

		JLabel l_Pheromon = new JLabel("<HTML><BODY>\u03B1, Pheromon Parameter:</BODY></HTML>");
		l_Pheromon.setFont(new Font("Tahoma", Font.BOLD, 9));
		l_Pheromon.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Pheromon);

		t_Pheromon = new JTextField();
		t_Pheromon.setColumns(10);
		t_Pheromon.setText("1");
		t_Pheromon.setToolTipText("alpha > 0");
		p_Para.add(t_Pheromon);

		// Leerzeile

		JLabel l_Leer09 = new JLabel("");
		p_Para.add(l_Leer09);

		JLabel l_Leer10 = new JLabel("");
		p_Para.add(l_Leer10);

		// heuristischer Parameter

		JLabel l_heuristisch = new JLabel("<HTML><BODY>\u03B2, heuristischer Parameter:</BODY></HTML>");
		l_heuristisch.setFont(new Font("Tahoma", Font.BOLD, 9));
		l_heuristisch.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_heuristisch);

		t_heuristisch = new JTextField();
		t_heuristisch.setColumns(10);
		t_heuristisch.setText("1");
		t_heuristisch.setToolTipText("beta > 0");
		p_Para.add(t_heuristisch);

		// Leerzeile

		JLabel l_Leer11 = new JLabel("");
		p_Para.add(l_Leer11);

		JLabel l_Leer12 = new JLabel("");
		p_Para.add(l_Leer12);

		// Verdunstungsfaktor

		JLabel l_Verdunst = new JLabel("<HTML><BODY>\u03C1, Verdunstungsfaktor:</BODY></HTML>");
		l_Verdunst.setFont(new Font("Tahoma", Font.BOLD, 9));
		l_Verdunst.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Verdunst);
		
		s_Verdunst = new JSlider();
		s_Verdunst.setPaintTicks(true);
		s_Verdunst.setMinorTickSpacing(10);
		p_Para.add(s_Verdunst);
		s_Verdunst.addChangeListener(new Listener_Slide());

		// Leerfläche
		
		JLabel l_Leer13 = new JLabel("");
		p_Para.add(l_Leer13);

		// Betrag des Slider
		
		l_Slidewert = new JLabel("0,5");
		l_Slidewert.setHorizontalAlignment(SwingConstants.CENTER);
		l_Slidewert.setFont(new Font("Tahoma", Font.BOLD, 9));
		p_Para.add(l_Slidewert);

		// initiale Pheromon-Werte

		JLabel l_init_Pheromon = new JLabel("<HTML><BODY>\u03C40, initiale Pheromon-Werte:</BODY></HTML>");
		l_init_Pheromon.setFont(new Font("Tahoma", Font.BOLD, 9));
		l_init_Pheromon.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_init_Pheromon);

		t_init_Pheromon = new JTextField();
		t_init_Pheromon.setColumns(10);
		t_init_Pheromon.setText("1");
		p_Para.add(t_init_Pheromon);

		// Leerzeile
		
		JLabel l_Leer15 = new JLabel("");
		p_Para.add(l_Leer15);

		JLabel l_Leer16 = new JLabel("");
		p_Para.add(l_Leer16);

		// heuristischer Parameter

		JLabel l_heur_Pheromon = new JLabel("<HTML><BODY>Q, heuristischer Parameter:</BODY></HTML>");
		l_heur_Pheromon.setFont(new Font("Tahoma", Font.BOLD, 9));
		l_heur_Pheromon.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_heur_Pheromon);

		t_heur_Pheromon = new JTextField();
		t_heur_Pheromon.setColumns(10);
		t_heur_Pheromon.setText("1");
		p_Para.add(t_heur_Pheromon);

		// Leerzeile

		JLabel l_Leer17 = new JLabel("");
		p_Para.add(l_Leer17);

		JLabel l_Leer18 = new JLabel("");
		p_Para.add(l_Leer18);

		// Stoppkriterien

		JLabel l_Stoppkrit = new JLabel("<HTML><BODY>Stoppkriterien:</BODY></HTML>");
		l_Stoppkrit.setFont(new Font("Tahoma", Font.BOLD, 11));
		l_Stoppkrit.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Stoppkrit);

		// Anzahl von Iterationen erreicht

		JCheckBox chb_It_erreicht = new JCheckBox("<HTML><BODY>Anzahl von Iterationen erreicht</BODY></HTML>");
		chb_It_erreicht.setFont(new Font("Tahoma", Font.PLAIN, 9));
		p_Para.add(chb_It_erreicht);

		// Leerfläche
		
		JLabel l_Leer19 = new JLabel("");
		p_Para.add(l_Leer19);

		// Lösung gefunden

		JCheckBox chb_Erg_gefunden = new JCheckBox("<HTML><BODY>L\u00F6sung gefunden</BODY></HTML>");
		chb_Erg_gefunden.setFont(new Font("Tahoma", Font.PLAIN, 9));
		p_Para.add(chb_Erg_gefunden);

		// Leerfläche
		
		JLabel l_Leer20 = new JLabel("");
		p_Para.add(l_Leer20);

		// Schwellenwert für Tourlänge erreicht

		JCheckBox chb_Schwelle = new JCheckBox("<HTML><BODY>Schwellenwert f\u00FCr Tourl\u00E4nge</BODY></HTML>");
		chb_Schwelle.setFont(new Font("Tahoma", Font.PLAIN, 9));
		p_Para.add(chb_Schwelle);
		
		// Leerzeile
		
		JLabel l_Leer01 = new JLabel("");
		p_Para.add(l_Leer01);

		JLabel l_Leer02 = new JLabel("");
		p_Para.add(l_Leer02);
		
		// Zoom-Slider
		
		JLabel l_Zoom = new JLabel("<HTML><BODY> Zoom:</BODY></HTML>");
		l_Verdunst.setFont(new Font("Tahoma", Font.BOLD, 9));
		l_Verdunst.setHorizontalAlignment(SwingConstants.LEFT);
		p_Para.add(l_Zoom);

		s_Zoom = new JSlider();
		s_Zoom.setPaintTicks(true);
		s_Zoom.setMinorTickSpacing(10);
		p_Para.add(s_Zoom);
		s_Zoom.addChangeListener(new Listener_Zoom_Slide());
		
		// Leerfläche
		
		JLabel l_Leer21 = new JLabel("");
		p_Para.add(l_Leer21);

		// Betrag des Zoom-Slider
		
		l_Zoomwert = new JLabel("0");
		l_Zoomwert.setHorizontalAlignment(SwingConstants.CENTER);
		l_Zoomwert.setFont(new Font("Tahoma", Font.BOLD, 9));
		p_Para.add(l_Zoomwert);
		
		// Buttonflächen
		
		JPanel p_ControlStart = new JPanel();
		p_Para.add(p_ControlStart, BorderLayout.SOUTH);
		p_ControlStart.setLayout(new GridLayout(1, 2));

		JPanel p_ControlStop = new JPanel();
		p_Para.add(p_ControlStop, BorderLayout.SOUTH);
		p_ControlStop.setLayout(new GridLayout(1, 2));

		// Startbutton

		JLabel l_Leer23 = new JLabel("");
		p_ControlStart.add(l_Leer23);

		JButton b_Start = new JButton("Start");
		b_Start.setFont(new Font("Tahoma", Font.PLAIN, 9));
		p_ControlStart.add(b_Start);
		b_Start.addActionListener(new Listener_Start());

		// Stopbutton

		JLabel l_Leer24 = new JLabel("");
		p_ControlStop.add(l_Leer24);

		JButton b_Stop = new JButton("Stop");
		b_Stop.setFont(new Font("Tahoma", Font.PLAIN, 9));
		p_ControlStop.add(b_Stop);
		b_Stop.addActionListener(new Listener_Stop());

		/**
		 * Ergebnispanel
		 */

		JPanel p_Erg = new JPanel();
		contentPane.add(p_Erg, BorderLayout.SOUTH);
		p_Erg.setLayout(new BorderLayout(0, 0));
		p_Erg.setVisible(true);

		// Progressbar

		JPanel p_Progress = new JPanel();
		p_Progress.setLayout(new BorderLayout(0, 0));
		p_Erg.add(p_Progress, BorderLayout.WEST);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		p_Progress.add(progressBar, BorderLayout.CENTER);
		
		JPanel p_North = new JPanel();
		p_Progress.add(p_North, BorderLayout.NORTH);

		JPanel p_South = new JPanel();
		p_Progress.add(p_South, BorderLayout.SOUTH);

		JPanel p_West = new JPanel();
		p_Progress.add(p_West, BorderLayout.WEST);

		JPanel p_East = new JPanel();
		p_Progress.add(p_East, BorderLayout.EAST);
		
		// Ergenisse

		JPanel p_Ergebnisse = new JPanel();
		p_Erg.add(p_Ergebnisse, BorderLayout.EAST);
		p_Ergebnisse.setLayout(new GridLayout(3, 5, 0, 0));
		p_Ergebnisse.setVisible(true);

		// Optimale Strecke

		JLabel l_opt_Strecke = new JLabel("Optimale Strecke:");
		p_Ergebnisse.add(l_opt_Strecke);

		JLabel l_Leer25 = new JLabel("lokal");
		l_Leer25.setHorizontalAlignment(SwingConstants.RIGHT);
		p_Ergebnisse.add(l_Leer25);

		l_local_opt = new JLabel("100");
		l_local_opt.setHorizontalAlignment(SwingConstants.CENTER);
		p_Ergebnisse.add(l_local_opt);

		JLabel l_Leer26 = new JLabel("global");
		l_Leer26.setHorizontalAlignment(SwingConstants.RIGHT);
		p_Ergebnisse.add(l_Leer26);

		l_global_opt = new JLabel("100");
		l_global_opt.setHorizontalAlignment(SwingConstants.CENTER);
		p_Ergebnisse.add(l_global_opt);

		// Durchschnittliche Strecke

		JLabel l_durch_Strecke = new JLabel("Durchschnittliche Strecke:");
		p_Ergebnisse.add(l_durch_Strecke);

		JLabel l_Leer27 = new JLabel("lokal");
		l_Leer27.setHorizontalAlignment(SwingConstants.RIGHT);
		p_Ergebnisse.add(l_Leer27);

		l_local_aver = new JLabel("");
		l_local_aver.setHorizontalAlignment(SwingConstants.CENTER);
		p_Ergebnisse.add(l_local_aver);

		JLabel l_Leer28 = new JLabel("global");
		l_Leer28.setHorizontalAlignment(SwingConstants.RIGHT);
		p_Ergebnisse.add(l_Leer28);

		l_global_aver = new JLabel("100");
		l_global_aver.setHorizontalAlignment(SwingConstants.CENTER);
		p_Ergebnisse.add(l_global_aver);

		// Vergangene Zeit

		JLabel l_Zeit = new JLabel("Vergangene Zeit:");
		p_Ergebnisse.add(l_Zeit);

		l_Time = new JLabel("100");
		l_Time.setHorizontalAlignment(SwingConstants.CENTER);
		p_Ergebnisse.add(l_Time);

		JLabel l_Leer29 = new JLabel("");
		p_Ergebnisse.add(l_Leer29);

		JLabel l_Leer30 = new JLabel("");
		p_Ergebnisse.add(l_Leer30);

		JLabel l_Leer31 = new JLabel("");
		p_Ergebnisse.add(l_Leer31);
		
		/**
		 * TSP-Panel
		 */

		p_TSP = new JPanel();
		p_TSP.setBackground(Color.WHITE);
		contentPane.add(p_TSP, BorderLayout.CENTER);
		p_TSP.setLayout(new BorderLayout(0, 0));

		// Rahmen
		
		JPanel p_north = new JPanel();
		p_TSP.add(p_north, BorderLayout.NORTH);

		JPanel p_south = new JPanel();
		p_TSP.add(p_south, BorderLayout.SOUTH);

		JPanel p_west = new JPanel();
		p_TSP.add(p_west, BorderLayout.WEST);

		JPanel p_east = new JPanel();
		p_TSP.add(p_east, BorderLayout.EAST);

		// Punkte zeichnen
		
		draw_TSP();
		neue_Stadt();
	}

}
