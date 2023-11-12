package main;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

import sportyfy.core.Pronosticador;
import sportyfy.core.entidades.core.SportyfyCore;
import sportyfy.core.servicios.iniciador.IniciadorSportyfyCore;
import controladores.VentanaHistorialControlador;
import controladores.VentanaInicialControlador;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                IniciadorSportyfyCore iniciador;
                VentanaHistorialControlador controladorHistorial;
                try {
                    iniciador = new IniciadorSportyfyCore();
                    SportyfyCore sportyfyCore = iniciador.iniciar("src/pronosticadores", "src/main/resources/datos/partidos");

                    System.out.print(sportyfyCore.getPronosticadores().size());

                    controladorHistorial = new VentanaHistorialControlador();
                    sportyfyCore.getNotificador().addPropertyChangeListener(controladorHistorial.getHistorial());
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