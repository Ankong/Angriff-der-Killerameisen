
public class ChangeParameter {

	public static Integer getMaximum_X_Wert() {
		int groessterX = 0;
		for (int i= 0; i < OeffnenListener.list.size(); i++) {
			if (OeffnenListener.list.get(i).getxPos() > groessterX) {
				groessterX = OeffnenListener.list.get(i).getxPos();		
			}
		}
		return groessterX;
	}
	
	public static Integer getMaximum_Y_Wert() {
		int groessterY = 0;
		for (int i= 0; i < OeffnenListener.list.size(); i++) {
			if (OeffnenListener.list.get(i).getyPos() > groessterY) {
				groessterY = OeffnenListener.list.get(i).getyPos();		
			}
		}
		return groessterY;
	}
	
	public static Integer berechneXParam() {
		int xParam = 0;
		if (getMaximum_X_Wert() < 250) {
			xParam = (250 / getMaximum_X_Wert())-1;
		}
		else {
			xParam = (getMaximum_X_Wert() / 250) + 1;
		}
		return xParam;
	}
	
	public static Integer berechneYParam() {
		int yParam = 0;
		if (getMaximum_Y_Wert() < 213) {
			yParam = (213 / getMaximum_Y_Wert()) -1;
		}
		else {
			yParam = (getMaximum_Y_Wert() / 213) + 1;
		}
		return yParam;
	}
	public static Integer grossterParam () {
		int grossterPara = 0;
		if (berechneXParam() < berechneYParam()){
			grossterPara = berechneYParam();
		}
		else {
			grossterPara = berechneXParam();
		}
		return grossterPara;
	}
	public static Integer kleinsterParam () {
		int kleinsterPara = 0;
		if (berechneXParam() < berechneYParam()){
			kleinsterPara = berechneXParam();
		}
		else {
			kleinsterPara = berechneYParam();
		}
		return kleinsterPara;
	}
}
