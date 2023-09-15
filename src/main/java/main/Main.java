package main;

import controladores.VentanaInicialControlador;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

import sportyfy.core.*;

public class Main {


    public static void main(String[] args)  throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                IniciadorSportyfyCore iniciador = new IniciadorSportyfyCore();
                try {
                    iniciador.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/pronosticadores");
                    VentanaInicialControlador ventanaInicialControlador = new VentanaInicialControlador();
                    ventanaInicialControlador.iniciar(iniciador);
                } catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException |
                         InstantiationException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}