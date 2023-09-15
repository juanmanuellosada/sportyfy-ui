package controladores;

import sportyfy.ui.VentanaInicial;

public class VentanaInicialControlador {
   VentanaInicial ventanaInicial;

    public VentanaInicialControlador(){
       this.ventanaInicial = new VentanaInicial();
    }

    public void iniciar() {
        this.ventanaInicial.inicializar();
    }



}
