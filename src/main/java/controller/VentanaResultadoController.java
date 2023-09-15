package controller;

import sportyfy.ui.VentanaResultado;

public class VentanaResultadoController {
    VentanaResultado ventanaResultado;

    public VentanaResultadoController(){
       this.ventanaResultado = new VentanaResultado();
    }

    public void extracted() {
        this.ventanaResultado.inicializar();
    }



}
