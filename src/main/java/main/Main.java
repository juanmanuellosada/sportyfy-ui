package main;

import controladores.VentanaInicialControlador;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException  {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //IniciadorSportyfyCore iniciadorSportyfyCore = new IniciadorSportyfyCore();
                //iniciadorSportyfyCore.iniciar("../sportyfy-core/datosFutbol/equipos/equipos.json","../sportyfy-core/datosFutbol/ultimos_resultados/","../sportyfy/src/pronosticadores");
                VentanaInicialControlador ventanaInicialControlador = new VentanaInicialControlador();
                ventanaInicialControlador.iniciar();
            }
        });
    }
}