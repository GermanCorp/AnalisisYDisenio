package royal_gym;

/**
 *
 * @author alxcr
 */
public class Mensaje {

    public Mensaje() {
    }

    public static void setMensaje(String mensaje) {
        royal_gym.VP.jlMensajes.setText(mensaje);
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                royal_gym.VP.jlMensajes.setText("");
            } catch (InterruptedException ex) {
            }
        }).start();
    }

}
