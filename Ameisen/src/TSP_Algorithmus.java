import java.util.ArrayList;
import java.util.List;

public class TSP_Algorithmus extends Thread {
	
	/**
	 * Klasse zur Berechnung des Ameisen-Algorithmus
	 */

	/**
	 * Klassenrelevante Variablen
	 */
	
	public static List<TSP_Ameisen> antList = new ArrayList<TSP_Ameisen>();
	public static List<TSP_Strecke> streckenList = new ArrayList<TSP_Strecke>();
	public static List<TSP_Strecke> optStreckeList = new ArrayList<TSP_Strecke>();
	
	static double opt_laenge = Double.MAX_VALUE;
	static double aver_glob;
	public static double gesamtLaenge;
	public static double gesamtpheromon = 0;
	public static boolean stop_btn = false;
	static double update;
	static TSP_Strecke strecke = null;
	
	/**
	 * Parametervariablen
	 */
	
	public static int v_Ameisen;
	public static int v_Stadte;
	public static int v_Iteration;
	public static double v_Pheromon;
	public static double v_heuristisch;
	public static double v_Verdunst;
	public static double v_init_Pheromon;
	public static double v_heur_Pheromon;
	static boolean posible;
	
	/**
	 * Einlesen der Parameter aus den Textfeldern
	 */
	
	public static void parameter_einlesen() {
		v_Ameisen = Integer.parseInt(GUI.t_Ameisen.getText());
		v_Stadte = Integer.parseInt(GUI.t_Stadte.getText());
		v_Iteration = Integer.parseInt(GUI.t_Iteration.getText());
		v_Pheromon = (double)(GUI.s_Pheromon.getValue())/100;
		v_heuristisch = (double)(GUI.s_heuristisch.getValue())/100;
		v_Verdunst = (double)(GUI.s_Verdunst.getValue())/100;
		v_init_Pheromon = Double.parseDouble(GUI.t_init_Pheromon.getText());
		v_heur_Pheromon = Double.parseDouble(GUI.t_heur_Pheromon.getText());
	}
	
	/**
	 * Erstellen der Ameisen
	 */
	
	public static void ameisen_generieren() {
		int zufall;
		
		for (int i = 0; i < v_Ameisen; i++) {
			zufall = (int)( Math.random() * v_Stadte );
			TSP_Ameisen ameisen = new TSP_Ameisen(Listener_Oeffnen.cityList.get(zufall).getId(), Listener_Oeffnen.cityList.get(zufall).getxPos(), Listener_Oeffnen.cityList.get(zufall).getyPos(), 0);
			antList.add(ameisen);
		}
	}
	
	/**
	 * Erstellen der Strecken
	 */
	
	public static void strecken_generieren() {
		double random = (Math.random() * v_init_Pheromon);
		for (int j = 0; j < Listener_Oeffnen.cityList.size(); j++) { 
		try { 
			for (int k = 0; k < Listener_Oeffnen.cityList.size(); k++) {
				TSP_Strecke element = new TSP_Strecke(Listener_Oeffnen.cityList.get(j).getxPos(), Listener_Oeffnen.cityList.get(j).getyPos(), Listener_Oeffnen.cityList.get(k).getxPos(), Listener_Oeffnen.cityList.get(k).getyPos(), Math.sqrt( Math.pow( ( Listener_Oeffnen.cityList.get(k).getxPos() - Listener_Oeffnen.cityList.get(j).getxPos() ), 2) + Math.pow( ( Listener_Oeffnen.cityList.get(k).getyPos() - Listener_Oeffnen.cityList.get(j).getyPos() ), 2) ), random);
				if (k != j) {
					streckenList.add(element);
				}
			}	
		} catch (IndexOutOfBoundsException e){ 
			System.out.println("Streckenfail");
			}
		}
	}
	
	/**
	 * Testweise die Lösung für Berlin52
	 */
	
