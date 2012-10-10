import java.util.ArrayList;
import java.util.List;

public class TSP_Ameisen {
	
	/**
	 * Klasse zum definieren der Ameisen
	 */
	
	/**
	 * Klassenrelevante Variablen
	 */
	
	private int antID;
	private int id;
	private double xPos;
	private double yPos;
	static List<TSP_Stadt> tabuList = new ArrayList<TSP_Stadt>();
	
	/**
	 * Definition
	 */
	
	public TSP_Ameisen (int antid, int id0, double x0Pos, double y0Pos ) {
		antID = antid;
		id = id0;
		xPos = x0Pos;
		yPos = y0Pos;
		TSP_Stadt home = new TSP_Stadt(id0, x0Pos, y0Pos);
		tabuList.add(home);
	}
	
	/**
	 * Möglichkeitsabfrage
	 */
	
	public static Boolean check_posibility(TSP_Stadt test){
		boolean check;
		
		check = true;
		
		for (int i = 0; i < tabuList.size(); i++) {
			if (test.getId() == tabuList.get(i).getId()) {
				check = false;
				break;
			}		
		}
		
		return check;
	}
	
	/**
	 * Berechnung der Tour einer Ameise
	 */
	
	public static void berechne_Tour(int antid) {
		
	}

	/**
	 * Getter und Setter für die Ameisen
	 */
	
	// Ameisen ID
	
	public int getAntID() {
		return antID;
	}

	public void setAntID(int antID) {
		this.antID = antID;
	}

	// Heimatstadt ID
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Heimatstadt x-Koordinate
	
	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	// Heimatstadt y-Koordinate
	
	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}

	// Tabu-Liste
	
	public static List<TSP_Stadt> getTabuList() {
		return tabuList;
	}

	public static void setTabuList(ArrayList<TSP_Stadt> tabuList) {
		TSP_Ameisen.tabuList = tabuList;
	}

	/**
	 * Methode zur Ausgabe der Ameisen
	 */
	
	public String toString() {
		return " " + antID + " Home " + id + " " + xPos
				+ " " + yPos + "]";
	}

	
}
