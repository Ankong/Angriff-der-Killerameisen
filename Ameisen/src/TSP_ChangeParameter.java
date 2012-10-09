
public class TSP_ChangeParameter {

	/**
	 * Klasse zum Skalieren der TSP
	 */
	
	public static Double getMaximum_X_Wert() {
		double groessterX = Integer.MIN_VALUE;
		for (int i= 0; i < Listener_Oeffnen.list.size(); i++) {
			if (Listener_Oeffnen.list.get(i).getxPos() > groessterX) {
				groessterX = Listener_Oeffnen.list.get(i).getxPos();		
			}
		}
		return groessterX;
	}
	
	public static Double getMaximum_Y_Wert() {
		double groessterY = Integer.MIN_VALUE;
		for (int i= 0; i < Listener_Oeffnen.list.size(); i++) {
			if (Listener_Oeffnen.list.get(i).getyPos() > groessterY) {
				groessterY = Listener_Oeffnen.list.get(i).getyPos();		
			}
		}
		return groessterY;
	}
	
	public static Double getMinimum_X_Wert() {
		double kleinsterX = Integer.MAX_VALUE;
		for (int i= 0; i < Listener_Oeffnen.list.size(); i++) {
			if (Listener_Oeffnen.list.get(i).getxPos() < kleinsterX) {
				kleinsterX = Listener_Oeffnen.list.get(i).getxPos();		
			}
		}
		return kleinsterX;
	}
	
	public static Double getMinimum_Y_Wert() {
		double kleinsterY = Integer.MAX_VALUE;
		for (int i= 0; i < Listener_Oeffnen.list.size(); i++) {
			if (Listener_Oeffnen.list.get(i).getyPos() < kleinsterY) {
				kleinsterY = Listener_Oeffnen.list.get(i).getyPos();		
			}
		}
		return kleinsterY;
	}
	
	public static Double berechneXParam(double sliderzahl) {
		double xParam = 0;
		double slider = sliderzahl;
		xParam = getMaximum_X_Wert() / (500 - getMinimum_X_Wert()+slider);
		return xParam;
	}
	
	public static Double berechneYParam(double sliderzahl) {
		double yParam = 0;
		double slider = sliderzahl;
		yParam = getMaximum_Y_Wert() / (425 + getMinimum_Y_Wert()+slider);
		return yParam;
	}
	
	public static Double grossterParam (double slidezahl) {
		double grossterPara = 0;
		double slider = slidezahl;
		if (berechneXParam(slider) < berechneYParam(slider)){
			grossterPara = berechneYParam(slider);
		}
		else {
			grossterPara = berechneXParam(slider);
		}
		return grossterPara;
	}
}
