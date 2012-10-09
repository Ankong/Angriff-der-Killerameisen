public class TSP_Stadt {

	/**
	 * Klasse zur Definition der Städte
	 */
	
	/**
	 * Klassenrelevante Variablen
	 */
	
	private int id;
	private double xPos;
	private double yPos;

	public TSP_Stadt(int id, double xPos, double yPos) {
		super();
		this.id = id;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	/**
	 * Getter und Setter für die Städte
	 */
	
	// Stadt ID
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Stadt x-Koordinate
	
	public Double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	// Stadt y-Koordinate
	
	public Double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}

	/**
	 * Methode zum Ausgeben der Städte
	 */
	
	public String toString() {
		return " " + id + " " + xPos + " " + yPos;
	}

}
