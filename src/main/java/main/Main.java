package main;

import controller.VentanaInicialController;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VentanaInicialController ventanaInicialController = new VentanaInicialController();
                ventanaInicialController.iniciar();
            }
        });
    }
}