package main;

import controladores.VentanaInicialControlador;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

import sportyfy.core.*;
import sportyfy.core.futbol.Equipo;
import sportyfy.core.futbol.Partido;

<<<<<<< HEAD
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main implements Pronosticador {


    public static void main(String[] args)  throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                IniciadorSportyfyCore iniciador = new IniciadorSportyfyCore();
                try {
                    iniciador.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/pronosticadores");
                    VentanaInicialController ventanaInicialController = new VentanaInicialController();
                    ventanaInicialController.iniciar(iniciador);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
=======
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException  {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //IniciadorSportyfyCore iniciadorSportyfyCore = new IniciadorSportyfyCore();
                //iniciadorSportyfyCore.iniciar("../sportyfy-core/datosFutbol/equipos/equipos.json","../sportyfy-core/datosFutbol/ultimos_resultados/","../sportyfy/src/pronosticadores");
                VentanaInicialControlador ventanaInicialControlador = new VentanaInicialControlador();
                ventanaInicialControlador.iniciar();
>>>>>>> b43e6bf52047950ecec48662612eb42ac3e8bc4d
            }
        });
    }

    @Override
    public Pronostico pronosticar(Equipo equipoLocal, Equipo equipoVisitante, List<Partido> partidosAnteriores) {
        return null;
    }

    @Override
    public String obtenerDeporte() {
        return null;
    }
}