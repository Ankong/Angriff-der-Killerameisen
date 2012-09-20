public class TSP_Formatierung {

	private int id;
	private int xPos;
	private int yPos;

	public TSP_Formatierung(int id, int xPos, int yPos) {
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
		return "TSP_Formatierung [id=" + id + ", xPos=" + xPos + ", yPos=" + yPos
				+ "]";
	}

}
