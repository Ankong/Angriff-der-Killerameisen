import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;


public class Listener_Key implements KeyListener{
	
    private static final char[] NUMERIC_CHARS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '\b'
    };
    
    //private String keyset;
    
	public boolean checkInput(char C){
        boolean result = false;
		for(int b = 0; (b < NUMERIC_CHARS.length) && (!result); b++)
            if(C == NUMERIC_CHARS[b])
                result = true;
		return(result);
	}
	
	//Tastendruck abfangen und überprüfen ob Eingabe valide ist   
	 public void keyPressed(KeyEvent arg0){

	    }
	@Override
	public void keyTyped(KeyEvent arg0) {
		if (checkInput(arg0.getKeyChar()) == false){
			arg0.consume();
			JOptionPane.showMessageDialog(null, "Die Eingabe ist Fehlerhaft. Bitte geben sie eine Zahl ein.", "Achtung", JOptionPane.OK_CANCEL_OPTION);
        }
	}
	@Override
	public void keyReleased(KeyEvent arg0) {

	}
}


