import java.util.ArrayList;
import java.util.List;

public class Ameisen {
	
	/**
	 * Klasse zum definieren der Ameisen
	 */
	
	/**
	 * Klassenrelevante Variablen
	 */
	
	int antID;
	int id;
	double xPos;
	double yPos;
	static List<Stadt> tabuList = new ArrayList<Stadt>();
	
	/**
	 * Definition
	 */
	
	public Ameisen (int antid, int id0, double x0Pos, double y0Pos ) {
		antID = antid;
		id = id0;
		xPos = x0Pos;
		yPos = y0Pos;
		Stadt home = new Stadt(id0, x0Pos, y0Pos);
		tabuList.add(home);
	}
	
	/**
	 * Möglichkeitsabfrage
	 */
	
	public static Boolean check_posibility(Stadt test){
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
		double antTour;
		
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
	
	public static List<Stadt> getTabuList() {
		return tabuList;
	}

	public static void setTabuList(ArrayList<Stadt> tabuList) {
		Ameisen.tabuList = tabuList;
	}

	/**
	 * Methode zur Ausgabe der Ameisen
	 */
	
	public String toString() {
		return " " + antID + " Home " + id + " " + xPos
				+ " " + yPos + "]";
	}

	
}
