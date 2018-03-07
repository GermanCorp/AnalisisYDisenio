package royal_gym;

import java.awt.event.KeyEvent;

public class Validaciones 
{
    Character s;
    Number n;
    
    public void soloLetras(KeyEvent evt)
    {
        s = evt.getKeyChar();
        
        if(!Character.isLetter(s) && s != KeyEvent.VK_SPACE){
            evt.consume();   
        }
        
    }
    
    public void soloNumeros (KeyEvent evt)
    {
        n = evt.getKeyCode();
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
            
        }
        
    }
    
    
}
