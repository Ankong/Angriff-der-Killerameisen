
public class Daten_einlesen {

	private int id;
	private double xPos;
	private double yPos;
	
	public Daten_einlesen(int id, double xPos, double yPos) {
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
	@Override
	public String toString() {
		return "Daten_einlesen [id=" + id + ", xPos=" + xPos + ", yPos=" + yPos
				+ "]";
	}
	
	
}
