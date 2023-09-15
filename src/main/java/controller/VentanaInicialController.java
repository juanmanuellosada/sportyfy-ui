package controller;

import sportyfy.ui.VentanaInicial;

public class VentanaInicialController{
   VentanaInicial ventanaInicial;

    public VentanaInicialController (){
       this.ventanaInicial = new VentanaInicial();
    }

    public void iniciar() {
        this.ventanaInicial.inicializar();
    }



}
