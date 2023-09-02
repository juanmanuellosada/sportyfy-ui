package sportyfy.ui;

import javax.swing.*;
import java.awt.event.*;

public class MiVentana extends JFrame {
    public MiVentana() {
        setTitle("Mi Ventana Swing");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton boton = new JButton("Haz clic");

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hola, Mundo!");
            }
        });

        getContentPane().add(boton);

        setVisible(true);
    }
}