
public class Daten_einlesen {

	private double id;
	private double xPos;
	private double yPos;
	
	public Daten_einlesen(double id, double xPos, double yPos) {
		super();
		this.id = id;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	public double getId() {
		return id;
	}
	public void setId(double id) {
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
	
	
}
