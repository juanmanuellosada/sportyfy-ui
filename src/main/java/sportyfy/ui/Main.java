package sportyfy.ui;

import javax.swing.SwingUtilities;

public class Main {

    public String saludar() {
        return "¡Hola mundo!";
    }
    public static void main(String[] args) {
        System.out.println(new Main().saludar());

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MiVentana();
            }
        });
    }
}