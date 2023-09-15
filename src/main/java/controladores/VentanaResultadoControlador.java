package controladores;

import sportyfy.ui.VentanaResultado;

public class VentanaResultadoControlador {
    VentanaResultado ventanaResultado;

    public VentanaResultadoControlador(){
       this.ventanaResultado = new VentanaResultado();
    }

    public void extracted() {
        this.ventanaResultado.inicializar();
    }



}
