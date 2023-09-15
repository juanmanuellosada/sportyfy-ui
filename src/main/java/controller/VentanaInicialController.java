package controller;

import sportyfy.core.IniciadorSportyfyCore;
import sportyfy.core.futbol.Equipo;
import sportyfy.ui.VentanaInicial;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class VentanaInicialController{
   VentanaInicial ventanaInicial;

    public VentanaInicialController (){
       this.ventanaInicial = new VentanaInicial();
    }

    public void iniciar(IniciadorSportyfyCore iniciador) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        this.ventanaInicial.inicializar(iniciador);
        this.ventanaInicial.llenarCombo(iniciador.getBuscadorPronosticadores());
    }



}