	/**public static void berlin52_opt() {
		TSP_Stadt daten1 = new TSP_Stadt(1, 565.0, 575.0);
		optStreckeList.add(daten1);
		TSP_Stadt daten2 = new TSP_Stadt(49, 605.0, 625.0);
		optStreckeList.add(daten2);
		TSP_Stadt daten3 = new TSP_Stadt(32, 575.0, 665.0);
		optStreckeList.add(daten3);
		TSP_Stadt daten4 = new TSP_Stadt(45, 555.0, 815.0);
		optStreckeList.add(daten4);
		TSP_Stadt daten5 = new TSP_Stadt(19, 510.0, 875.0);
		optStreckeList.add(daten5);
		TSP_Stadt daten6 = new TSP_Stadt(41, 475.0, 960.0);
		optStreckeList.add(daten6);
		TSP_Stadt daten7 = new TSP_Stadt(8, 525.0, 1000.0);
		optStreckeList.add(daten7);
		TSP_Stadt daten8 = new TSP_Stadt(9, 580.0, 1175.0);
		optStreckeList.add(daten8);
		TSP_Stadt daten9 = new TSP_Stadt(10, 650.0, 1130.0);
		optStreckeList.add(daten9);
		TSP_Stadt daten10 = new TSP_Stadt(43, 875.0, 920.0);
		optStreckeList.add(daten10);
		TSP_Stadt daten11 = new TSP_Stadt(33, 1150.0, 1160.0);
		optStreckeList.add(daten11);
		TSP_Stadt daten12 = new TSP_Stadt(51, 1340.0, 725.0);
		optStreckeList.add(daten12);
		TSP_Stadt daten13 = new TSP_Stadt(11, 1605.0, 620.0);
		optStreckeList.add(daten13);
		TSP_Stadt daten14 = new TSP_Stadt(52, 1740.0, 245.0);
		optStreckeList.add(daten14);
		TSP_Stadt daten15 = new TSP_Stadt(14, 1530.0, 5.0);
		optStreckeList.add(daten15);
		TSP_Stadt daten16 = new TSP_Stadt(13, 1465.0, 200.0);
		optStreckeList.add(daten16);
		TSP_Stadt daten17 = new TSP_Stadt(47, 1170.0, 65.0);
		optStreckeList.add(daten17);
		TSP_Stadt daten18 = new TSP_Stadt(26, 1215.0, 245.0);
		optStreckeList.add(daten18);
		TSP_Stadt daten19 = new TSP_Stadt(27, 1320.0, 315.0);
		optStreckeList.add(daten19);
		TSP_Stadt daten20 = new TSP_Stadt(28, 1250.0, 400.0);
		optStreckeList.add(daten20);
		TSP_Stadt daten21 = new TSP_Stadt(12, 1220.0, 580.0);
		optStreckeList.add(daten21);
		TSP_Stadt daten22 = new TSP_Stadt(25, 975.0, 580.0);
		optStreckeList.add(daten22);
		TSP_Stadt daten23 = new TSP_Stadt(4, 945.0, 685.0);
		optStreckeList.add(daten23);
		TSP_Stadt daten24 = new TSP_Stadt(6, 880.0, 660.0);
		optStreckeList.add(daten24);
		TSP_Stadt daten25 = new TSP_Stadt(15, 845.0, 680.0);
		optStreckeList.add(daten25);
		TSP_Stadt daten26 = new TSP_Stadt(5, 845.0, 655.0);
		optStreckeList.add(daten26);
		TSP_Stadt daten27 = new TSP_Stadt(24, 835.0, 625.0);
		optStreckeList.add(daten27);
		TSP_Stadt daten28 = new TSP_Stadt(48, 830.0, 610.0);
		optStreckeList.add(daten28);
		TSP_Stadt daten29 = new TSP_Stadt(38, 795.0, 645.0);
		optStreckeList.add(daten29);
		TSP_Stadt daten30 = new TSP_Stadt(37, 770.0, 610.0);
		optStreckeList.add(daten30);
		TSP_Stadt daten31 = new TSP_Stadt(40, 760.0, 650.0);
		optStreckeList.add(daten31);
		TSP_Stadt daten32 = new TSP_Stadt(39, 720.0, 635.0);
		optStreckeList.add(daten32);
		TSP_Stadt daten33 = new TSP_Stadt(36, 685.0, 610.0);
		optStreckeList.add(daten33);
		TSP_Stadt daten34 = new TSP_Stadt(35, 685.0, 595.0);
		optStreckeList.add(daten34);
		TSP_Stadt daten35 = new TSP_Stadt(34, 700.0, 580.0);
		optStreckeList.add(daten35);
		TSP_Stadt daten36 = new TSP_Stadt(44, 700.0, 500.0);
		optStreckeList.add(daten36);
		TSP_Stadt daten37 = new TSP_Stadt(46, 830.0, 485.0);
		optStreckeList.add(daten37);
		TSP_Stadt daten38 = new TSP_Stadt(16, 725.0, 370.0);
		optStreckeList.add(daten38);
		TSP_Stadt daten39 = new TSP_Stadt(29, 660.0, 180.0);
		optStreckeList.add(daten39);
		TSP_Stadt daten40 = new TSP_Stadt(50, 595.0, 360.0);
		optStreckeList.add(daten40);
		TSP_Stadt daten41 = new TSP_Stadt(20, 560.0, 365.0);
		optStreckeList.add(daten41);
		TSP_Stadt daten42 = new TSP_Stadt(23, 480.0, 415.0);
		optStreckeList.add(daten42);
		TSP_Stadt daten43 = new TSP_Stadt(30, 410.0, 250.0);
		optStreckeList.add(daten43);
		TSP_Stadt daten44 = new TSP_Stadt(2, 25.0, 185.0);
		optStreckeList.add(daten44);
		TSP_Stadt daten45 = new TSP_Stadt(7, 25.0, 230.0);
		optStreckeList.add(daten45);
		TSP_Stadt daten46 = new TSP_Stadt(42, 95.0, 260.0);
		optStreckeList.add(daten46);
		TSP_Stadt daten47 = new TSP_Stadt(21, 300.0, 465.0);
		optStreckeList.add(daten47);
		TSP_Stadt daten48 = new TSP_Stadt(17, 145.0, 665.0);
		optStreckeList.add(daten48);
		TSP_Stadt daten49 = new TSP_Stadt(3, 345.0, 750.0);
		optStreckeList.add(daten49);
		TSP_Stadt daten50 = new TSP_Stadt(18, 415.0, 635.0);
		optStreckeList.add(daten50);
		TSP_Stadt daten51 = new TSP_Stadt(31, 420.0, 555.0);
		optStreckeList.add(daten51);
		TSP_Stadt daten52 = new TSP_Stadt(22, 520.0, 585.0);
		optStreckeList.add(daten52);
		TSP_Stadt daten = new TSP_Stadt(1, 565.0, 575.0);
		optStreckeList.add(daten);
	}**/
	
