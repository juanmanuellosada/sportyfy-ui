package main;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import controladores.VentanaInicialControlador;
import sportyfy.core.iniciador.IniciadorSportyfyCore;
import sportyfy.core.core.SportyfyCore;

public class Main {
    public static void main(String[] args)  throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                IniciadorSportyfyCore iniciador = new IniciadorSportyfyCore();
                try {
                    SportyfyCore sportyfyCore = iniciador.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/pronosticadores");
                    VentanaInicialControlador ventanaInicialControlador = new VentanaInicialControlador();
                    ventanaInicialControlador.iniciar(sportyfyCore);
                } catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException |
                         InstantiationException | NoSuchMethodException | FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}