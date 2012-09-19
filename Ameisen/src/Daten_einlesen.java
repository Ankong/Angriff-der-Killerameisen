
public class Daten_einlesen {

	private int id;
	private int xPos;
	private int yPos;
	
	public Daten_einlesen(int id, int xPos, int yPos) {
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
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	@Override
	public String toString() {
		return "Daten_einlesen [id=" + id + ", xPos=" + xPos + ", yPos=" + yPos
				+ "]";
	}
	
	
}