	public static TSP_Strecke findeStrecke (double startx, double starty, double endx, double endy) {
		TSP_Strecke strecke = null;
		for (int a = 0; a < streckenList.size(); a++) {
			if ((startx == streckenList.get(a).getStartxPos()) && (starty == streckenList.get(a).getStartyPos()) && (endx == streckenList.get(a).getEndxPos()) && (endy == streckenList.get(a).getEndyPos())) {
				strecke = streckenList.get(a);
			}
		}
		return strecke;
	}
	
	/**
	 * Pheromonaktualisierung
	 */
	
	// Berechnung der Pheromonaktualisierung
	
	public static Double berechne_pheromon (int index, TSP_Strecke strecke) {
		double update;
		if (antList.get(index).tabuList.contains(strecke)) {
			update = v_heur_Pheromon / antList.get(index).getGesamtlaenge();
			gesamtpheromon += update;
		}
		else {
			update = 0;
		}
		return update;
	}
	
	// Aktualisierung der Pheromone
	
	public static void pheromonUpdate(int index) {
		for (int a = 0; a < antList.get(index).tabuList.size(); a++) {
			update = berechne_pheromon(index, antList.get(index).tabuList.get(a));
			antList.get(index).tabuList.get(a).setPheromon(antList.get(index).tabuList.get(a).getPheromon() + update);
		}	
	}
	
