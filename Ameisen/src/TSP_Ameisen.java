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
	static List<double[]> tabuList = new ArrayList<double[]>();
	
	/**
	 * Definition
	 */
	
	public TSP_Ameisen (int id0, double x0Pos, double y0Pos ) {
		id = id0;
		xPos = x0Pos;
		yPos = y0Pos;
	}
	
	/**
	 * Möglichkeitsabfrage
	 */
	
	public static Boolean check_posibility(int ameisenid, double testx, double testy){
		boolean check;
		double[] test = {testx, testy};
		
		check = true;
		
		for (int i = 0; i < TSP_Algorithmus.antList.get(ameisenid).getTabuList().size(); i++) {
			if ( TSP_Algorithmus.antList.get(ameisenid).getTabuList().contains(test) ) {
				check = false;
				break;
			}		
		}
		
		if (TSP_Algorithmus.antList.get(ameisenid).getTabuList().size() == Listener_Oeffnen.cityList.size() ) {
			TSP_Algorithmus.antList.get(ameisenid).getTabuList().add( TSP_Algorithmus.antList.get(ameisenid).getTabuList().get(0) );
		}
		
		return check;
	}
	
	/**
	 * Neue Stadt zur Tabuliste hinzufügen
	 */
	
	public static void add_city(int ameisenid, double[] punkt) {
		TSP_Algorithmus.antList.get(ameisenid).getTabuList().add(punkt);
	}
	
	/**
	 * Ameise auf neue Stadt
	 */
	
	public static void next_city(int meisenid, double[] punkt) {
		TSP_Algorithmus.antList.get(meisenid).setxPos(punkt[0]);
		TSP_Algorithmus.antList.get(meisenid).setyPos(punkt[1]);
	}
	
	/**
	 * Berechnung der Tour einer Ameise
	 */
	
	public static void berechne_Tour(int antid) {
		
	}
	
	public static void printListDouble(List<double[]> liste) {
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
	
	public List<double[]> getTabuList() {
		return tabuList;
	}

	public void setTabuList(List<double[]> tabuList) {
		this.tabuList = tabuList;
	}

	@Override
	public String toString() {
		return "TSP_Ameisen [id=" + id + ", xPos=" + xPos + ", yPos=" + yPos
				+ "]";
	}

	
	
}
