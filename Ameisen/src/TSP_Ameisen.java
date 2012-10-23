import java.util.ArrayList;
import java.util.List;

public class TSP_Ameisen {
	
	/**
	 * Klasse zum definieren der Ameisen
	 */
	
	/**
	 * Klassenrelevante Variablen
	 */
	
	private int id;
	private double xPos;
	private double yPos;
	private double gesamtlaenge;
	List<TSP_Strecke> tabuList = new ArrayList<TSP_Strecke>();
	List<TSP_Strecke> tabuList2 = new ArrayList<TSP_Strecke>();
	
	/**
	 * Definition
	 */
	
	public TSP_Ameisen (int id0, double x0Pos, double y0Pos, double gesmtlaenge ) {
		id = id0;
		xPos = x0Pos;
		yPos = y0Pos;
		gesamtlaenge = gesmtlaenge;
	}
	
	

	/**
	 * Möglichkeitsabfrage
	 */
	
	public static Boolean inhalt_check(int ameisenid, double testx, double testy) {
		boolean check = false;
		TSP_Strecke koord;
		double x;
		double y;
		
		for ( int z =0; z < TSP_Algorithmus.antList.get(ameisenid).getTabuList().size(); z++){
			koord = TSP_Algorithmus.antList.get(ameisenid).tabuList.get(z);
			x = koord.getStartxPos();
			y = koord.getStartyPos();
			if ((x == testx) && (y == testy)) {
				check = true;
				break;
			}
		}
		
		return check;
	}
	
	
	public static Boolean check_posibility(int ameisenid, double testx, double testy){
		boolean check;
		boolean is_in;
		
		check = true;
		
		for (int i = 0; i < TSP_Algorithmus.antList.get(ameisenid).getTabuList().size(); i++) {
			is_in = TSP_Ameisen.inhalt_check(ameisenid, testx, testy);
			//is_in = (TSP_Algorithmus.antList.get(ameisenid).getTabuList().contains(testx));
			if ( is_in ) {
				check = false;
				break;
			}		
		}
		
		return check;
	} 
	/*public static void add_city2(int ameisenid, TSP_Strecke strecke) {
		TSP_Algorithmus.antList.get(ameisenid).getTabuList2().add(strecke);
	}
	
	public static Boolean check_posibility (int ameisenid, TSP_Strecke stecke) {
		boolean check = true;
		TSP_Strecke retour = null;
		
		retour = TSP_Algorithmus.finde_retour(stecke);
		
		for (int a = 0; a < TSP_Algorithmus.antList.get(ameisenid).getTabuList().size(); a++) {
			if (TSP_Algorithmus.antList.get(ameisenid).getTabuList().contains(stecke) || TSP_Algorithmus.antList.get(ameisenid).getTabuList2().contains(retour)) {
				check = false;
				break;
			}
		}
		
		return check;
	}*/
	/**
	 * Neue Stadt zur Tabuliste hinzufügen
	 */
	
	public static void add_city(int ameisenid, TSP_Strecke strecke) {
		TSP_Algorithmus.antList.get(ameisenid).getTabuList().add(strecke);
	}
	
	/**
	 * Ameise auf neue Stadt
	 */
	
	public static void next_city(int meisenid,TSP_Strecke strecke) {
		TSP_Algorithmus.antList.get(meisenid).setxPos(strecke.getEndxPos());
		TSP_Algorithmus.antList.get(meisenid).setyPos(strecke.getEndyPos());
	}
	
	public static void printListDouble(List<double[]> liste) {
		System.out.println();
		for (double[] line: liste) {
			for (double d: line) {
				System.out.print(d + " ");
			}
		}
	}

	/**
	 * Getter und Setter für die Ameisen
	 */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}
	
	public List<TSP_Strecke> getTabuList() {
		return tabuList;
	}

	public void setTabuList(List<TSP_Strecke> tabuList) {
		this.tabuList = tabuList;
	}
	
	public double getGesamtlaenge() {
		return gesamtlaenge;
	}

	public void setGesamtlaenge(double gesamtlaenge) {
		this.gesamtlaenge = gesamtlaenge;
	}
	

	public List<TSP_Strecke> getTabuList2() {
		return tabuList2;
	}



	public void setTabuList2(List<TSP_Strecke> tabuList2) {
		this.tabuList2 = tabuList2;
	}



	@Override
	public String toString() {
		return "TSP_Ameisen [id=" + id + ", xPos=" + xPos + ", yPos=" + yPos
				+ "]";
	}

	
	
}
