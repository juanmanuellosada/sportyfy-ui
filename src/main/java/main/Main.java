package main;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import controladores.VentanaInicialControlador;
import sportyfy.core.core.SportyfyCore;
import sportyfy.core.iniciadores.IniciadorSportyfyCore;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                IniciadorSportyfyCore iniciador;
                try {
                    iniciador = new IniciadorSportyfyCore();

                    SportyfyCore sportyfyCore = iniciador.iniciar("src/pronosticadores");

                    VentanaInicialControlador ventanaInicialControlador = new VentanaInicialControlador();
                    ventanaInicialControlador.iniciar(sportyfyCore);
                }
                catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException |
                         InstantiationException | NoSuchMethodException | IOException e ) {
                    e.printStackTrace();
                }
            }
        });
    }
}