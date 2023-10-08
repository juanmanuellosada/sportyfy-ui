package sportyfy.ui.personalizador;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class JButtonRedondeado extends JButton {

    public JButtonRedondeado(String texto) {
        super(texto);
        setContentAreaFilled(false); // Hace que el área de contenido del botón sea transparente
        setFocusPainted(false); // Elimina el borde de enfoque
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            // Si el botón está presionado, puedes personalizar su apariencia aquí
            g.setColor(Color.gray);
        } else {
            g.setColor(getBackground());
        }

        // Crea una forma redondeada para el botón
        RoundRectangle2D.Float botonRedondeado = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fill(botonRedondeado);

        super.paintComponent(g);
    }
}