	// Verdunstung
	
	public static void verdunstung() {
		for (int u = 0; u < streckenList.size(); u++) {
			streckenList.get(u).setPheromon( (1 - v_Verdunst) * streckenList.get(u).getPheromon() + gesamtpheromon);
		}
	}
	
	/**
	 * Route finden
	 */
		
	// Summe der Streckenmöglichkeiten
	
	public static double berechne_summe_strecken (int index, int amid) {
		boolean moglich;
		double summe;
		
		summe = 0;
		moglich = false;
		
		for (int j = index; j < (v_Stadte - 1 + index); j++) {
			moglich = ( TSP_Ameisen.check_posibility(amid, streckenList.get(j).getEndxPos(), streckenList.get(j).getEndyPos()) ) ;
			if (moglich = true) {
				summe += (Math.pow(streckenList.get(index).getPheromon(), v_Pheromon)) * (Math.pow((1 / streckenList.get(index).getLaenge() ), (v_heuristisch)));
			}
		}
		
		return summe;
	}
	
	// Möglichkeit einer Strecke
	
	public static double berechne (int index, int amid, double summe) {
		double posibility;
		double gesamt;
		
		posibility = (Math.pow(streckenList.get(index).getPheromon(), v_Pheromon)) * (Math.pow((1 / streckenList.get(index).getLaenge() ), (v_heuristisch)));
		//if (antList.get(index))
		gesamt = posibility / summe;
		
		return gesamt;
	}
	
	// Finden der wahrscheinlichsten Strecke
	
	public static TSP_Strecke Stadtauswahl(int ameisenid, double startx, double starty) {
		double auswahl = Double.MIN_VALUE;
		double summe_pos;
		TSP_Strecke strecke = null;
		
		for (int k= 0; k < streckenList.size(); k++) {
			if ( (startx == streckenList.get(k).getStartxPos() ) && ( starty == streckenList.get(k).getStartyPos() ) ) {
				summe_pos = berechne_summe_strecken(k, ameisenid);
				for (int i = k; i < (v_Stadte - 1 + k); i++) {
					posible = ( TSP_Ameisen.check_posibility(ameisenid, streckenList.get(i).getEndxPos(), streckenList.get(i).getEndyPos())) ;
					if ( ( berechne(i, ameisenid, summe_pos) > auswahl ) && (posible) ) {
						auswahl = berechne(i, ameisenid, summe_pos);
						strecke = streckenList.get(i);
					}
				}
			break;
			}
		}
		return strecke;
	}
	@Override
	public void run () {
	//public static void iterationen_durchlaufen() {
		GUI.progressBar.setMaximum(v_Iteration);
		long start_time = System.currentTimeMillis();
		stop_btn = false;
		
		aver_glob = 0;
		opt_laenge = Double.MAX_VALUE;
		GUI.progressBar.setForeground(null);
		
		for (int b = 0; b < v_Iteration; b++) {
			//Liste leeren und neue Ameisen für neue zufällige Städte erstellen und setzen, nach dem ersten Durchlauf
			if (!antList.isEmpty() & b!=0) {
				antList.clear();
				ameisen_generieren();
			}
			for (int l = 0; l < antList.size(); l++) {
				gesamtLaenge = 0;
				if (!antList.get(l).tabuList.isEmpty()) {
					antList.get(l).tabuList.clear();
				} 
							
				for (int t = 0; t < Listener_Oeffnen.cityList.size()   ; t++) {	
					strecke = Stadtauswahl(l, antList.get(l).getxPos(), antList.get(l).getyPos());
					gesamtLaenge = gesamtLaenge + strecke.getLaenge();
					TSP_Ameisen.add_city(l, strecke);
					//TSP_Ameisen.add_city2(l, finde_retour(strecke));
					TSP_Ameisen.next_city(l, strecke);
					if (antList.get(l).getTabuList().size() == (Listener_Oeffnen.cityList.size() - 1) ) {
						strecke = findeStrecke(strecke.getEndxPos(), strecke.getEndyPos(), antList.get(l).getTabuList().get(0).getStartxPos(), antList.get(l).getTabuList().get(0).getStartyPos());
						gesamtLaenge = gesamtLaenge + strecke.getLaenge();
						antList.get(l).getTabuList().add(strecke);
						TSP_Ameisen.next_city(l, strecke);
						break;
					}
				}
				antList.get(l).setGesamtlaenge(Math.round((100 *gesamtLaenge))/100.0);
				pheromonUpdate(l);
				GUI.progressBar.setValue(b + 1);
				long dauer = System.currentTimeMillis() - start_time;
				GUI.l_Time.setText(String.valueOf(dauer/1000)+" Sekunden");
				GUI.l_global_aver.setText(String.valueOf(Math.round((100 *( aver_glob / b )))/100.0));
				GUI.draw_TSP();
				GUI.frame_refresh();
				if (stop_btn){
					break;
				}
			}
			verdunstung();
			glob_opt_strecke();
			GUI.l_local_opt.setText(String.valueOf(Math.round((100 *opt_strecke()))/100.0));
			GUI.l_local_aver.setText(String.valueOf(Math.round((100 *aver_strecke()))/100.0));
			GUI.draw_TSP();
			GUI.frame_refresh();
			if (stop_btn){
				break;
			}
		}	
	}
	
