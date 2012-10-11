public class TSP_Strecke {
	
	/**
	 * Klasse zum definieren der Strecken
	 */
	
	/**
	 * klassenrelevante Variablen
	 */
	
	private double startxPos;
	private double startyPos;
	private double endxPos;
	private double endyPos;
	private double laenge;
	private double pheromon;

	public TSP_Strecke(double startxPos, double startyPos, double endxPos, double endyPos, double laenge, double pheromon) {
		super();
		this.startxPos = startxPos;
		this.startyPos = startyPos;
		this.endxPos = endxPos;
		this.endyPos = endyPos;
		this.laenge = laenge;
		this.pheromon = pheromon;
	}

	public double getStartxPos() {
		return startxPos;
	}

	public void setStartxPos(double startxPos) {
		this.startxPos = startxPos;
	}

	public double getStartyPos() {
		return startyPos;
	}

	public void setStartyPos(double startyPos) {
		this.startyPos = startyPos;
	}

	public double getEndxPos() {
		return endxPos;
	}

	public void setEndxPos(double endxPos) {
		this.endxPos = endxPos;
	}

	public double getEndyPos() {
		return endyPos;
	}

	public void setEndyPos(double endyPos) {
		this.endyPos = endyPos;
	}

	public double getLaenge() {
		return laenge;
	}

	public void setLaenge(double laenge) {
		this.laenge = laenge;
	}

	public double getPheromon() {
		return pheromon;
	}

	public void setPheromon(double pheromon) {
		this.pheromon = pheromon;
	}

	@Override
	public String toString() {
		return "TSP_Strecke [startxPos=" + startxPos + ", startyPos="
				+ startyPos + ", endxPos=" + endxPos + ", endyPos=" + endyPos
				+ ", laenge=" + laenge + ", pheromon=" + pheromon + "]";
	}
	
}
