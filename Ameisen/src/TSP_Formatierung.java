public class TSP_Formatierung {

	private int id;
	private double xPos;
	private double yPos;

	public TSP_Formatierung(int id, double xPos, double yPos) {
		super();
		this.id = id;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public Double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}

	@Override
	public String toString() {
		return " " + id + " " + xPos + " " + yPos;
	}

}