	public static double aver_strecke() {
		double laenge = 0;
		
		for (int h = 0; h < antList.size(); h++) {
			laenge += antList.get(h).getGesamtlaenge();
		}
		
		laenge = laenge / antList.size();
		aver_glob += laenge;
		
		return laenge;
	}
	
	public static double opt_strecke() {
		double laenge = Double.MAX_VALUE;
		
		for (int h = 0; h < antList.size(); h++) {
			if (antList.get(h).getGesamtlaenge() < laenge) {
				laenge = antList.get(h).getGesamtlaenge();
			}
		}
		
		return laenge;
	}
	
	public static int opt_ameise() {
		double laenge = Double.MAX_VALUE;
		int opt = 0;
		
		for (int h = 0; h < antList.size(); h++) {
			if (antList.get(h).getGesamtlaenge() < laenge) {
				laenge = antList.get(h).getGesamtlaenge();
				opt = h;
			}
		}
		
		return opt;
	}
	
	public static void glob_opt_strecke () {
		double laenge = Double.MAX_VALUE;
		int opt = -1;
		TSP_Strecke strecke = null;
		
		for (int h = 0; h < antList.size(); h++) {
			if (antList.get(h).getGesamtlaenge() < laenge) {
				laenge = antList.get(h).getGesamtlaenge();
				opt = h;
			}
		}
		
		if (opt_laenge == Double.MAX_VALUE) {
			opt_laenge = laenge;
			for (int q = 0; q < antList.get(opt).getTabuList().size(); q++) {
				strecke = antList.get(opt).getTabuList().get(q);
				optStreckeList.add(strecke);
			}
		} else {
			if (laenge < opt_laenge) {
				opt_laenge = laenge;
				if (!optStreckeList.isEmpty()) {
					optStreckeList.clear();
				} 
				for (int q = 0; q < antList.get(opt).getTabuList().size(); q++) {
					strecke = antList.get(opt).getTabuList().get(q);
					optStreckeList.add(strecke);
				}
			}
		}
		
		GUI.l_global_opt.setText(String.valueOf(Math.round((100 *opt_laenge))/100.0));
	}	
}
