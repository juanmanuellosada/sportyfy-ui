package main;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

import controladores.VentanaHistorialControlador;
import controladores.VentanaInicialControlador;
import sportyfy.core.core.SportyfyCore;
import sportyfy.core.iniciadores.IniciadorSportyfyCore;
import sportyfy.historial.Historial;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                IniciadorSportyfyCore iniciador;
                VentanaHistorialControlador controladorHistorial;
                try {
                    iniciador = new IniciadorSportyfyCore(false);
                    SportyfyCore sportyfyCore = iniciador.iniciar("src/pronosticadores");

                    controladorHistorial = new VentanaHistorialControlador();
                    sportyfyCore.addObserver(controladorHistorial.getHistorial());
                    controladorHistorial.iniciar(sportyfyCore);

                    VentanaInicialControlador ventanaInicialControlador = new VentanaInicialControlador();
                    ventanaInicialControlador.iniciar(sportyfyCore, controladorHistorial);
                }

                catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException |
                         InstantiationException | NoSuchMethodException | IOException e ) {
                    Logger logger = Logger.getLogger("Main");
                    logger.severe(e.getMessage());
                }
            }
        });
    }
}