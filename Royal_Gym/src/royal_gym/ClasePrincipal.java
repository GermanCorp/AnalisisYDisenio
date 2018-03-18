package royal_gym;

// método principal

import java.util.TimerTask;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ClasePrincipal {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        
        try {
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        UIManager.setLookAndFeel(javax.swing.plaf.nimbus.NimbusLookAndFeel.class.getName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    Conexion conectar = new Conexion();
    conectar.conectar();
    VentanaPrincipal ventana = new VentanaPrincipal();
    ventana.setVisible(true);
    ventana.setLocationRelativeTo(null);
    ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
                
}